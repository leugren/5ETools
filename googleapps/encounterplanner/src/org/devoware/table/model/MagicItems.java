package org.devoware.table.model;

import static org.devoware.table.dice.Die.D10;
import static org.devoware.table.dice.Die.D100;
import static org.devoware.table.dice.Die.D12;
import static org.devoware.table.dice.Die.D8;
import static org.devoware.table.dice.Die.newDie;
import static org.devoware.table.model.FormattedValue.newFormattedValue;
import static org.devoware.table.model.NamedRandomizableStringSource.newNamedStringSource;
import static org.devoware.table.model.Spells.CANTRIPS;
import static org.devoware.table.model.Spells.LEVEL_1_SPELLS;
import static org.devoware.table.model.Spells.LEVEL_2_SPELLS;
import static org.devoware.table.model.Spells.LEVEL_3_SPELLS;
import static org.devoware.table.model.Spells.LEVEL_4_SPELLS;
import static org.devoware.table.model.Spells.LEVEL_5_SPELLS;
import static org.devoware.table.model.Spells.LEVEL_6_SPELLS;
import static org.devoware.table.model.Spells.LEVEL_7_SPELLS;
import static org.devoware.table.model.Spells.LEVEL_8_SPELLS;
import static org.devoware.table.model.Spells.LEVEL_9_SPELLS;
import static org.devoware.table.model.ValueRangeMap.newValueRangeMap;
import static org.devoware.table.model.WeaponsAndArmor.AMMUNITION;
import static org.devoware.table.model.WeaponsAndArmor.WEAPONS;

public class MagicItems {
	
	public static final RandomizableStringSource DAMAGE_TYPE = newValueRangeMap(D10)
			.with(1, "acid")
			.with(2, "cold")
			.with(3, "fire")
			.with(4, "force")
			.with(5, "lightning")
			.with(6, "necrotic")
			.with(7, "psychic")
			.with(8, "poison")
			.with(9, "radiant")
			.with(10, "thunder")
			.build();
	
	
	public static final RandomizableStringSource MAGIC_ITEM_TABLE_A = newNamedStringSource("MAGIC ITEM TABLE A",  
			newValueRangeMap(D100)
				.with(1, 50, "Potion of healing")
				.with(51, 60, newFormattedValue("Spell scroll (%s)", CANTRIPS))
				.with(61, 70, "Potion of climbing")
				.with(71, 90, newFormattedValue("Spell scroll (%s)", LEVEL_1_SPELLS))
			    .with(91, 94, newFormattedValue("Spell scroll (%s)", LEVEL_2_SPELLS))
				.with(95, 98, "Potion of greater healing")
				.with(99, "Bag of holding")
				.with(100, "Driftglobe")
				.build());
			
	public static final RandomizableStringSource MAGIC_ITEM_TABLE_B = newNamedStringSource("MAGIC ITEM TABLE B",  
			newValueRangeMap(D100)
				.with(1, 15, "Potion of greater healing")
				.with(16, 22, "Potion of fire breath")
				.with(23, 29, newFormattedValue("Potion of %s resistance", DAMAGE_TYPE))
				.with(30, 34, newFormattedValue("+1 %s", AMMUNITION))
				.with(35, 39, "Potion of animal friendship")
				.with(40, 44, "Potion of hill giant strength")
				.with(45, 49, "Potion of growth")
				.with(50, 54, "Potion of water breathing")
				.with(55, 59, newFormattedValue("Spell scroll (%s)", LEVEL_2_SPELLS))
				.with(60, 64, newFormattedValue("Spell scroll (%s)", LEVEL_3_SPELLS))
				.with(65, 67, "Bag of holding")
				.with(68, 70, "Keoghtom's ointment")
				.with(71, 73, "Oil of slipperiness")
				.with(74, 75, "Dust of disappearance")
				.with(76, 77, "Dust of dryness")
				.with(78, 79, "Dust of sneezing and choking")
				.with(80, 81, "Elemental gem")
				.with(82, 83, "Philter of love")
				.with(84, "Alchemy jug")
				.with(85, "Cap of water breathing")
				.with(86, "Cloak of the manta ray")
				.with(87, "Driftglobe")
				.with(88, "Goggles of night")
				.with(89, "Helm of comprehending languages")
				.with(90, "Immovable rod")
				.with(91, "Lantern of revealing")
				.with(92, "Mariner's armor")
				.with(93, "Mithral armor")
				.with(94, "Potion of poison")
				.with(95, "Ring of swimming")
				.with(96, "Robe of useful items")
				.with(97, "Rope of climbing")
				.with(98, "Saddle of the cavalier")
				.with(99, "Wand of magic detection")
				.with(100, "Wand of secrets")
				.build());
	
