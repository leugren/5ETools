package org.devoware.table.model;

class StringValue implements StringSource {
	public static final StringValue NO_VALUE = new StringValue("");
	
	private String value;
	
	static StringValue newValue (String value) {
		return new StringValue(value);
	}
	
	private StringValue (String value) {
		this.value = value;
	}
	
	@Override
	public String getValue() {
		return this.value;
	}

	@Override
	public String getValue(String separator) {
		return this.value;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((value == null) ? 0 : value.hashCode());
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
		StringValue other = (StringValue) obj;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}
	
	
}
