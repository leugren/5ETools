package org.devoware.table.model;

import static org.devoware.table.model.StringSourceMetadataMap.newSingletonMetadataMap;
import static org.devoware.table.model.StringValue.newValue;

public class Ideal extends StringSourceWithMetadata {

	public static Ideal newIdeal(String ideal, IdealType type) {
		StringSource source = newValue(ideal);
		StringSourceMetadataMap metadata = newSingletonMetadataMap(StringSourceMetadata.IDEAL_TYPE, type);
		return new Ideal(source, metadata);
	}

	private Ideal(StringSource source, StringSourceMetadataMap metadata) {
		super(source, metadata);
	}
	
}
