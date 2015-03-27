package org.devoware.encounterplanner.service;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import static java.util.Collections.disjoint;
import static org.devoware.encounterplanner.model.Building.newBuilding;
import static org.devoware.encounterplanner.model.DungeonIdea.newDungeonIdea;
import static org.devoware.encounterplanner.model.LocationBasedAdventure.newLocationBasedAdventure;
import static org.devoware.encounterplanner.model.Monument.newMonument;
import static org.devoware.encounterplanner.model.Npc.newNpc;
import static org.devoware.encounterplanner.model.NpcName.newNpcName;
import static org.devoware.encounterplanner.model.PcPersonality.newPcPersonality;
import static org.devoware.encounterplanner.model.Treasure.newTreasure;
import static org.devoware.encounterplanner.model.Trinket.newTrinket;
import static org.devoware.encounterplanner.model.Weather.newWeather;
import static org.devoware.encounterplanner.model.WeirdLocale.newWeirdLocale;
import static org.devoware.encounterplanner.model.WorldShakingEvent.newWorldShakingEvent;
import static org.devoware.table.dice.Die.D6;
import static org.devoware.table.model.DungeonIdeas.CREATOR;
import static org.devoware.table.model.DungeonIdeas.HISTORY;
import static org.devoware.table.model.DungeonIdeas.LOCATION;
import static org.devoware.table.model.DungeonIdeas.PURPOSE;
import static org.devoware.table.model.IdealType.setOfAllIdealTypes;
import static org.devoware.table.model.LocationBasedAdventures.ADVENTURE_ALLIES;
import static org.devoware.table.model.LocationBasedAdventures.ADVENTURE_CLIMAX;
import static org.devoware.table.model.LocationBasedAdventures.ADVENTURE_INTRODUCTION;
import static org.devoware.table.model.LocationBasedAdventures.ADVENTURE_PATRONS;
import static org.devoware.table.model.LocationBasedAdventures.ADVENTURE_VILLAINS;
import static org.devoware.table.model.LocationBasedAdventures.DUNGEON_GOALS;
import static org.devoware.table.model.LocationBasedAdventures.FRAMING_EVENTS;
import static org.devoware.table.model.LocationBasedAdventures.MORAL_QUANDARIES;
import static org.devoware.table.model.LocationBasedAdventures.OTHER_GOALS;
import static org.devoware.table.model.LocationBasedAdventures.RANDOM_GOALS;
import static org.devoware.table.model.LocationBasedAdventures.SIDE_QUESTS;
import static org.devoware.table.model.LocationBasedAdventures.TWISTS;
import static org.devoware.table.model.LocationBasedAdventures.WILDERNESS_GOALS;
import static org.devoware.table.model.Npcs.APPEARANCE;
import static org.devoware.table.model.Npcs.BONDS;
import static org.devoware.table.model.Npcs.FLAWS_AND_SECRETS;
import static org.devoware.table.model.Npcs.HIGH_ABILITY;
import static org.devoware.table.model.Npcs.IDEALS;
import static org.devoware.table.model.Npcs.INTERACTION_TRAITS;
import static org.devoware.table.model.Npcs.LOW_ABILITY;
import static org.devoware.table.model.Npcs.MANNERISMS;
import static org.devoware.table.model.Npcs.TALENTS;
import static org.devoware.table.model.PcPersonalities.BACKGROUNDS;
import static org.devoware.table.model.RandomInt.newRandomInt;
import static org.devoware.table.model.Settlements.CURRENT_CALAMITY;
import static org.devoware.table.model.Settlements.KNOWN_FOR_ITS;
import static org.devoware.table.model.Settlements.NOTABLE_TRAITS;
import static org.devoware.table.model.Settlements.RACE_RELATIONS;
import static org.devoware.table.model.Settlements.RULERS_STATUS;
import static org.devoware.table.model.Villains.VILLAINS_METHOD;
import static org.devoware.table.model.Villains.VILLAINS_SCHEME;
import static org.devoware.table.model.Villains.VILLAINS_WEAKNESS;
import static org.devoware.table.model.Wilderness.MONUMENTS;
import static org.devoware.table.model.Wilderness.PRECIPITATION;
import static org.devoware.table.model.Wilderness.TEMPERATURE;
import static org.devoware.table.model.Wilderness.WEIRD_LOCALES;
import static org.devoware.table.model.Wilderness.WIND;
import static org.devoware.table.model.WorldShakingEvents.EVENTS;

import java.util.List;
import java.util.Set;

