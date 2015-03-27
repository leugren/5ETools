package org.devoware.table.model;

import static com.google.common.base.Preconditions.checkNotNull;


public abstract class RandomizableStringSourceDecorator implements RandomizableStringSource {
	
	private final RandomizableStringSource source;
	
	public RandomizableStringSourceDecorator (RandomizableStringSource source) {
		checkNotNull(source);
		this.source = source;
	}
	
	@Override
	public String getValue(int idx) {
		String value = source.getValue(idx);
		return generateValue(value);
	}
	
	@Override
	public String getValue(int idx, String separator) {
		String value = source.getValue(idx, separator);
		return generateValue(value);
	}

	@Override
	public String getValue() {
		String value = source.getValue();
		return generateValue(value);
	}

	@Override
	public String getValue(String separator) {
		String value = source.getValue(separator);
		return generateValue(value);
	}
	
    @Override
    public IntegerSource getIntegerSource() {
    	return source.getIntegerSource();
    }
    
    @Override
    public ValueSet toValueSet() {
    	return source.toValueSet();
    }
	
	protected String generateValue (String value) {
		return value;
	}
	

}
