package org.devoware.encounterplanner.model;

import static com.google.common.base.Preconditions.checkNotNull;

public class DungeonIdea {

	private final String location;
	private final String creator;
	private final String purpose;
	private final String history;
	
	public static Builder newDungeonIdea () {
		return new Builder();
	}
	
	private DungeonIdea (Builder builder) {
		this.location = builder.location;
		this.creator = builder.creator;
		this.purpose = builder.purpose;
		this.history = builder.history;
	}
	
	public String getLocation() {
		return location;
	}

	public String getCreator() {
		return creator;
	}

	public String getPurpose() {
		return purpose;
	}

	public String getHistory() {
		return history;
	}

	public static class Builder {
		private String location;
		private String creator;
		private String purpose;
		private String history;

		private Builder () {}

		public Builder withLocation(String location) {
			checkNotNull(location);
			this.location = location;
			return this;
		}

		public Builder withCreator(String creator) {
			checkNotNull(creator);
			this.creator = creator;
			return this;
		}

		public Builder withPurpose(String purpose) {
			checkNotNull(purpose);
			this.purpose = purpose;
			return this;
		}

		public Builder withHistory(String history) {
			checkNotNull(history);
			this.history = history;
			return this;
		}
		
        public DungeonIdea build () {
			checkNotNull(location);
			checkNotNull(creator);
			checkNotNull(purpose);
			checkNotNull(history);
			
			return new DungeonIdea(this);
        	
        }
	}
}