import org.devoware.encounterplanner.model.Building;
import org.devoware.encounterplanner.model.DungeonIdea;
import org.devoware.encounterplanner.model.Encounter;
import org.devoware.encounterplanner.model.EncounterStats;
import org.devoware.encounterplanner.model.LocationBasedAdventure;
import org.devoware.encounterplanner.model.MonsterStatistics;
import org.devoware.encounterplanner.model.Monument;
import org.devoware.encounterplanner.model.Npc;
import org.devoware.encounterplanner.model.NpcName;
import org.devoware.encounterplanner.model.Party;
import org.devoware.encounterplanner.model.PcPersonality;
import org.devoware.encounterplanner.model.Settlement;
import org.devoware.encounterplanner.model.Treasure;
import org.devoware.encounterplanner.model.Trinket;
import org.devoware.encounterplanner.model.Villain;
import org.devoware.encounterplanner.model.VillainNpc;
import org.devoware.encounterplanner.model.Weather;
import org.devoware.encounterplanner.model.WeirdLocale;
import org.devoware.encounterplanner.model.WorldShakingEvent;
import org.devoware.encounterplanner.monstercr.AttackType;
import org.devoware.encounterplanner.monstercr.ChallengeRating;
import org.devoware.encounterplanner.monstercr.MonsterStats;
import org.devoware.encounterplanner.parser.ExpressionParser;
import org.devoware.encounterplanner.parser.ParseException;
import org.devoware.encounterplanner.util.EncounterUtil;
import org.devoware.table.model.Background;
import org.devoware.table.model.Buildings;
import org.devoware.table.model.IdealType;
import org.devoware.table.model.IntegerSource;
import org.devoware.table.model.NamedRandomizableStringSource;
import org.devoware.table.model.Npcs;
import org.devoware.table.model.RandomizableStringSource;
import org.devoware.table.model.TreasureType;
import org.devoware.table.model.Treasures;
import org.devoware.table.model.Trinkets;
import org.devoware.table.weather.AdvancedWeather;
import org.devoware.table.weather.ClimateCategory;
import org.devoware.table.weather.Hemisphere;
import org.devoware.table.weather.Latitudes;
import org.devoware.table.weather.Month;
import org.devoware.table.weather.Terrain;
import org.devoware.table.weather.TerrainLocation;

import com.google.common.collect.Range;
import com.google.common.collect.Sets;

public class EncounterPlannerService {
	private final ExpressionParser parser = new ExpressionParser();
	private final Range<Integer> backgroundRange = Range.closed(-1, BACKGROUNDS.size());
	
	
	public Treasure generateTreasure (String treasureType, String challengeRating) throws ParseException {
		TreasureType type = TreasureType.get(treasureType);
		if (treasureType == null) {
			throw new IllegalArgumentException("The treasure type must be one of 'INDIVIDUAL' or 'TREASURE_HOARD'");
		}
		if (challengeRating == null) {
			throw new IllegalArgumentException("Expected a challenge rating");
		}
		Double cr = parser.parseChallengeRating(challengeRating);
		if (cr == null) {
			throw new IllegalArgumentException("An invalid challenge rating was specified");
		}
		String data = Treasures.generate(type, cr);
		return newTreasure(data);
	}
	
	public EncounterStats getEncounterStats (String partyString, String encounterString) throws ParseException {
		Party party = parser.parseParty(partyString);
		Encounter encounter = parser.parseEncounter(encounterString);

		EncounterStats stats = EncounterStats.builder()
		    .withBaseXps(EncounterUtil.getBaseXpsForEncounter(encounter))
		    .withAdjustedXps(EncounterUtil.getAdjustedXpsForEncounter(party, encounter))
		    .withDifficultyLevel(EncounterUtil.getDifficultyForEncounter(party, encounter))
		    .withDifficultyThresholds(EncounterUtil.getXpThresholdsByParty(party))
		    .build();
		
		return stats;
	}
	
	public Npc generateNpc (int idealType) {
	    checkArgument(idealType >= 1 && idealType <= 7, "Expected an ideal type value between 1 and 7.");
		Npc.Builder builder = newNpc()
				.withAppearance(APPEARANCE.getValue())
				.withBonds(BONDS.getValue("|"))
				.withFlawOrSecret(FLAWS_AND_SECRETS.getValue())
				.withInteractionTrait(INTERACTION_TRAITS.getValue())
				.withMannerism(MANNERISMS.getValue())
				.withTalent(TALENTS.getValue());
		
		if (idealType == 7) {
			builder.withIdeal(IDEALS.getValue());
		} else {
			builder.withIdeal(IDEALS.getValue(idealType));
		}
		
		int roll = D6.roll();
		builder.withHighAbility(HIGH_ABILITY.getValue(roll));
		
		int roll2;
		do {
		    roll2 = D6.roll();
		} while (roll2 == roll);
		builder.withLowAbility(LOW_ABILITY.getValue(roll2));
		
		return builder.build();
	}
	
