package org.devoware.table.model;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import static org.devoware.table.model.IntegerValue.newValue;
import static org.devoware.table.model.RollMultiple.rollMultiple;

class RollMultipleProxy implements StringSource {
	
	private final IntegerSource intSource;
	private final int [] ignoreRolls;
	
	static RollMultipleProxy rollMultipleProxy (int numRolls, IntegerSource die, int ... ignoreRolls) {
		return new RollMultipleProxy(newValue(numRolls), die, ignoreRolls);
	}
	
	static RollMultipleProxy rollMultipleProxy (IntegerSource intSource, IntegerSource die, int ... ignoreRolls) {
		return new RollMultipleProxy(intSource, die, ignoreRolls);
	}

	private RollMultipleProxy (IntegerSource intSource, IntegerSource die, int ... ignoreRolls) {
		checkNotNull(intSource);
		if (intSource instanceof IntegerValue) {
		    checkArgument(intSource.getValue() > 1, "The number of rolls must be greater than one.");
		}
		checkNotNull(die);
		this.intSource = intSource;
		this.ignoreRolls = new int[ignoreRolls.length];
        for (int i = 0; i < ignoreRolls.length; i++) {
    		checkArgument(ignoreRolls[i] > 0, "Rolls to be ignored must be between 1 and %d.", die.getUpperEndpoint());
        	this.ignoreRolls[i] = ignoreRolls[i];
        }
	}
	
	public RollMultiple toRollMultiple (ValueRangeMap table) {
		return rollMultiple(table, intSource, ignoreRolls);
	}
	
	@Override
	public String getValue() {
		throw new UnsupportedOperationException();
	}

	@Override
	public String getValue(String separator) {
		throw new UnsupportedOperationException();
	}

}