	public static final RandomizableStringSource MAGIC_ITEM_TABLE_C = newNamedStringSource("MAGIC ITEM TABLE C",  
			newValueRangeMap(D100)
				.with(1, 15, "Potion of superior healing")
				.with(16, 22, newFormattedValue("Spell scroll (%s)", LEVEL_4_SPELLS))
				.with(23, 27, newFormattedValue("+2 %s", AMMUNITION))
				.with(28, 32, "Potion of clairvoyance")
				.with(33, 37, "Potion of diminution")
				.with(38, 42, "Potion of gaseous form")
				.with(43, 47, "Potion of frost giant strength")
				.with(48, 52, "Potion of stone giant strength")
				.with(53, 57, "Potion of heroism")
				.with(58, 62, "Potion of invulnerability")
				.with(63, 67, "Potion of mind reading")
				.with(68, 72, newFormattedValue("Spell scroll (%s)", LEVEL_5_SPELLS))
				.with(73, 75, "Elixir of health")
				.with(76, 78, "Oil of etherealness")
				.with(79, 81, "Potion of fire giant strength")
				.with(82, 84, "Quaal's feather token")
				.with(85, 87, "Scroll of protection")
				.with(88, 89, "Bag of beans")
				.with(90, 91, "Bead of force")
				.with(92, "Chime of opening")
				.with(93, "Decanter of endless water")
				.with(94, "Eyes of minute seeing")
				.with(95, "Folding boat")
				.with(96, "Heward's handy haversack")
				.with(97, "Horseshoes of speed")
				.with(98, "Necklace of fireballs")
				.with(99, "Periapt of health")
				.with(100, "Sending stones")
				.build());
	
	public static final RandomizableStringSource MAGIC_ITEM_TABLE_D = newNamedStringSource("MAGIC ITEM TABLE D",  
			newValueRangeMap(D100)
				.with(1, 20, "Potion of supreme healing")
				.with(21, 30, "Potion of invisibility")
				.with(31, 40, "Potion of speed")
				.with(41, 50, newFormattedValue("Spell scroll (%s)", LEVEL_6_SPELLS))
				.with(51, 57, newFormattedValue("Spell scroll (%s)", LEVEL_7_SPELLS))
				.with(58, 62, newFormattedValue("+3 %s", AMMUNITION))
				.with(63, 67, "Oil of sharpness")
				.with(68, 72, "Potion of flying")
				.with(73, 77, "Potion of cloud giant stength")
				.with(78, 82, "Potion of longevity")
				.with(83, 87, "Potion of vitality")
				.with(88, 92, newFormattedValue("Spell scroll (%s)", LEVEL_8_SPELLS))
				.with(93, 95, "Horseshoes of the zephyr")
				.with(96, 98, "Nolzur's marvelous pigments")
				.with(99, "Bag of devouring")
				.with(100, "Portable hole")
				.build());

	public static final RandomizableStringSource MAGIC_ITEM_TABLE_E = newNamedStringSource("MAGIC ITEM TABLE E",  
			newValueRangeMap(D100)
				.with(1, 30, newFormattedValue("Spell scroll (%s)", LEVEL_8_SPELLS))
				.with(31, 55, "Potion of storm giant strength")
				.with(56, 70, "Potion of supreme healing")
				.with(71, 85, newFormattedValue("Spell scroll (%s)", LEVEL_9_SPELLS))
				.with(86, 93, "Universal solvent")
				.with(94, 98, "Arrow of slaying")
				.with(99, 100, "Sovereign glue")
				.build());
	
