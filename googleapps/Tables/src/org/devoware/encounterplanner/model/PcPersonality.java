package org.devoware.encounterplanner.model;

import static com.google.common.base.Preconditions.checkNotNull;

public class PcPersonality {
	private final String background;
	private final String personalityTrait1;
	private final String personalityTrait2;
	private final String ideal;
	private final String bond;
	private final String flaw;
	private final AdditionalInfo additionalInfo;
	
	public static Builder newPcPersonality () {
		return new Builder();
	}
	
	private PcPersonality (Builder builder) {
		this.background = builder.background;
		this.personalityTrait1 = builder.personalityTrait1;
		this.personalityTrait2 = builder.personalityTrait2;
		this.ideal = builder.ideal;
		this.bond = builder.bond;
		this.flaw = builder.flaw;
		this.additionalInfo = builder.additionalInfo;
	}

	public String getBackground() {
		return background;
	}

	public String getPersonalityTrait1() {
		return personalityTrait1;
	}

	public String getPersonalityTrait2() {
		return personalityTrait2;
	}

	public String getIdeal() {
		return ideal;
	}

	public String getBond() {
		return bond;
	}

	public String getFlaw() {
		return flaw;
	}

	public AdditionalInfo getAdditionalInfo() {
		return additionalInfo;
	}

	@Override
	public String toString() {
		return "PcPersonality [background=" + background
				+ ", personalityTrait1=" + personalityTrait1
				+ ", personalityTrait2=" + personalityTrait2 + ", ideal="
				+ ideal + ", bond=" + bond + ", flaw=" + flaw
				+ ", additionalInfo=" + additionalInfo + "]";
	}



	public static class Builder {
		private String background;
		private String personalityTrait1;
		private String personalityTrait2;
		private String ideal;
		private String bond;
		private String flaw;
		private AdditionalInfo additionalInfo;
		
		private Builder () {}
		
		public Builder withBackground(String background) {
			checkNotNull(background);
			this.background = background;
			return this;
		}
		
		public Builder withPersonalityTrait1(String personalityTrait1) {
			checkNotNull(personalityTrait1);
			this.personalityTrait1 = personalityTrait1;
			return this;
		}
		
		public Builder withPersonalityTrait2(String personalityTrait2) {
			checkNotNull(personalityTrait2);
			this.personalityTrait2 = personalityTrait2;
			return this;
		}
		
		public Builder withIdeal(String ideal) {
			checkNotNull(ideal);
			this.ideal = ideal;
			return this;
		}
		
		public Builder withBond(String bond) {
			checkNotNull(bond);
			this.bond = bond;
			return this;
		}
		
		public Builder withFlaw(String flaw) {
			checkNotNull(flaw);
			this.flaw = flaw;
			return this;
		}
		
		public Builder withAdditionalInfo(String label, String value) {
			checkNotNull(label);
			checkNotNull(value);
			this.additionalInfo = new AdditionalInfo(label, value);
			return this;
		}

		public PcPersonality build () {
			checkNotNull(background);
			checkNotNull(personalityTrait1);
			checkNotNull(personalityTrait2);
			checkNotNull(ideal);
			checkNotNull(bond);
			checkNotNull(flaw);
			return new PcPersonality(this);
		}
 	}
	
	
	public static class AdditionalInfo {
		private String label;
		private String value;
		
		
		private AdditionalInfo (String label, String value) {
			this.label = label;
			this.value = value;
		}

		public String getLabel() {
			return label;
		}

		public String getValue() {
			return value;
		}

		@Override
		public String toString() {
			return "AdditionalInfo [label=" + label + ", value=" + value + "]";
		}
		
	}

	
}
