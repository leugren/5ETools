package org.devoware.table.model;

import static org.devoware.table.dice.Die.D20;
import static org.devoware.table.model.FormattedValue.newFormattedValue;
import static org.devoware.table.model.ValueRangeMap.newValueRangeMap;

public class Buildings {

	public static final RandomizableStringSource RESIDENCE = newValueRangeMap(D20)
			.with(1, 2, "Abandoned squat")
			.with(3, 8, "Middle-class home")
			.with(9, 10, "Upper-class home")
			.with(11, 15, "Crowded tenement")
			.with(16, 17, "Orphanage")
			.with(18, "Hidden slavers' den")
			.with(19, "Front for a secret cult")
			.with(20, "Lavish, guarded mansion")
			.build();

	public static final RandomizableStringSource RELIGIOUS_BUILDING = newValueRangeMap(D20)
			.with(1, 10, "Temple to a good or neutral deity")
			.with(11, 12, "Temple to a false deity (run by charlatan priests)")
			.with(13, "Home of ascetics")
			.with(14, 15, "Abandoned shrine")
			.with(16, 17, "Library dedicated to religious study")
			.with(18, 20, "Hidden shrine to a fiend or an evil deity")
			.build();

	public static final RandomizableStringSource TAVERN = newValueRangeMap(D20)
			.with(1, 5, "Quiet, low-key bar")
			.with(6, 9, "Raucous dive")
			.with(10, "Thieves' guild hangout")
			.with(11, "Gathering place for a secret society")
			.with(12, 13, "Upper-class dining club")
			.with(14, 15, "Gambling den")
			.with(16, 17, "Caters to specific race or guild")
			.with(18, "Members-only club")
			.with(19, 20, "Brothel")
			.build();
	
	public static final RandomizableStringSource TAVERN_NAME_FIRST = newValueRangeMap(D20)
			.with(1, "The Silver")
			.with(2, "The Golden")
			.with(3, "The Staggering")
			.with(4, "The Laughing")
			.with(5, "The Prancing")
			.with(6, "The Gilded")
			.with(7, "The Running")
			.with(8, "The Howling")
			.with(9, "The Slaughtered")
			.with(10, "The Leering")
			.with(11, "The Drunken")
			.with(12, "The Leaping")
			.with(13, "The Roaring")
			.with(14, "The Frowning")
			.with(15, "The Lonely")
			.with(16, "The Wandering")
			.with(17, "The Mysterious")
			.with(18, "The Barking")
			.with(19, "The Black")
			.with(20, "The Gleaming")
			.build();
	
	public static final RandomizableStringSource TAVERN_NAME_SECOND = newValueRangeMap(D20)
			.with(1, "Eel")
			.with(2, "Dolphin")
			.with(3, "Dwarf")
			.with(4, "Pegasus")
			.with(5, "Pony")
			.with(6, "Rose")
			.with(7, "Stag")
			.with(8, "Wolf")
			.with(9, "Lamb")
			.with(10, "Demon")
			.with(11, "Goat")
			.with(12, "Spirit")
			.with(13, "Horde")
			.with(14, "Jester")
			.with(15, "Mountain")
			.with(16, "Eagle")
			.with(17, "Satyr")
			.with(18, "Dog")
			.with(19, "Spider")
			.with(20, "Star")
			.build();

	public static final RandomizableStringSource WAREHOUSE = newValueRangeMap(D20)
			.with(1, 4, "Empty or abandoned")
			.with(5, 6, "Heavily guarded, expensive goods")
			.with(7, 10, "Cheap goods")
			.with(11, 14, "Bulk goods")
			.with(15, "Live animals")
			.with(16, 17, "Weapons/armor")
			.with(18, 19, "Goods from a distant land")
			.with(20, "Secret smuggler's den")
			.build();

	public static final RandomizableStringSource SHOP = newValueRangeMap(D20)
			.with(1, "Pawnshop")
			.with(2, "Herbs/incense")
			.with(3, "Fruits/vegetables")
			.with(4, "Dried meats")
			.with(5, "Pottery")
			.with(6, "Undertaker")
			.with(7, "Books")
			.with(8, "Moneylender")
			.with(9, "Weapons/armor")
			.with(10, "Chandler")
			.with(11, "Smithy")
			.with(12, "Carpenter")
			.with(13, "Weaver")
			.with(14, "Jewelry")
			.with(15, "Baker")
			.with(16, "Mapmaker")
			.with(17, "Tailor")
			.with(18, "Ropemaker")
			.with(19, "Mason")
			.with(20, "Scribe")
			.build();

	public static final RandomizableStringSource BUILDING_TYPE = newValueRangeMap(D20)
			.with(1, 10, newFormattedValue("Residence - %s", RESIDENCE))
			.with(11, 12, newFormattedValue("Religious - %s", RELIGIOUS_BUILDING))
			.with(13, 15, newFormattedValue("Tavern - %s %s, %s ", TAVERN_NAME_FIRST, TAVERN_NAME_SECOND, TAVERN))
			.with(16, 17, newFormattedValue("Warehouse - %s", WAREHOUSE))
			.with(18, 20, newFormattedValue("Shop - %s", SHOP))
			.build();
	
	public static final StringSource RANDOM_TAVERN = newFormattedValue("%s %s - %s ", TAVERN_NAME_FIRST, TAVERN_NAME_SECOND, TAVERN);
}