	public static final RandomizableStringSource MAGIC_ITEM_TABLE_F = newNamedStringSource("MAGIC ITEM TABLE F",  
			newValueRangeMap(D100)
				.with(1, 15, newFormattedValue("+1 %s", WEAPONS))
				.with(16, 18, "+1 Shield")
				.with(19, 21, "Sentinel Shield")
				.with(22, 23, "Amulet of proof against detection and location")
				.with(24, 25, "Boots of elvenkind")
				.with(26, 27, "Boots of springing and striding")
				.with(28, 29, "Bracers of archery")
				.with(30, 31, "Brooch of shielding")
				.with(32, 33, "Broom of flying")
				.with(34, 35, "Cloak of elvenkind")
				.with(36, 37, "Cloak of protection")
				.with(38, 39, "Gauntlets of ogre power")
				.with(40, 41, "Hat of disguise")
				.with(42, 43, "Javelin of lightning")
				.with(44, 45, "Pearl of power")
				.with(46, 47, "+1 Rod of the pact keeper")
				.with(48, 49, "Slippers of spider climbing")
				.with(50, 51, "Staff of the adder")
				.with(52, 53, "Staff of the python")
				.with(54, 55, "Sword of vengeance")
				.with(56, 57, "Trident of fish command")
				.with(58, 59, "Wand of magic missiles")
				.with(60, 61, "+1 Wand of the war mage")
				.with(62, 63, "Wand of web")
				.with(64, 65, "Weapon of warning")
			    .with(66, "Adamantine armor (chain mail)")
			    .with(67, "Adamantine armor (chain shirt)")
			    .with(68, "Adamantine armor (scale mail)")
			    .with(69, "Bag of tricks (gray)")
			    .with(70, "Bag of tricks (rust)")
			    .with(71, "Bag of tricks (tan)")
			    .with(72, "Boots of the winterlands")
			    .with(73, "Circlet of blasting")
			    .with(74, "Deck of illusions")
			    .with(75, "Eversmoking bottle")
			    .with(76, "Eyes of charming")
			    .with(77, "Eyes of the eagle")
			    .with(78, "Figurine of wondrous power (Silver raven)")
			    .with(79, "Gem of brightness")
			    .with(80, "Gloves of missile snaring")
			    .with(81, "Gloves of swimming and climbing")
			    .with(82, "Gloves of thievery")
			    .with(83, "Headband of intellect")
			    .with(84, "Helm of telepathy")
			    .with(85, "Instrument of the bards (Doss lute)")
			    .with(86, "Instrument of the bards (Fochlucan bandore)")
			    .with(87, "Instrument of the bards (Mac-Fuimidh cittern)")
			    .with(88, "Medallion of thooughts")
			    .with(89, "Necklace of adaptation")
			    .with(90, "Periapt of wound closure")
			    .with(91, "Pipes of haunting")
			    .with(92, "Pipes of the sewers")
			    .with(93, "Ring of jumping")
			    .with(94, "Ring of mind shielding")
			    .with(95, "Ring of warmth")
			    .with(96, "Ring of water walking")
			    .with(97, "Quiver of Ehlonna")
			    .with(98, "Stone of good luck")
			    .with(99, "Wind fan")
			    .with(100, "Winged boots")
			    .build());

