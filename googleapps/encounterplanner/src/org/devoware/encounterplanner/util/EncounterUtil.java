package org.devoware.encounterplanner.util;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import static org.devoware.encounterplanner.model.DifficultyLevel.DEADLY;
import static org.devoware.encounterplanner.model.DifficultyLevel.EASY;
import static org.devoware.encounterplanner.model.DifficultyLevel.HARD;
import static org.devoware.encounterplanner.model.DifficultyLevel.MEDIUM;
import static org.devoware.encounterplanner.util.EncounterMultiplierModifier.NEXT_HIGHER_MULTIPLIER;
import static org.devoware.encounterplanner.util.EncounterMultiplierModifier.NEXT_LOWER_MULTIPLIER;
import static org.devoware.encounterplanner.util.EncounterMultiplierModifier.STANDARD_MULTIPLIER;

import java.util.Map;

import org.devoware.encounterplanner.model.Encounter;
import org.devoware.encounterplanner.model.DifficultyLevel;
import org.devoware.encounterplanner.model.Monster;
import org.devoware.encounterplanner.model.Party;
import org.devoware.encounterplanner.model.PartyMember;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableRangeMap;
import com.google.common.collect.ImmutableRangeSet;
import com.google.common.collect.ImmutableTable;
import com.google.common.collect.Maps;
import com.google.common.collect.Range;
import com.google.common.collect.RangeMap;
import com.google.common.collect.RangeSet;
import com.google.common.collect.Table;
import com.google.common.collect.TreeRangeMap;
import com.google.common.collect.TreeRangeSet;

public class EncounterUtil {
	
	public static final Range<Integer> CHAR_LEVEL_RANGE = Range.closed(1, 20);
	public static final RangeSet<Double> CR_RANGE;
	
	private static final Map<Range<Integer>, Double> ENCOUNTER_MULTIPLIERS;
	private static final RangeMap<Integer, EncounterMultiplierModifier> ENCOUNTER_MULTIPLIER_MODIFIERS;
	private static final BiMap<Range<Integer>, Integer> ENCOUNTER_MULTIPLIER_RANGE_INDECES;
	
	private static final Table<Integer, DifficultyLevel, Integer> XP_THRESHOLDS = 
			ImmutableTable.<Integer, DifficultyLevel, Integer>builder()
			.put(1, EASY, 25).put(1, MEDIUM, 50).put(1, HARD, 75).put(1, DEADLY, 100)
			.put(2, EASY, 50).put(2, MEDIUM, 100).put(2, HARD, 150).put(2, DEADLY, 200)
			.put(3, EASY, 75).put(3, MEDIUM, 150).put(3, HARD, 225).put(3, DEADLY, 400)
			.put(4, EASY, 125).put(4, MEDIUM, 250).put(4, HARD, 375).put(4, DEADLY, 500)
			.put(5, EASY, 250).put(5, MEDIUM, 500).put(5, HARD, 750).put(5, DEADLY, 1100)
			.put(6, EASY, 300).put(6, MEDIUM, 600).put(6, HARD, 900).put(6, DEADLY, 1400)
			.put(7, EASY, 350).put(7, MEDIUM, 750).put(7, HARD, 1100).put(7, DEADLY, 1700)
			.put(8, EASY, 450).put(8, MEDIUM, 900).put(8, HARD, 1400).put(8, DEADLY, 2100)
			.put(9, EASY, 550).put(9, MEDIUM, 1100).put(9, HARD, 1600).put(9, DEADLY, 2400)
			.put(10, EASY, 600).put(10, MEDIUM, 1200).put(10, HARD, 1900).put(10, DEADLY, 2800)
			.put(11, EASY, 800).put(11, MEDIUM, 1600).put(11, HARD, 2400).put(11, DEADLY, 3600)
			.put(12, EASY, 1000).put(12, MEDIUM, 2000).put(12, HARD, 3000).put(12, DEADLY, 4500)
			.put(13, EASY, 1100).put(13, MEDIUM, 2200).put(13, HARD, 3400).put(13, DEADLY, 5100)
			.put(14, EASY, 1250).put(14, MEDIUM, 2500).put(14, HARD, 3800).put(14, DEADLY, 5700)
			.put(15, EASY, 1400).put(15, MEDIUM, 2800).put(15, HARD, 4300).put(15, DEADLY, 6400)
			.put(16, EASY, 1600).put(16, MEDIUM, 3200).put(16, HARD, 4800).put(16, DEADLY, 7200)
			.put(17, EASY, 2000).put(17, MEDIUM, 3900).put(17, HARD, 5900).put(17, DEADLY, 8800)
			.put(18, EASY, 2100).put(18, MEDIUM, 4200).put(18, HARD, 6300).put(18, DEADLY, 9500)
			.put(19, EASY, 2400).put(19, MEDIUM, 4900).put(19, HARD, 7300).put(19, DEADLY, 10900)
			.put(20, EASY, 2800).put(20, MEDIUM, 5700).put(20, HARD, 8500).put(20, DEADLY, 12700)
			.build();
	
