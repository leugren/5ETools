package org.devoware.encounterplanner.util;

import org.devoware.encounterplanner.model.Encounter;
import org.devoware.encounterplanner.model.Party;

public class Main {
	
	public static void main(String[] args) {
		Encounter encounter = Encounter.builder()
				.withMonster(1)
				.withMonsters(3, 0.5)
				.build();
		
		Party party = Party.builder()
				.withPartyMembers(3, 3)
				.withPartyMember(2)
				.build();
		
		computeStats(encounter, party);
		
		encounter = Encounter.builder()
				.withMonster(1)
				.build();
		
		party = Party.builder()
				.withPartyMember(3)
				.build();
		
		computeStats(encounter, party);
		
		encounter = Encounter.builder()
				.withMonsters(15, 0.125)
				.build();
		
		party = Party.builder()
				.withPartyMembers(5, 2)
				.build();
		
		computeStats(encounter, party);
		
	}

	private static void computeStats(Encounter encounter, Party party) {
		System.out.println("Base XP: " + EncounterUtil.getBaseXpsForEncounter(encounter));
		System.out.println("Adjusted XP: " + EncounterUtil.getAdjustedXpsForEncounter(party, encounter));
		System.out.println("Difficulty: " + EncounterUtil.getDifficultyForEncounter(party, encounter));
		System.out.println("Difficulty Thresholds: " + EncounterUtil.getXpThresholdsByParty(party));
		System.out.println();
	}

}