	public Settlement generateSettlement () {
		Settlement settlement = Settlement.newSettlement()
				.withCurrentCalamity(CURRENT_CALAMITY.getValue())
				.withKnownForIts(KNOWN_FOR_ITS.getValue())
				.withNotableTraits(NOTABLE_TRAITS.getValue())
				.withRaceRelations(RACE_RELATIONS.getValue())
				.withRulersStatus(RULERS_STATUS.getValue())
				.build();
		return settlement;
	}

	public Building generateBuilding () {
		Building building = newBuilding(Buildings.BUILDING_TYPE.getValue());
		return building;
	}

	public NpcName generateNpcName () {
		NpcName name = newNpcName(Npcs.NAME_GENERATOR.getValue());
		return name;
	}

	public Building generateTavern () {
		Building building = newBuilding(Buildings.RANDOM_TAVERN.getValue());
		return building;
	}
	
	public LocationBasedAdventure generateLocationBasedAdventure (String adventureType) {
		checkNotNull(adventureType);
		LocationBasedAdventure.Builder builder = newLocationBasedAdventure();
		if (adventureType.equals("dungeon")) {
			builder.withGoal(DUNGEON_GOALS.getValue());
		} else if (adventureType.equals("wilderness")) {
			builder.withGoal(WILDERNESS_GOALS.getValue());
		} else if (adventureType.equals("other")) {
			builder.withGoal(OTHER_GOALS.getValue());
		} else if (adventureType.equals("random")) {
			builder.withGoal(RANDOM_GOALS.getValue());
		} else {
			throw new IllegalArgumentException("Invalid adventure type.");
		}
		
		LocationBasedAdventure adventure = builder.withAlly(ADVENTURE_ALLIES.getValue())
		    .withClimax(ADVENTURE_CLIMAX.getValue())
		    .withFramingEvent(FRAMING_EVENTS.getValue())
		    .withIntroduction(ADVENTURE_INTRODUCTION.getValue())
		    .withMoralQuandary(MORAL_QUANDARIES.getValue())
		    .withPatron(ADVENTURE_PATRONS.getValue())
		    .withSideQuest(SIDE_QUESTS.getValue())
		    .withTwist(TWISTS.getValue())
		    .withVillain(ADVENTURE_VILLAINS.getValue())
		    .build();
		
		return adventure;
	}

	
	public VillainNpc generateVillain (boolean includeWeakness, int idealType) {
		Villain.Builder builder = Villain.newVillain();
		if (includeWeakness) {
			builder.withWeakness(VILLAINS_WEAKNESS.getValue());
		}
		Villain villain = builder.withScheme(VILLAINS_SCHEME.getValue())
				.withMethod(VILLAINS_METHOD.getValue())
				.build();
		
		Npc npc = generateNpc(idealType);
		VillainNpc villainNpc = VillainNpc.newVillainNpc(villain, npc);
		return villainNpc;
	}

	public DungeonIdea generateDungeonIdea () {
		DungeonIdea dungeonIdea = newDungeonIdea()
				.withCreator(CREATOR.getValue())
				.withHistory(HISTORY.getValue())
				.withLocation(LOCATION.getValue())
				.withPurpose(PURPOSE.getValue())
				.build();
		return dungeonIdea;
	}
	
	public Weather generateWeather () {
		Weather weather = newWeather()
				.withTemperature(TEMPERATURE.getValue())
				.withWind(WIND.getValue())
				.withPrecipitation(PRECIPITATION.getValue())
				.build();
		
		return weather;
	}
	
	public Monument generateMonument () {
		Monument monument = newMonument(MONUMENTS.getValue());
		return monument;
	}

	public WeirdLocale generateWeirdLocale () {
		WeirdLocale locale = newWeirdLocale(WEIRD_LOCALES.getValue());
		return locale;
	}
	
	public WorldShakingEvent generateWorldShakingEvent () {
		WorldShakingEvent event = newWorldShakingEvent(EVENTS.getValue());
		return event;
	}
	
