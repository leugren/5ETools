var DEVOWARE = DEVOWARE || {};

console = console || {
	log: function() {},
	error: function () {},
	warn: function () {},
	assert: function () {},
	dir: function () {},
};

DEVOWARE.wizardBreadcrumb = (function () {
	var standardLabels = [
		                  "Select Race",
		                  "Select Attributes",
		                  "Select Class",
		                  "Select Background",
		                  "Select Equipment",
		                  "Generate Character"
	                     ];
	
	var generate = function (labels, currentLabelIdx) {
		if (!$.isArray(labels)) {
			throw new Error("Expected an array of labels.");
		} else if (labels.length === 0) {
			throw new Error("Expected a non-empty array of labels.");
		}
		if ($.type(currentLabelIdx) !== "number") {
			throw new Error("Expected a numeric index.");
		} else if (currentLabelIdx < 0 || currentLabelIdx >= labels.length) {
			throw new Error("Expected a numeric index between 0 and " + (labels.length - 1) + ".");
		}
		$(".breadcrumb").each(function () {
			var i, maxLength;
			var blockTitle = $("<div>", { class: "block-title"});
			var span = $("<span>");
			maxLength = labels.length;
			for (i = 0; i < maxLength; i++) {
				var crumb = $("<div>");
				if (i === 0) {
					crumb.addClass("first");
				}
				if (i === maxLength - 1) {
					crumb.addClass("last");
				}
				if (i === currentLabelIdx) {
					crumb.addClass("current");
				}
				crumb.append("" + labels[i]);
				span.append(crumb);
			}
			blockTitle.append(span);
			$(this).append(blockTitle);
		});
	};
	
	var standardBreadcrumb = function (idx) {
		generate(standardLabels, idx);
	}
	
	return {
		generate: generate,
	    standardBreadcrumb: standardBreadcrumb
	};
})();