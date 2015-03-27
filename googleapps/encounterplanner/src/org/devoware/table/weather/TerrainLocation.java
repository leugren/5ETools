package org.devoware.table.weather;

import java.util.Map;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;

public enum TerrainLocation {
	INLAND(1, "Inland"),
	COASTAL(2, "Coastal");
	
	private static final Map<Integer, TerrainLocation> TERRAIN_LOCATION_MAP;

	private final int ordinal;
	private final String name;
	
	static {
		Map<Integer, TerrainLocation> map = Maps.newLinkedHashMap();
		for (TerrainLocation object : TerrainLocation.values()) {
			map.put(object.getOrdinal(), object);
		}
		TERRAIN_LOCATION_MAP = ImmutableMap.copyOf(map);
	}
	
	public static TerrainLocation terrainLocationFor(int ordinal) {
		return TERRAIN_LOCATION_MAP.get(ordinal);
	}

	private TerrainLocation(int ordinal, String name) {
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