	public PcPersonality generatePcPersonality(int background, List<String> excludedIdealTypes) {
		checkNotNull(excludedIdealTypes);
		checkArgument(backgroundRange.contains(background), "Invalid background");
		Set<IdealType> excludedTypes = Sets.newHashSet();
		for (String type : excludedIdealTypes) {
			IdealType idealType = IdealType.get(type);
			checkNotNull(idealType, "Invalid ideal type %s", type);
			excludedTypes.add(idealType);
		}
		Set<IdealType> includedTypes = Sets.difference(setOfAllIdealTypes(), excludedTypes);
		checkArgument(includedTypes.size() > 0, "You cannot exclude all ideal types.");
		if (background == -1) {
			// Mixed background
			String ideal = null;
			do {
				try {
					ideal = BACKGROUNDS.get().getIdeals().includes(includedTypes).getValue();
				} catch (IllegalArgumentException ex) {}
			} while (ideal == null);
			
			RandomizableStringSource traits1 = BACKGROUNDS.get().getPersonalityTraits();
			RandomizableStringSource traits2 = BACKGROUNDS.get().getPersonalityTraits();
			String trait1 = null, trait2 = null;
			if (traits1 != traits2) {
				trait1 = traits1.getValue();
				trait2 = traits2.getValue();
			} else {
				IntegerSource source = traits1.getIntegerSource();
				int roll1 = source.getValue();
				int roll2;
				do {
					roll2 = source.getValue();
				} while (roll2 == roll1);
				trait1 = traits1.getValue(roll1);
				trait2 = traits1.getValue(roll2);
			}
			
			PcPersonality personality = newPcPersonality()
					.withBackground("Any")
					.withPersonalityTrait1(trait1)
					.withPersonalityTrait2(trait2)
					.withIdeal(ideal)
					.withBond(BACKGROUNDS.get().getBond().getValue())
					.withFlaw(BACKGROUNDS.get().getFlaw().getValue())
					.build();
			return personality;
		}
		
		Background backgroundObject = null;
		if (background == 0) {
			boolean backgroundFound = false;
			do {
			    backgroundObject = BACKGROUNDS.get();
			    if (!disjoint(backgroundObject.getIdeals().getIdealTypes(), includedTypes)) {
			    	backgroundFound = true;
			    }
			} while (!backgroundFound);
		} else {
			backgroundObject = BACKGROUNDS.get(background - 1);
		}
		checkArgument(!disjoint(backgroundObject.getIdeals().getIdealTypes(), includedTypes), "The selected background does not support the specified ideal types");

		IntegerSource source = backgroundObject.getPersonalityTraits().getIntegerSource();
		int roll1 = source.getValue();
		int roll2;
		do {
			roll2 = source.getValue();
		} while (roll2 == roll1);
		String trait1 = backgroundObject.getPersonalityTraits().getValue(roll1);
		String trait2 = backgroundObject.getPersonalityTraits().getValue(roll2);
	
		
		PcPersonality.Builder builder = newPcPersonality()
				.withBackground(backgroundObject.getName())
				.withPersonalityTrait1(trait1)
				.withPersonalityTrait2(trait2)
				.withIdeal(backgroundObject.getIdeals().includes(includedTypes).getValue())
				.withBond(backgroundObject.getBond().getValue())
				.withFlaw(backgroundObject.getFlaw().getValue());
	
		if (backgroundObject.getAdditionalTable().isPresent()) {
			NamedRandomizableStringSource table = backgroundObject.getAdditionalTable().get();
			builder.withAdditionalInfo(table.getName(), table.getValue());
		}
		
		return builder.build();
	}
	
	public Trinket generateTrinket () {
		Trinket trinket = newTrinket(Trinkets.TRINKETS.getValue());
		return trinket;
	}
	
	public ClimateCategory generateClimateCategory (int terrainIdx, int terrainLocationIdx, int latitude) {
		Terrain terrain = Terrain.terrainFor(terrainIdx);
		if (terrain == null) {
			throw new IllegalArgumentException("Invalid terrain.");
		}
		
		TerrainLocation terrainLocation = TerrainLocation.terrainLocationFor(terrainLocationIdx);
		if (terrainLocation == null) {
			throw new IllegalArgumentException("Invalid terrain location.");
		}
		if (!Latitudes.isValid(latitude)) {
			throw new IllegalArgumentException("Invalid latitude.");
		}
		
		ClimateCategory climate = ClimateCategory.climateCategoryFor(terrain, terrainLocation, latitude);
        if (climate == null) {
        	throw new IllegalArgumentException("Invalid latitude for the terrain in question.");
        }
	    return climate;		
	}
	
