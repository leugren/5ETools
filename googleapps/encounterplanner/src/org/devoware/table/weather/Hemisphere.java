package org.devoware.table.weather;

import java.util.Map;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;

public enum Hemisphere {
	NORTHERN(1, "Northern"),
	SOUTHERN(2, "Southern");

	private static final Map<Integer, Hemisphere> HEMISPHERE_MAP;
	
	private final int ordinal;
	private final String name;
	
	static {
		Map<Integer, Hemisphere> map = Maps.newLinkedHashMap();
		for (Hemisphere object : Hemisphere.values()) {
			map.put(object.getOrdinal(), object);
		}
		HEMISPHERE_MAP = ImmutableMap.copyOf(map);
	}
	
	public static Hemisphere hemisphereFor(int ordinal) {
		return HEMISPHERE_MAP.get(ordinal);
	}
	
	private Hemisphere(int ordinal, String name) {
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
