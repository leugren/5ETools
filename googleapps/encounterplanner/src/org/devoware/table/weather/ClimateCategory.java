package org.devoware.table.weather;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import static org.devoware.table.dice.Die.D100;
import static org.devoware.table.dice.Die.newDie;
import static org.devoware.table.model.FormattedIntegerValue.newFormattedIntegerValue;
import static org.devoware.table.model.RandomInt.newRandomInt;
import static org.devoware.table.model.ValueRangeMap.newValueRangeMap;
import static org.devoware.table.weather.Hemisphere.NORTHERN;
import static org.devoware.table.weather.Terrain.BROKEN_LAND;
import static org.devoware.table.weather.Terrain.FOREST;
import static org.devoware.table.weather.Terrain.GRASSLAND;
import static org.devoware.table.weather.Terrain.HILLS;
import static org.devoware.table.weather.Terrain.JUNGLE;
import static org.devoware.table.weather.Terrain.MOUNTAINS;
import static org.devoware.table.weather.Terrain.SWAMP;
import static org.devoware.table.weather.TerrainLocation.COASTAL;
import static org.devoware.table.weather.TerrainLocation.INLAND;

import java.util.Arrays;
import java.util.Map;

import org.devoware.encounterplanner.util.Pair;
import org.devoware.table.dice.Die;
import org.devoware.table.model.RandomizableStringSource;

import com.google.common.base.Optional;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableRangeMap;
import com.google.common.collect.ImmutableTable;
import com.google.common.collect.Maps;
import com.google.common.collect.Range;
import com.google.common.collect.RangeMap;
import com.google.common.collect.Table;
import com.google.common.collect.TreeRangeMap;

public abstract class ClimateCategory {
	
	public static final ClimateCategory DESERT = new ClimateCategory (1, "Desert") {

		@Override
		protected Pair<RangeMap<Integer, RandomizableStringSource>, RangeMap<Integer, RandomizableStringSource>> getTemperatures() {
			RangeMap<Integer, RandomizableStringSource> northTemps = TreeRangeMap.create();
			RangeMap<Integer, RandomizableStringSource> southTemps = TreeRangeMap.create();

			RandomizableStringSource source = newValueRangeMap(D100)
					.with(1, 5, newFormattedIntegerValue("%d° F (cold)", newRandomInt(50, 59)))
					.with(6, 95, newFormattedIntegerValue("%d° F (cool)", newRandomInt(60, 69)))
					.with(96, 100, newFormattedIntegerValue("%d° F (warm)", newRandomInt(70, 75)))
					.build();
			northTemps.put(Range.singleton(12), source);
			northTemps.put(Range.singleton(1), source);
			southTemps.put(Range.closed(5, 6), source);

			source = newValueRangeMap(D100)
					.with(1, 5, newFormattedIntegerValue("%d° F (cool)", newRandomInt(60, 69)))
					.with(6, 95, newFormattedIntegerValue("%d° F (hot)", newRandomInt(70, 90)))
					.with(96, 100, newFormattedIntegerValue("%d° F (very hot)", newRandomInt(105, 115)))
					.build();
			northTemps.put(Range.closed(2, 11), source);
			southTemps.put(Range.closed(1, 4), source);
			southTemps.put(Range.closed(7, 12), source);
			
			return Pair.of(northTemps, southTemps);
		}

		
	};
	
