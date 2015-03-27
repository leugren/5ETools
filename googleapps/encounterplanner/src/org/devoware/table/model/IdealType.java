package org.devoware.table.model;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Map;
import java.util.Set;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

public enum IdealType {
    GOOD,
    EVIL,
    LAWFUL,
    CHAOTIC,
    NEUTRAL,
    ANY;
    
    private static final Set<IdealType> IDEAL_TYPES;
    private static final Map<String, IdealType> IDEAL_TYPE_MAP;
    
    static {
    	Map<String, IdealType> idealTypeMap = Maps.newHashMap();
    	Set<IdealType> idealTypes = Sets.newLinkedHashSet();
    	for (IdealType type : values()) {
    		idealTypeMap.put(type.toString(), type);
    		idealTypes.add(type);
    	}
    	IDEAL_TYPES = ImmutableSet.copyOf(idealTypes);
    	IDEAL_TYPE_MAP = ImmutableMap.copyOf(idealTypeMap);
    }
    
    public static Set<IdealType> setOfAllIdealTypes() {
    	return IDEAL_TYPES;
    }

    public static IdealType get (String idealType) {
    	checkNotNull(idealType);
    	return IDEAL_TYPE_MAP.get(idealType.toUpperCase());
    }
}
