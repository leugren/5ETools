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

	var handleSuccess = function (json) {
		var bonds, firstLoop, idx;

		$("#stats-button").prop("disabled", false);	
		$("#stats-button").removeClass("disabled");	
		$("#stats").empty();

		generateStat($("#stats"), "Appearance", json.appearance);
		generateStat($("#stats"), "High Ability", json.highAbility);
		generateStat($("#stats"), "Low Ability", json.lowAbility);
		generateStat($("#stats"), "Talent", json.talent);
		generateStat($("#stats"), "Mannerism", json.mannerism);
		generateStat($("#stats"), "Interaction Trait", json.interactionTrait);
		generateStat($("#stats"), "Ideal", json.ideal);
		if (json.bonds.length === 1) {
			generateStat($("#stats"), "Bond", json.bonds[0]);
		} else {
			bonds = "";
			firstLoop = true;
			for (idx = 0; idx < json.bonds.length; idx++) {
				if (firstLoop) {
					firstLoop = false;
				} else {
					bonds += ", ";
				}
				bonds += "(" + (idx + 1) + ") " + json.bonds[idx]; 
			}
			generateStat($("#stats"), "Bonds", bonds);
		}
		generateStat($("#stats"), "Flaw or Secret", json.flawOrSecret);
		
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
		var idealType = $("#idealType").val();
		if (!/\S/.test(idealType)) {
			handleError({ message: "You must specify a value for the Ideal Type field."});
		    return;
		}
		var url = "/api/npc-generator?idealType=" + idealType + "&var=" + (new Date()).getTime();
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