	public AdvancedWeather generateAdvanceWeather(int climateCategoryIdx, int hemisphereIdx, int monthIdx) {
		ClimateCategory climate = ClimateCategory.climateCategoryFor(climateCategoryIdx);
		if (climate == null) {
			throw new IllegalArgumentException("Invalid climate category.");
		}
		
		Hemisphere hemisphere = Hemisphere.hemisphereFor(hemisphereIdx);
		if (hemisphere == null) {
			throw new IllegalArgumentException("Invalid hemisphere.");
		}
		
		Month month = Month.monthFor(monthIdx);
		if (month == null) {
			throw new IllegalArgumentException("Invalid month.");
		}
		
		AdvancedWeather weather = AdvancedWeather.generateWeather(climate, hemisphere, month);
		return weather;
	}
	
	public MonsterStatistics getMonsterStats(int hitPoints, int armorClass, int damagePerRound, int attackType, int attackValue) {
		if (attackType != 0 && attackType != 1) {
			attackType = 0;
		}
		AttackType type = AttackType.values()[attackType];
		if (type == AttackType.ATTACK_BONUS) {
			return getMonsterStatsByAttackBonus(hitPoints, armorClass, damagePerRound, attackValue);
		} else {
			return getMonsterStatsBySaveDc(hitPoints, armorClass, damagePerRound, attackValue);
		}
	}
	
	private MonsterStatistics getMonsterStatsByAttackBonus (int hitPoints, int armorClass, int damagePerRound, int attackBonus) {
		ChallengeRating cr = MonsterStats.getAverageChallengeRatingByAttackBonus(hitPoints, armorClass, damagePerRound, attackBonus);
		MonsterStats stats = MonsterStats.getStatsByChallengeRating(cr);
		MonsterStatistics result = MonsterStatistics.newMonsterStatistics()
				.withChallengeRating(stats.getChallengeRating())
				.withArmorClass(armorClass)
				.withHitPoints(hitPoints)
				.withDamagePerRound(damagePerRound)
				.withAttackBonus(attackBonus)
				.withProficiencyBonus(stats.getProficiencyBonus().lowerEndpoint())
				.withSaveDc(stats.getSaveDc())
				.build();
		return result;
	}
	
	
	
	private MonsterStatistics getMonsterStatsBySaveDc (int hitPoints, int armorClass, int damagePerRound, int saveDc) {
		ChallengeRating cr = MonsterStats.getAverageChallengeRatingBySaveDc(hitPoints, armorClass, damagePerRound, saveDc);
		MonsterStats stats = MonsterStats.getStatsByChallengeRating(cr);
		MonsterStatistics result = MonsterStatistics.newMonsterStatistics()
				.withChallengeRating(stats.getChallengeRating())
				.withArmorClass(armorClass)
				.withHitPoints(hitPoints)
				.withDamagePerRound(damagePerRound)
				.withAttackBonus(stats.getAttackBonus())
				.withProficiencyBonus(stats.getProficiencyBonus().lowerEndpoint())
				.withSaveDc(saveDc)
				.build();
		return result;
	}
	
	public MonsterStatistics generateMonsterStats (double challengeRating) {
		ChallengeRating cr = ChallengeRating.get(challengeRating);
		if (cr == null) {
			throw new IllegalArgumentException("An invalid challenge rating was specified");
		}
		MonsterStats stats = MonsterStats.getStatsByChallengeRating(cr);
		MonsterStatistics result = MonsterStatistics.newMonsterStatistics()
				.withChallengeRating(stats.getChallengeRating())
				.withArmorClass(newRandomInt(stats.getArmorClass().lowerEndpoint(), stats.getArmorClass().upperEndpoint()).getValue())
				.withHitPoints(newRandomInt(stats.getHitPoints().lowerEndpoint(), stats.getHitPoints().upperEndpoint()).getValue())
				.withDamagePerRound(newRandomInt(stats.getDamagePerRound().lowerEndpoint(), stats.getDamagePerRound().upperEndpoint()).getValue())
				.withAttackBonus(newRandomInt(stats.getAttackBonus().lowerEndpoint(), stats.getAttackBonus().upperEndpoint()).getValue())
				.withProficiencyBonus(newRandomInt(stats.getProficiencyBonus().lowerEndpoint(), stats.getProficiencyBonus().upperEndpoint()).getValue())
				.withSaveDc(newRandomInt(stats.getSaveDc().lowerEndpoint(), stats.getSaveDc().upperEndpoint()).getValue())
				.build();
		return result;
		
	}
}