	public static final RandomizableStringSource MAGIC_ITEM_TABLE_G = newNamedStringSource("MAGIC ITEM TABLE G",  
			newValueRangeMap(D100)
				.with(1, 11, newFormattedValue("+2 %s", WEAPONS))
				.with(12, 14, newFormattedValue("Figuring of wondrous power %s", newValueRangeMap(D8)
						    .with(1, "Bronze griffon")
						    .with(2, "Ebony fly")
						    .with(3, "Golden lions")
						    .with(4, "Ivory goats")
						    .with(5, "Marble elephant")
						    .with(6, 7, "Onyx dog")
						    .with(8, "Serpentine owl")
						    .build()
						))
			    .with(15, "Adamantine armor (breastplate)")
			    .with(16, "Adamantine armor (splint)")
			    .with(17, "Amulet of health")
			    .with(18, "Armor of vulnerability")
			    .with(19, "Arrow-catching shield")
			    .with(20, "Belt of dwarvenkind")
			    .with(21, "Belt of hill giant strength")
			    .with(22, "Berserker axe")
			    .with(23, "Boots of levitation")
			    .with(24, "Boots of speed")
			    .with(25, "Bowl of commanding water elementals")
			    .with(26, "Bracers of defense")
			    .with(27, "Brazier of commanding fire elementals")
			    .with(28, "Cape of the mountebank")
			    .with(29, "Censer of controlling air elementals")
			    .with(30, "+1 Chain mail armor")
			    .with(31, newFormattedValue("Armor of %s resistance (chain mail)", DAMAGE_TYPE))
			    .with(32, "+1 Chain shirt armor")
			    .with(33, newFormattedValue("Armor of %s resistance (chain shirt)", DAMAGE_TYPE))
			    .with(34, "Cloak of displacement")
			    .with(35, "Cloak of the bat")
			    .with(36, "Cube of force")
			    .with(37, "Daern's instant fortress")
			    .with(38, "Dagger of venom")
			    .with(39, "Dimensional shackles")
			    .with(40, "Dragon slayer")
			    .with(41, "Elven chain")
			    .with(42, "Flame tongue")
			    .with(43, "Gem of seeing")
			    .with(44, "Giant slayer")
			    .with(45, "Glamoured studded leather")
			    .with(46, "Helm of teleportation")
			    .with(47, "Horn of blasting")
			    .with(48, newFormattedValue("Horn of Valhalla (%s)", newValueRangeMap(newDie(2))
					    .with(1, "silver")
					    .with(2, "brass")
					    .build()
					))
			    .with(49, "Instrument of the bards (Canaith mandolin)")
			    .with(50, "Instrument of the bards (Cli lyre)")
			    .with(51, "Ioun stone (awareness)")
			    .with(52, "Ioun stone (protection)")
			    .with(53, "Ioun stone (reserve)")
			    .with(54, "Ioun stone (sustenance)")
			    .with(55, "Iron bands of Bilarro")
			    .with(56, "+1 Leather armor")
			    .with(57, newFormattedValue("Armor of %s resistance (leather)", DAMAGE_TYPE))
			    .with(58, "Mace of disruption")
			    .with(59, "Mace of smiting")
			    .with(60, "Mace of terror")
			    .with(61, "Mantle of spell resistance")
			    .with(62, "Necklace of prayer beads")
			    .with(63, "Periapt of proof against poison")
			    .with(64, "Ring of animal influence")
			    .with(65, "Ring of evasion")
			    .with(66, "Ring of feather falling")
			    .with(67, "Ring of free action")
			    .with(68, "Ring of protection")
			    .with(69, newFormattedValue("Ring of %s resistance", DAMAGE_TYPE))
			    .with(70, "Ring of spell storing")
			    .with(71, "Ring of the ram")
			    .with(72, "Ring of X-ray vision")
			    .with(73, "Robe of eyes")
			    .with(74, "Rod of rulership")
			    .with(75, "+2 Rod of the pact keeper")
			    .with(76, "Rope of entanglement")
			    .with(77, "+1 Scale mail armor")
			    .with(78, newFormattedValue("Armor of %s resistance (scale mail)", DAMAGE_TYPE))
			    .with(79, "+2 Shield")
			    .with(80, "Shield of missile attraction")
			    .with(81, "Staff of charming")
			    .with(82, "Staff of healing")
			    .with(83, "Staff of swarming insects")
			    .with(84, "Staff of the woodlands")
			    .with(85, "Staff of withering")
			    .with(86, "Stone of controlling earth elementals")
			    .with(87, "Sun blade")
			    .with(88, "Sword of life stealing")
			    .with(89, "Sword of wounding")
			    .with(90, "Tentacle rod")
			    .with(91, "Vicious weapon")
			    .with(92, "Wand of binding")
			    .with(93, "Wand of enemy detection")
			    .with(94, "Wand of fear")
			    .with(95, "Wand of fireballs")
			    .with(96, "Wand of lightning bolts")
			    .with(97, "Wand of paralysis")
			    .with(98, "+2 Wand of the war mage")
			    .with(99, "Wand of wonder")
			    .with(100, "Wings of flying")
				.build());

