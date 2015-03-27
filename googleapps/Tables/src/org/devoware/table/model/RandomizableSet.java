package org.devoware.table.model;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.devoware.table.dice.Die;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

public class RandomizableSet <T> implements Iterable<T> {
	private final Die die;
	private final List<T> values;
	
	public static <T> Builder<T> newRandomizableSet() {
		return new Builder<>();
	}
	
	private RandomizableSet (Builder<T> builder) {
		List<T> list = Lists.newArrayList();
		list.addAll(builder.values);
		this.values = ImmutableList.copyOf(list);
		this.die = Die.newDie(this.values.size());
	}
	
	public T get() {
		int roll = this.die.roll();
		return this.values.get(roll - 1);
	}
	
	public T get(int idx) {
		return this.values.get(idx);
	}
	
	public int size () {
		return this.values.size();
	}
	
	@Override
	public Iterator<T> iterator() {
		return this.values.iterator();
	}
	
	public static class Builder <T> {
		private final Set<T> values = Sets.newLinkedHashSet();
		
		public Builder<T> with (T value) {
			this.values.add(value);
			return this;
		}
		
		public Builder<T> withAll (Collection<T> values) {
			this.values.addAll(values);
			return this;
		}
		
		public RandomizableSet<T> build () {
			return new RandomizableSet<>(this);
		}
	}

}