	private static final Map<Double, Integer> XP_BY_CR = ImmutableMap.<Double, Integer>builder()
			.put(0.0, 10).put(0.125, 25).put(0.25, 50).put(0.5, 100)
			.put(1.0, 200).put(2.0, 450).put(3.0, 700).put(4.0, 1100).put(5.0, 1800)
			.put(6.0, 2300).put(7.0, 2900).put(8.0, 3900).put(9.0, 5000).put(10.0, 5900)
			.put(11.0, 7200).put(12.0, 8400).put(13.0, 10000).put(14.0, 11500).put(15.0, 13000)
			.put(16.0, 15000).put(17.0, 18000).put(18.0, 20000).put(19.0, 22000).put(20.0, 25000)
			.put(21.0, 33000).put(22.0, 41000).put(23.0, 50000).put(24.0, 62000).put(25.0, 75000)
			.put(26.0, 90000).put(27.0, 105000).put(28.0, 120000).put(29.0, 135000).put(30.0, 155000)
			.build();
	
	static {
		RangeSet<Double> crRange = TreeRangeSet.create();
		crRange.add(Range.singleton(0.0));
		crRange.add(Range.singleton(0.125));
		crRange.add(Range.singleton(0.25));
		crRange.add(Range.singleton(0.5));
		for (int i = 1; i <= 30; i++) {
		    crRange.add(Range.singleton((double) i));
		}
		CR_RANGE = ImmutableRangeSet.copyOf(crRange);
		
		
		Map<Range<Integer>, Double> encounterMults = Maps.newLinkedHashMap();
		BiMap<Range<Integer>, Integer> encounterMultRangeIndexes = HashBiMap.create();
		int index = 0;
		Range<Integer> range = Range.singleton(0);
		encounterMultRangeIndexes.put(range, index++);
		encounterMults.put(range, 0.5);
		range = Range.singleton(1);
		encounterMultRangeIndexes.put(range, index++);
		encounterMults.put(range, 1.0);
		range = Range.singleton(2);
		encounterMultRangeIndexes.put(range, index++);
		encounterMults.put(range, 1.5);
		range = Range.closed(3, 6);
		encounterMultRangeIndexes.put(range, index++);
		encounterMults.put(range, 2.0);
		range = Range.closed(7, 10);
		encounterMultRangeIndexes.put(range, index++);
		encounterMults.put(range, 2.5);
		range = Range.closed(11, 14);
		encounterMultRangeIndexes.put(range, index++);
		encounterMults.put(range, 3.0);
		range = Range.atLeast(15);
		encounterMultRangeIndexes.put(range, index++);
		encounterMults.put(range, 4.0);
		range = Range.singleton(-1);
		encounterMultRangeIndexes.put(range, index++);
		encounterMults.put(range, 5.0);
		
		ENCOUNTER_MULTIPLIERS = ImmutableMap.copyOf(encounterMults);
		ENCOUNTER_MULTIPLIER_RANGE_INDECES = ImmutableBiMap.copyOf(encounterMultRangeIndexes);
		
		RangeMap<Integer, EncounterMultiplierModifier> encounterMultMods = TreeRangeMap.create();
		encounterMultMods.put(Range.closed(1, 2), NEXT_HIGHER_MULTIPLIER);
		encounterMultMods.put(Range.closed(3, 5), STANDARD_MULTIPLIER);
		encounterMultMods.put(Range.atLeast(6), NEXT_LOWER_MULTIPLIER);
		
		ENCOUNTER_MULTIPLIER_MODIFIERS = ImmutableRangeMap.copyOf(encounterMultMods);
		
	}
	
