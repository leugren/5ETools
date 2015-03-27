package org.devoware.table.model;

import static org.devoware.table.model.Separators.DEFAULT_SEPARATOR;

import java.util.Arrays;

import com.google.common.base.Preconditions;

public class FormattedValue implements StringSource {
	
	private final String valueTemplate;
	private final StringSource [] valueSources;
	
	public static FormattedValue newFormattedValue (String valueTemplate, StringSource ... valueSources) {
		return new FormattedValue(valueTemplate, valueSources);
	}

	private FormattedValue (String valueTemplate, StringSource ... valueSources) {
		Preconditions.checkNotNull(valueTemplate);
		for (StringSource valueSource : valueSources) {
		    Preconditions.checkNotNull(valueSource);
		}
		this.valueTemplate = valueTemplate;
		this.valueSources = valueSources;
	}

	@Override
	public String getValue() {
		return getValue(DEFAULT_SEPARATOR);
	}

	@Override
	public String getValue(String separator) {
		Object [] values = new String [valueSources.length];
		for (int i = 0; i < values.length; i++) {
			values[i] = this.valueSources[i].getValue(separator);
		}
		return String.format(this.valueTemplate, values);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(valueSources);
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
		FormattedValue other = (FormattedValue) obj;
		if (!Arrays.equals(valueSources, other.valueSources))
			return false;
		if (valueTemplate == null) {
			if (other.valueTemplate != null)
				return false;
		} else if (!valueTemplate.equals(other.valueTemplate))
			return false;
		return true;
	}

}
