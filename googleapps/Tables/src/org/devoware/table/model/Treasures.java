package org.devoware.table.model;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import static org.devoware.table.dice.Dice.newDice;
import static org.devoware.table.dice.Die.D10;
import static org.devoware.table.dice.Die.D100;
import static org.devoware.table.dice.Die.D4;
import static org.devoware.table.dice.Die.D6;
import static org.devoware.table.dice.Die.D8;
import static org.devoware.table.model.CompositeValueSource.newCompositeValueSource;
import static org.devoware.table.model.FormattedValue.newFormattedValue;
import static org.devoware.table.model.GemsAndArt.ART_2500_GP;
import static org.devoware.table.model.GemsAndArt.ART_250_GP;
import static org.devoware.table.model.GemsAndArt.ART_25_GP;
import static org.devoware.table.model.GemsAndArt.ART_7500_GP;
import static org.devoware.table.model.GemsAndArt.ART_750_GP;
import static org.devoware.table.model.GemsAndArt.GEMS_1000_GP;
import static org.devoware.table.model.GemsAndArt.GEMS_100_GP;
import static org.devoware.table.model.GemsAndArt.GEMS_10_GP;
import static org.devoware.table.model.GemsAndArt.GEMS_5000_GP;
import static org.devoware.table.model.GemsAndArt.GEMS_500_GP;
import static org.devoware.table.model.GemsAndArt.GEMS_50_GP;
import static org.devoware.table.model.MagicItems.MAGIC_ITEM_TABLE_A;
import static org.devoware.table.model.MagicItems.MAGIC_ITEM_TABLE_B;
import static org.devoware.table.model.MagicItems.MAGIC_ITEM_TABLE_C;
import static org.devoware.table.model.MagicItems.MAGIC_ITEM_TABLE_D;
import static org.devoware.table.model.MagicItems.MAGIC_ITEM_TABLE_E;
import static org.devoware.table.model.MagicItems.MAGIC_ITEM_TABLE_F;
import static org.devoware.table.model.MagicItems.MAGIC_ITEM_TABLE_G;
import static org.devoware.table.model.MagicItems.MAGIC_ITEM_TABLE_H;
import static org.devoware.table.model.MagicItems.MAGIC_ITEM_TABLE_I;
import static org.devoware.table.model.FormattedIntegerValue.newFormattedIntegerValue;
import static org.devoware.table.model.RollMultiple.rollMultiple;
import static org.devoware.table.model.Separators.DEFAULT_SEPARATOR;
import static org.devoware.table.model.StringValue.NO_VALUE;
import static org.devoware.table.model.ValueRangeMap.newValueRangeMap;

import java.util.Map;

import org.devoware.encounterplanner.util.EncounterUtil;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableRangeMap;
import com.google.common.collect.Maps;
import com.google.common.collect.Range;
import com.google.common.collect.RangeMap;
import com.google.common.collect.TreeRangeMap;

public class Treasures {

	public static final ValueRangeMap INDIVIDUAL_TREASURE_0_TO_4 = newValueRangeMap(D100)
			.with(1, 30, newFormattedIntegerValue("%d cp", newDice().with(5, D6).build()))
			.with(31, 60, newFormattedIntegerValue("%d sp", newDice().with(4, D6).build()))
			.with(61, 70, newFormattedIntegerValue("%d ep", newDice().with(3, D6).build()))
			.with(71, 95, newFormattedIntegerValue("%d gp", newDice().with(3, D6).build()))
			.with(96, 100, newFormattedIntegerValue("%d pp", D6))
			.build();

	public static final ValueRangeMap INDIVIDUAL_TREASURE_5_TO_10 = newValueRangeMap(D100)
			.with(1, 30, newCompositeValueSource()
					.with(newFormattedIntegerValue("%d cp", newDice().with(4, D6).withMultiplier(100).build()))
					.with(newFormattedIntegerValue("%d ep", newDice().with(1, D6).withMultiplier(10).build()))
                    .build())					
			.with(31, 60, newCompositeValueSource()
					.with(newFormattedIntegerValue("%d sp", newDice().with(6, D6).withMultiplier(10).build()))
					.with(newFormattedIntegerValue("%d gp", newDice().with(2, D6).withMultiplier(10).build()))
                    .build())
			.with(61, 70, newCompositeValueSource()
					.with(newFormattedIntegerValue("%d ep", newDice().with(3, D6).withMultiplier(10).build()))
					.with(newFormattedIntegerValue("%d gp", newDice().with(2, D6).withMultiplier(10).build()))
                    .build())
			.with(71, 95, newFormattedIntegerValue("%d gp", newDice().with(4, D6).withMultiplier(10).build()))
			.with(96, 100, newCompositeValueSource()
					.with(newFormattedIntegerValue("%d gp", newDice().with(2, D6).withMultiplier(10).build()))
					.with(newFormattedIntegerValue("%d pp", newDice().with(3, D6).build()))
                    .build())
			.build();

