package org.devoware.table.weather;

import static com.google.common.base.Preconditions.checkNotNull;
import static org.devoware.table.dice.Dice.newDice;
import static org.devoware.table.dice.Die.D6;
import static org.devoware.table.model.FormattedIntegerValue.newFormattedIntegerValue;
import static org.devoware.table.model.FormattedValue.newFormattedValue;
import static org.devoware.table.model.RandomInt.newRandomInt;
import static org.devoware.table.model.ValueRangeMap.newValueRangeMap;
import static org.devoware.table.weather.ClimateCategory.COOL_AND_RAINY;
import static org.devoware.table.weather.ClimateCategory.COOL_WITH_DRY_WINTER;
import static org.devoware.table.weather.ClimateCategory.DESERT;
import static org.devoware.table.weather.ClimateCategory.EQUATORIAL;
import static org.devoware.table.weather.ClimateCategory.MONSOON;
import static org.devoware.table.weather.ClimateCategory.POLAR;
import static org.devoware.table.weather.ClimateCategory.STEPPE;
import static org.devoware.table.weather.ClimateCategory.TROPICAL_SAVANNA;
import static org.devoware.table.weather.ClimateCategory.TUNDRA;
import static org.devoware.table.weather.ClimateCategory.WARM_AND_RAINY;
import static org.devoware.table.weather.ClimateCategory.WARM_WITH_DRY_SUMMER;
import static org.devoware.table.weather.ClimateCategory.WARM_WITH_DRY_WINTER;
import static org.devoware.table.weather.Hemisphere.NORTHERN;
import static org.devoware.table.weather.Hemisphere.SOUTHERN;
import static org.devoware.table.weather.Temperature.newTemperature;

import java.util.Map;

import org.devoware.table.dice.Dice;
import org.devoware.table.dice.Die;
import org.devoware.table.dice.RandomNumberGenerator;
import org.devoware.table.model.RandomizableStringSource;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableTable;
import com.google.common.collect.Maps;
import com.google.common.collect.Range;
import com.google.common.collect.RangeMap;
import com.google.common.collect.Table;
import com.google.common.collect.TreeRangeMap;

public class AdvancedWeather {
	
	private static final Dice _6D10 = Dice.newDice().with(6, Die.D10).build();

	private static final Dice _2D20 = Dice.newDice().with(2, Die.D20).build();

	private static final Table<ClimateCategory, Hemisphere, RangeMap<Integer, Integer>> PRECIP_CHANCE;

	private static final RandomizableStringSource RAIN = newValueRangeMap(D6)
			.with(1, newFormattedValue("Light mist %s", newValueRangeMap(Die.D100)
					.with(1, 20, "(fog)")
					.with(21, 100, "")
					.build()))
			.with(2, newFormattedValue("Drizzle %s", newValueRangeMap(Die.D100)
					.with(1, 20, "(fog)")
					.with(21, 100, "")
					.build()))
			.with(3, "Steady rainfall")		
			.with(4, "Strong rainfall")		
			.with(5, "Pounding rain")		
			.with(6, "Downpour")		
			.build();
	
	private static final RandomizableStringSource SNOW = newValueRangeMap(D6)
			.with(1, "Few flakes")		
			.with(2, "Dusting")		
			.with(3, "Flurries")		
			.with(4, "Moderate snowfall")		
			.with(5, "Heavy snowfall")		
			.with(6, newFormattedValue("Blizzard %s", newValueRangeMap(Die.D100)
					.with(1, 20, "(hail mixed with snow)")
					.with(11, 100, "")
					.build()))		
			.build();
	
	private static final RandomizableStringSource CLOUD_TYPE = newValueRangeMap(D6)
			.with(1, "A few clouds")		
			.with(2, "Mostly cloudy")		
			.with(3, "Gray, slightly overcast")		
			.with(4, "Gray, highly overcast")		
			.with(5, 6, newFormattedValue("Dark storm clouds %s", newValueRangeMap(Die.D100)
					.with(1, 15, "(electrical storm)")
					.with(16, 100, "")
					.build()))		
			.build();
	
	private static final Map<Integer, RandomNumberGenerator> WIND_TYPE;
	
