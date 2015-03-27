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

		generateStat($("#stats"), "Scheme", json.villain.scheme);
		generateStat($("#stats"), "Method", json.villain.method);
		generateStat($("#stats"), "Weakness", json.villain.weakness);
		generateStat($("#stats"), "Appearance", json.npc.appearance);
		generateStat($("#stats"), "High Ability", json.npc.highAbility);
		generateStat($("#stats"), "Low Ability", json.npc.lowAbility);
		generateStat($("#stats"), "Talent", json.npc.talent);
		generateStat($("#stats"), "Mannerism", json.npc.mannerism);
		generateStat($("#stats"), "Interaction Trait", json.npc.interactionTrait);
		generateStat($("#stats"), "Ideal", json.npc.ideal);
		if (json.npc.bonds.length === 1) {
			generateStat($("#stats"), "Bond", json.npc.bonds[0]);
		} else {
			bonds = "";
			firstLoop = true;
			for (idx = 0; idx < json.npc.bonds.length; idx++) {
				if (firstLoop) {
					firstLoop = false;
				} else {
					bonds += ", ";
				}
				bonds += "(" + (idx + 1) + ") " + json.npc.bonds[idx]; 
			}
			generateStat($("#stats"), "Bonds", bonds);
		}
		generateStat($("#stats"), "Flaw or Secret", json.npc.flawOrSecret);
		
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
		var url = "/api/villain-generator?" + ($("#includeWeakness").is(":checked") ? "includeWeakness=true&" : "") + "idealType=" + idealType + "&var=" + (new Date()).getTime();
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