	public static final ValueRangeMap INDIVIDUAL_TREASURE_11_TO_16 = newValueRangeMap(D100)
			.with(1, 20, newCompositeValueSource()
					.with(newFormattedIntegerValue("%d sp", newDice().with(4, D6).withMultiplier(10).build()))
					.with(newFormattedIntegerValue("%d gp", newDice().with(1, D6).withMultiplier(100).build()))
                    .build())					
			.with(21, 35, newCompositeValueSource()
					.with(newFormattedIntegerValue("%d ep", newDice().with(1, D6).withMultiplier(100).build()))
					.with(newFormattedIntegerValue("%d gp", newDice().with(1, D6).withMultiplier(100).build()))
                    .build())
			.with(36, 75, newCompositeValueSource()
					.with(newFormattedIntegerValue("%d gp", newDice().with(2, D6).withMultiplier(100).build()))
					.with(newFormattedIntegerValue("%d pp", newDice().with(1, D6).withMultiplier(10).build()))
                    .build())
			.with(76, 100, newCompositeValueSource()
					.with(newFormattedIntegerValue("%d gp", newDice().with(2, D6).withMultiplier(100).build()))
					.with(newFormattedIntegerValue("%d pp", newDice().with(2, D6).withMultiplier(10).build()))
                    .build())
			.build();

	public static final ValueRangeMap INDIVIDUAL_TREASURE_17_PLUS = newValueRangeMap(D100)
			.with(1, 15, newCompositeValueSource()
					.with(newFormattedIntegerValue("%d ep", newDice().with(2, D6).withMultiplier(1000).build()))
					.with(newFormattedIntegerValue("%d gp", newDice().with(8, D6).withMultiplier(100).build()))
                    .build())					
			.with(16, 55, newCompositeValueSource()
					.with(newFormattedIntegerValue("%d gp", newDice().with(1, D6).withMultiplier(1000).build()))
					.with(newFormattedIntegerValue("%d pp", newDice().with(1, D6).withMultiplier(100).build()))
                    .build())
			.with(56, 100, newCompositeValueSource()
					.with(newFormattedIntegerValue("%d gp", newDice().with(1, D6).withMultiplier(1000).build()))
					.with(newFormattedIntegerValue("%d pp", newDice().with(2, D6).withMultiplier(100).build()))
                    .build())
			.build();
	

	public static final CompositeValueSource TREASURE_HOARD_0_TO_4 = newCompositeValueSource()
			.with(newCompositeValueSource()
					.with(newFormattedIntegerValue("%d cp", newDice().with(6, D6).withMultiplier(100).build()))
					.with(newFormattedIntegerValue("%d sp", newDice().with(3, D6).withMultiplier(100).build()))
					.with(newFormattedIntegerValue("%d gp", newDice().with(2, D6).withMultiplier(10).build()))
			        .build())
			.with(newValueRangeMap(D100)
					.with(1, 6, NO_VALUE)
					.with(7, 16, newCompositeValueSource()
							.with(newFormattedValue("%s (%s)", newFormattedIntegerValue("%d x 10 gp gems", newDice().with(2, D6).build()), GEMS_10_GP))
							.build())
					.with(17, 26, newCompositeValueSource()
							.with(rollMultiple(ART_25_GP, newDice().with(2, D4).build()))
							.build())
					.with(27, 36, newCompositeValueSource()
							.with(newFormattedValue("%s (%s)", newFormattedIntegerValue("%d x 50 gp gems", newDice().with(2, D6).build()), GEMS_50_GP))
							.build())
					.with(37, 44, newCompositeValueSource()
							.with(newFormattedValue("%s (%s)", newFormattedIntegerValue("%d x 10 gp gems", newDice().with(2, D6).build()), GEMS_10_GP))
							.with(rollMultiple(MAGIC_ITEM_TABLE_A, D6))
							.build())
					.with(45, 52, newCompositeValueSource()
							.with(rollMultiple(ART_25_GP, newDice().with(2, D4).build()))
							.with(rollMultiple(MAGIC_ITEM_TABLE_A, D6))
							.build())
					.with(53, 60, newCompositeValueSource()
							.with(newFormattedValue("%s (%s)", newFormattedIntegerValue("%d x 50 gp gems", newDice().with(2, D6).build()), GEMS_50_GP))
							.with(rollMultiple(MAGIC_ITEM_TABLE_A, D6))
							.build())
					.with(61, 65, newCompositeValueSource()
							.with(newFormattedValue("%s (%s)", newFormattedIntegerValue("%d x 10 gp gems", newDice().with(2, D6).build()), GEMS_10_GP))
							.with(rollMultiple(MAGIC_ITEM_TABLE_B, D4))
							.build())
					.with(66, 70, newCompositeValueSource()
							.with(rollMultiple(ART_25_GP, newDice().with(2, D4).build()))
							.with(rollMultiple(MAGIC_ITEM_TABLE_B, D4))
							.build())
					.with(71, 75, newCompositeValueSource()
							.with(newFormattedValue("%s (%s)", newFormattedIntegerValue("%d x 50 gp gems", newDice().with(2, D6).build()), GEMS_50_GP))
							.with(rollMultiple(MAGIC_ITEM_TABLE_B, D4))
							.build())
					.with(76, 78, newCompositeValueSource()
							.with(newFormattedValue("%s (%s)", newFormattedIntegerValue("%d x 10 gp gems", newDice().with(2, D6).build()), GEMS_10_GP))
							.with(rollMultiple(MAGIC_ITEM_TABLE_C, D4))
							.build())
					.with(79, 80, newCompositeValueSource()
							.with(rollMultiple(ART_25_GP, newDice().with(2, D4).build()))
							.with(rollMultiple(MAGIC_ITEM_TABLE_C, D4))
							.build())
					.with(81, 85, newCompositeValueSource()
							.with(newFormattedValue("%s (%s)", newFormattedIntegerValue("%d x 50 gp gems", newDice().with(2, D6).build()), GEMS_50_GP))
							.with(rollMultiple(MAGIC_ITEM_TABLE_C, D4))
							.build())
					.with(86, 92, newCompositeValueSource()
							.with(rollMultiple(ART_25_GP, newDice().with(2, D4).build()))
							.with(rollMultiple(MAGIC_ITEM_TABLE_F, D4))
							.build())
					.with(93, 97, newCompositeValueSource()
							.with(newFormattedValue("%s (%s)", newFormattedIntegerValue("%d x 50 gp gems", newDice().with(2, D6).build()), GEMS_50_GP))
							.with(rollMultiple(MAGIC_ITEM_TABLE_F, D4))
							.build())
					.with(98, 99, newCompositeValueSource()
							.with(rollMultiple(ART_25_GP, newDice().with(2, D4).build()))
							.with(MAGIC_ITEM_TABLE_G)
							.build())
					.with(100, newCompositeValueSource()
							.with(newFormattedValue("%s (%s)", newFormattedIntegerValue("%d x 50 gp gems", newDice().with(2, D6).build()), GEMS_50_GP))
							.with(MAGIC_ITEM_TABLE_G)
							.build())
					.build())        
			.build();
	
