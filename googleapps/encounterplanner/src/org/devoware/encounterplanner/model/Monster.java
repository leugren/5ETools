package org.devoware.encounterplanner.model;

import static com.google.common.base.Preconditions.checkArgument;

import org.devoware.encounterplanner.util.EncounterUtil;

public class Monster {
	private double challengeRating;
	
	public static Monster create (double challengeRating) {
		return new Monster(challengeRating);
	}
	
	private Monster(double challengeRating) {
		checkArgument(EncounterUtil.CR_RANGE.contains(challengeRating));
		this.challengeRating = challengeRating;
	}
	
	public double getChallengeRating () {
		return this.challengeRating;
	}

	@Override
	public String toString() {
		return "Monster [challengeRating=" + challengeRating + "]";
	}
}
