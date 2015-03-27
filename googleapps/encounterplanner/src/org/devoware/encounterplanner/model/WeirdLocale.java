package org.devoware.encounterplanner.model;

import static com.google.common.base.Preconditions.checkNotNull;

public class WeirdLocale {
	private final String description;
	
	public static WeirdLocale newWeirdLocale(String description) {
		return new WeirdLocale(description);
	}
	
	private WeirdLocale (String description) {
		checkNotNull(description);
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

}