	public static final RandomizableStringSource MAGIC_ITEM_TABLE_H = newNamedStringSource("MAGIC ITEM TABLE H",  
			newValueRangeMap(D100)
				.with(1, 10, newFormattedValue("+3 %s", WEAPONS))
				.with(11, 12, "Amulet of the planes")
				.with(13, 14, "Carpet of flying")
				.with(15, 16, "Crystal ball (very rare version)")
				.with(17, 18, "Ring of regeneration")
				.with(19, 20, "Ring of shooting stars")
				.with(21, 22, "Ring of telekinesis")
				.with(23, 24, "Robe of scintillating colors")
				.with(25, 26, "Robe of stars")
				.with(27, 28, "Rod of absorption")
				.with(28, 30, "Rod of alertness")
				.with(31, 32, "Rod of security")
				.with(33, 34, "+3 Rod of the pact keeper")
				.with(35, 36, "Scimitar of speed")
				.with(37, 38, "+3 Shield")
				.with(39, 40, "Staff of fire")
				.with(41, 42, "Staff of frost")
				.with(43, 44, "Staff of power")
				.with(45, 46, "Staff of striking")
				.with(47, 48, "Staff of thunder and lightning")
				.with(49, 50, "Sword of sharpness")
				.with(51, 52, "Wand of polymorph")
				.with(53, 54, "+3 Wand of the war mage")
				.with(55, "Adamantine armor (half plate)")
				.with(56, "Adamantine armor (plate)")
				.with(57, "Animated shield")
				.with(58, "Belt of fire giant strength")
				.with(59, newFormattedValue("Belt of %s giant strength", newValueRangeMap(newDie(2))
					    .with(1, "frost")
					    .with(2, "stone")
					    .build()
					))
				.with(60, "+1 Breastplate armor")
				.with(61, newFormattedValue("Armor of %s resistance (breastplate)", DAMAGE_TYPE))
				.with(62, "Candle of invocation")
				.with(63, "+2 Chain mail armor")
				.with(64, "+2 Chain shirt armor")
				.with(65, "Cloak of arachnida")
				.with(66, "Dancing sword")
				.with(67, "Demon armor")
				.with(68, "Dragon scale mail")
				.with(69, "Dwarven plate")
				.with(70, "Dwarven thrower")
				.with(71, "Efreeti bottle")
				.with(72, "Figurine of wondrous power (Obsidian steed)")
				.with(73, "Frost brand")
				.with(74, "Helm of brilliance")
				.with(75, "Horn of Valhalla (bronze)")
				.with(76, "Instrument of the bards (Anstruth harp)")
				.with(77, "Ioun stone (absorption)")
				.with(78, "Ioun stone (agility)")
				.with(79, "Ioun stone (fortitude)")
				.with(80, "Ioun stone (insight)")
				.with(81, "Ioun stone (intellect)")
				.with(82, "Ioun stone (leadership)")
				.with(83, "Ioun stone (strength)")
				.with(84, "+2 Leather armor")
				.with(85, "Manual of bodily health")
				.with(86, "Manual of gainful exercise")
				.with(87, "Manual of golems")
				.with(88, "Manual of quickness of action")
				.with(89, "Mirror of life trapping")
				.with(90, "Nine lives stealer")
				.with(91, "Oathbow")
				.with(92, "+2 Scale mail armor")
			    .with(93, "Spellguard shield")
				.with(94, "+1 Splint armor")
				.with(95, newFormattedValue("Armor of %s resistance (splint)", DAMAGE_TYPE))
				.with(96, "+1 Studded leather armor")
				.with(97, newFormattedValue("Armor of %s resistance (studded leather)", DAMAGE_TYPE))
				.with(98, "Tome of clear thought")
				.with(99, "Tome of leadership and influence")
				.with(100, "Tome of understanding")
			    .build());
	
