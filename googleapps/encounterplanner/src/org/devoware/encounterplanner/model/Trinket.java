package org.devoware.encounterplanner.model;

import static com.google.common.base.Preconditions.checkNotNull;


public class Trinket {
	private final String description;
	
	public static Trinket newTrinket(String description) {
		return new Trinket(description);
	}
	
	private Trinket (String description) {
		checkNotNull(description);
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

}
