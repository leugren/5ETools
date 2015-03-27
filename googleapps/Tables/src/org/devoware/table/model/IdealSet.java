package org.devoware.table.model;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import static org.devoware.table.dice.Die.newDie;
import static org.devoware.table.model.Ideal.newIdeal;
import static org.devoware.table.model.IdealType.setOfAllIdealTypes;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.devoware.table.dice.Die;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;


public class IdealSet implements StringSource, Iterable<Ideal> {
	
	private final List<Ideal> ideals;
	private final Set<IdealType> idealTypes;
	private final Die die;
	
	
	public static Builder newIdealSet () {
		return new Builder();
	}
	
	private IdealSet (Builder builder) {
		this.ideals = ImmutableList.copyOf(builder.ideals);
		this.die = newDie(ideals.size());
		Set<IdealType> types = Sets.newHashSet();
		for (Ideal ideal : this.ideals) {
			types.add(ideal.getMetadata(StringSourceMetadata.IDEAL_TYPE));
		}
		this.idealTypes = ImmutableSet.copyOf(types);
	}
	
	public Set<IdealType> getIdealTypes () {
		return this.idealTypes;
	}

	@Override
	public String getValue() {
		return getValue(Separators.DEFAULT_SEPARATOR);
	}

	@Override
	public String getValue(String separator) {
		return getIdeal().getValue(separator);
	}
	
	public Iterator<Ideal> iterator () {
		return this.ideals.iterator();
	}
	
	public boolean contains (Ideal valueSource) {
		return this.ideals.contains(valueSource);
	}
	
	public int size () {
		return this.ideals.size();
	}
	
	public Filter includes (IdealType ... idealTypes) {
		Set<IdealType> includes = Sets.newHashSet();
		for (IdealType type : idealTypes) {
			includes.add(type);
		}
		return new Filter(includes);
	}

	public Filter includes (Set<IdealType> idealTypes) {
		return new Filter(idealTypes);
	}

	public Filter excludes (IdealType ... idealTypes) {
		Set<IdealType> excludes = Sets.newHashSet();
		for (IdealType type : idealTypes) {
			excludes.add(type);
		}
		return new Filter(Sets.difference(setOfAllIdealTypes(), excludes));
	}

	public Filter excludes (Set<IdealType> idealTypes) {
		return new Filter(Sets.difference(setOfAllIdealTypes(), idealTypes));
	}
	
	public ValueSet toValueSet () {
		ValueSet.Builder builder = ValueSet.newValueSet();
		for (StringSource stringSource : this.ideals) {
			builder.with(stringSource);
		}
		return builder.build();
	}

	private Ideal getIdeal () {
		int roll = this.die.roll();
		return this.ideals.get(roll - 1);		
	}
	
	public class Filter implements StringSource {
		private final IdealSet includes;
		
		private Filter (Set<IdealType> includes) {
			checkNotNull(includes);
			checkArgument(includes.size() > 0);
			Builder builder = newIdealSet();
			for (Ideal ideal : IdealSet.this.ideals) {
				IdealType type = ideal.getMetadata(StringSourceMetadata.IDEAL_TYPE);
				if (includes.contains(type) || type == IdealType.ANY) {
					builder.with(ideal);
				}
			}
			this.includes = builder.build();
			checkArgument(this.includes.size() > 0, "The selected ideal type filter does not match any of the ideals for this background.");
		}

		@Override
		public String getValue() {
			return this.includes.getValue();
		}

		@Override
		public String getValue(String separator) {
			return this.includes.getValue(separator);
		}
		
	}
	
	public static class Builder {
		private Set<Ideal> ideals = Sets.newLinkedHashSet();
		
		private Builder () {}
		
		public Builder with (IdealType type, String ideal) {
			checkNotNull(ideal);
			checkNotNull(type);
			this.ideals.add(newIdeal(ideal, type));
			return this;
		}

		public Builder with (IdealSet valueSet) {
			checkNotNull(valueSet);
			this.ideals.addAll(valueSet.ideals);
			return this;
		}
		
		
		public Builder with (Ideal ideal) {
			checkNotNull(ideal);
			this.ideals.add(ideal);
			return this;
		}
		
		public IdealSet build () {
			return new IdealSet(this);
		}
		
	}
 
}