	public static final CompositeValueSource TREASURE_HOARD_5_TO_10 = newCompositeValueSource()
			.with(newCompositeValueSource()
					.with(newFormattedIntegerValue("%d cp", newDice().with(2, D6).withMultiplier(100).build()))
					.with(newFormattedIntegerValue("%d sp", newDice().with(2, D6).withMultiplier(1000).build()))
					.with(newFormattedIntegerValue("%d gp", newDice().with(6, D6).withMultiplier(100).build()))
					.with(newFormattedIntegerValue("%d pp", newDice().with(3, D6).withMultiplier(10).build()))
			        .build())
			.with(newValueRangeMap(D100)
					.with(1, 4, NO_VALUE)
					.with(5, 10, newCompositeValueSource()
							.with(rollMultiple(ART_25_GP, newDice().with(2, D4).build()))
							.build())
					.with(11, 16, newCompositeValueSource()
							.with(newFormattedValue("%s (%s)", newFormattedIntegerValue("%d x 50 gp gems", newDice().with(3, D6).build()), GEMS_50_GP))
							.build())
					.with(17, 22, newCompositeValueSource()
							.with(newFormattedValue("%s (%s)", newFormattedIntegerValue("%d x 100 gp gems", newDice().with(3, D6).build()), GEMS_100_GP))
							.build())
					.with(23, 28, newCompositeValueSource()
							.with(rollMultiple(ART_250_GP, newDice().with(2, D4).build()))
							.build())
					.with(29, 32, newCompositeValueSource()
							.with(rollMultiple(ART_25_GP, newDice().with(2, D4).build()))
							.with(rollMultiple(MAGIC_ITEM_TABLE_A, D6))
							.build())
					.with(33, 36, newCompositeValueSource()
							.with(newFormattedValue("%s (%s)", newFormattedIntegerValue("%d x 50 gp gems", newDice().with(3, D6).build()), GEMS_50_GP))
							.with(rollMultiple(MAGIC_ITEM_TABLE_A, D6))
							.build())
					.with(37, 40, newCompositeValueSource()
							.with(newFormattedValue("%s (%s)", newFormattedIntegerValue("%d x 100 gp gems", newDice().with(3, D6).build()), GEMS_100_GP))
							.with(rollMultiple(MAGIC_ITEM_TABLE_A, D6))
							.build())
					.with(41, 44, newCompositeValueSource()
							.with(rollMultiple(ART_250_GP, newDice().with(2, D4).build()))
							.with(rollMultiple(MAGIC_ITEM_TABLE_A, D6))
							.build())
					.with(45, 49, newCompositeValueSource()
							.with(rollMultiple(ART_25_GP, newDice().with(2, D4).build()))
							.with(rollMultiple(MAGIC_ITEM_TABLE_B, D4))
							.build())
					.with(50, 54, newCompositeValueSource()
							.with(newFormattedValue("%s (%s)", newFormattedIntegerValue("%d x 50 gp gems", newDice().with(3, D6).build()), GEMS_50_GP))
							.with(rollMultiple(MAGIC_ITEM_TABLE_B, D4))
							.build())
					.with(55, 59, newCompositeValueSource()
							.with(newFormattedValue("%s (%s)", newFormattedIntegerValue("%d x 100 gp gems", newDice().with(3, D6).build()), GEMS_100_GP))
							.with(rollMultiple(MAGIC_ITEM_TABLE_B, D4))
							.build())
					.with(60, 63, newCompositeValueSource()
							.with(rollMultiple(ART_250_GP, newDice().with(2, D4).build()))
							.with(rollMultiple(MAGIC_ITEM_TABLE_B, D4))
							.build())
					.with(64, 66, newCompositeValueSource()
							.with(rollMultiple(ART_25_GP, newDice().with(2, D4).build()))
							.with(rollMultiple(MAGIC_ITEM_TABLE_C, D4))
							.build())
					.with(67, 69, newCompositeValueSource()
							.with(newFormattedValue("%s (%s)", newFormattedIntegerValue("%d x 50 gp gems", newDice().with(3, D6).build()), GEMS_50_GP))
							.with(rollMultiple(MAGIC_ITEM_TABLE_C, D4))
							.build())
					.with(70, 72, newCompositeValueSource()
							.with(newFormattedValue("%s (%s)", newFormattedIntegerValue("%d x 100 gp gems", newDice().with(3, D6).build()), GEMS_100_GP))
							.with(rollMultiple(MAGIC_ITEM_TABLE_C, D4))
							.build())
					.with(73, 74, newCompositeValueSource()
							.with(rollMultiple(ART_250_GP, newDice().with(2, D4).build()))
							.with(rollMultiple(MAGIC_ITEM_TABLE_C, D4))
							.build())
					.with(75, 76, newCompositeValueSource()
							.with(rollMultiple(ART_25_GP, newDice().with(2, D4).build()))
							.with(MAGIC_ITEM_TABLE_D)
							.build())
					.with(77, 78, newCompositeValueSource()
							.with(newFormattedValue("%s (%s)", newFormattedIntegerValue("%d x 50 gp gems", newDice().with(3, D6).build()), GEMS_50_GP))
							.with(MAGIC_ITEM_TABLE_D)
							.build())
					.with(79, newCompositeValueSource()
							.with(newFormattedValue("%s (%s)", newFormattedIntegerValue("%d x 100 gp gems", newDice().with(3, D6).build()), GEMS_100_GP))
							.with(MAGIC_ITEM_TABLE_D)
							.build())
					.with(80, newCompositeValueSource()
							.with(rollMultiple(ART_250_GP, newDice().with(2, D4).build()))
							.with(MAGIC_ITEM_TABLE_D)
							.build())
					.with(81, 84, newCompositeValueSource()
							.with(rollMultiple(ART_25_GP, newDice().with(2, D4).build()))
							.with(rollMultiple(MAGIC_ITEM_TABLE_F, D4))
							.build())
					.with(85, 88, newCompositeValueSource()
							.with(newFormattedValue("%s (%s)", newFormattedIntegerValue("%d x 50 gp gems", newDice().with(3, D6).build()), GEMS_50_GP))
							.with(rollMultiple(MAGIC_ITEM_TABLE_F, D4))
							.build())
					.with(89, 91, newCompositeValueSource()
							.with(newFormattedValue("%s (%s)", newFormattedIntegerValue("%d x 100 gp gems", newDice().with(3, D6).build()), GEMS_100_GP))
							.with(rollMultiple(MAGIC_ITEM_TABLE_F, D4))
							.build())
					.with(92, 94, newCompositeValueSource()
							.with(rollMultiple(ART_250_GP, newDice().with(2, D4).build()))
							.with(rollMultiple(MAGIC_ITEM_TABLE_F, D4))
							.build())
					.with(95, 96, newCompositeValueSource()
							.with(newFormattedValue("%s (%s)", newFormattedIntegerValue("%d x 100 gp gems", newDice().with(3, D6).build()), GEMS_100_GP))
							.with(rollMultiple(MAGIC_ITEM_TABLE_G, D4))
							.build())
					.with(97, 98, newCompositeValueSource()
							.with(rollMultiple(ART_250_GP, newDice().with(2, D4).build()))
							.with(rollMultiple(MAGIC_ITEM_TABLE_G, D4))
							.build())
					.with(99, newCompositeValueSource()
							.with(newFormattedValue("%s (%s)", newFormattedIntegerValue("%d x 100 gp gems", newDice().with(3, D6).build()), GEMS_100_GP))
							.with(MAGIC_ITEM_TABLE_H)
							.build())
					.with(100, newCompositeValueSource()
							.with(rollMultiple(ART_250_GP, newDice().with(2, D4).build()))
							.with(MAGIC_ITEM_TABLE_H)
							.build())
					.build())        
			.build();

