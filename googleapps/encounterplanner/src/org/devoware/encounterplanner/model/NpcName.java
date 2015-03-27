package org.devoware.encounterplanner.model;

import static com.google.common.base.Preconditions.checkNotNull;


public class NpcName {
	private final String description;
	
	public static NpcName newNpcName(String description) {
		return new NpcName(description);
	}
	
	private NpcName (String description) {
		checkNotNull(description);
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

}
