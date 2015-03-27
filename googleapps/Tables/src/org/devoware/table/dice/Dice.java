package org.devoware.table.dice;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import java.util.List;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

public class Dice implements RandomNumberGenerator {
	
	private final List<RandomNumberGenerator> dice;
	private final int modifier;
	private final int multiplier;
	private final int upperEndpoint;
	private final int lowerEndpoint;
	
	public static Builder newDice () {
		return new Builder();
	}
	
	private Dice (Builder builder) {
		this.dice = ImmutableList.copyOf(builder.dice);
		this.modifier = builder.modifier;
		this.multiplier = builder.multiplier;
		int lowerEndpoint = 0, upperEndpoint = 0;
		for (RandomNumberGenerator die : this.dice) {
			lowerEndpoint += die.getLowerEndpoint();
			upperEndpoint += die.getUpperEndpoint();
		}
		this.lowerEndpoint = (lowerEndpoint + this.modifier) * this.multiplier;
		this.upperEndpoint = (upperEndpoint + this.modifier) * this.multiplier;
	}
	
	@Override
	public int getValue() {
		return roll();
	}
	
	@Override
	public int roll () {
		int result = 0;
		for (RandomNumberGenerator rnd : this.dice) {
			result += rnd.roll();
		}
		result += this.modifier;
		result *= this.multiplier;
		return result;
	}
	
	@Override
	public int getUpperEndpoint() {
		return this.upperEndpoint;
	}
	
	@Override
	public int getLowerEndpoint() {
		return this.lowerEndpoint;
	}
	
	@Override
	public boolean contains(int value) {
		int temp = value / this.multiplier;
		return temp >= this.lowerEndpoint && temp <= this.upperEndpoint;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dice == null) ? 0 : dice.hashCode());
		result = prime * result + modifier;
		result = prime * result + multiplier;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dice other = (Dice) obj;
		if (dice == null) {
			if (other.dice != null)
				return false;
		} else if (!dice.equals(other.dice))
			return false;
		if (modifier != other.modifier)
			return false;
		if (multiplier != other.multiplier)
			return false;
		return true;
	}



	public static class Builder {
		private final List<RandomNumberGenerator> dice = Lists.newArrayList();
		private int modifier = 0;
		private int multiplier = 1;
		
		private Builder () {}
		
		public Builder with(RandomNumberGenerator dice) {
			return with(1, dice);
		}

		public Builder with(int numRolls, RandomNumberGenerator dice) {
			checkArgument(numRolls > 0, "The number of times to roll the dice must be greater than zero.");
		    checkNotNull(dice);
		    for (int i = 0; i < numRolls; i++) {
		    	this.dice.add(dice);
		    }
		    return this;
		}
		
		public Builder withMultiplier (int multiplier) {
			this.multiplier = multiplier;
			return this;
		}
		
		public Builder withModifier(int modifier) {
			this.modifier = modifier;
			return this;
		}
		
		public Dice build () {
			return new Dice(this);
		}
		
	}

}
