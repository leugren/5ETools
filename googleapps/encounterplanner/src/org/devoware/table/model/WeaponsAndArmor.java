package org.devoware.table.model;

import static org.devoware.table.model.ValueSet.newValueSet;

public class WeaponsAndArmor {

	public static final ValueSet AMMUNITION = newValueSet()
		    .with("Arrow")
		    .with("Blowgun needle")
		    .with("Crossbow bolt")
		    .with("Sling bullet")
		    .build();
	
	public static final ValueSet LIGHT_ARMOR = newValueSet()
			.with("Padded armor")
			.with("Leather armor")
			.with("Studded leather armor")
			.build();
	
	public static final ValueSet MEDIUM_ARMOR = newValueSet()
			.with("Hide armor")
			.with("Chain shirt armor")
			.with("Scale mail armor")
			.with("Breastplate armor")
			.with("Half plate armor")
			.build();

	public static final ValueSet HEAVY_ARMOR = newValueSet()
			.with("Ring mail armor")
			.with("Chain mail armor")
			.with("Splint mail armor")
			.with("Plate armor")
			.build();

	public static final ValueSet ARMOR = newValueSet()
			.with(LIGHT_ARMOR)
			.with(MEDIUM_ARMOR)
			.with(HEAVY_ARMOR)
			.build();
	
	public static final ValueSet SIMPLE_MELEE_WEAPONS = newValueSet()
			.with("Club")
			.with("Dagger")
			.with("Greatclub")
			.with("Handaxe")
			.with("Javelin")
			.with("Light hammer")
			.with("Mace")
			.with("Quarterstaff")
			.with("Sickle")
			.with("Spear")
			.build();

	public static final ValueSet SIMPLE_RANGED_WEAPONS = newValueSet()
			.with("Light crossbow")
			.with("Dart")
			.with("Shortbow")
			.with("Sling")
			.build();
			
	public static final ValueSet SIMPLE_WEAPONS = newValueSet()
			.with(SIMPLE_MELEE_WEAPONS)
			.with(SIMPLE_RANGED_WEAPONS)
			.build();
	
	public static final ValueSet MARTIAL_MELEE_WEAPONS = newValueSet()
			.with("Battleaxe")
			.with("Flail")
			.with("Glaive")
			.with("Greataxe")
			.with("Greatsword")
			.with("Halberd")
			.with("Lance")
			.with("Longsword")
			.with("Maul")
			.with("Morningstar")
			.with("Pike")
			.with("Rapier")
			.with("Scimitar")
			.with("Shortsword")
			.with("Trident")
			.with("War pick")
			.with("Warhammer")
			.with("Whip")
			.build();
	
	public static final ValueSet MARTIAL_RANGED_WEAPONS = newValueSet()
			.with("Blowgun")
			.with("Hand crossbow")
			.with("Heavy crossbow")
			.with("Longbow")
			.with("Net")
			.build();

	public static final ValueSet MARTIAL_WEAPONS = newValueSet()
			.with(MARTIAL_MELEE_WEAPONS)
			.with(MARTIAL_RANGED_WEAPONS)
			.build();
	
	public static final ValueSet MELEE_WEAPONS = newValueSet()
			.with(SIMPLE_MELEE_WEAPONS)
			.with(MARTIAL_MELEE_WEAPONS)
			.build();

	public static final ValueSet RANGED_WEAPONS = newValueSet()
			.with(SIMPLE_RANGED_WEAPONS)
			.with(MARTIAL_RANGED_WEAPONS)
			.build();

	public static final ValueSet WEAPONS = newValueSet()
			.with(MELEE_WEAPONS)
			.with(RANGED_WEAPONS)
			.build();
	
	
    private WeaponsAndArmor () {}
}
