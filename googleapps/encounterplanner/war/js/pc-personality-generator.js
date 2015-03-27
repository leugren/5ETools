var DEVOWARE = DEVOWARE || {};

console = console || {
	log: function() {},
	error: function () {},
	warn: function () {},
	assert: function () {},
	dir: function () {},
};

DEVOWARE.encounterPlanner = (function () {
	var excludedIdealTypeControls;
	var generateStat = function (stats, statName, statValue) {
		var stat = $("<div>", {class: "output-line"});
		var statLabel = $("<span>", {class: "emphasis"});
		statLabel.append(statName + ": ");
		stat.append(statLabel);
		stat.append(statValue);
		stats.append(stat);
	};

	var handleSuccess = function (json) {
		var bonds, firstLoop, idx;

		$("#stats-button").prop("disabled", false);	
		$("#stats-button").removeClass("disabled");	
		$("#stats").empty();

		generateStat($("#stats"), "Background", json.background);
		generateStat($("#stats"), "Personality Trait 1", json.personalityTrait1);
		generateStat($("#stats"), "Personality Trait 2", json.personalityTrait2);
		generateStat($("#stats"), "Ideal", json.ideal);
		generateStat($("#stats"), "Bond", json.bond);
		generateStat($("#stats"), "Flaw", json.flaw);
		
		if (json.additionalInfo !== undefined && json.additionalInfo !== null) {
			generateStat($("#stats"), json.additionalInfo.label, json.additionalInfo.value);
		}
		
		$("#stats").css("display", "block");
	};
	
	
	var handleError = function (json) {
		$("#stats-button").prop("disabled", false);	
		$("#stats-button").removeClass("disabled");	
		$("#stats").empty();

		var errorDiv = $("<div>", {class: "error-message"});
        if (json === undefined) {
            errorDiv.append("An error occurred while processing your request.");
        } else {
            errorDiv.append(json.message);
        }
        $("#stats").append(errorDiv);
        $("#stats").css("display", "block");
	};

	var generate = function () {
		var i;
		var background = $("#background").val();
		if (!/\S/.test(background)) {
			handleError({ message: "You must specify a value for the Background field."});
		    return;
		}
		var numChecked = 0;
		var url = "/api/pc-personality-generator?background=" + background + "&var=" + (new Date()).getTime();
		for (i = 0; i < excludedIdealTypeControls.length; i++) {
			if (excludedIdealTypeControls[i].is(":checked")) {
				numChecked++;
				url += "&excludedIdealType=" + excludedIdealTypeControls[i].val();
			}
		}
		if (numChecked === excludedIdealTypeControls.length &&
				background === "3") {
			handleError({ message: "Please deselect at least one of the excluded ideal types."});
			return;
		}
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
		excludedIdealTypeControls = [
		    $("#good"), $("#evil"), $("#lawful"), $("#chaotic"), $("#neutral")                         
		    ];
		$("#stats-button").bind("click", function (e) {
			$(this).prop("disabled", true);
			$(this).addClass("disabled");
			generate();
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