	private static final RandomizableStringSource WIND_SPEED_TYPE = newValueRangeMap(Die.D200)
			.with(1, 10, "Calm")		
			.with(11, 30, "Light air")		
			.with(31, 50, "Light breeze")		
			.with(51, 70, "Gentle breeze")		
			.with(71, 90, "Moderate breeze")		
			.with(91, 110, "Fresh breeze")		
			.with(111, 130, "Strong breeze")		
			.with(131, 150, "Moderate gale (or near gale)")		
			.with(151, 170, "Fresh gale (or gale)")		
			.with(171, 180, "Strong gale")		
			.with(181, 190, "Strong gale (or storm)")		
			.with(191, 198, "Storm (or violent)")		
			.with(199, 200, "Hurricane")		
			.build();

	private static final RandomizableStringSource WIND_SPEED_MPH = newValueRangeMap(Die.D200)
			.with(1, 10, "Less than 1")		
			.with(11, 30, newFormattedIntegerValue("%d", newRandomInt(1, 3)))		
			.with(31, 50, newFormattedIntegerValue("%d", newRandomInt(4, 7)))		
			.with(51, 70, newFormattedIntegerValue("%d", newRandomInt(8, 12)))		
			.with(71, 90, newFormattedIntegerValue("%d", newRandomInt(13, 18)))		
			.with(91, 110, newFormattedIntegerValue("%d", newRandomInt(19, 24)))		
			.with(111, 130, newFormattedIntegerValue("%d", newRandomInt(25, 31)))		
			.with(131, 150, newFormattedIntegerValue("%d", newRandomInt(32, 38)))		
			.with(151, 170, newFormattedIntegerValue("%d", newRandomInt(39, 46)))		
			.with(171, 180, newFormattedIntegerValue("%d", newRandomInt(47, 54)))		
			.with(181, 190, newFormattedIntegerValue("%d", newRandomInt(55, 63)))		
			.with(191, 198, newFormattedIntegerValue("%d", newRandomInt(64, 72)))		
			.with(199, 200, newFormattedIntegerValue("%d", newRandomInt(73, 136)))		
			.build();
	
	private static final RandomizableStringSource WIND_SPEED_DESCRIPTION = newValueRangeMap(Die.D200)
			.with(1, 10, "Smoke rises vertically")		
			.with(11, 30, "Wind direction shown by smoke but not wind vanes")		
			.with(31, 50, "Wind felt on face, leaves rustle, and ordinary vanes move")		
			.with(51, 70, "Leaves and small twigs sway and banners flap")		
			.with(71, 90, "Small branches move, and dust and small branches are raised")		
			.with(91, 110, "Small trees sway and small waves form on inland waters")		
			.with(111, 130, "Large branches move")		
			.with(131, 150, "Whole trees sway and walking against wind is an inconvenience")		
			.with(151, 170, "Twigs break off trees and general progress is impeded")		
			.with(171, 180, "Slight structural damage occurs")		
			.with(181, 190, "Trees are uprooted and considerable structural damage occurs")		
			.with(191, 198, "Widespread damage occurs")		
			.with(199, 200, "Widespread devastation occurs")		
			.build();

	private static final RandomizableStringSource WIND_DIRECTION = newValueRangeMap(Die.D8)
			.with(1, "North")		
			.with(2, "Northeast")		
			.with(3, "East")		
			.with(4, "Southeast")		
			.with(5, "South")
			.with(6, "Southwest")
			.with(7, "West")
			.with(8, "Northwest")
			.build();
	
	private final String temperature;
	private final String effectiveTemperature;
	private final String nightTimeTemperature;
	private final String precipitation;
	private final String cloudType;
	private final String windType;
	private final String windSpeed;
	private final String windDescription;
	private final String windDirection;