	public static final CompositeValueSource TREASURE_HOARD_11_TO_16 = newCompositeValueSource()
			.with(newCompositeValueSource()
					.with(newFormattedIntegerValue("%d gp", newDice().with(4, D6).withMultiplier(1000).build()))
					.with(newFormattedIntegerValue("%d pp", newDice().with(5, D6).withMultiplier(100).build()))
			        .build())
			.with(newValueRangeMap(D100)
					.with(1, 3, NO_VALUE)
					.with(4, 6, newCompositeValueSource()
							.with(rollMultiple(ART_250_GP, newDice().with(2, D4).build()))
							.build())
					.with(7, 9, newCompositeValueSource()
							.with(rollMultiple(ART_750_GP, newDice().with(2, D4).build()))
							.build())
					.with(10, 12, newCompositeValueSource()
							.with(newFormattedValue("%s (%s)", newFormattedIntegerValue("%d x 500 gp gems", newDice().with(3, D6).build()), GEMS_500_GP))
							.build())
					.with(13, 15, newCompositeValueSource()
							.with(newFormattedValue("%s (%s)", newFormattedIntegerValue("%d x 1,000 gp gems", newDice().with(3, D6).build()), GEMS_1000_GP))
							.build())
					.with(16, 19, newCompositeValueSource()
							.with(rollMultiple(ART_250_GP, newDice().with(2, D4).build()))
							.with(rollMultiple(MAGIC_ITEM_TABLE_A, D4))
							.with(rollMultiple(MAGIC_ITEM_TABLE_B, D6))
							.build())
					.with(20, 23, newCompositeValueSource()
							.with(rollMultiple(ART_750_GP, newDice().with(2, D4).build()))
							.with(rollMultiple(MAGIC_ITEM_TABLE_A, D4))
							.with(rollMultiple(MAGIC_ITEM_TABLE_B, D6))
							.build())
					.with(24, 26, newCompositeValueSource()
							.with(newFormattedValue("%s (%s)", newFormattedIntegerValue("%d x 500 gp gems", newDice().with(3, D6).build()), GEMS_500_GP))
							.with(rollMultiple(MAGIC_ITEM_TABLE_A, D4))
							.with(rollMultiple(MAGIC_ITEM_TABLE_B, D6))
							.build())
					.with(27, 29, newCompositeValueSource()
							.with(newFormattedValue("%s (%s)", newFormattedIntegerValue("%d x 1,000 gp gems", newDice().with(3, D6).build()), GEMS_1000_GP))
							.with(rollMultiple(MAGIC_ITEM_TABLE_A, D4))
							.with(rollMultiple(MAGIC_ITEM_TABLE_B, D6))
							.build())
					.with(30, 35, newCompositeValueSource()
							.with(rollMultiple(ART_250_GP, newDice().with(2, D4).build()))
							.with(rollMultiple(MAGIC_ITEM_TABLE_C, D6))
							.build())
					.with(36, 40, newCompositeValueSource()
							.with(rollMultiple(ART_750_GP, newDice().with(2, D4).build()))
							.with(rollMultiple(MAGIC_ITEM_TABLE_C, D6))
							.build())
					.with(41, 45, newCompositeValueSource()
							.with(newFormattedValue("%s (%s)", newFormattedIntegerValue("%d x 500 gp gems", newDice().with(3, D6).build()), GEMS_500_GP))
							.with(rollMultiple(MAGIC_ITEM_TABLE_C, D6))
							.build())
					.with(46, 50, newCompositeValueSource()
							.with(newFormattedValue("%s (%s)", newFormattedIntegerValue("%d x 1,000 gp gems", newDice().with(3, D6).build()), GEMS_1000_GP))
							.with(rollMultiple(MAGIC_ITEM_TABLE_C, D6))
							.build())
					.with(51, 54, newCompositeValueSource()
							.with(rollMultiple(ART_250_GP, newDice().with(2, D4).build()))
							.with(rollMultiple(MAGIC_ITEM_TABLE_D, D4))
							.build())
					.with(55, 58, newCompositeValueSource()
							.with(rollMultiple(ART_750_GP, newDice().with(2, D4).build()))
							.with(rollMultiple(MAGIC_ITEM_TABLE_D, D4))
							.build())
					.with(59, 62, newCompositeValueSource()
							.with(newFormattedValue("%s (%s)", newFormattedIntegerValue("%d x 500 gp gems", newDice().with(3, D6).build()), GEMS_500_GP))
							.with(rollMultiple(MAGIC_ITEM_TABLE_D, D4))
							.build())
					.with(63, 66, newCompositeValueSource()
							.with(newFormattedValue("%s (%s)", newFormattedIntegerValue("%d x 1,000 gp gems", newDice().with(3, D6).build()), GEMS_1000_GP))
							.with(rollMultiple(MAGIC_ITEM_TABLE_D, D4))
							.build())
					.with(67, 68, newCompositeValueSource()
							.with(rollMultiple(ART_250_GP, newDice().with(2, D4).build()))
							.with(MAGIC_ITEM_TABLE_E)
							.build())
					.with(69, 70, newCompositeValueSource()
							.with(rollMultiple(ART_750_GP, newDice().with(2, D4).build()))
							.with(MAGIC_ITEM_TABLE_E)
							.build())
					.with(71, 72, newCompositeValueSource()
							.with(newFormattedValue("%s (%s)", newFormattedIntegerValue("%d x 500 gp gems", newDice().with(3, D6).build()), GEMS_500_GP))
							.with(MAGIC_ITEM_TABLE_E)
							.build())
					.with(73, 74, newCompositeValueSource()
							.with(newFormattedValue("%s (%s)", newFormattedIntegerValue("%d x 1,000 gp gems", newDice().with(3, D6).build()), GEMS_1000_GP))
							.with(MAGIC_ITEM_TABLE_E)
							.build())
					.with(75, 76, newCompositeValueSource()
							.with(rollMultiple(ART_250_GP, newDice().with(2, D4).build()))
							.with(MAGIC_ITEM_TABLE_F)
							.with(rollMultiple(MAGIC_ITEM_TABLE_G, D4))
							.build())
					.with(77, 78, newCompositeValueSource()
							.with(rollMultiple(ART_750_GP, newDice().with(2, D4).build()))
							.with(MAGIC_ITEM_TABLE_F)
							.with(rollMultiple(MAGIC_ITEM_TABLE_G, D4))
							.build())
					.with(79, 80, newCompositeValueSource()
							.with(newFormattedValue("%s (%s)", newFormattedIntegerValue("%d x 500 gp gems", newDice().with(3, D6).build()), GEMS_500_GP))
							.with(MAGIC_ITEM_TABLE_F)
							.with(rollMultiple(MAGIC_ITEM_TABLE_G, D4))
							.build())
					.with(81, 82, newCompositeValueSource()
							.with(newFormattedValue("%s (%s)", newFormattedIntegerValue("%d x 1,000 gp gems", newDice().with(3, D6).build()), GEMS_1000_GP))
							.with(MAGIC_ITEM_TABLE_F)
							.with(rollMultiple(MAGIC_ITEM_TABLE_G, D4))
							.build())
					.with(83, 85, newCompositeValueSource()
							.with(rollMultiple(ART_250_GP, newDice().with(2, D4).build()))
							.with(rollMultiple(MAGIC_ITEM_TABLE_H, D4))
							.build())
					.with(86, 88, newCompositeValueSource()
							.with(rollMultiple(ART_750_GP, newDice().with(2, D4).build()))
							.with(rollMultiple(MAGIC_ITEM_TABLE_H, D4))
							.build())
					.with(89, 90, newCompositeValueSource()
							.with(newFormattedValue("%s (%s)", newFormattedIntegerValue("%d x 500 gp gems", newDice().with(3, D6).build()), GEMS_500_GP))
							.with(rollMultiple(MAGIC_ITEM_TABLE_H, D4))
							.build())
					.with(91, 92, newCompositeValueSource()
							.with(newFormattedValue("%s (%s)", newFormattedIntegerValue("%d x 1,000 gp gems", newDice().with(3, D6).build()), GEMS_1000_GP))
							.with(rollMultiple(MAGIC_ITEM_TABLE_H, D4))
							.build())
					.with(93, 94, newCompositeValueSource()
							.with(rollMultiple(ART_250_GP, newDice().with(2, D4).build()))
							.with(MAGIC_ITEM_TABLE_I)
							.build())
					.with(95, 96, newCompositeValueSource()
							.with(rollMultiple(ART_750_GP, newDice().with(2, D4).build()))
							.with(MAGIC_ITEM_TABLE_I)
							.build())
					.with(97, 98, newCompositeValueSource()
							.with(newFormattedValue("%s (%s)", newFormattedIntegerValue("%d x 500 gp gems", newDice().with(3, D6).build()), GEMS_500_GP))
							.with(MAGIC_ITEM_TABLE_I)
							.build())
					.with(99, 100, newCompositeValueSource()
							.with(newFormattedValue("%s (%s)", newFormattedIntegerValue("%d x 1,000 gp gems", newDice().with(3, D6).build()), GEMS_1000_GP))
							.with(MAGIC_ITEM_TABLE_I)
							.build())
					.build())
			.build();

