package org.devoware.encounterplanner.model;

import static com.google.common.base.Preconditions.checkArgument;
import static org.devoware.encounterplanner.util.EncounterUtil.CHAR_LEVEL_RANGE;

public class PartyMember {
	private int level;
	
	public static PartyMember create (int level) {
		return new PartyMember(level);
	}
	
	private PartyMember(int level) {
		checkArgument(CHAR_LEVEL_RANGE.contains(level));
		this.level = level;
	}
	
	public int getLevel () {
		return this.level;
	}

	@Override
	public String toString() {
		return "PartyMember [level=" + level + "]";
	}
	
	
}
