package org.devoware.encounterplanner.model;

import static com.google.common.base.Preconditions.checkNotNull;


public class WorldShakingEvent {
	private final String description;
	
	public static WorldShakingEvent newWorldShakingEvent(String description) {
		return new WorldShakingEvent(description);
	}
	
	private WorldShakingEvent (String description) {
		checkNotNull(description);
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

}
