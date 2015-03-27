package org.devoware.table.model;

import java.util.Random;

import org.devoware.table.dice.RandomNumberGenerator;

public class RandomInt implements IntegerSource, RandomNumberGenerator {

	private Random random = new Random();
	private final int lowValue;
	private final int highValue;

	public static RandomInt newRandomInt(int lowValue, int highValue) {
		return new RandomInt(lowValue, highValue);
	}
	
	private RandomInt (int lowValue, int highValue) {
		this.lowValue = lowValue;
		this.highValue = highValue;
	}

	@Override
	public int getValue() {
		if (highValue == lowValue) {
			return highValue;
		}
		return  random.nextInt(highValue - lowValue + 1) + lowValue;
	}

	@Override
	public int getUpperEndpoint() {
		return highValue;
	}

	@Override
	public int getLowerEndpoint() {
		return lowValue;
	}

	@Override
	public boolean contains(int value) {
		return value >= lowValue && value <= highValue;
	}

	@Override
	public int roll() {
		return getValue();
	}

}