	static {
		Table<ClimateCategory, Hemisphere, RangeMap<Integer, Integer>> precipChance = HashBasedTable.create();
		
		RangeMap<Integer, Integer> rangeMap = TreeRangeMap.create();
		rangeMap.put(Range.closed(1, 12), 5);
		
		precipChance.put(DESERT, NORTHERN, rangeMap);
		precipChance.put(DESERT, SOUTHERN, rangeMap);
		
		rangeMap = TreeRangeMap.<Integer, Integer>create();
		rangeMap.put(Range.closed(5, 9), 85);
		rangeMap.put(Range.singleton(4), 35);
		rangeMap.put(Range.singleton(10), 35);
		rangeMap.put(Range.closed(11, 12), 10);
		rangeMap.put(Range.closed(1, 3), 10);
		
		precipChance.put(TROPICAL_SAVANNA, NORTHERN, rangeMap);
		precipChance.put(TROPICAL_SAVANNA, SOUTHERN, rangeMap);
		
		rangeMap = TreeRangeMap.<Integer, Integer>create();
		rangeMap.put(Range.closed(7, 9), 5);
		rangeMap.put(Range.closed(1, 6), 20);
		rangeMap.put(Range.closed(10, 12), 20);
		
		precipChance.put(STEPPE, NORTHERN, rangeMap);

		rangeMap = TreeRangeMap.<Integer, Integer>create();
		rangeMap.put(Range.closed(1, 3), 5);
		rangeMap.put(Range.closed(4, 12), 20);
		
		precipChance.put(STEPPE, SOUTHERN, rangeMap);

		rangeMap = TreeRangeMap.<Integer, Integer>create();
		rangeMap.put(Range.closed(3, 5), 50);
		rangeMap.put(Range.closed(6, 12), 40);
		rangeMap.put(Range.closed(1, 2), 30);
		
		precipChance.put(EQUATORIAL, NORTHERN, rangeMap);
		precipChance.put(EQUATORIAL, SOUTHERN, rangeMap);

		rangeMap = TreeRangeMap.<Integer, Integer>create();
		rangeMap.put(Range.closed(6, 10), 90);
		rangeMap.put(Range.closed(11, 12), 15);
		rangeMap.put(Range.closed(1, 5), 15);
		
		precipChance.put(MONSOON, NORTHERN, rangeMap);
		precipChance.put(MONSOON, SOUTHERN, rangeMap);

		rangeMap = TreeRangeMap.create();
		rangeMap.put(Range.closed(1, 12), 40);
		
		precipChance.put(WARM_AND_RAINY, NORTHERN, rangeMap);
		precipChance.put(WARM_AND_RAINY, SOUTHERN, rangeMap);

		rangeMap = TreeRangeMap.<Integer, Integer>create();
		rangeMap.put(Range.closed(6, 8), 10);
		rangeMap.put(Range.closed(1, 5), 30);
		rangeMap.put(Range.closed(9, 12), 30);
		
		precipChance.put(WARM_WITH_DRY_SUMMER, NORTHERN, rangeMap);

		rangeMap = TreeRangeMap.<Integer, Integer>create();
		rangeMap.put(Range.singleton(12), 10);
		rangeMap.put(Range.closed(1, 2), 10);
		rangeMap.put(Range.closed(3, 11), 30);
		
		precipChance.put(WARM_WITH_DRY_SUMMER, SOUTHERN, rangeMap);

		rangeMap = TreeRangeMap.<Integer, Integer>create();
		rangeMap.put(Range.closed(7, 8), 45);
		rangeMap.put(Range.closed(1, 6), 15);
		rangeMap.put(Range.closed(9, 12), 15);
		
		precipChance.put(WARM_WITH_DRY_WINTER, NORTHERN, rangeMap);

		rangeMap = TreeRangeMap.<Integer, Integer>create();
		rangeMap.put(Range.closed(1, 2), 45);
		rangeMap.put(Range.closed(3, 12), 15);
		
		precipChance.put(WARM_WITH_DRY_WINTER, SOUTHERN, rangeMap);
		
		rangeMap = TreeRangeMap.create();
		rangeMap.put(Range.closed(1, 12), 35);
		
		precipChance.put(COOL_AND_RAINY, NORTHERN, rangeMap);
		precipChance.put(COOL_AND_RAINY, SOUTHERN, rangeMap);

		rangeMap = TreeRangeMap.<Integer, Integer>create();
		rangeMap.put(Range.closed(7, 9), 35);
		rangeMap.put(Range.closed(11, 12), 10);
		rangeMap.put(Range.closed(1, 4), 10);
		rangeMap.put(Range.closed(5, 6), 20);
		rangeMap.put(Range.singleton(10), 20);
		
		precipChance.put(COOL_WITH_DRY_WINTER, NORTHERN, rangeMap);

		rangeMap = TreeRangeMap.<Integer, Integer>create();
		rangeMap.put(Range.closed(1, 3), 35);
		rangeMap.put(Range.closed(5, 10), 10);
		rangeMap.put(Range.closed(11, 12), 20);
		rangeMap.put(Range.singleton(4), 20);
		
		precipChance.put(COOL_WITH_DRY_WINTER, SOUTHERN, rangeMap);

		rangeMap = TreeRangeMap.create();
		rangeMap.put(Range.closed(1, 12), 10);
		
		precipChance.put(TUNDRA, NORTHERN, rangeMap);
		precipChance.put(TUNDRA, SOUTHERN, rangeMap);
		precipChance.put(POLAR, NORTHERN, rangeMap);
		precipChance.put(POLAR, SOUTHERN, rangeMap);

		PRECIP_CHANCE = ImmutableTable.copyOf(precipChance);
		
		Map<Integer, RandomNumberGenerator> windType = Maps.newLinkedHashMap();
		windType.put(1, Die.D4);
		windType.put(2, Die.D6);
		windType.put(3, newDice().with(2, Die.D4).build());
		windType.put(4, newDice().with(2, Die.D6).build());
		windType.put(5, newDice().with(2, Die.D8).build());
		windType.put(6, newDice().with(2, Die.D10).build());
		
		WIND_TYPE = ImmutableMap.copyOf(windType);
	}
	
