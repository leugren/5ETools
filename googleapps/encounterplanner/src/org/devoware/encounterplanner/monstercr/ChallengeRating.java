package org.devoware.encounterplanner.monstercr;

import java.util.Map;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;


public enum ChallengeRating {
	CR0(0),
    CR1_8(0.125, "1/8"), CR1_4(0.250, "1/4"), CR1_2(0.5, "1/2"),
    CR1(1),   CR2(2),   CR3(3),   CR4(4),   CR5(5),
    CR6(6),   CR7(7),   CR8(8),   CR9(9),   CR10(10),
    CR11(11), CR12(12), CR13(13), CR14(14), CR15(15),
    CR16(16), CR17(17), CR18(18), CR19(19), CR20(20),
    CR21(21), CR22(22), CR23(23), CR24(24), CR25(25),
    CR26(26), CR27(27), CR28(28), CR29(29), CR30(30);
    
    private static final Map<Double, ChallengeRating> CR_MAP;

    private final String stringValue;
    private final double value;

    private ChallengeRating(double value) {
    	this(value, null);
    }
    
    static {
    	Map<Double, ChallengeRating> crMap = Maps.newHashMap();
    	for (ChallengeRating cr : ChallengeRating.values()) {
    		crMap.put(cr.value, cr);
    	}
    	CR_MAP = ImmutableMap.copyOf(crMap);
    }
    
    public static ChallengeRating get (double value) {
    	return CR_MAP.get(value);
    }
    
    private ChallengeRating(double value, String stringValue) {
    	this.value = value;
    	if (stringValue != null) {
    		this.stringValue = stringValue;
    	} else {
    		this.stringValue = String.valueOf((int) this.value);
    	}
    }

    public ChallengeRating getByOrdinalOffset (int offset) {
    	int ordinal = Math.min(ChallengeRating.values().length - 1, Math.max(0, this.ordinal() + offset));
        return ChallengeRating.values()[ordinal];
    }
    
    public double getValue () {
    	return this.value;
    }
    
    public String toString () {
    	return this.stringValue;
    }
}

