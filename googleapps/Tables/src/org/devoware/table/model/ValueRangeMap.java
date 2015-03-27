package org.devoware.table.model;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Preconditions.checkState;
import static org.devoware.table.model.RollMultipleProxy.rollMultipleProxy;
import static org.devoware.table.model.StringValue.newValue;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

import org.devoware.table.dice.Die;
import org.devoware.table.dice.RandomNumberGenerator;

import com.google.common.collect.ImmutableRangeMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Range;
import com.google.common.collect.RangeMap;
import com.google.common.collect.TreeRangeMap;

public final class ValueRangeMap implements RandomizableStringSource, Iterable<StringSource> {

	private final IntegerSource die;
	private final RangeMap<Integer, StringSource> entries;
	
	public static Builder newValueRangeMap(Die die) {
		return new Builder(die);
	}
	
	private ValueRangeMap (Builder builder) {
		this.die = builder.die;
		RangeMap<Integer, StringSource> entries = TreeRangeMap.create();
		for (Entry<Range<Integer>, StringSource> entry : builder.entries.asMapOfRanges().entrySet()) {
			StringSource valueSource = entry.getValue();
			if (valueSource instanceof RollMultipleProxy) {
				valueSource = RollMultipleProxy.class.cast(valueSource).toRollMultiple(this);
			} 
			entries.put(entry.getKey(), valueSource);
		}
		this.entries = ImmutableRangeMap.copyOf(entries);
	}
	
	@Override
	public IntegerSource getIntegerSource () {
		return this.die;
	}
	
	public StringSource getValueSource (int idx) {
		checkArgument(idx > 0 && idx <= this.die.getUpperEndpoint(), "The index must be between 1 and %s", String.valueOf(this.die.getUpperEndpoint())); 
		return this.entries.get(idx);
	}
	
	public StringSource getValueSource () {
		return this.entries.get(this.die.getValue());
	}
	
	public String getValue(int idx) {
		return getValueSource(idx).getValue();
	}
	
	public String getValue(int idx, String separator) {
		return getValueSource(idx).getValue(separator);
	}

	@Override
    public String getValue() {
    	return getValueSource().getValue();
    }
    
	@Override
    public String getValue(String separator) {
    	return getValueSource().getValue(separator);
    }
	
	public Iterator<StringSource> iterator () {
		return this.entries.asMapOfRanges().values().iterator();
	}

	public boolean contains (StringSource valueSource) {
		return this.entries.asMapOfRanges().values().contains(valueSource);
	}
	
	public ValueSet toValueSet () {
		ValueSet.Builder builder = ValueSet.newValueSet();
		for (StringSource stringSource : this.entries.asMapOfRanges().values()) {
			builder.with(stringSource);
		}
		return builder.build();
	}

	public static class Builder {
		private final RangeMap<Integer, StringSource> entries = TreeRangeMap.create();
		private final IntegerSource die;
		
		private Builder(IntegerSource die) {
			checkNotNull(die);
			this.die = die;
		}
		
		public Builder with(int index, String value) {
			checkArgument(index > 0 && index <= die.getUpperEndpoint(), "The index must be between 1 and %s", String.valueOf(die.getUpperEndpoint())); 
			return with(index, index, newValue(value));
		}

		public Builder with(int fromIndex, int toIndex, String value) {
			return with(fromIndex, toIndex, newValue(value));
		}

		public Builder with(int index, StringSource value) {
			checkArgument(index > 0 && index <= die.getUpperEndpoint(), "The index must be between 1 and %s", String.valueOf(die.getUpperEndpoint())); 
			return with(index, index, value);
		}
		
		public Builder with(int fromIndex, int toIndex, StringSource value) {
			checkNotNull(value);
			checkArgument(fromIndex > 0 && fromIndex <= die.getUpperEndpoint(), "The fromIndex must be between 1 and %s", String.valueOf(die.getUpperEndpoint())); 
			checkArgument(toIndex > 0 && toIndex <= die.getUpperEndpoint(), "The toIndex must be between 1 and %s", String.valueOf(die.getUpperEndpoint()));
			checkArgument(toIndex >= fromIndex, "The toIndex must be greater than or equal to the fromIndex");
			this.entries.put(Range.closed(fromIndex, toIndex), value);
			return this;
		}
		
