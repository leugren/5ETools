package org.devoware.table.model;

import static com.google.common.base.Preconditions.checkNotNull;
import static org.devoware.table.dice.Die.newDie;
import static org.devoware.table.model.StringValue.newValue;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.devoware.table.dice.Die;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Sets;

public class ValueSet implements StringSource, Iterable<StringSource> {
	private final List<StringSource> valueSources;
	private final Die die;
	
	
	public static Builder newValueSet () {
		return new Builder();
	}
	
	private ValueSet (Builder builder) {
		this.valueSources = ImmutableList.copyOf(builder.valueSources);
		this.die = newDie(valueSources.size());
	}

	@Override
	public String getValue() {
		return getValue(Separators.DEFAULT_SEPARATOR);
	}

	@Override
	public String getValue(String separator) {
		int roll = this.die.roll();
		return this.valueSources.get(roll - 1).getValue(separator);
	}
	
	public Iterator<StringSource> iterator () {
		return this.valueSources.iterator();
	}
	
	public boolean contains (StringSource valueSource) {
		return this.valueSources.contains(valueSource);
	}
	
	public static class Builder {
		private Set<StringSource> valueSources = Sets.newLinkedHashSet();
		
		private Builder () {}
		
		public Builder with (String value) {
			checkNotNull(value);
			this.valueSources.add(newValue(value));
			return this;
		}

		public Builder with (ValueSet valueSet) {
			checkNotNull(valueSet);
			this.valueSources.addAll(valueSet.valueSources);
			return this;
		}
		
		
		public Builder with (StringSource valueSource) {
			checkNotNull(valueSource);
			this.valueSources.add(valueSource);
			return this;
		}
		
		public ValueSet build () {
			return new ValueSet(this);
		}
		
	}
 
}
