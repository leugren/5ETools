package org.devoware.characterbuilder.model;

import java.util.Map;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;

public enum Race {
    AASIMAR("aasimar", "Aasimar", "Aasimar"),
    DRAGONBORN("dragonborn", "Dragonborn", "Dragonborn"),
    DWARF_HILL("dwarfHill", "Dwarf, Hill", "Hill Dwarf"),
    DWARF_MOUNTAIN("dwarfMountain", "Dwarf, Mountain", "Mountain Dwarf"),
    ELF_DARK("elfDark", "Elf, Dark (Drow)", "Drow"),
    ELF_ELADRIN("elfEladrin", "Elf Eladrin", "Eladrin"),
    ELF_HIGH("elfHigh", "Elf, High", "High Elf"),
    ELF_WOOD("elfWood", "Elf, Wood", "Wood Elf"),
    GNOME_FOREST("gnomeForest", "Gnome, Forest", "Forest Gnome"),
    GNOME_ROCK("gnomeRock", "Gnome, Rock", "Rock Gnome"),
    HALFLING_LIGHTFOOT("halflingLightfoot", "Halfling, Lightfoot", "Lightfoot Halfling"),
    HALFLING_STOUT("halflingStout", "Halfling, Stout", "Stout Halfling"),
    HALF_ELF("halfElf", "Half-Elf", "Half-Elf"),
    HALF_ORC("halfOrc", "Half-Orc", "Half-Orc"),
    HUMAN("human", "Human", "Human"),
    HUMAN_VARIANT("humanVariant", "Human, Variant", "Human"),
    TIEFLING("tiefling", "Tiefling", "Tiefling");
    
    private static final Map<String, Race> MAP; 
	
    private String tag;
    private String label;
    private String name;
    
    static {
    	Map<String, Race> map = Maps.newHashMap();
    	for (Race race : Race.values()) {
    		map.put(race.getTag(), race);
    	}
    	MAP = ImmutableMap.copyOf(map);
    }
    
    public Race get (String tag) {
    	return MAP.get(tag);
    }
    
	private Race(String tag, String label, String name) {
		this.tag = tag;
		this.label = label;
		this.name = name;
	}

	public String getTag() {
		return tag;
	}

	public String getLabel() {
		return label;
	}
	
	public String getName() {
		return name;
	}
    
}