		public Builder withRollMultiple (int index, int numRolls) {
			return withRollMultipleAndIgnore(index, numRolls, index);
		}
		
		public Builder withRollMultipleAndIgnore (int index, int numRolls, int ignoreRoll, int ... ignoreRolls) {
			checkArgument(index > 0 && index <= die.getUpperEndpoint(), "The index must be between 1 and %s", String.valueOf(die.getUpperEndpoint()));
			int [] ignoreRolls2 = new int[ignoreRolls.length + 1];
			ignoreRolls2[0] = ignoreRoll;
			for (int i = 0; i < ignoreRolls.length; i++) {
				ignoreRolls2[i + 1] = ignoreRolls[i];
			}
			return with(index, rollMultipleProxy(numRolls, this.die, ignoreRolls2));
		}
		
		public Builder withRollMultiple (int fromIndex, int toIndex, int numRolls) {
			checkArgument(toIndex >= fromIndex, "The toIndex must be greater than or equal to the fromIndex");
			int [] ignoreRolls = new int[toIndex - fromIndex];
			for (int i = 0, j = fromIndex + 1; j <= toIndex; i++, j++) {
				ignoreRolls[i] = j;
			}
			return withRollMultipleAndIgnore2(fromIndex, toIndex, numRolls, fromIndex, ignoreRolls);
		}

		public Builder withRollMultipleAndIgnore2 (int fromIndex, int toIndex, int numRolls, int ignoreRoll, int ... ignoreRolls) {
			int [] ignoreRolls2 = new int[ignoreRolls.length + 1];
			ignoreRolls2[0] = ignoreRoll;
			for (int i = 0; i < ignoreRolls.length; i++) {
				ignoreRolls2[i + 1] = ignoreRolls[i];
			}
			return with(fromIndex, toIndex, rollMultipleProxy(numRolls, this.die, ignoreRolls2));
		}

		public Builder withRollRandomMultiple (int index, RandomNumberGenerator rnd) {
			return withRollRandomMultipleAndIgnore(index, rnd, index);
		}
		
		public Builder withRollRandomMultipleAndIgnore (int ignoreIndex, RandomNumberGenerator rnd, int ignoreRoll, int ... ignoreRolls) {
			checkArgument(ignoreIndex > 0 && ignoreIndex <= die.getUpperEndpoint(), "The index must be between 1 and %s", String.valueOf(die.getUpperEndpoint()));
			int [] ignoreRolls2 = new int[ignoreRolls.length + 1];
			ignoreRolls2[0] = ignoreRoll;
			for (int i = 0; i < ignoreRolls.length; i++) {
				ignoreRolls2[i + 1] = ignoreRolls[i];
			}
			return with(ignoreIndex, rollMultipleProxy(rnd, this.die, ignoreRolls2));
		}
		
		public Builder withRollRandomMultiple (int fromIndex, int toIndex, RandomNumberGenerator rnd) {
			checkArgument(toIndex >= fromIndex, "The toIndex must be greater than or equal to the fromIndex");
			int [] ignoreRolls = new int[toIndex - fromIndex];
			for (int i = 0, j = fromIndex + 1; j <= toIndex; i++, j++) {
				ignoreRolls[i] = j;
			}
			return withRollRandomMultipleAndIgnore(fromIndex, toIndex, rnd, fromIndex, ignoreRolls);
		}

		public Builder withRollRandomMultipleAndIgnore (int fromIndex, int toIndex, RandomNumberGenerator rnd, int ignoreRoll, int ... ignoreRolls) {
			int [] ignoreRolls2 = new int[ignoreRolls.length + 1];
			ignoreRolls2[0] = ignoreRoll;
			for (int i = 0; i < ignoreRolls.length; i++) {
				ignoreRolls2[i + 1] = ignoreRolls[i];
			}
			return with(fromIndex, toIndex, rollMultipleProxy(rnd, this.die, ignoreRolls2));
		}

		public ValueRangeMap build () {
			List<Integer> missingEntries = Lists.newArrayList();
			for (int i = 1; i <= die.getUpperEndpoint(); i++) {
				if (entries.get(i) == null) {
					missingEntries.add(i);
				}
			}
			checkState(missingEntries.isEmpty(), "Missing entries for the following roll results: %s", Arrays.toString(missingEntries.toArray()));
			return new ValueRangeMap(this);
		}
	}
}
