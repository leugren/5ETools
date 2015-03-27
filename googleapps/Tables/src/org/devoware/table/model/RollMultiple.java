package org.devoware.table.model;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import static org.devoware.table.model.CompositeStringValue.newCompositeStringValue;
import static org.devoware.table.model.Separators.DEFAULT_SEPARATOR;

import java.util.Set;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;

public class RollMultiple implements RandomizableStringSource {
	
	private final RandomizableStringSource table;
	private final IntegerSource intSource;
	private final Set<Integer> ignoreRolls;
	
	public static RollMultiple rollMultiple (RandomizableStringSource table, int numRolls, int ... ignoreRolls) {
		return rollMultiple(table, IntegerValue.newValue(numRolls), ignoreRolls);
	}
	
	
	public static RollMultiple rollMultiple (RandomizableStringSource table, IntegerSource intSource, int ... ignoreRolls) {
		return new RollMultiple(table, intSource, ignoreRolls);
	}
	
	private RollMultiple (RandomizableStringSource table, IntegerSource intSource, int ... ignoreRolls) {
		checkNotNull(table);
		checkNotNull(intSource);
		if (intSource instanceof IntegerValue) {
		    checkArgument(intSource.getValue() > 1, "The number of rolls must be greater than one.");
		}
		this.table = table;
		this.intSource = intSource;
		Set<Integer> ignoreRollsSet = Sets.newLinkedHashSet();
		for (int i = 0; i < ignoreRolls.length; i++) {
			checkArgument(ignoreRolls[i] > 0, "Rolls to be ignored must be between 1 and %d.", table.getIntegerSource().getUpperEndpoint());
			ignoreRollsSet.add(ignoreRolls[i]);
		}
		this.ignoreRolls = ImmutableSet.copyOf(ignoreRollsSet);
	}
	
	@Override
	public IntegerSource getIntegerSource() {
		return this.intSource;
	}
	
	@Override
	public String getValue() {
        return getValue(DEFAULT_SEPARATOR);   
	}
	
	@Override
	public String getValue(int idx) {
		return getValue(idx, DEFAULT_SEPARATOR);
	}
	
	@Override
	public String getValue(int idx, String separator) {
		return generateValue(separator, idx);
	}

	@Override
	public String getValue(String separator) {
		return generateValue(separator, this.intSource.getValue());
	}
	
	@Override
	public ValueSet toValueSet() {
		return table.toValueSet();
	}

	private String generateValue(String separator, int numRolls) {
		CompositeStringValue.Builder builder = newCompositeStringValue();
		for (int i = 1; i <= numRolls; i++) {
			int roll = -1;
			int tries = 0;
			do {
				roll = table.getIntegerSource().getValue();
			} while (this.ignoreRolls.contains(roll) && tries++ < 10000);
			if (this.ignoreRolls.contains(roll)) {
				throw new RuntimeException("Could not produce a roll with a value that is not a part of the ignore list.");
			}
			builder.with(table.getValue(roll));
		}
		return builder.build().getValue(separator);
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((ignoreRolls == null) ? 0 : ignoreRolls.hashCode());
		result = prime * result
				+ ((intSource == null) ? 0 : intSource.hashCode());
		result = prime * result + ((table == null) ? 0 : table.hashCode());
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
		RollMultiple other = (RollMultiple) obj;
		if (ignoreRolls == null) {
			if (other.ignoreRolls != null)
				return false;
		} else if (!ignoreRolls.equals(other.ignoreRolls))
			return false;
		if (intSource == null) {
			if (other.intSource != null)
				return false;
		} else if (!intSource.equals(other.intSource))
			return false;
		if (table == null) {
			if (other.table != null)
				return false;
		} else if (!table.equals(other.table))
			return false;
		return true;
	}
	
}
