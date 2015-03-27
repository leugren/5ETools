package org.devoware.encounterplanner.model;

public enum DifficultyLevel {
	EASY("EASY - An easy encounter doesn't tax the characters' resources or put them in serious peril. They might lose a few hit points, but victory is pretty much guaranteed."),
	MEDIUM("MEDIUM - A medium encounter usually has one or two scary moments for the players, but the characters should emerge victorious with no casualties. One or more of them might need to use healing resources."),
	HARD("HARD - A hard encounter could go badly for the adventurers. Weaker characters might get taken out of the fight, and there's a slim chance that one or more of the characters might die."),
	DEADLY("DEADLY - A deadly encounter could be lethal for one or more player characters. Survival often requires good tactics and quick thinking, and the party risks defeat.");

    private String description;
	
	private DifficultyLevel (String description) {
		this.description = description;
	}
	
	public String getDescription () {
		return this.description;
	}
	
}
