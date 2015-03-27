package org.devoware.table.model;

public class Subtable implements StringSource {

	private ValueRangeMap table;
	
	public static Subtable newSubtable (ValueRangeMap table) {
		return new Subtable(table);
	}
	
	private Subtable(ValueRangeMap table) {
		this.table = table;
	}
	
	@Override
	public String getValue() {
		return table.getValue();
	}

	@Override
	public String getValue(String separator) {
		return table.getValue(separator);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((table == null) ? 0 : table.hashCode());
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
		Subtable other = (Subtable) obj;
		if (table == null) {
			if (other.table != null)
				return false;
		} else if (!table.equals(other.table))
			return false;
		return true;
	}
	
	
}
