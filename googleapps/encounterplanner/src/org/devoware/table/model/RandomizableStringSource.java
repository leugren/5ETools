package org.devoware.table.model;

public interface RandomizableStringSource extends StringSource {

	public IntegerSource getIntegerSource ();
	public String getValue(int idx);
	public String getValue(int idx, String separator);
}
