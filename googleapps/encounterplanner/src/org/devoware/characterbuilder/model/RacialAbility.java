package org.devoware.characterbuilder.model;

import java.util.Map;

import com.google.common.collect.ImmutableTable;
import com.google.common.collect.Table;
import com.google.common.collect.TreeBasedTable;

public enum RacialAbility {
	
	DWARF_HILL_ABILITY_SCORE_INCREASE("dwarfHill.abilityScoreIncrease", 
			"Ability Score Increase", 
			"Your Constitution score increases by 2 and your Wisdom score increases by 1."),
	DWARF_HILL_SIZE("dwarfHill.size", 
			"Size", 
			"Dwarves stand between 4 and 5 feet tall and average about 150 pounds. Your size is Medium."),
	DWARF_HILL_SPEED("dwarfHill.speed", 
			"Speed", 
			"Your base walking speed is 25 feet. Your speed is not reduced by wearing heavy armor."),
	DWARF_HILL_DARKVISION("dwarfHill.darkVision", 
			"Darkvision", 
			"Accustomed to life underground, you have superior vision in dark and dim conditions. You can see in dim light within 60 feet of you as if it were bright light, and in darkness as if it were dim light. You can’t discern color in darkness, only shades of gray."),
	DWARF_HILL_DWARVEN_RESILIENCE("dwarfHill.dwarvenResilience", 
			"Dwarven Resilience", 
			"You have advantage on saving throws against poison, and you have resistance against poison damage (explained in chapter 9)."),
	DWARF_HILL_DWARVEN_COMBAT_TRAINING("dwarfHill.dwarvenCombatTraining", 
			"Dwarven Combat Training", 
			"You have proficiency with the battleaxe, handaxe, throwing hammer, and warhammer."),
	DWARF_HILL_TOOL_PROFICIENCY("dwarfHill.toolProficiency", 
			"Tool Proficiency", 
			"You gain proficiency with the artisan’s tools of your choice: smith’s tools, brewer’s supplies, or mason’s tools."),
	DWARF_HILL_STONECUNNING("dwarfHill.stonecunning", 
			"Stonecunning", 
			"Whenever you make an Intelligence (History) check related to the origin of stonework, you are considered proficient in the History skill and add double your proficiency bonus to the check, instead of your normal proficiency bonus."),
	DWARF_HILL_DWARVEN_TOUGHNESS("dwarfHill.dwarvenToughness", 
			"Dwarven Toughness", 
			"Your hit point maximum increases by 1, and it increases by 1 every time you gain a level."),
	DWARF_MOUNTAIN_ABILITY_SCORE_INCREASE("dwarfMountain.abilityScoreIncrease", 
			"Ability Score Increase", 
			"Your Constitution score increases by 2 and your Wisdom score increases by 1."),
	DWARF_MOUNTAIN_SIZE("dwarfMountain.size", 
			"Size", 
			"Dwarves stand between 4 and 5 feet tall and average about 150 pounds. Your size is Medium."),
	DWARF_MOUNTAIN_SPEED("dwarfMountain.speed", 
			"Speed", 
			"Your base walking speed is 25 feet. Your speed is not reduced by wearing heavy armor."),
	DWARF_MOUNTAIN_DARKVISION("dwarfMountain.darkVision", 
			"Darkvision", 
			"Accustomed to life underground, you have superior vision in dark and dim conditions. You can see in dim light within 60 feet of you as if it were bright light, and in darkness as if it were dim light. You can’t discern color in darkness, only shades of gray."),
	DWARF_MOUNTAIN_DWARVEN_RESILIENCE("dwarfMountain.dwarvenResilience", 
			"Dwarven Resilience", 
			"You have advantage on saving throws against poison, and you have resistance against poison damage (explained in chapter 9)."),
	DWARF_MOUNTAIN_DWARVEN_COMBAT_TRAINING("dwarfMountain.dwarvenCombatTraining", 
			"Dwarven Combat Training", 
			"You have proficiency with the battleaxe, handaxe, throwing hammer, and warhammer."),
	DWARF_MOUNTAIN_TOOL_PROFICIENCY("dwarfMountain.toolProficiency", 
			"Tool Proficiency", 
			"You gain proficiency with the artisan’s tools of your choice: smith’s tools, brewer’s supplies, or mason’s tools."),
	DWARF_MOUNTAIN_STONECUNNING("dwarfMountain.stonecunning", 
			"Stonecunning", 
			"Whenever you make an Intelligence (History) check related to the origin of stonework, you are considered proficient in the History skill and add double your proficiency bonus to the check, instead of your normal proficiency bonus."),
	DWARF_MOUNTAIN_DWARVEN_ARMOR_TRAINING("dwarfMountain.dwarvenArmorTraining", 
			"Dwarven Armor Training", 
			"You have proficiency with light and medium armor."),
			;

	private static final Table<String, String, RacialAbility> TABLE;
	
	private final String tag;
	private final String label;
	private final String description;
	private final String decisionPageUrl;
	
	static {
		Table<String, String, RacialAbility> table = TreeBasedTable.create();
		for (RacialAbility ability: RacialAbility.values()) {
			int idx = ability.tag.indexOf('.');
			table.put(ability.tag.substring(0, idx), ability.tag.substring(idx), ability);
		}
		TABLE = ImmutableTable.copyOf(table);
	}
	
	public static RacialAbility getByTag (String tag) {
		if (tag == null) {
			return null;
		}
		int idx = tag.indexOf('.');
		if (idx == -1) {
			return null;
		}
		return TABLE.get(tag.substring(0, idx), tag.substring(idx));
	}

	public static Map<String, RacialAbility> getByPrefix (String tag) {
		if (tag == null) {
			return null;
		}
		return TABLE.row(tag);
	}

	private RacialAbility(String tag, String label, String description) {
		this(tag, label, description, null);
	}

	private RacialAbility(String tag, String label, String description, String decisionPageUrl) {
		this.tag = tag;
		this.label = label;
		this.description = description;
		this.decisionPageUrl = decisionPageUrl;
	}

	public String getTag() {
		return tag;
	}

	public String getLabel() {
		return label;
	}

	public String getDescription() {
		return description;
	}
	
	public String getDecisionPageUrl() {
		return decisionPageUrl;
	}

	public String toString () {
		return "RacialAbility [tag=" + tag + ", label=" + label + 
				", description=" + description + ", decisionPageUrl=" + decisionPageUrl + "]"; 
	}

	public static void main(String[] args) {
		for (RacialAbility ability : RacialAbility.getByPrefix("dwarfMountain").values()) {
			System.out.println(ability);
		}
	}
}