	public static final RandomizableStringSource MAGIC_ITEM_TABLE_I = newNamedStringSource("MAGIC ITEM TABLE I",  
			newValueRangeMap(D100)
			.with(1, 5, "Defender")
			.with(6, 10, "Hammer of thunderbolts")
			.with(11, 15, "Luckblade")
			.with(16, 20, "Sword of answering")
			.with(21, 23, "Holy avenger")
			.with(24, 26, "Ring of djinni summoning")
			.with(27, 29, "Ring of invisibility")
			.with(30, 32, "Ring of spell turning")
			.with(33, 35, "Rod of lordly might")
			.with(36, 38, "Staff of the magi")
			.with(39, 41, "Vorpal sword")
			.with(42, 43, "Belt of cloud giant strength")
			.with(44, 45, "+2 Breastplate armor")
			.with(46, 47, "+3 Chain mail armor")
			.with(48, 49, "+3 Chain shirt armor")
			.with(50, 51, "Cloak of invisibility")
			.with(52, 53, "Crystal ball (legendary version)")
			.with(54, 55, "+1 Half plate armor")
			.with(56, 57, "Iron flask")
			.with(58, 59, "+3 Leather armor")
			.with(60, 61, "+1 Plate armor")
			.with(62, 63, "Robe of the archmagi")
			.with(64, 65, "Rod of resurrection")
			.with(66, 67, "+1 Scale mail armor")
			.with(68, 69, "Scarab of protection")
			.with(70, 71, "+2 Splint armor")
			.with(72, 73, "+2 Studded leather armor")
			.with(74, 75, "Well of many worlds")
			.with(76, newValueRangeMap(D12)
					    .with(1, 2, "+2 Half plate armor")
					    .with(3, 4, "+2 Plate armor")
					    .with(5, 6, "+3 Studded leather armor")
					    .with(7, 8, "+3 Breastplate armor")
					    .with(9, 10, "+3 Splint armor")
					    .with(11, "+3 Half plate armor")
					    .with(12, "+3 Plate armor")
					    .build()
					)
			.with(77, "Apparatus of Kwalish")
			.with(78, "Armor of invulnerability")
			.with(79, "Belt of storm giant strength")
			.with(80, "Cubic gate")
			.with(81, "Deck of many things")
			.with(82, "Efreeti chain")
			.with(83, newFormattedValue("Armor of %s resistance (half plate)", DAMAGE_TYPE))
			.with(84, "Horn of Valhalla (iron)")
			.with(85, "Instrument of the bards (Ollamh harp)")
			.with(86, "Ioun stone (greater absorption)")
			.with(87, "Ioun stone (mastery)")
			.with(88, "Ioun stone (regeneration)")
			.with(89, "Plate armor of etherealness")
			.with(90, newFormattedValue("Armor of %s resistance (plate)", DAMAGE_TYPE))
			.with(91, "Ring of air elemental command")
			.with(92, "Ring of earth elemental command")
			.with(93, "Ring of fire elemental command")
			.with(94, "Ring of three wishes")
			.with(95, "Ring of water elemental command")
			.with(96, "Sphere of annihilation")
			.with(97, "Talisman of pure good")
			.with(98, "Talisman of the sphere")
			.with(99, "Talisman of ultimate evil")
			.with(100, "Tome of the stilled tongue")
			.build());
	
	private MagicItems(){}

}
