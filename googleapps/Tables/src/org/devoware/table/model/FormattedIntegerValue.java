package org.devoware.table.model;

import com.google.common.base.Preconditions;

public class FormattedIntegerValue implements StringSource {
	
	private final String valueTemplate;
	private final IntegerSource source;
	
	public static FormattedIntegerValue newFormattedIntegerValue (String valueTemplate, IntegerSource rnd) {
		return new FormattedIntegerValue(valueTemplate, rnd);
	}

	private FormattedIntegerValue (String valueTemplate, IntegerSource rnd) {
		Preconditions.checkNotNull(valueTemplate);
		Preconditions.checkNotNull(rnd);
		this.valueTemplate = valueTemplate;
		this.source = rnd;
	}

	@Override
	public String getValue() {
		return String.format(this.valueTemplate, this.source.getValue());
	}

	@Override
	public String getValue(String separator) {
		return getValue();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((source == null) ? 0 : source.hashCode());
		result = prime * result
				+ ((valueTemplate == null) ? 0 : valueTemplate.hashCode());
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
		FormattedIntegerValue other = (FormattedIntegerValue) obj;
		if (source == null) {
			if (other.source != null)
				return false;
		} else if (!source.equals(other.source))
			return false;
		if (valueTemplate == null) {
			if (other.valueTemplate != null)
				return false;
		} else if (!valueTemplate.equals(other.valueTemplate))
			return false;
		return true;
	}
	
	

}
