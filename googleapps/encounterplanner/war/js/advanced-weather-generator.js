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

	var handleClimateCategorySuccess = function (json) {
		var climateCat = json;
		climateCategory = climateCat;
		generateWeather(climateCat);
	};

	
	var handleWeatherSuccess = function (json, climateCat) {
		var bonds, firstLoop, idx;

		$("#stats-button").prop("disabled", false);	
		$("#stats-button").removeClass("disabled");	
		$("#stats").empty();

		generateStat($("#stats"), "Climate Category", climateCat.name);
		generateStat($("#stats"), "Daytime Temperature", json.temperature);
		generateStat($("#stats"), "Effective Daytime Temperature", json.effectiveTemperature);
		generateStat($("#stats"), "Effective Nighttime Temperature", json.nightTimeTemperature);
		generateStat($("#stats"), "Precipitation", json.precipitation);
		generateStat($("#stats"), "Cloud Cover", json.cloudType);
		generateStat($("#stats"), "Wind", json.windType);
		generateStat($("#stats"), "Wind Speed", json.windSpeed + " miles per hour");
		generateStat($("#stats"), "Wind Effects", json.windDescription);
		generateStat($("#stats"), "Wind Direction", json.windDirection);
		
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

	var generateWeather = function (climateCat) {
		var climateCatIdx = climateCat.ordinal;
		var hemisphere = $("#latitude").spinner("value") >= 0 ? 1 : 2;
		var month = $("#month").val();
		
		var url = "/api/advanced-weather-generator?climateCategory=" + climateCatIdx + "&hemisphere=" + hemisphere + "&month=" + month + "&var=" + (new Date()).getTime();
		url = encodeURI(url);

        $.ajax({
			url: url,
			dataType: "json",
			type: "GET",
			success: function (json) {
				handleWeatherSuccess(json, climateCat);
			},
			error: function (response, status, error) {
				handleError(response.responseJSON);
			}
		});
	};

	var generateClimateCategory = function () {
		var terrain = $("#terrain").val();
		var terrainLocation = $("#terrainLocation").val();
		var latitude = $("#latitude").spinner("value");
		if (terrain == 2 && Math.abs(latitude) > 30) {
			handleError({message:"Deserts can only appear in latitudes between -30 and 30 degrees."});
			return;
		}
		
		if ((terrain == 3 || terrain == 6 || terrain == 8) && Math.abs(latitude) > 70) {
			handleError({message:"Forests, swamps, and jungles can only appear in latitudes between -70 and 70 degrees."});
			return;
		}

		var url = "/api/climate-category-generator?terrain=" + terrain + "&terrainLocation=" + terrainLocation + "&latitude=" + latitude + "&var=" + (new Date()).getTime();
		url = encodeURI(url);

        $.ajax({
			url: url,
			dataType: "json",
			type: "GET",
			success: function (json) {
				handleClimateCategorySuccess(json);
			},
			error: function (response, status, error) {
				handleError(response.responseJSON);
			}
		});
	};

	var generate = function () {
		var climateCat = climateCategory;
		if (climateCat == null) {
			generateClimateCategory();
		} else {
			generateWeather(climateCat);
		}
	};
	
	var init = function () {
		$("#latitude").spinner({
			min: -90,
			max: 90,
			change: function (e, ui) {
				climateCategory = null;
				if ($(this).spinner("value") > 90) {
					$(this).spinner("value", 90);
				} else if ($(this).spinner("value") < -90) {
					$(this).spinner("value", -90);
				}
			},
			stop: function(e,ui){
				climateCategory = null;
		    }
		});
		$("#latitude").spinner("value", 45);
		$("#terrain").bind("change", function (e) {
			climateCategory = null;
		});
		$("#terrainLocation").bind("change", function (e) {
			climateCategory = null;
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