	public static final ClimateCategory TROPICAL_SAVANNA = new ClimateCategory (2, "Tropical Savanna") {

		@Override
		protected Pair<RangeMap<Integer, RandomizableStringSource>, RangeMap<Integer, RandomizableStringSource>> getTemperatures() {
			RangeMap<Integer, RandomizableStringSource> northTemps = TreeRangeMap.create();
			RangeMap<Integer, RandomizableStringSource> southTemps = TreeRangeMap.create();

			RandomizableStringSource source = newValueRangeMap(D100)
					.with(1, 5, newFormattedIntegerValue("%d° F (warm)", newRandomInt(75, 80)))
					.with(6, 95, newFormattedIntegerValue("%d° F (hot)", newRandomInt(90, 105)))
					.with(96, 100, newFormattedIntegerValue("%d° F (very hot)", newRandomInt(106, 115)))
					.build();
			northTemps.put(Range.closed(1, 12), source);
			southTemps.put(Range.closed(1, 12), source);

			return Pair.of(northTemps, southTemps);
		}
		
	};
	public static final ClimateCategory STEPPE = new ClimateCategory (3, "Steppe") {

		@Override
		protected Pair<RangeMap<Integer, RandomizableStringSource>, RangeMap<Integer, RandomizableStringSource>> getTemperatures() {
			RangeMap<Integer, RandomizableStringSource> northTemps = TreeRangeMap.create();
			RangeMap<Integer, RandomizableStringSource> southTemps = TreeRangeMap.create();

			RandomizableStringSource source = newValueRangeMap(D100)
					.with(1, 5, newFormattedIntegerValue("%d° F (warm)", newRandomInt(70, 75)))
					.with(6, 95, newFormattedIntegerValue("%d° F (hot)", newRandomInt(85, 95)))
					.with(96, 100, newFormattedIntegerValue("%d° F (warm)", newRandomInt(105, 112)))
					.build();
			northTemps.put(Range.closed(6, 8), source);
			southTemps.put(Range.singleton(12), source);
			southTemps.put(Range.closed(1, 2), source);

			source = newValueRangeMap(D100)
					.with(1, 5, newFormattedIntegerValue("%d° F (cool)", newRandomInt(48, 53)))
					.with(6, 95, newFormattedIntegerValue("%d° F (warm)", newRandomInt(60, 70)))
					.with(96, 100, newFormattedIntegerValue("%d° F (hot)", newRandomInt(77, 83)))
					.build();
			northTemps.put(Range.closed(9, 11), source);
			northTemps.put(Range.closed(3, 5), source);
			southTemps.put(Range.closed(9, 11), source);
			southTemps.put(Range.closed(3, 5), source);
			
			source = newValueRangeMap(D100)
					.with(1, 5, newFormattedIntegerValue("%d° F (cold)", newRandomInt(33, 38)))
					.with(6, 95, newFormattedIntegerValue("%d° F (chilly)", newRandomInt(40, 45)))
					.with(96, 100, newFormattedIntegerValue("%d° F (cool)", newRandomInt(48, 53)))
					.build();
			southTemps.put(Range.closed(6, 8), source);
			northTemps.put(Range.singleton(12), source);
			northTemps.put(Range.closed(1, 2), source);

			return Pair.of(northTemps, southTemps);
		}
		
	};
	public static final ClimateCategory EQUATORIAL = new ClimateCategory (4, "Equatorial") {

		@Override
		protected Pair<RangeMap<Integer, RandomizableStringSource>, RangeMap<Integer, RandomizableStringSource>> getTemperatures() {
			RangeMap<Integer, RandomizableStringSource> northTemps = TreeRangeMap.create();
			RangeMap<Integer, RandomizableStringSource> southTemps = TreeRangeMap.create();

			RandomizableStringSource source = newValueRangeMap(D100)
					.with(1, 5, newFormattedIntegerValue("%d° F (unusually cool)", newRandomInt(60, 65)))
					.with(6, 95, newFormattedIntegerValue("%d° F (hot)", newRandomInt(70, 85)))
					.with(96, 100, newFormattedIntegerValue("%d° F (very hot)", newRandomInt(95, 102)))
					.build();
			northTemps.put(Range.closed(1, 12), source);
			southTemps.put(Range.closed(1, 12), source);
			
			return Pair.of(northTemps, southTemps);
		}
		
	};
	public static final ClimateCategory MONSOON = new ClimateCategory (5, "Monsoon") {

		@Override
		protected Pair<RangeMap<Integer, RandomizableStringSource>, RangeMap<Integer, RandomizableStringSource>> getTemperatures() {
			RangeMap<Integer, RandomizableStringSource> northTemps = TreeRangeMap.create();
			RangeMap<Integer, RandomizableStringSource> southTemps = TreeRangeMap.create();

			RandomizableStringSource source = newValueRangeMap(D100)
					.with(1, 5, newFormattedIntegerValue("%d° F (warm)", newRandomInt(70, 75)))
					.with(6, 50, newFormattedIntegerValue("%d° F (hot)", newRandomInt(85, 100)))
					.with(51, 95, newFormattedIntegerValue("%d° F (very hot)", newRandomInt(101, 110)))
					.with(96, 100, newFormattedIntegerValue("%d° F (extremely hot)", newRandomInt(115, 120)))
					.build();
			northTemps.put(Range.closed(1, 12), source);
			southTemps.put(Range.closed(1, 12), source);
			
			return Pair.of(northTemps, southTemps);
		}
		
	};
	public static final ClimateCategory WARM_AND_RAINY = new ClimateCategory (6, "Warm and Rainy") {

		@Override
		protected Pair<RangeMap<Integer, RandomizableStringSource>, RangeMap<Integer, RandomizableStringSource>> getTemperatures() {
			RangeMap<Integer, RandomizableStringSource> northTemps = TreeRangeMap.create();
			RangeMap<Integer, RandomizableStringSource> southTemps = TreeRangeMap.create();

			RandomizableStringSource source = newValueRangeMap(D100)
					.with(1, 5, newFormattedIntegerValue("%d° F (cool)", newRandomInt(58, 63)))
					.with(6, 50, newFormattedIntegerValue("%d° F (warm)", newRandomInt(65, 70)))
					.with(51, 95, newFormattedIntegerValue("%d° F (hot)", newRandomInt(70, 75)))
					.with(96, 100, newFormattedIntegerValue("%d° F (very hot)", newRandomInt(83, 88)))
					.build();
			northTemps.put(Range.closed(6, 9), source);
			southTemps.put(Range.singleton(12), source);
			southTemps.put(Range.closed(1, 3), source);

			source = newValueRangeMap(D100)
					.with(1, 5, newFormattedIntegerValue("%d° F (cold)", newRandomInt(38, 43)))
					.with(6, 50, newFormattedIntegerValue("%d° F (chilly)", newRandomInt(48, 53)))
					.with(51, 95, newFormattedIntegerValue("%d° F (cool)", newRandomInt(58, 63)))
					.with(96, 100, newFormattedIntegerValue("%d° F (warm)", newRandomInt(64, 68)))
					.build();
			northTemps.put(Range.singleton(10), source);
			northTemps.put(Range.closed(3, 5), source);
			southTemps.put(Range.singleton(4), source);
			southTemps.put(Range.closed(9, 11), source);
			
			source = newValueRangeMap(D100)
					.with(1, 5, newFormattedIntegerValue("%d° F (very cold)", newRandomInt(8, 13)))
					.with(6, 50, newFormattedIntegerValue("%d° F (freezing)", newRandomInt(25, 32)))
					.with(51, 95, newFormattedIntegerValue("%d° F (cold)", newRandomInt(33, 45)))
					.with(96, 100, newFormattedIntegerValue("%d° F (cool)", newRandomInt(48, 53)))
					.build();
			northTemps.put(Range.closed(11, 12), source);
			northTemps.put(Range.closed(1, 2), source);
			southTemps.put(Range.closed(5, 8), source);
			
			return Pair.of(northTemps, southTemps);
		}
		
	};
	public static final ClimateCategory WARM_WITH_DRY_SUMMER = new ClimateCategory (7, "Warm with Dry Summer") {

		@Override
		protected Pair<RangeMap<Integer, RandomizableStringSource>, RangeMap<Integer, RandomizableStringSource>> getTemperatures() {
			RangeMap<Integer, RandomizableStringSource> northTemps = TreeRangeMap.create();
			RangeMap<Integer, RandomizableStringSource> southTemps = TreeRangeMap.create();

			RandomizableStringSource source = newValueRangeMap(D100)
					.with(1, 5, newFormattedIntegerValue("%d° F (cool)", newRandomInt(58, 63)))
					.with(6, 50, newFormattedIntegerValue("%d° F (warm)", newRandomInt(65, 70)))
					.with(51, 95, newFormattedIntegerValue("%d° F (hot)", newRandomInt(70, 85)))
					.with(96, 100, newFormattedIntegerValue("%d° F (very hot)", newRandomInt(92, 98)))
					.build();
			northTemps.put(Range.closed(5, 9), source);
			southTemps.put(Range.closed(11, 12), source);
			southTemps.put(Range.closed(1, 3), source);

			source = newValueRangeMap(D100)
					.with(1, 5, newFormattedIntegerValue("%d° F (chilly)", newRandomInt(48, 53)))
					.with(6, 50, newFormattedIntegerValue("%d° F (cool)", newRandomInt(58, 63)))
					.with(51, 95, newFormattedIntegerValue("%d° F (warm)", newRandomInt(64, 68)))
					.with(96, 100, newFormattedIntegerValue("%d° F (very warm)", newRandomInt(69, 74)))
					.build();
			northTemps.put(Range.closed(10, 11), source);
			northTemps.put(Range.closed(3, 4), source);
			southTemps.put(Range.closed(4, 5), source);
			southTemps.put(Range.closed(9, 10), source);
			
			source = newValueRangeMap(D100)
					.with(1, 5, newFormattedIntegerValue("%d° F (very cold)", newRandomInt(8, 13)))
					.with(6, 50, newFormattedIntegerValue("%d° F (freezing)", newRandomInt(20, 32)))
					.with(51, 95, newFormattedIntegerValue("%d° F (cold)", newRandomInt(35, 50)))
					.with(96, 100, newFormattedIntegerValue("%d° F (warm)", newRandomInt(58, 63)))
					.build();
			northTemps.put(Range.singleton(12), source);
			northTemps.put(Range.closed(1, 2), source);
			southTemps.put(Range.closed(6, 8), source);
			
			return Pair.of(northTemps, southTemps);
		}
		
	};
	public static final ClimateCategory WARM_WITH_DRY_WINTER = new ClimateCategory (8, "Warm with Dry Winter") {

		@Override
		protected Pair<RangeMap<Integer, RandomizableStringSource>, RangeMap<Integer, RandomizableStringSource>> getTemperatures() {
			RangeMap<Integer, RandomizableStringSource> northTemps = TreeRangeMap.create();
			RangeMap<Integer, RandomizableStringSource> southTemps = TreeRangeMap.create();

			RandomizableStringSource source = newValueRangeMap(D100)
					.with(1, 5, newFormattedIntegerValue("%d° F (warm)", newRandomInt(58, 73)))
					.with(6, 95, newFormattedIntegerValue("%d° F (hot)", newRandomInt(85, 90)))
					.with(96, 100, newFormattedIntegerValue("%d° F (very hot)", newRandomInt(108, 113)))
					.build();
			northTemps.put(Range.closed(6, 7), source);
			southTemps.put(Range.singleton(12), source);
			southTemps.put(Range.singleton(1), source);

			source = newValueRangeMap(D100)
					.with(1, 5, newFormattedIntegerValue("%d° F (cool)", newRandomInt(48, 53)))
					.with(6, 95, newFormattedIntegerValue("%d° F (warm)", newRandomInt(60, 65)))
					.with(96, 100, newFormattedIntegerValue("%d° F (hot)", newRandomInt(68, 73)))
					.build();
			northTemps.put(Range.closed(8, 10), source);
			northTemps.put(Range.closed(3, 5), source);
			southTemps.put(Range.closed(2, 4), source);
			southTemps.put(Range.closed(9, 11), source);
			
			source = newValueRangeMap(D100)
					.with(1, 5, newFormattedIntegerValue("%d° F (frosty)", newRandomInt(30, 34)))
					.with(6, 95, newFormattedIntegerValue("%d° F (chilly)", newRandomInt(35, 45)))
					.with(96, 100, newFormattedIntegerValue("%d° F (cool)", newRandomInt(48, 53)))
					.build();
			northTemps.put(Range.closed(11, 12), source);
			northTemps.put(Range.closed(1, 2), source);
			southTemps.put(Range.closed(5, 8), source);
			
			return Pair.of(northTemps, southTemps);
		}
		
	};
	public static final ClimateCategory COOL_AND_RAINY = new ClimateCategory (9, "Cool and Rainy") {

		@Override
		protected Pair<RangeMap<Integer, RandomizableStringSource>, RangeMap<Integer, RandomizableStringSource>> getTemperatures() {
			RangeMap<Integer, RandomizableStringSource> northTemps = TreeRangeMap.create();
			RangeMap<Integer, RandomizableStringSource> southTemps = TreeRangeMap.create();

			RandomizableStringSource source = newValueRangeMap(D100)
					.with(1, 5, newFormattedIntegerValue("%d° F (cool)", newRandomInt(58, 63)))
					.with(6, 50, newFormattedIntegerValue("%d° F (warm)", newRandomInt(65, 70)))
					.with(51, 95, newFormattedIntegerValue("%d° F (hot)", newRandomInt(70, 75)))
					.with(96, 100, newFormattedIntegerValue("%d° F (very hot)", newRandomInt(83, 88)))
					.build();
			northTemps.put(Range.closed(7, 9), source);
			southTemps.put(Range.closed(1, 3), source);

			source = newValueRangeMap(D100)
					.with(1, 5, newFormattedIntegerValue("%d° F (cold)", newRandomInt(33, 38)))
					.with(6, 50, newFormattedIntegerValue("%d° F (chilly)", newRandomInt(40, 50)))
					.with(51, 95, newFormattedIntegerValue("%d° F (cool)", newRandomInt(50, 60)))
					.with(96, 100, newFormattedIntegerValue("%d° F (warm)", newRandomInt(63, 68)))
					.build();
			northTemps.put(Range.singleton(10), source);
			northTemps.put(Range.closed(3, 6), source);
			southTemps.put(Range.singleton(4), source);
			southTemps.put(Range.closed(9, 12), source);
			
			source = newValueRangeMap(D100)
					.with(1, 5, newFormattedIntegerValue("%d° F (very cold)", newRandomInt(3, 8)))
					.with(6, 50, newFormattedIntegerValue("%d° F (very cold)", newRandomInt(15, 25)))
					.with(51, 95, newFormattedIntegerValue("%d° F (freezing)", newRandomInt(25, 32)))
					.with(96, 100, newFormattedIntegerValue("%d° F (chilly)", newRandomInt(38, 43)))
					.build();
			northTemps.put(Range.closed(11, 12), source);
			northTemps.put(Range.closed(1, 2), source);
			southTemps.put(Range.closed(5, 8), source);
			
			return Pair.of(northTemps, southTemps);
		}
		
	};
	public static final ClimateCategory COOL_WITH_DRY_WINTER = new ClimateCategory (10, "Cool with Dry Winter") {

		@Override
		protected Pair<RangeMap<Integer, RandomizableStringSource>, RangeMap<Integer, RandomizableStringSource>> getTemperatures() {
			RangeMap<Integer, RandomizableStringSource> northTemps = TreeRangeMap.create();
			RangeMap<Integer, RandomizableStringSource> southTemps = TreeRangeMap.create();

			RandomizableStringSource source = newValueRangeMap(D100)
					.with(1, 5, newFormattedIntegerValue("%d° F (cool)", newRandomInt(58, 63)))
					.with(6, 50, newFormattedIntegerValue("%d° F (warm)", newRandomInt(65, 70)))
					.with(51, 95, newFormattedIntegerValue("%d° F (hot)", newRandomInt(70, 75)))
					.with(96, 100, newFormattedIntegerValue("%d° F (very hot)", newRandomInt(83, 88)))
					.build();
			northTemps.put(Range.closed(7, 9), source);
			southTemps.put(Range.closed(1, 3), source);

			source = newValueRangeMap(D100)
					.with(1, 5, newFormattedIntegerValue("%d° F (cold)", newRandomInt(33, 38)))
					.with(6, 50, newFormattedIntegerValue("%d° F (chilly)", newRandomInt(40, 50)))
					.with(51, 95, newFormattedIntegerValue("%d° F (cool)", newRandomInt(50, 60)))
					.with(96, 100, newFormattedIntegerValue("%d° F (warm)", newRandomInt(63, 68)))
					.build();
			northTemps.put(Range.singleton(10), source);
			northTemps.put(Range.closed(3, 6), source);
			southTemps.put(Range.singleton(4), source);
			southTemps.put(Range.closed(9, 12), source);
			
			source = newValueRangeMap(D100)
					.with(1, 5, newFormattedIntegerValue("%d° F (very cold)", newRandomInt(3, 8)))
					.with(6, 50, newFormattedIntegerValue("%d° F (very cold)", newRandomInt(15, 25)))
					.with(51, 95, newFormattedIntegerValue("%d° F (freezing)", newRandomInt(25, 32)))
					.with(96, 100, newFormattedIntegerValue("%d° F (chilly)", newRandomInt(38, 43)))
					.build();
			northTemps.put(Range.closed(11, 12), source);
			northTemps.put(Range.closed(1, 2), source);
			southTemps.put(Range.closed(5, 8), source);
			
			return Pair.of(northTemps, southTemps);
		}
		
	};
	public static final ClimateCategory TUNDRA = new ClimateCategory (11, "Tundra") {

		@Override
		protected Pair<RangeMap<Integer, RandomizableStringSource>, RangeMap<Integer, RandomizableStringSource>> getTemperatures() {
			RangeMap<Integer, RandomizableStringSource> northTemps = TreeRangeMap.create();
			RangeMap<Integer, RandomizableStringSource> southTemps = TreeRangeMap.create();

			RandomizableStringSource source = newValueRangeMap(D100)
					.with(1, 5, newFormattedIntegerValue("%d° F (cold)", newRandomInt(28, 33)))
					.with(6, 50, newFormattedIntegerValue("%d° F (chilly)", newRandomInt(35, 40)))
					.with(51, 95, newFormattedIntegerValue("%d° F (cool)", newRandomInt(40, 50)))
					.with(96, 100, newFormattedIntegerValue("%d° F (warm)", newRandomInt(63, 68)))
					.build();
			northTemps.put(Range.closed(6, 7), source);
			southTemps.put(Range.singleton(12), source);
			southTemps.put(Range.singleton(1), source);

			source = newValueRangeMap(D100)
					.with(1, 5, newFormattedIntegerValue("%d° F (very cold)", newRandomInt(8, 13)))
					.with(6, 50, newFormattedIntegerValue("%d° F (cold)", newRandomInt(15, 20)))
					.with(51, 95, newFormattedIntegerValue("%d° F (freezing)", newRandomInt(25, 32)))
					.with(96, 100, newFormattedIntegerValue("%d° F (chilly)", newRandomInt(33, 38)))
					.build();
			northTemps.put(Range.closed(8, 11), source);
			northTemps.put(Range.closed(2, 5), source);
			southTemps.put(Range.closed(2, 5), source);
			southTemps.put(Range.closed(8, 11), source);
			
			source = newValueRangeMap(D100)
					.with(1, 5, newFormattedIntegerValue("%d° F (extremely cold)", newRandomInt(-18, -13)))
					.with(6, 50, newFormattedIntegerValue("%d° F (very cold)", newRandomInt(-5, 15)))
					.with(51, 95, newFormattedIntegerValue("%d° F (freezing)", newRandomInt(15, 32)))
					.with(96, 100, newFormattedIntegerValue("%d° F (cold)", newRandomInt(33, 38)))
					.build();
			southTemps.put(Range.closed(6, 7), source);
			northTemps.put(Range.singleton(12), source);
			northTemps.put(Range.singleton(1), source);
			
			return Pair.of(northTemps, southTemps);
		}
		
	};
	public static final ClimateCategory POLAR = new ClimateCategory (12, "Polar") {

		@Override
		protected Pair<RangeMap<Integer, RandomizableStringSource>, RangeMap<Integer, RandomizableStringSource>> getTemperatures() {
			RangeMap<Integer, RandomizableStringSource> northTemps = TreeRangeMap.create();
			RangeMap<Integer, RandomizableStringSource> southTemps = TreeRangeMap.create();

			RandomizableStringSource source = newValueRangeMap(D100)
					.with(1, 5, newFormattedIntegerValue("%d° F (cold)", newRandomInt(38, 33)))
					.with(6, 50, newFormattedIntegerValue("%d° F (chilly)", newRandomInt(35, 40)))
					.with(51, 95, newFormattedIntegerValue("%d° F (cool)", newRandomInt(40, 50)))
					.with(96, 100, newFormattedIntegerValue("%d° F (warm)", newRandomInt(63, 68)))
					.build();
			northTemps.put(Range.closed(6, 7), source);
			southTemps.put(Range.singleton(12), source);
			southTemps.put(Range.singleton(1), source);

			source = newValueRangeMap(D100)
					.with(1, 5, newFormattedIntegerValue("%d° F (very cold)", newRandomInt(20, 25)))
					.with(6, 50, newFormattedIntegerValue("%d° F (cold)", newRandomInt(26, 30)))
					.with(51, 95, newFormattedIntegerValue("%d° F (frosty)", newRandomInt(31, 32)))
					.with(96, 100, newFormattedIntegerValue("%d° F (cool)", newRandomInt(33, 40)))
					.build();
			northTemps.put(Range.closed(8, 11), source);
			northTemps.put(Range.closed(2, 5), source);
			southTemps.put(Range.closed(2, 5), source);
			southTemps.put(Range.closed(8, 11), source);
			
			source = newValueRangeMap(D100)
					.with(1, 5, newFormattedIntegerValue("%d° F (extremely cold)", newRandomInt(-38, 33)))
					.with(6, 50, newFormattedIntegerValue("%d° F (very cold)", newRandomInt(-25, 0)))
					.with(51, 95, newFormattedIntegerValue("%d° F (cold)", newRandomInt(0, 30)))
					.with(96, 100, newFormattedIntegerValue("%d° F (frosty)", newRandomInt(31, 32)))
					.build();
			southTemps.put(Range.closed(6, 7), source);
			northTemps.put(Range.singleton(12), source);
			northTemps.put(Range.singleton(1), source);
			
			return Pair.of(northTemps, southTemps);
		}
		
	};
	
