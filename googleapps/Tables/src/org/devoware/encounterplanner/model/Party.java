package org.devoware.encounterplanner.model;

import static com.google.common.base.Preconditions.checkArgument;

import java.util.List;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

public class Party {
	private final List<PartyMember> partyMembers;
	
	public static Builder builder () {
		return new Builder();
	}
	
	private Party (Builder builder) {
		this.partyMembers = ImmutableList.copyOf(builder.partyMembers);
	}
	
	public int size () {
		return this.partyMembers.size();
	}
	
	public List<PartyMember> getPartyMembers () {
		return this.partyMembers;
	}
	
	@Override
	public String toString() {
		return "Party [partyMembers=" + partyMembers + "]";
	}



	public static class Builder {
		private List<PartyMember> partyMembers = Lists.newArrayList();
		
		private Builder () {}
		
		public Builder withPartyMember(int level) {
			this.partyMembers.add(PartyMember.create(level));
			return this;
		}

		public Builder withPartyMembers(int numMembers, int level) {
			checkArgument(numMembers >= 1);
			for (int i = 0; i < numMembers; i++) {
			    this.partyMembers.add(PartyMember.create(level));
			}
			return this;
		}
		
		public Party build () {
			return new Party(this);
		}
	
	}

}
