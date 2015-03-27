package org.devoware.table.weather;

import com.google.common.collect.Range;

public class Latitudes {
	private static final Range<Integer> LATITUDE_RANGE = Range.closed(0, 90);
	
	public static boolean isValid (int latitude) {
		return LATITUDE_RANGE.contains(latitude);
	}

}
