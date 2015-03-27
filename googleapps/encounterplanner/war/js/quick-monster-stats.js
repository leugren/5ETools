var DEVOWARE = DEVOWARE || {};

console = console || {
	log: function() {},
	error: function () {},
	warn: function () {},
	assert: function () {},
	dir: function () {},
};

DEVOWARE.encounterPlanner = (function () {
	var climateCategory = null;

	var generateStat = function (stats, statName, statValue) {
		var stat = $("<div>", {class: "output-line"});
		var statLabel = $("<span>", {class: "emphasis"});
		statLabel.append(statName + ": ");
		stat.append(statLabel);
		stat.append(statValue);
		stats.append(stat);
	};

    var handleSuccess = function (json) {
		$("#stats-button").prop("disabled", false);	
		$("#stats-button").removeClass("disabled");	
		$("#stats").empty();

		generateStat($("#stats"), "Challenge Rating", json.challengeRating);
		generateStat($("#stats"), "Proficiency Bonus", json.proficiencyBonus);
		generateStat($("#stats"), "Armor Class", json.armorClass);
		generateStat($("#stats"), "Average Hit Points", json.hitPoints);
		generateStat($("#stats"), "Attack Bonus", json.attackBonus);
		generateStat($("#stats"), "Average Damage Per Round", json.damagePerRound);
		generateStat($("#stats"), "Save DC", json.saveDc);
		
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
		var hitPoints = $("#hitPoints").spinner("value");
		var armorClass = $("#armorClass").spinner("value");
		var damagePerRound = $("#damagePerRound").spinner("value");
		var attackType = $("#attackType").val();
		var attackValue = $("#attackValue").spinner("value");
		
		var url = "/api/quick-monster-stats?hitPoints=" + hitPoints + "&armorClass=" + armorClass + "&damagePerRound=" + damagePerRound + "&attackType=" + attackType + "&attackValue=" + attackValue + "&var=" + (new Date()).getTime();
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
		var attackBonusChangeFunction = function (e, ui) {
			if ($(this).spinner("value") > 20) {
				$(this).spinner("value", 20);
			} else if ($(this).spinner("value") < 0) {
				$(this).spinner("value", 0);
			}
		};
		
		var saveDcChangeFunction = function (e, ui) {
			if ($(this).spinner("value") > 30) {
				$(this).spinner("value", 30);
			} else if ($(this).spinner("value") < 8) {
				$(this).spinner("value", 8);
			}
		};

		$("#hitPoints").spinner({
			min: 1,
			max: 850,
			change: function (e, ui) {
				if ($(this).spinner("value") > 850) {
					$(this).spinner("value", 850);
				} else if ($(this).spinner("value") < 1) {
					$(this).spinner("value", 1);
				}
			},
		});
		$("#hitPoints").spinner("value", 1);
		$("#armorClass").spinner({
			value: 10,
			min: 8,
			max: 35,
			change: function (e, ui) {
				if ($(this).spinner("value") > 35) {
					$(this).spinner("value", 35);
				} else if ($(this).spinner("value") < 8) {
					$(this).spinner("value", 8);
				}
			},
		});
		$("#armorClass").spinner("value", 10);
		$("#damagePerRound").spinner({
			value: 1,
			min: 0,
			max: 320,
			change: function (e, ui) {
				if ($(this).spinner("value") > 320) {
					$(this).spinner("value", 320);
				} else if ($(this).spinner("value") < 0) {
					$(this).spinner("value", 0);
				}
			},
		});
		$("#damagePerRound").spinner("value", 1);
		$("#attackValue").spinner({
			value: 0,
			min: 0,
			max: 20,
			change: attackBonusChangeFunction
		});
		$("#attackValue").spinner("value", 0);

		
		$("#attackType").bind("change", function (e) {
			$("#attackValueLabel").empty();
			if ($(this).val() === "0") {
				$("#attackValueLabel").text("Attack Bonus");
				$("#attackValue").spinner("value", 0);
				$("#attackValue").spinner("option", "max", 20);
				$("#attackValue").spinner("option", "change", attackBonusChangeFunction);
			} else {
				$("#attackValueLabel").text("Save DC");
				$("#attackValue").spinner("value", 10);
				$("#attackValue").spinner("option", "max", 30);
				$("#attackValue").spinner("option", "change", saveDcChangeFunction);
			}
		});
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
