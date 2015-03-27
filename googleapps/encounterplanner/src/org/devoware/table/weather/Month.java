package org.devoware.table.weather;

import static com.google.common.base.Preconditions.checkArgument;

import java.util.Map;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;

public enum Month {
	JANUARY(1, "January (Hammer)"),
	FEBRUARY(2, "February (Alturiak)"),
	MARCH(3, "March (Ches)"),
	APRIL(4, "April (Tarsakh)"),
	MAY(5, "May (Mirtul)"),
	JUNE(6, "June (Kythorn)"),
	JULY(7, "July (Flamerule)"),
	AUGUST(8, "August (Eleasias)"),
	SEPTEMBER(9, "September (Eleint)"),
	OCTOBER(10, "October (Marpenoth)"),
	NOVEMBER(11, "November (Uktar)"),
	DECEMBER(12, "December (Nightal)");

	private static final Map<Integer, Month> MONTH_MAP;

	private final int ordinal;
	private final String name;
	
	static {
		Map<Integer, Month> map = Maps.newLinkedHashMap();
		for (Month object : Month.values()) {
			map.put(object.getOrdinal(), object);
		}
		MONTH_MAP = ImmutableMap.copyOf(map);
	}
	
	public static Month monthFor(int ordinal) {
		checkArgument(ordinal >= 1 && ordinal <= 12);
		return MONTH_MAP.get(ordinal);
	}

	private Month(int ordinal, String name) {
		this.ordinal = ordinal;
		this.name = name;
	}
	
	public int getOrdinal () {
		return this.ordinal;
	}
	
	public String getName() {
		return name;
	}

	public String toString () {
		return this.name;
	}
}
