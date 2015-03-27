var DEVOWARE = DEVOWARE || {};

console = console || {
	log: function() {},
	error: function () {},
	warn: function () {},
	assert: function () {},
	dir: function () {},
};

DEVOWARE.encounterPlanner = (function () {
	var generateStat = function (stats, statName, statValue) {
		var stat = $("<div>", {class: "output-line"});
		var statLabel = $("<span>", {class: "emphasis"});
		statLabel.append(statName + ": ");
		stat.append(statLabel);
		stat.append(statValue);
		stats.append(stat);
	};
	
	var stringifyThresholds = function (thresholds) {
		var result = "{ ";
		var firstLoop = true;
		for (var prop in thresholds) {
			if (firstLoop) {
				firstLoop = false;
			} else {
				result += ", ";
			}
			result += prop + "=" + thresholds[prop];
		}
		result += " }";
		return result;
	}
	
	var handleSuccess = function (json) {
		$("#stats-button").prop("disabled", false);	
		$("#stats-button").removeClass("disabled");	
		$("#stats").empty();

		generateStat($("#stats"), "Base XPs", json.baseXps);
		generateStat($("#stats"), "Adjusted XPs", json.adjustedXps);
		generateStat($("#stats"), "Difficulty", json.difficultyLevel);
		generateStat($("#stats"), "Difficulty Thresholds", stringifyThresholds(json.difficultyThresholds));

		$("#stats").css("display", "block");
	};
	
	
	var handleError = function (json) {
		$("#stats-button").prop("disabled", false);	
		$("#stats-button").removeClass("disabled");	
		$("#stats").empty();

		var errorDiv = $("<div>", {class: "error-message"});
        if (json === undefined) {
            errorDiv.append("An error occurred while processing your request.  Please make sure that you have supplied valid values for both the 'Party' field and the 'Encounter' field.");
        } else {
            errorDiv.append(json.message);
        }
        $("#stats").append(errorDiv);
        $("#stats").css("display", "block");
	};

	var computeStats = function () {
		var party = $("#party").val();
		var encounter = $("#encounter").val();
		if (!/\S/.test(party) || !/\S/.test(encounter)) {
			handleError({ message: "You must specify a value for both the Party field and the Encounter field."});
		    return;
		}
		var url = "/api/difficulty-calculator?party=" + party + "&encounter=" + encounter + "&var=" + (new Date()).getTime();
		url = encodeURI(url);

        $.ajax({
			url: url,
			dataType: "json",
			type: "GET",
			success: function (json) {
				handleSuccess(json);
			},
			error: function (response, status, error) {
				handleError(response.responseJSON);
			}
		});
	};
	
	var init = function () {
		$("#stats-button").bind("click", function (e) {
			$(this).prop("disabled", true);
			$(this).addClass("disabled");
			computeStats();
			return false;
		});
	};

	
	return {
		init: init
	};
})();

$(document).ready(function() {
    DEVOWARE.encounterPlanner.init();
 });