	public static AdvancedWeather generateWeather(ClimateCategory climate, Hemisphere hemisphere, Month month) {
		checkNotNull(climate);
		checkNotNull(hemisphere);
		checkNotNull(month);
		int precipChance = PRECIP_CHANCE.get(climate, hemisphere).get(month.getOrdinal());
		boolean precip = Die.D100.roll() <= precipChance;
		Temperature temperature = climate.getTemperature(hemisphere, month);
		String precipitation, cloudType;
		RandomNumberGenerator windSpeedGenerator = Die.D8;
		int precipRoll = 0;
		if (precip) {
			precipRoll = Die.D6.roll();
			windSpeedGenerator = WIND_TYPE.get(precipRoll);
		}
		int windSpeedRoll = ((windSpeedGenerator.roll() - 1) * 10) + Die.D10.roll();
		String windType = WIND_SPEED_TYPE.getValue(windSpeedRoll);
		String windSpeed = WIND_SPEED_MPH.getValue(windSpeedRoll);
		String windDescription = WIND_SPEED_DESCRIPTION.getValue(windSpeedRoll);
		String windDirection = WIND_DIRECTION.getValue();
		
		int effectiveTempValue = temperature.getValue();
		if (temperature.getValue() <= 32 && windSpeedRoll > 110) {
			effectiveTempValue -= _2D20.roll();
		}
		Temperature effectiveTemperature = newTemperature(effectiveTempValue, "");
		
		Temperature nightimeTemperature;
		if (climate == DESERT) {
			nightimeTemperature = newTemperature(effectiveTempValue - _6D10.roll(), "");
		} else {
			nightimeTemperature = effectiveTemperature.toNightimeTemperature();
		}
		if (precip) {
			RandomizableStringSource precipSource = effectiveTempValue <= 32 ? SNOW : RAIN;
			precipitation = precipSource.getValue(precipRoll).trim();
			cloudType = CLOUD_TYPE.getValue(precipRoll).trim();
		} else {
			precipitation = "None";
			cloudType = Die.D100.roll() <= 60 ? "Clear skies" : CLOUD_TYPE.getValue(Die.D4.roll()).trim();
		}
		
		AdvancedWeather weather = new AdvancedWeather.Builder()
		    .withCloudType(cloudType)
		    .withEffectiveTemperature(effectiveTemperature.toString())
		    .withNightTimeTemperature(nightimeTemperature.toString())
		    .withPrecipitation(precipitation)
		    .withTemperature(temperature.toString())
		    .withWindDescription(windDescription)
		    .withWindDirection(windDirection)
		    .withWindSpeed(windSpeed)
		    .withWindType(windType)
		    .build();
		
		return weather;
		
	}

