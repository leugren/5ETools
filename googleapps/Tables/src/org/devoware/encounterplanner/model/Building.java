package org.devoware.encounterplanner.model;

import static com.google.common.base.Preconditions.checkNotNull;


public class Building {
	private final String description;
	
	public static Building newBuilding(String description) {
		return new Building(description);
	}
	
	private Building (String description) {
		checkNotNull(description);
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

}
