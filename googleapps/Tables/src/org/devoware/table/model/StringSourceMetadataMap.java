package org.devoware.table.model;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Map;
import java.util.Set;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;



public class StringSourceMetadataMap {
	
	private final Map<StringSourceMetadata<?>, Object> map;
	
	public static Builder newMetadataMap () {
		return new Builder();
	}
	
	public static <T> StringSourceMetadataMap newSingletonMetadataMap (StringSourceMetadata<T> key, T value) {
		return newMetadataMap()
				.put(key, value)
				.build();
	}
	
	private StringSourceMetadataMap(Builder builder) {
		this.map = ImmutableMap.copyOf(builder.map);
	}
	
	public Set<StringSourceMetadata<?>> keySet () {
		return map.keySet();
	}
	
	public <T> T get(StringSourceMetadata<T> key) {
		Object value = map.get(key);
		if (value == null) {
			return null;
		}
		return key.getType().cast(value);
	}

	public static class Builder {
		private final Map<StringSourceMetadata<?>, Object> map = Maps.newLinkedHashMap();
		
		public <T> Builder put(StringSourceMetadata<T> key, T value) {
			checkNotNull(key);
			checkNotNull(value);
			map.put(key, value);
			return this;
		}
		
		public StringSourceMetadataMap build () {
			return new StringSourceMetadataMap(this);
		}
	}
	
}