	private AdvancedWeather (Builder builder) {
		this.temperature = builder.temperature;
		this.effectiveTemperature = builder.effectiveTemperature;
		this.nightTimeTemperature = builder.nightTimeTemperature;
		this.precipitation = builder.precipitation;
		this.cloudType = builder.cloudType;
		this.windType = builder.windType;
		this.windSpeed = builder.windSpeed;
		this.windDescription = builder.windDescription;
		this.windDirection = builder.windDirection;
	}
	
	public String getTemperature() {
		return temperature;
	}

	public String getEffectiveTemperature() {
		return effectiveTemperature;
	}

	public String getNightTimeTemperature() {
		return nightTimeTemperature;
	}

	public String getPrecipitation() {
		return precipitation;
	}

	public String getCloudType() {
		return cloudType;
	}

	public String getWindType() {
		return windType;
	}

	public String getWindSpeed() {
		return windSpeed;
	}

	public String getWindDescription() {
		return windDescription;
	}

	public String getWindDirection() {
		return windDirection;
	}
	
	@Override
	public String toString() {
		return "Weather [temperature=" + temperature
				+ ", effectiveTemperature=" + effectiveTemperature
				+ ", nightTimeTemperature=" + nightTimeTemperature
				+ ", precipitation=" + precipitation + ", cloudType="
				+ cloudType + ", windType=" + windType + ", windSpeed="
				+ windSpeed + ", windDescription=" + windDescription
				+ ", windDirection=" + windDirection + "]";
	}

	private static class Builder {
		private String temperature;
		private String effectiveTemperature;
		private String nightTimeTemperature;
		private String precipitation;
		private String cloudType;
		private String windType;
		private String windSpeed;
		private String windDescription;
		private String windDirection;
		
		private Builder () {}

		public Builder withTemperature(String temperature) {
			checkNotNull(temperature);
			this.temperature = temperature;
			return this;
		}
		
		public Builder withEffectiveTemperature(String temperature) {
			checkNotNull(temperature);
			this.effectiveTemperature = temperature;
			return this;
		}

		public Builder withNightTimeTemperature(String temperature) {
			checkNotNull(temperature);
			this.nightTimeTemperature = temperature;
			return this;
		}

		public Builder withPrecipitation(String precipitation) {
			checkNotNull(precipitation);
			this.precipitation = precipitation;
			return this;
		}

		public Builder withCloudType(String cloudType) {
			checkNotNull(cloudType);
			this.cloudType = cloudType;
			return this;
		}

		public Builder withWindType(String windType) {
			checkNotNull(windType);
			this.windType = windType;
			return this;
		}

		public Builder withWindSpeed(String windSpeed) {
			checkNotNull(windSpeed);
			this.windSpeed = windSpeed;
			return this;
		}

		public Builder withWindDescription(String windDescription) {
			checkNotNull(windDescription);
			this.windDescription = windDescription;
			return this;
		}
		
		public Builder withWindDirection(String windDirection) {
			checkNotNull(windDirection);
			this.windDirection = windDirection;
			return this;
		}

		public AdvancedWeather build () {
			checkNotNull(temperature);
			checkNotNull(effectiveTemperature);
			checkNotNull(nightTimeTemperature);
			checkNotNull(precipitation);
			checkNotNull(cloudType);
			checkNotNull(windType);
			checkNotNull(windSpeed);
			checkNotNull(windDescription);
			checkNotNull(windDirection);
       	    return new AdvancedWeather(this);
        }
	}
	
	public static void main(String[] args) {
		for (int i = 0; i < 1000; i++) {
			AdvancedWeather weather = AdvancedWeather.generateWeather(COOL_AND_RAINY, NORTHERN, Month.OCTOBER);
		    System.out.println(i + " " +weather);
		}
	}
}
