package org.devoware.table.weather;

import java.util.Map;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;

public enum Terrain {
    BROKEN_LAND(1, "Broken Land"),
    DESERT(2, "Desert"),
    FOREST(3, "Forest"),
    GRASSLAND(4, "Grassland (or Clear)"),
    HILLS(5, "Hills"),
    JUNGLE(6, "Jungle"),
    MOUNTAINS(7, "Mountains"),
    SWAMP(8, "Swamp");
    
	private static final Map<Integer, Terrain> TERRAIN_MAP;

	private final int ordinal;
	private final String name;
	
	static {
		Map<Integer, Terrain> map = Maps.newLinkedHashMap();
		for (Terrain object : Terrain.values()) {
			map.put(object.getOrdinal(), object);
		}
		TERRAIN_MAP = ImmutableMap.copyOf(map);
	}
	
	public static Terrain terrainFor(int ordinal) {
		return TERRAIN_MAP.get(ordinal);
	}

	private Terrain(int ordinal, String name) {
		this.ordinal = ordinal;
		this.name = name;
	}
	
	public int getOrdinal() {
		return ordinal;
	}

	public String getName() {
		return name;
	}


	public String toString () {
		return this.name;
	}
}
