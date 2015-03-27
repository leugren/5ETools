package org.devoware.table.model;

public class StringSourceMetadata <T> {
	public static final StringSourceMetadata<IdealType> IDEAL_TYPE = new StringSourceMetadata<>(IdealType.class);
	
    private final Class<T> type;
    
    private StringSourceMetadata (Class<T> type) {
    	this.type = type;
    }
	
	public final Class<T> getType () {
    	return this.type;
    }
	
}