	private static final ClimateCategoryFactory DESERT_FACTORY = new ClimateCategoryFactory(DESERT); 
	private static final ClimateCategoryFactory TROPICAL_SAVANNA_FACTORY = new ClimateCategoryFactory(TROPICAL_SAVANNA); 
	private static final ClimateCategoryFactory STEPPE_FACTORY = new ClimateCategoryFactory(STEPPE); 
	private static final ClimateCategoryFactory EQUATORIAL_FACTORY = new ClimateCategoryFactory(EQUATORIAL); 
	private static final ClimateCategoryFactory MONSOON_FACTORY = new ClimateCategoryFactory(MONSOON); 
	private static final ClimateCategoryFactory WARM_AND_RAINY_FACTORY = new ClimateCategoryFactory(WARM_AND_RAINY); 
	private static final ClimateCategoryFactory WARM_WITH_DRY_SUMMER_FACTORY = new ClimateCategoryFactory(WARM_WITH_DRY_SUMMER); 
	private static final ClimateCategoryFactory WARM_WITH_DRY_WINTER_FACTORY = new ClimateCategoryFactory(WARM_WITH_DRY_WINTER); 
	private static final ClimateCategoryFactory COOL_AND_RAINY_FACTORY = new ClimateCategoryFactory(COOL_AND_RAINY); 
	private static final ClimateCategoryFactory COOL_WITH_DRY_WINTER_FACTORY = new ClimateCategoryFactory(COOL_WITH_DRY_WINTER); 
	private static final ClimateCategoryFactory TUNDRA_FACTORY = new ClimateCategoryFactory(TUNDRA); 
	private static final ClimateCategoryFactory POLAR_FACTORY = new ClimateCategoryFactory(POLAR); 
    private static final ClimateCategory [] CATEGORY_LIST = { DESERT, TROPICAL_SAVANNA, STEPPE, EQUATORIAL, MONSOON, WARM_AND_RAINY, 
    	WARM_WITH_DRY_SUMMER, WARM_WITH_DRY_WINTER, COOL_AND_RAINY, COOL_WITH_DRY_WINTER, TUNDRA, POLAR};
	private static final Map<Integer, ClimateCategory> CATEGORY_MAP;
	