	public static final CompositeValueSource TREASURE_HOARD_17_PLUS = newCompositeValueSource()
			.with(newCompositeValueSource()
					.with(newFormattedIntegerValue("%d gp", newDice().with(12, D6).withMultiplier(1000).build()))
					.with(newFormattedIntegerValue("%d pp", newDice().with(8, D6).withMultiplier(1000).build()))
			        .build())
			.with(newValueRangeMap(D100)
					.with(1, 2, NO_VALUE)
					.with(3, 5, newCompositeValueSource()
							.with(newFormattedValue("%s (%s)", newFormattedIntegerValue("%d x 1,000 gp gems", newDice().with(3, D6).build()), GEMS_1000_GP))
							.with(rollMultiple(MAGIC_ITEM_TABLE_C, D8))
							.build())
					.with(6, 8, newCompositeValueSource()
							.with(rollMultiple(ART_2500_GP, D10))
							.with(rollMultiple(MAGIC_ITEM_TABLE_C, D8))
							.build())
					.with(9, 11, newCompositeValueSource()
							.with(rollMultiple(ART_7500_GP, D4))
							.with(rollMultiple(MAGIC_ITEM_TABLE_C, D8))
							.build())
					.with(12, 14, newCompositeValueSource()
							.with(newFormattedValue("%s (%s)", newFormattedIntegerValue("%d x 5,000 gp gems", newDice().with(1, D8).build()), GEMS_5000_GP))
							.with(rollMultiple(MAGIC_ITEM_TABLE_C, D8))
							.build())
					.with(15, 22, newCompositeValueSource()
							.with(newFormattedValue("%s (%s)", newFormattedIntegerValue("%d x 1,000 gp gems", newDice().with(3, D6).build()), GEMS_1000_GP))
							.with(rollMultiple(MAGIC_ITEM_TABLE_D, D6))
							.build())
					.with(23, 30, newCompositeValueSource()
							.with(rollMultiple(ART_2500_GP, D10))
							.with(rollMultiple(MAGIC_ITEM_TABLE_D, D6))
							.build())
					.with(31, 38, newCompositeValueSource()
							.with(rollMultiple(ART_7500_GP, D4))
							.with(rollMultiple(MAGIC_ITEM_TABLE_D, D6))
							.build())
					.with(39, 46, newCompositeValueSource()
							.with(newFormattedValue("%s (%s)", newFormattedIntegerValue("%d x 5,000 gp gems", newDice().with(1, D8).build()), GEMS_5000_GP))
							.with(rollMultiple(MAGIC_ITEM_TABLE_E, D6))
							.build())
					.with(47, 52, newCompositeValueSource()
							.with(newFormattedValue("%s (%s)", newFormattedIntegerValue("%d x 1,000 gp gems", newDice().with(3, D6).build()), GEMS_1000_GP))
							.with(rollMultiple(MAGIC_ITEM_TABLE_E, D6))
							.build())
					.with(53, 58, newCompositeValueSource()
							.with(rollMultiple(ART_2500_GP, D10))
							.with(rollMultiple(MAGIC_ITEM_TABLE_E, D6))
							.build())
					.with(59, 63, newCompositeValueSource()
							.with(rollMultiple(ART_7500_GP, D4))
							.with(rollMultiple(MAGIC_ITEM_TABLE_E, D6))
							.build())
					.with(64, 68, newCompositeValueSource()
							.with(newFormattedValue("%s (%s)", newFormattedIntegerValue("%d x 5,000 gp gems", newDice().with(1, D8).build()), GEMS_5000_GP))
							.with(rollMultiple(MAGIC_ITEM_TABLE_E, D6))
							.build())
					.with(69, newCompositeValueSource()
							.with(newFormattedValue("%s (%s)", newFormattedIntegerValue("%d x 1,000 gp gems", newDice().with(3, D6).build()), GEMS_1000_GP))
							.with(rollMultiple(MAGIC_ITEM_TABLE_G, D4))
							.build())
					.with(70, newCompositeValueSource()
							.with(rollMultiple(ART_2500_GP, D10))
							.with(rollMultiple(MAGIC_ITEM_TABLE_G, D4))
							.build())
					.with(71, newCompositeValueSource()
							.with(rollMultiple(ART_7500_GP, D4))
							.with(rollMultiple(MAGIC_ITEM_TABLE_G, D4))
							.build())
					.with(72, newCompositeValueSource()
							.with(newFormattedValue("%s (%s)", newFormattedIntegerValue("%d x 5,000 gp gems", newDice().with(1, D8).build()), GEMS_5000_GP))
							.with(rollMultiple(MAGIC_ITEM_TABLE_G, D4))
							.build())
					.with(73, 74, newCompositeValueSource()
							.with(newFormattedValue("%s (%s)", newFormattedIntegerValue("%d x 1,000 gp gems", newDice().with(3, D6).build()), GEMS_1000_GP))
							.with(rollMultiple(MAGIC_ITEM_TABLE_H, D4))
							.build())
					.with(75, 76, newCompositeValueSource()
							.with(rollMultiple(ART_2500_GP, D10))
							.with(rollMultiple(MAGIC_ITEM_TABLE_H, D4))
							.build())
					.with(77, 78, newCompositeValueSource()
							.with(rollMultiple(ART_7500_GP, D4))
							.with(rollMultiple(MAGIC_ITEM_TABLE_H, D4))
							.build())
					.with(79, 80, newCompositeValueSource()
							.with(newFormattedValue("%s (%s)", newFormattedIntegerValue("%d x 5,000 gp gems", newDice().with(1, D8).build()), GEMS_5000_GP))
							.with(rollMultiple(MAGIC_ITEM_TABLE_H, D4))
							.build())
					.with(81, 85, newCompositeValueSource()
							.with(newFormattedValue("%s (%s)", newFormattedIntegerValue("%d x 1,000 gp gems", newDice().with(3, D6).build()), GEMS_1000_GP))
							.with(rollMultiple(MAGIC_ITEM_TABLE_I, D4))
							.build())
					.with(86, 90, newCompositeValueSource()
							.with(rollMultiple(ART_2500_GP, D10))
							.with(rollMultiple(MAGIC_ITEM_TABLE_I, D4))
							.build())
					.with(91, 95, newCompositeValueSource()
							.with(rollMultiple(ART_7500_GP, D4))
							.with(rollMultiple(MAGIC_ITEM_TABLE_I, D4))
							.build())
					.with(96, 100, newCompositeValueSource()
							.with(newFormattedValue("%s (%s)", newFormattedIntegerValue("%d x 5,000 gp gems", newDice().with(1, D8).build()), GEMS_5000_GP))
							.with(rollMultiple(MAGIC_ITEM_TABLE_I, D4))
							.build())
					.build())
			.build();
	
