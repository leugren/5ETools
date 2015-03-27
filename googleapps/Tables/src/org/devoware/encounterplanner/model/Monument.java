package org.devoware.encounterplanner.model;

import static com.google.common.base.Preconditions.checkNotNull;

public class Monument {
	private final String description;
	
	public static Monument newMonument(String description) {
		return new Monument(description);
	}
	
	private Monument (String description) {
		checkNotNull(description);
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

}
