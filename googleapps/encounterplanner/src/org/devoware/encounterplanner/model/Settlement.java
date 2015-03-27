package org.devoware.encounterplanner.model;

import static com.google.common.base.Preconditions.checkNotNull;

public class Settlement {
    private final String raceRelations;
    private final String rulersStatus;
    private final String notableTraits;
    private final String knownForIts;
    private final String currentCalamity;
    
    public static Builder newSettlement () {
    	return new Builder();
    }
    
    private Settlement (Builder builder) {
    	this.raceRelations = builder.raceRelations;
    	this.rulersStatus = builder.rulersStatus;
    	this.notableTraits = builder.notableTraits;
    	this.knownForIts = builder.knownForIts;
    	this.currentCalamity = builder.currentCalamity;
    }
    
    public String getRaceRelations() {
		return raceRelations;
	}

	public String getRulersStatus() {
		return rulersStatus;
	}

	public String getNotableTraits() {
		return notableTraits;
	}

	public String getKnownForIts() {
		return knownForIts;
	}

	public String getCurrentCalamity() {
		return currentCalamity;
	}

	public static class Builder {
        private String raceRelations;
        private String rulersStatus;
        private String notableTraits;
        private String knownForIts;
        private String currentCalamity;
        
        private Builder () {}

		public Builder withRaceRelations(String raceRelations) {
			checkNotNull(raceRelations);
			this.raceRelations = raceRelations;
			return this;
		}

		public Builder withRulersStatus(String rulersStatus) {
			checkNotNull(rulersStatus);
			this.rulersStatus = rulersStatus;
			return this;
		}

		public Builder withNotableTraits(String notableTraits) {
			checkNotNull(notableTraits);
			this.notableTraits = notableTraits;
			return this;
		}

		public Builder withKnownForIts(String knownForIts) {
			checkNotNull(knownForIts);
			this.knownForIts = knownForIts;
			return this;
		}

		public Builder withCurrentCalamity(String currentCalamity) {
			checkNotNull(currentCalamity);
			this.currentCalamity = currentCalamity;
			return this;
		}
		
		public Settlement build () {
			checkNotNull(raceRelations);
			checkNotNull(rulersStatus);
			checkNotNull(notableTraits);
			checkNotNull(knownForIts);
			checkNotNull(currentCalamity);
			return new Settlement(this);
		}
        
    }
}