	public static final Map<TreasureType, RangeMap<Double, StringSource>> TREASURES;
	
	static {
		Map<TreasureType, RangeMap<Double, StringSource>> treasures = Maps.newHashMap();
		RangeMap<Double, StringSource> individualTreasures = TreeRangeMap.create();
		individualTreasures.put(Range.singleton(0.0), INDIVIDUAL_TREASURE_0_TO_4);
		individualTreasures.put(Range.singleton(0.125), INDIVIDUAL_TREASURE_0_TO_4);
		individualTreasures.put(Range.singleton(0.25), INDIVIDUAL_TREASURE_0_TO_4);
		individualTreasures.put(Range.singleton(0.5), INDIVIDUAL_TREASURE_0_TO_4);
		for (int i = 1; i <= 4; i++) {
			individualTreasures.put(Range.singleton((double) i), INDIVIDUAL_TREASURE_0_TO_4);
		}
		for (int i = 5; i <= 10; i++) {
			individualTreasures.put(Range.singleton((double) i), INDIVIDUAL_TREASURE_5_TO_10);
		}
		for (int i = 11; i <= 16; i++) {
			individualTreasures.put(Range.singleton((double) i), INDIVIDUAL_TREASURE_11_TO_16);
		}
		for (int i = 17; i <= 30; i++) {
			individualTreasures.put(Range.singleton((double) i), INDIVIDUAL_TREASURE_17_PLUS);
		}
		treasures.put(TreasureType.INDIVIDUAL, ImmutableRangeMap.copyOf(individualTreasures));

		RangeMap<Double, StringSource> treasureHoard = TreeRangeMap.create();
		treasureHoard.put(Range.singleton(0.0), TREASURE_HOARD_0_TO_4);
		treasureHoard.put(Range.singleton(0.125), TREASURE_HOARD_0_TO_4);
		treasureHoard.put(Range.singleton(0.25), TREASURE_HOARD_0_TO_4);
		treasureHoard.put(Range.singleton(0.5), TREASURE_HOARD_0_TO_4);
		for (int i = 1; i <= 4; i++) {
			treasureHoard.put(Range.singleton((double) i), TREASURE_HOARD_0_TO_4);
		}
		for (int i = 5; i <= 10; i++) {
			treasureHoard.put(Range.singleton((double) i), TREASURE_HOARD_5_TO_10);
		}
		for (int i = 11; i <= 16; i++) {
			treasureHoard.put(Range.singleton((double) i), TREASURE_HOARD_11_TO_16);
		}
		for (int i = 17; i <= 30; i++) {
			treasureHoard.put(Range.singleton((double) i), TREASURE_HOARD_17_PLUS);
		}
		treasures.put(TreasureType.TREASURE_HOARD, ImmutableRangeMap.copyOf(treasureHoard));
		
		TREASURES = ImmutableMap.copyOf(treasures);
	}
	
	public static String generate (TreasureType type, double challengeRating) {
		return generate(type, challengeRating, DEFAULT_SEPARATOR);
	}

	public static String generate (TreasureType type, double challengeRating, String separator) {
		checkNotNull(type);
		checkNotNull(separator);
		checkArgument(EncounterUtil.CR_RANGE.contains(challengeRating));
		
		RangeMap<Double, StringSource> treasureTables = TREASURES.get(type);
		StringSource treasureTable = treasureTables.get(challengeRating);
		return treasureTable.getValue(separator);
	}

	private Treasures () {}
}
