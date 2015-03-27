package org.devoware.table.model;

import static com.google.common.base.Preconditions.checkNotNull;


public class NamedRandomizableStringSource extends RandomizableStringSourceDecorator {

	private final String name;
	private final boolean includeNameInValue;

	public static NamedRandomizableStringSource newNamedStringSource (String name, RandomizableStringSource source) {
		return new NamedRandomizableStringSource(name, source, true);
	}
	
	public static NamedRandomizableStringSource newNamedStringSource (String name, RandomizableStringSource source, boolean includeNameInValue) {
		return new NamedRandomizableStringSource(name, source, includeNameInValue);
	}

	public String getName () {
		return this.name;
	}
	
	private NamedRandomizableStringSource(String name, RandomizableStringSource source, boolean includeNameInValue) {
		super(source);
		checkNotNull(name);
		this.name = name;
		this.includeNameInValue = includeNameInValue;
	}
	
	@Override
	protected String generateValue(String value) {
		if (!includeNameInValue) {
			return value;
		}
		return String.format("%s (%s)", value, this.name);
	}

}
