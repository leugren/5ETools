package org.devoware.table.model;

import static org.devoware.table.dice.Die.*;
import static org.devoware.table.model.FormattedValue.newFormattedValue;
import static org.devoware.table.model.ValueRangeMap.newValueRangeMap;

public class WorldShakingEvents {

	public static final RandomizableStringSource LEADER_TYPES = newValueRangeMap(D6)
			.with(1, "Political")
			.with(2, "Religious")
			.with(3, "Military")
			.with(4, "Crime/underworld")
			.with(5, "Art/culture")
			.with(6, "Philosophy/learning/magic")
			.build();

	public static final RandomizableStringSource CATACLYSMIC_DISASTER = newValueRangeMap(D10)
			.with(1, "Earthquake")
			.with(2, "Famine/draught")
			.with(3, "Fire")
			.with(4, "Flood")
			.with(5, "Plague/disease")
			.with(6, "Rain of fire (meteoric impact)")
			.with(7, "Storm (hurricane, tornado, tsunami)")
			.with(8, "Volcanic eruption")
			.with(9, "Magic gone awry or a planar warp")
			.with(10, "Divine judgment")
			.build();

	public static final RandomizableStringSource INVADING_FORCES = newValueRangeMap(D10)
			.with(1, "A criminal enterprise")
			.with(2, "Monsters or a unique monster")
			.with(3, "A planar threat")
			.with(4, "A past adversary reawakened, reborn, or resurgent")
			.with(5, "A splinter faction")
			.with(6, "A savage tribe")
			.with(7, "A secret society")
			.with(8, "A traitorous ally")
			.with(9, "A religious crusade")
			.with(10, "A conquering empire")
			.build();
	
	public static final RandomizableStringSource EXTINCTION_OR_DEPLETION = newValueRangeMap(D8)
			.with(1, "A kind of animal (insect, bird, fish, livestock)")
			.with(2, "Habitable land")
			.with(3, "Magic or magic-users (all magic, or specific kinds or schools of magic)")
			.with(4, "A mineral resource (gems, metals, ores)")
			.with(5, "A type of monster (unicorn, mantucore, dragon)")
			.with(6, "A people (family line, clan, culture, race)")
			.with(7, "A kind of plant (crop, tree, herb, forest)")
			.with(8, "A waterway (river, lake, ocean)")
			.build();

	public static final RandomizableStringSource NEW_ORGANIZATIONS = newValueRangeMap(D10)
			.with(1, "Crime syndicate / bandit confederacy")
			.with(2, "Guild (masons, apothecaries, goldsmiths)")
			.with(3, "Magical circle / society")
			.with(4, "Military / knightly order")
			.with(5, "New family dynasty / tribe / clan")
			.with(6, "Philosophy / discipline dedicated to a principle or ideal")
			.with(7, "Realm (village, town, duchy, kingdom)")
			.with(8, "Religion / sect / denomination")
			.with(9, "School / university")
			.with(10, "Secret society / cult / cabal")
			.build();

	public static final RandomizableStringSource DISCOVERIES = newValueRangeMap(D10)
			.with(1, "Ancient ruin / lost city of a legendary race")
			.with(2, "Animal / monster / magical mutation")
			.with(3, "Invention / technology / magic (helpful, destructive)")
			.with(4, "New (or forgotten) god or planar deity")
			.with(5, "New (or rediscovered) artifact or religious relic")
			.with(6, "New land (island, continent, lost world, demiplane)")
			.with(7, "Otherworldly object (planar portal, alien spacecraft)")
			.with(8, "People (race, tribe, lost civilization, colony)")
			.with(9, "Plant (miracle herb, fungal parasite, sentient plant)")
			.with(10, "Resource or wealth (gold, gems, mithral)")
			.build();

	public static final RandomizableStringSource EVENTS = newValueRangeMap(D10)
			.with(1, newFormattedValue("Rise of a leader or an era - %s", LEADER_TYPES))
			.with(2, newFormattedValue("Fall of a leader or an era - %s", LEADER_TYPES))
			.with(3, newFormattedValue("Cataclysmic disaster - %s", CATACLYSMIC_DISASTER))
			.with(4, newFormattedValue("Assault or invasion - %s", INVADING_FORCES))
			.with(5, "Rebellion, revolution, overthrow")
			.with(6, newFormattedValue("Extinction or depletion - %s", EXTINCTION_OR_DEPLETION))
			.with(7, newFormattedValue("New organization - %s", NEW_ORGANIZATIONS))
			.with(8, newFormattedValue("Discovery, expansion, invention - %s", DISCOVERIES))
			.with(9, "Prediction, omen, prophesy")
			.with(10, "Myth and legend")
			.build();
	
	private WorldShakingEvents() {}
}
