package org.devoware.table.model;

public class IntegerValue implements IntegerSource {
	
	private int value;

	public static IntegerValue newValue (int value) {
		return new IntegerValue(value);
	}
	
	private IntegerValue (int value) {
		this.value = value;
	}

	@Override
	public int getValue() {
		return this.value;
	}
	
	@Override
	public int getUpperEndpoint() {
		return this.value;
	}

	@Override
	public int getLowerEndpoint() {
		return this.value;
	}
	
	@Override
	public boolean contains(int value) {
		return value == this.value;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + value;
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
		IntegerValue other = (IntegerValue) obj;
		if (value != other.value)
			return false;
		return true;
	}
}
