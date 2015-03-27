package org.devoware.table.weather;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import org.devoware.table.dice.Dice;
import org.devoware.table.dice.Die;


public class Temperature {
	private static final Dice nightTimeDice = Dice.newDice().with(5, Die.D6).build();

	private int value;
	private String descriptor;
	
	public static Temperature newTemperature(String description) {
		checkNotNull(description);
		int idx = description.indexOf('°');
		checkArgument(idx != -1);
		int value = Integer.parseInt(description.substring(0, idx).trim());
		idx = description.indexOf('(');
		checkArgument(idx != -1);
		String descriptor = description.substring(idx).trim();
		return new Temperature(value, descriptor);
	}

	public static Temperature newTemperature(int value, String descriptor) {
		return new Temperature(value, descriptor);
	}
	
	private Temperature(int value, String descriptor) {
		this.value = value;
		this.descriptor = descriptor;
	}

	public int getValue() {
		return value;
	}

	public String getDescriptor() {
		return descriptor;
	}

	public Temperature toNightimeTemperature() {
		return new Temperature(this.value - nightTimeDice.roll(), "");
	}

    public String toString () {
    	return String.format("%d° F  (%,.2f° C) %s", value, ((double) value - 32) * 5 / 9, descriptor); 
    }

}
