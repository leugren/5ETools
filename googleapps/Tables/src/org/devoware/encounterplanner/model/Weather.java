package org.devoware.encounterplanner.model;

import static com.google.common.base.Preconditions.checkNotNull;

public class Weather {
	private final String temperature;
	private final String wind;
	private final String precipitation;
	
	public static Builder newWeather() {
		return new Builder();
	}
	
	private Weather (Builder builder) {
		this.temperature = builder.temperature;
		this.wind = builder.wind;
		this.precipitation = builder.precipitation;
	}
	
	public String getTemperature() {
		return temperature;
	}

	public String getWind() {
		return wind;
	}

	public String getPrecipitation() {
		return precipitation;
	}




	public static class Builder {
		private String temperature;
		private String wind;
		private String precipitation;
		
		private Builder () {}

		public Builder withTemperature(String temperature) {
			checkNotNull(temperature);
			this.temperature = temperature;
			return this;
		}

		public Builder withWind(String wind) {
			checkNotNull(wind);
			this.wind = wind;
			return this;
		}

		public Builder withPrecipitation(String precipitation) {
			checkNotNull(precipitation);
			this.precipitation = precipitation;
			return this;
		}
		
	    public Weather build () {
			checkNotNull(temperature);
			checkNotNull(wind);
			checkNotNull(precipitation);

			return new Weather(this);
	    }
	}
}
