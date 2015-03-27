package org.devoware.table.model;

import static org.devoware.table.model.Separators.DEFAULT_SEPARATOR;

import java.util.List;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

public class CompositeStringValue implements StringSource {
	private final List<String> values;
	
	public static Builder newCompositeStringValue () {
		return new Builder();
	}
	
	private CompositeStringValue (Builder builder) {
		this.values = ImmutableList.copyOf(builder.values);
	}
	
	@Override
	public String getValue() {
		return getValue(DEFAULT_SEPARATOR);
	}
	
	@Override
	public String getValue(String separator) {
		StringBuilder buf = new StringBuilder();
		boolean firstLoop = true;
		for (String value : this.values) {
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
		result = prime * result + ((values == null) ? 0 : values.hashCode());
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
		CompositeStringValue other = (CompositeStringValue) obj;
		if (values == null) {
			if (other.values != null)
				return false;
		} else if (!values.equals(other.values))
			return false;
		return true;
	}



	public static class Builder {
		private List<String> values = Lists.newArrayList();
		
		private Builder () {}
		
		public Builder with (String value) {
			Preconditions.checkNotNull(value);
			this.values.add(value);
			return this;
		}
		
		public CompositeStringValue build () {
			return new CompositeStringValue(this);
		}
		
	}

}
