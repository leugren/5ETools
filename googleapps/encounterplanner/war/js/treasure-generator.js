var DEVOWARE = DEVOWARE || {};

console = console || {
	log: function() {},
	error: function () {},
	warn: function () {},
	assert: function () {},
	dir: function () {},
};

DEVOWARE.encounterPlanner = (function () {

	var handleSuccess = function (json) {
		$("#stats-button").prop("disabled", false);	
		$("#stats-button").removeClass("disabled");	
		$("#stats").empty();

		var pre = $("<pre>");
		pre.append(json.data);
		$("#stats").append(pre);
		$("#stats").css("display", "block");
	};
	
	
	var handleError = function (json) {
		$("#stats-button").prop("disabled", false);	
		$("#stats-button").removeClass("disabled");	
		$("#stats").empty();

		var errorDiv = $("<div>", {class: "error-message"});
        if (json === undefined) {
            errorDiv.append("An error occurred while processing your request.  Please make sure that you have supplied valid values for both the 'Treasure Type' field and the 'Challenge Rating' field.");
        } else {
            errorDiv.append(json.message);
        }
        $("#stats").append(errorDiv);
        $("#stats").css("display", "block");
	};

	var generateTreasure = function () {
		var treasureType = $("#treasureType").val();
		var challengeRating = $("#challengeRating").val();
		if (!/\S/.test(treasureType) || !/\S/.test(challengeRating)) {
			handleError({ message: "You must specify a value for both the Treasure Type field and the Challenge Rating field."});
		    return;
		}
		var url = "/api/treasure-generator?treasureType=" + treasureType + "&challengeRating=" + challengeRating + "&var=" + (new Date()).getTime();
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
			generateTreasure();
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
