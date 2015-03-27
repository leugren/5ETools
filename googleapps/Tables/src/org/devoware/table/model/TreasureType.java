package org.devoware.table.model;

import java.util.Map;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;

public enum TreasureType {
    INDIVIDUAL("INDIVIDUAL"),
    TREASURE_HOARD("TREASURE_HOARD");
    
    private static final Map<String, TreasureType> TYPES;
    
    private final String key;
    
    static {
    	Map<String, TreasureType> types = Maps.newHashMap();
    	for (TreasureType type : TreasureType.values()) {
    		types.put(type.getKey(), type);
    	}
    	TYPES = ImmutableMap.copyOf(types);
    }
    
    public static TreasureType get (String key) {
    	if (key == null) {
    		return null;
    	}
    	return TYPES.get(key);
    }
    
    private TreasureType(String key) {
    	this.key = key;
    }
    
    public String getKey () {
    	return this.key;
    }
}