	public static final DifficultyLevel getDifficultyForEncounter (Party party, Encounter encounter) {
		checkNotNull(party);
		checkNotNull(encounter);
		int encounterXp = getAdjustedXpsForEncounter(party, encounter);
		DifficultyLevel difficulty = getDifficultyByXps(party, encounterXp);
		return difficulty;
 	}

	public static final int getAdjustedXpsForEncounter (Encounter encounter) {
		checkNotNull(encounter);
		int encounterXp = getBaseXpsForEncounter(encounter);
		double encounterMultiplier = getEncounterMultiplier(encounter);
		encounterXp = (int) Math.floor(encounterXp * encounterMultiplier);
		return encounterXp;
 	}

	
	public static final int getAdjustedXpsForEncounter (Party party, Encounter encounter) {
		checkNotNull(party);
		checkNotNull(encounter);
		int encounterXp = getBaseXpsForEncounter(encounter);
		double encounterMultiplier = getEncounterMultiplier(party, encounter);
		encounterXp = (int) Math.floor(encounterXp * encounterMultiplier);
		return encounterXp;
 	}

	private static DifficultyLevel getDifficultyByXps(Party party,
			int encounterXp) {
		Map<DifficultyLevel, Integer> xpThresholds = getXpThresholdsByParty(party);
		DifficultyLevel result = DifficultyLevel.EASY;
		for (DifficultyLevel difficulty : xpThresholds.keySet()) {
			if (encounterXp >= xpThresholds.get(difficulty)) {
				result = difficulty;
			} else {
				break;
			}
		}
		return result;
	}

	private static double getEncounterMultiplier(Encounter encounter) {
        return getEncounterMultiplier(null, encounter);
	}	
	private static double getEncounterMultiplier(Party party,
			Encounter encounter) {
		EncounterMultiplierModifier multMod = STANDARD_MULTIPLIER;
		if (party != null) {
		    multMod = ENCOUNTER_MULTIPLIER_MODIFIERS.get(party.size());
		}
		double encounterMultiplier = 0;
		for (Range<Integer> range : ENCOUNTER_MULTIPLIERS.keySet()) {
			if (range.contains(encounter.size())) {
				int idx = ENCOUNTER_MULTIPLIER_RANGE_INDECES.get(range);
				if (multMod == NEXT_HIGHER_MULTIPLIER) {
					idx += 1;
				} else if (multMod == NEXT_LOWER_MULTIPLIER) {
					idx -= 1;
				}
				range = ENCOUNTER_MULTIPLIER_RANGE_INDECES.inverse().get(idx);
				encounterMultiplier = ENCOUNTER_MULTIPLIERS.get(range);
				break;
			}
		}
		checkArgument(encounterMultiplier > 0);
		return encounterMultiplier;
	}

	public static final Map<DifficultyLevel, Integer> getXpThresholdsByParty (Party party) {
		checkNotNull(party);
		Map<DifficultyLevel, Integer> xpThresholds = Maps.newLinkedHashMap();
		for (DifficultyLevel difficulty : DifficultyLevel.values()) {
			int thresholdSum = 0;
			for (PartyMember member : party.getPartyMembers()) {
				thresholdSum += getXpThresholdByCharLevelAndDifficulty(member.getLevel(), difficulty);
			}
			xpThresholds.put(difficulty, thresholdSum);
		}
		return ImmutableMap.copyOf(xpThresholds);
	}

	public static final Integer getBaseXpsForEncounter (Encounter encounter) {
		checkNotNull(encounter);
		int totalXp = 0;
		for (Monster monster : encounter.getMonsters()) {
			totalXp += XP_BY_CR.get(monster.getChallengeRating());
		}
		return totalXp;
	}
	
	
	public static final Map<DifficultyLevel, Integer> getXpThresholdsByCharLevel (int charLevel) {
	   checkArgument(CHAR_LEVEL_RANGE.contains(charLevel));
	   Map<DifficultyLevel, Integer> result = XP_THRESHOLDS.row(charLevel);
	   return result;
   }

   private static final Integer getXpThresholdByCharLevelAndDifficulty (int charLevel, DifficultyLevel difficulty) {
	   checkArgument(CHAR_LEVEL_RANGE.contains(charLevel));
	   checkNotNull(difficulty);
	   Integer result = XP_THRESHOLDS.get(charLevel, difficulty);
	   return result;
   }

}
