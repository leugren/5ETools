package org.devoware.encounterplanner.model;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import java.util.List;

import com.google.common.base.Splitter;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

public class Npc {
    private final String appearance;
    private final String highAbility;
    private final String lowAbility;
    private final String talent;
    private final String mannerism;
    private final String interactionTrait;
    private final String ideal;
    private final List<String> bonds;
    private final String flawOrSecret;
    
    public static Builder newNpc () {
    	return new Builder();
    }
    
    private Npc (Builder builder) {
    	this.appearance = builder.appearance;
    	this.highAbility = builder.highAbility;
    	this.lowAbility = builder.lowAbility;
    	this.talent = builder.talent;
    	this.mannerism = builder.mannerism;
    	this.interactionTrait = builder.interactionTrait;
    	this.ideal = builder.ideal;
    	this.bonds = ImmutableList.copyOf(builder.bonds);
    	this.flawOrSecret = builder.flawOrSecret;
    }
    
    public String getAppearance() {
		return appearance;
	}

	public String getHighAbility() {
		return highAbility;
	}

	public String getLowAbility() {
		return lowAbility;
	}

	public String getTalent() {
		return talent;
	}

	public String getMannerism() {
		return mannerism;
	}

	public String getInteractionTrait() {
		return interactionTrait;
	}

	public String getIdeal() {
		return ideal;
	}

	public List<String> getBonds() {
		return bonds;
	}

	public String getFlawOrSecret() {
		return flawOrSecret;
	}

	public static class Builder {
        private String appearance;
        private String highAbility;
        private String lowAbility;
        private String talent;
        private String mannerism;
        private String interactionTrait;
        private String ideal;
        private List<String> bonds = Lists.newArrayList();
        private String flawOrSecret;
        
        private Builder () {}

		public Builder withAppearance(String appearance) {
			checkNotNull(appearance);
			this.appearance = appearance;
			return this;
		}

		public Builder withHighAbility(String highAbility) {
			checkNotNull(highAbility);
			this.highAbility = highAbility;
			return this;
		}

		public Builder withLowAbility(String lowAbility) {
			checkNotNull(lowAbility);
			this.lowAbility = lowAbility;
			return this;
		}

		public Builder withTalent(String talent) {
			checkNotNull(talent);
			this.talent = talent;
			return this;
		}

		public Builder withMannerism(String mannerism) {
			checkNotNull(mannerism);
			this.mannerism = mannerism;
			return this;
		}

		public Builder withInteractionTrait(String interactionTrait) {
			checkNotNull(interactionTrait);
			this.interactionTrait = interactionTrait;
			return this;
		}

		public Builder withIdeal(String ideal) {
			checkNotNull(ideal);
			this.ideal = ideal;
			return this;
		}

		public Builder withBonds(String bonds) {
			checkNotNull(bonds);
			Splitter.on('|').trimResults().omitEmptyStrings().split(bonds);
			this.bonds = Lists.newArrayList(Splitter.on('|').trimResults().omitEmptyStrings().split(bonds));
			return this;
		}

		public Builder withFlawOrSecret(String flawOrSecret) {
			checkNotNull(flawOrSecret);
			this.flawOrSecret = flawOrSecret;
			return this;
		}
        
        public Npc build () {
			checkNotNull(appearance);
			checkNotNull(highAbility);
			checkNotNull(lowAbility);
			checkNotNull(talent);
			checkNotNull(mannerism);
			checkNotNull(interactionTrait);
			checkNotNull(ideal);
			checkArgument(bonds.size() > 0);
			checkNotNull(flawOrSecret);
			
			return new Npc(this);

        }
     	
    }
}
