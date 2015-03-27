package org.devoware.table.model;

import static org.devoware.table.dice.Dice.newDice;
import static org.devoware.table.dice.Die.D20;
import static org.devoware.table.dice.Die.D4;
import static org.devoware.table.model.FormattedIntegerValue.newFormattedIntegerValue;
import static org.devoware.table.model.ValueRangeMap.newValueRangeMap;

public class Wilderness {
	
	public static final RandomizableStringSource MONUMENTS = newValueRangeMap(D20)
			.with(1, "Sealed burial mound or pyramid")
			.with(2, "Plundered burial mound or pyramid")
			.with(3, "Faces carved into a mountainside or cliff")
			.with(4, "Giant statues carved out of a mountainside or cliff")
			.with(5, 6, "Intact obelisk etched with a warning, historical lore dedication, or religious iconography")
			.with(7, 8, "Ruined or toppled obelisk")
			.with(9, 10, "Intact statue of a person or deity")
			.with(11, 13, "Ruined or toppled statue of a person or deity")
			.with(14, "Great stone wall, intact, with tower fortifications spaced at one-mile intervals")
			.with(15, "Great stone wall in ruins")
			.with(16, "Great stone arch")
			.with(17, "Fountain")
			.with(18, "Intact circle of standing stones")
			.with(19, "Ruined or toppled circle of standing stones")
			.with(20, "Tome pole")
			.build();
	
	public static final RandomizableStringSource WEIRD_LOCALES = newValueRangeMap(D20)
			.with(1, 2, "Dead magic zone (similar to an anti-magic field)")
			.with(3, "Wild magic zone (roll on the Wild Magic Surge table in the Player's Handbook whenever a spell is cast within the zone)")
			.with(4, "Boulder carved with talking faces")
			.with(5, "Crystal cave that mystically answers questions")
			.with(6, "Ancient tree containing a trapped spirit")
			.with(7, 8, "Battlefield where lingering fog occasionally assumes humanoid forms")
			.with(9, 10, "Permanent portal to another plane of existence")
			.with(11, "Wishing well")
			.with(12, "Giant crystal shard protruding from the ground")
			.with(13, "Wrecked ship, which might be nowhere near water")
			.with(14, 15, "Haunted hill or barrow mound")
			.with(16, "River ferry guided by a skeletal captain")
			.with(17, "Field of petrified soldiers or other creatures")
			.with(18, "Forest of petrified or awakened trees")
			.with(19, "Canyon containing a dragons' graveyard")
			.with(20, "Floating earth mote with a tower on it")
			.build();

	public static final RandomizableStringSource TEMPERATURE = newValueRangeMap(D20)
			.with(1, 14, "Normal for the season")
			.with(15, 17, newFormattedIntegerValue("%d degrees Fahrenheit colder than normal", newDice().with(1, D4).withMultiplier(10).build()))
			.with(18, 20, newFormattedIntegerValue("%d degrees Fahrenheit hotter than normal", newDice().with(1, D4).withMultiplier(10).build()))
			.build();

	public static final RandomizableStringSource WIND = newValueRangeMap(D20)
			.with(1, 12, "None")
			.with(13, 17, "Light")
			.with(18, 20, "Strong")
			.build();

	public static final RandomizableStringSource PRECIPITATION = newValueRangeMap(D20)
			.with(1, 12, "None")
			.with(13, 17, "Light rain or light snowfall")
			.with(18, 20, "Heavy rain or heavy snowfall")
			.build();
}
