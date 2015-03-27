package org.devoware.table.model;

public interface IntegerSource {

	public int getValue();
	public int getUpperEndpoint();
	public int getLowerEndpoint();
	public boolean contains(int value);
}
