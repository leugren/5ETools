package org.devoware.table.model;

import static com.google.common.base.Preconditions.checkNotNull;

public abstract class StringSourceDecorator implements StringSource {

	private final StringSource source;
	
	public StringSourceDecorator (StringSource source) {
		checkNotNull(source);
		this.source = source;
	}
	
	@Override
	public String getValue() {
		return source.getValue();
	}

	@Override
	public String getValue(String separator) {
		return source.getValue(separator);
	}

}
