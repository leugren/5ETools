package org.devoware.encounterplanner.model;

import static com.google.common.base.Preconditions.checkArgument;

import java.util.List;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

public class Encounter {
	private final List<Monster> monsters;
	
	public static Builder builder () {
		return new Builder();
	}
	
	private Encounter (Builder builder) {
		this.monsters = ImmutableList.copyOf(builder.monsters);
	}
	
	public int size () {
		return this.monsters.size();
	}
	
	public List<Monster> getMonsters () {
		return this.monsters;
	}
	
	@Override
	public String toString() {
		return "Encounter [monsters=" + monsters + "]";
	}



	public static class Builder {
		private List<Monster> monsters = Lists.newArrayList();
		
		private Builder () {}
		
		public Builder withMonster(double challengeRating) {
			this.monsters.add(Monster.create(challengeRating));
			return this;
		}

		public Builder withMonsters(int numMonsters, double challengeRating) {
			checkArgument(numMonsters >= 1);
			for (int i = 0; i < numMonsters; i++) {
			    this.monsters.add(Monster.create(challengeRating));
			}
			return this;
		}
		
		public Encounter build () {
			return new Encounter(this);
		}
	
	}

}
