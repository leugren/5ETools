package org.devoware.table.model;

public abstract class StringSourceWithMetadata extends StringSourceDecorator {

	private final StringSourceMetadataMap map;

	public StringSourceWithMetadata(StringSource source, StringSourceMetadataMap map) {
		super(source);
		this.map = map;
	}

	public <T> T getMetadata(StringSourceMetadata<T> metadata) {
		return map.get(metadata);
	}

}
