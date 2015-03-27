package org.devoware.table.model;

import static org.devoware.table.model.Separators.DEFAULT_SEPARATOR;

import java.util.List;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

public class CompositeValueSource implements StringSource {
	private final List<StringSource> valueSources;
	
	public static Builder newCompositeValueSource () {
		return new Builder();
	}
	
	private CompositeValueSource (Builder builder) {
		this.valueSources = ImmutableList.copyOf(builder.valueSources);
	}
	
	@Override
	public String getValue() {
		return getValue(DEFAULT_SEPARATOR);
	}
	
	@Override
	public String getValue(String separator) {
		StringBuilder buf = new StringBuilder();
		boolean firstLoop = true;
		for (StringSource valueSource : this.valueSources) {
			String value = valueSource.getValue(separator);
			if (value.trim().isEmpty()) {
				continue;
			}
			if (firstLoop) {
				firstLoop = false;
			} else {
				buf.append(separator);
			}
			buf.append(value);
		}
		return buf.toString();
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((valueSources == null) ? 0 : valueSources.hashCode());
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
		CompositeValueSource other = (CompositeValueSource) obj;
		if (valueSources == null) {
			if (other.valueSources != null)
				return false;
		} else if (!valueSources.equals(other.valueSources))
			return false;
		return true;
	}



	public static class Builder {
		private List<StringSource> valueSources = Lists.newArrayList();
		
		private Builder () {}
		
		public Builder with (StringSource valueSource) {
			Preconditions.checkNotNull(valueSource);
			this.valueSources.add(valueSource);
			return this;
		}
		
		public CompositeValueSource build () {
			return new CompositeValueSource(this);
		}
		
	}
}
