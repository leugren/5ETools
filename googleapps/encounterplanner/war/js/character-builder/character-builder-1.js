var DEVOWARE = DEVOWARE || {};

console = console || {
	log: function() {},
	error: function () {},
	warn: function () {},
	assert: function () {},
	dir: function () {},
};

DEVOWARE.characterBuilder1 = (function () {
	var wizardIdx = 0;
	
	var init = function () {
		$.getScript("/js/character-builder/wizard-breadcrumb.js", function () {
			DEVOWARE.wizardBreadcrumb.standardBreadcrumb(wizardIdx);
		});		
	};
	
	return {
		init: init
	};
})();

$(document).ready(function() {
    DEVOWARE.characterBuilder1.init();
 });