	private static final Table<Terrain, TerrainLocation, RangeMap<Integer, Optional<ClimateCategoryFactory>>> CLIMATE_CATEGORIES;
	
	private final int ordinal;
	private final String name;
	private final RangeMap<Integer, RandomizableStringSource> northTemps;
	private final RangeMap<Integer, RandomizableStringSource> southTemps;
	
	static {
		Map<Integer, ClimateCategory> categoryMap = Maps.newLinkedHashMap();
		for (ClimateCategory category : CATEGORY_LIST) {
			categoryMap.put(category.getOrdinal(), category);
		}
		CATEGORY_MAP = ImmutableMap.copyOf(categoryMap);
		
		Table<Terrain, TerrainLocation, RangeMap<Integer, Optional<ClimateCategoryFactory>>> climateCategories = HashBasedTable.
				<Terrain, TerrainLocation, RangeMap<Integer, Optional<ClimateCategoryFactory>>>create();
	
	    RangeMap<Integer, Optional<ClimateCategoryFactory>> latitudeMap = TreeRangeMap.<Integer, Optional<ClimateCategoryFactory>>create();
	    latitudeMap.put(Range.closed(0, 20), Optional.of(DESERT_FACTORY));
	    latitudeMap.put(Range.closed(21, 40), Optional.of(WARM_WITH_DRY_WINTER_FACTORY));
	    latitudeMap.put(Range.closed(41, 70), Optional.of(COOL_AND_RAINY_FACTORY));
	    latitudeMap.put(Range.closed(71, 90), Optional.of(POLAR_FACTORY));
	    
	    climateCategories.put(BROKEN_LAND, INLAND, ImmutableRangeMap.copyOf(latitudeMap));

	    latitudeMap = TreeRangeMap.<Integer, Optional<ClimateCategoryFactory>>create();
	    latitudeMap.put(Range.closed(0, 20), Optional.of(DESERT_FACTORY));
	    latitudeMap.put(Range.closed(21, 50), Optional.of(new ClimateCategoryFactory(WARM_AND_RAINY, WARM_WITH_DRY_SUMMER)));
	    latitudeMap.put(Range.closed(51, 70), Optional.of(COOL_WITH_DRY_WINTER_FACTORY));
	    latitudeMap.put(Range.closed(71, 90), Optional.of(TUNDRA_FACTORY));
	    
	    climateCategories.put(BROKEN_LAND, COASTAL, ImmutableRangeMap.copyOf(latitudeMap));
	
	    latitudeMap = TreeRangeMap.<Integer, Optional<ClimateCategoryFactory>>create();
	    latitudeMap.put(Range.closed(0, 30), Optional.of(DESERT_FACTORY));
	    latitudeMap.put(Range.closed(31, 90), Optional.<ClimateCategoryFactory>absent());
	    
	    climateCategories.put(Terrain.DESERT, COASTAL, ImmutableRangeMap.copyOf(latitudeMap));
	    climateCategories.put(Terrain.DESERT, INLAND, ImmutableRangeMap.copyOf(latitudeMap));

	    latitudeMap = TreeRangeMap.<Integer, Optional<ClimateCategoryFactory>>create();
	    latitudeMap.put(Range.closed(0, 20), Optional.of(TROPICAL_SAVANNA_FACTORY));
	    latitudeMap.put(Range.closed(21, 50), Optional.of(WARM_WITH_DRY_WINTER_FACTORY));
	    latitudeMap.put(Range.closed(51, 70), Optional.of(COOL_AND_RAINY_FACTORY));
	    latitudeMap.put(Range.closed(71, 90), Optional.<ClimateCategoryFactory>absent());
	
	    climateCategories.put(FOREST, INLAND, ImmutableRangeMap.copyOf(latitudeMap));

	    latitudeMap = TreeRangeMap.<Integer, Optional<ClimateCategoryFactory>>create();
	    latitudeMap.put(Range.closed(0, 20), Optional.of(TROPICAL_SAVANNA_FACTORY));
	    latitudeMap.put(Range.closed(21, 50), Optional.of(new ClimateCategoryFactory(WARM_AND_RAINY, WARM_WITH_DRY_SUMMER)));
	    latitudeMap.put(Range.closed(51, 70), Optional.of(COOL_WITH_DRY_WINTER_FACTORY));
	    latitudeMap.put(Range.closed(71, 90), Optional.<ClimateCategoryFactory>absent());
	
	    climateCategories.put(FOREST, COASTAL, ImmutableRangeMap.copyOf(latitudeMap));
	
	    latitudeMap = TreeRangeMap.<Integer, Optional<ClimateCategoryFactory>>create();
	    latitudeMap.put(Range.closed(0, 20), Optional.of(TROPICAL_SAVANNA_FACTORY));
	    latitudeMap.put(Range.closed(21, 50), Optional.of(STEPPE_FACTORY));
	    latitudeMap.put(Range.closed(51, 70), Optional.of(COOL_AND_RAINY_FACTORY));
	    latitudeMap.put(Range.closed(71, 90), Optional.of(new ClimateCategoryFactory(TUNDRA, POLAR)));
	
	    climateCategories.put(GRASSLAND, INLAND, ImmutableRangeMap.copyOf(latitudeMap));

	    latitudeMap = TreeRangeMap.<Integer, Optional<ClimateCategoryFactory>>create();
	    latitudeMap.put(Range.closed(0, 20), Optional.of(TROPICAL_SAVANNA_FACTORY));
	    latitudeMap.put(Range.closed(21, 50), Optional.of(new ClimateCategoryFactory(WARM_AND_RAINY, WARM_WITH_DRY_SUMMER)));
	    latitudeMap.put(Range.closed(51, 70), Optional.of(COOL_WITH_DRY_WINTER_FACTORY));
	    latitudeMap.put(Range.closed(71, 90), Optional.of(new ClimateCategoryFactory(TUNDRA, POLAR)));
	
	    climateCategories.put(GRASSLAND, COASTAL, ImmutableRangeMap.copyOf(latitudeMap));

	    latitudeMap = TreeRangeMap.<Integer, Optional<ClimateCategoryFactory>>create();
	    latitudeMap.put(Range.closed(0, 20), Optional.of(TROPICAL_SAVANNA_FACTORY));
	    latitudeMap.put(Range.closed(21, 40), Optional.of(WARM_WITH_DRY_WINTER_FACTORY));
	    latitudeMap.put(Range.closed(41, 70), Optional.of(COOL_AND_RAINY_FACTORY));
	    latitudeMap.put(Range.closed(71, 90), Optional.of(POLAR_FACTORY));
	
	    climateCategories.put(HILLS, INLAND, ImmutableRangeMap.copyOf(latitudeMap));

	    latitudeMap = TreeRangeMap.<Integer, Optional<ClimateCategoryFactory>>create();
	    latitudeMap.put(Range.closed(0, 20), Optional.of(TROPICAL_SAVANNA_FACTORY));
	    latitudeMap.put(Range.closed(21, 50), Optional.of(new ClimateCategoryFactory(WARM_AND_RAINY, WARM_WITH_DRY_SUMMER)));
	    latitudeMap.put(Range.closed(51, 70), Optional.of(COOL_WITH_DRY_WINTER_FACTORY));
	    latitudeMap.put(Range.closed(71, 90), Optional.of(TUNDRA_FACTORY));
	
	    climateCategories.put(HILLS, COASTAL, ImmutableRangeMap.copyOf(latitudeMap));
	
	    latitudeMap = TreeRangeMap.<Integer, Optional<ClimateCategoryFactory>>create();
	    latitudeMap.put(Range.closed(0, 20), Optional.of(EQUATORIAL_FACTORY));
	    latitudeMap.put(Range.closed(21, 50), Optional.of(WARM_WITH_DRY_WINTER_FACTORY));
	    latitudeMap.put(Range.closed(51, 70), Optional.of(COOL_AND_RAINY_FACTORY));
	    latitudeMap.put(Range.closed(71, 90), Optional.<ClimateCategoryFactory>absent());
	
	    climateCategories.put(JUNGLE, INLAND, ImmutableRangeMap.copyOf(latitudeMap));

	    latitudeMap = TreeRangeMap.<Integer, Optional<ClimateCategoryFactory>>create();
	    latitudeMap.put(Range.closed(0, 20), Optional.of(MONSOON_FACTORY));
	    latitudeMap.put(Range.closed(21, 50), Optional.of(new ClimateCategoryFactory(WARM_AND_RAINY, WARM_WITH_DRY_SUMMER)));
	    latitudeMap.put(Range.closed(51, 70), Optional.of(COOL_WITH_DRY_WINTER_FACTORY));
	    latitudeMap.put(Range.closed(71, 90), Optional.<ClimateCategoryFactory>absent());
	
	    climateCategories.put(JUNGLE, COASTAL, ImmutableRangeMap.copyOf(latitudeMap));

	    latitudeMap = TreeRangeMap.<Integer, Optional<ClimateCategoryFactory>>create();
	    latitudeMap.put(Range.closed(0, 20), Optional.of(new ClimateCategoryFactory(WARM_AND_RAINY, WARM_WITH_DRY_SUMMER)));
	    latitudeMap.put(Range.closed(21, 40), Optional.of(WARM_WITH_DRY_WINTER_FACTORY));
	    latitudeMap.put(Range.closed(41, 70), Optional.of(COOL_AND_RAINY_FACTORY));
	    latitudeMap.put(Range.closed(71, 90), Optional.of(POLAR_FACTORY));
	
	    climateCategories.put(MOUNTAINS, INLAND, ImmutableRangeMap.copyOf(latitudeMap));

	    latitudeMap = TreeRangeMap.<Integer, Optional<ClimateCategoryFactory>>create();
	    latitudeMap.put(Range.closed(0, 20), Optional.of(new ClimateCategoryFactory(WARM_AND_RAINY, WARM_WITH_DRY_SUMMER)));
	    latitudeMap.put(Range.closed(21, 40), Optional.of(new ClimateCategoryFactory(WARM_AND_RAINY, WARM_WITH_DRY_SUMMER)));
	    latitudeMap.put(Range.closed(41, 70), Optional.of(COOL_WITH_DRY_WINTER_FACTORY));
	    latitudeMap.put(Range.closed(71, 90), Optional.of(TUNDRA_FACTORY));
	
	    climateCategories.put(MOUNTAINS, COASTAL, ImmutableRangeMap.copyOf(latitudeMap));
	
	    latitudeMap = TreeRangeMap.<Integer, Optional<ClimateCategoryFactory>>create();
	    latitudeMap.put(Range.closed(0, 20), Optional.of(EQUATORIAL_FACTORY));
	    latitudeMap.put(Range.closed(21, 40), Optional.of(WARM_WITH_DRY_SUMMER_FACTORY));
	    latitudeMap.put(Range.closed(41, 50), Optional.of(WARM_WITH_DRY_WINTER_FACTORY));
	    latitudeMap.put(Range.closed(51, 70), Optional.of(COOL_AND_RAINY_FACTORY));
	    latitudeMap.put(Range.closed(71, 90), Optional.<ClimateCategoryFactory>absent());
	
	    climateCategories.put(SWAMP, INLAND, ImmutableRangeMap.copyOf(latitudeMap));

	    latitudeMap = TreeRangeMap.<Integer, Optional<ClimateCategoryFactory>>create();
	    latitudeMap.put(Range.closed(0, 20), Optional.of(MONSOON_FACTORY));
	    latitudeMap.put(Range.closed(21, 40), Optional.of(WARM_AND_RAINY_FACTORY));
	    latitudeMap.put(Range.closed(41, 50), Optional.of(new ClimateCategoryFactory(WARM_AND_RAINY, WARM_WITH_DRY_SUMMER)));
	    latitudeMap.put(Range.closed(51, 70), Optional.of(COOL_WITH_DRY_WINTER_FACTORY));
	    latitudeMap.put(Range.closed(71, 90), Optional.<ClimateCategoryFactory>absent());

	    climateCategories.put(SWAMP, COASTAL, ImmutableRangeMap.copyOf(latitudeMap));
	    
	    CLIMATE_CATEGORIES = ImmutableTable.copyOf(climateCategories);
    }
	
