package org.devoware.encounterplanner.model;

import static com.google.common.base.Preconditions.checkNotNull;

public class Villain {
	private final String scheme;
	private final String method;
	private final String weakness;
	
	public static Builder newVillain () {
		return new Builder ();
	}
	
	private Villain (Builder builder) {
		this.scheme = builder.scheme;
		this.method = builder.method;
		this.weakness = builder.weakness;
	}
	
	public String getScheme() {
		return scheme;
	}

	public String getMethod() {
		return method;
	}

	public String getWeakness() {
		return weakness;
	}

	public static class Builder {
		private String scheme;
		private String method;
		private String weakness = "--";

		private Builder () {}

		public Builder withScheme(String scheme) {
			checkNotNull(scheme);
			this.scheme = scheme;
			return this;
		}

		public Builder withMethod(String method) {
			checkNotNull(method);
			this.method = method;
			return this;
		}

		public Builder withWeakness(String weakness) {
			checkNotNull(weakness);
			this.weakness = weakness;
			return this;
		}
		
        public Villain build () {
			checkNotNull(scheme);
			checkNotNull(method);
			checkNotNull(weakness);
        	
			return new Villain(this);
        }
	}

}