	public static ClimateCategory climateCategoryFor(Terrain terrain, TerrainLocation terrainLocation, int latitude) {
		checkNotNull(terrain);
		checkNotNull(terrainLocation);
		checkArgument(Latitudes.isValid(latitude));
		Optional<ClimateCategoryFactory> factory = CLIMATE_CATEGORIES.get(terrain, terrainLocation).get(latitude);
		if (!factory.isPresent()) {
			return null;
		}
		return factory.get().create();
	}
	
	public static ClimateCategory climateCategoryFor(int ordinal) {
		return CATEGORY_MAP.get(ordinal);
	}
	
	private ClimateCategory(int ordinal, String name) {
		this.ordinal = ordinal;
		this.name = name;
		Pair<RangeMap<Integer, RandomizableStringSource>, RangeMap<Integer, RandomizableStringSource>> temps = getTemperatures();
		this.northTemps = temps.getLeft();
		this.southTemps = temps.getRight();
		checkNotNull(this.northTemps);
		checkNotNull(this.southTemps);
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
	
	public Temperature getTemperature (Hemisphere hemisphere, Month month) {
		checkNotNull(hemisphere);
		checkNotNull(month);
		RangeMap<Integer, RandomizableStringSource> rangeMap = hemisphere == NORTHERN ? northTemps : southTemps;	
	    String description = rangeMap.get(month.getOrdinal()).getValue();
	    Temperature temperature = Temperature.newTemperature(description);
	    return temperature;
	}
	
	protected abstract Pair<RangeMap<Integer, RandomizableStringSource>, RangeMap<Integer, RandomizableStringSource>> getTemperatures();

    private static class ClimateCategoryFactory {
    	
    	private final ClimateCategory [] categories;
    	private final Die die;
    	
    	private ClimateCategoryFactory (ClimateCategory ... categories) {
    		checkArgument(categories.length > 0);
    		this.categories = Arrays.copyOf(categories, categories.length);
    		this.die = newDie(categories.length);
    	}
    	
    	public ClimateCategory create () {
    		if (categories.length == 1) {
    			return categories[0];
    		}
    		return categories[die.roll() - 1];
    	}
    }

}
