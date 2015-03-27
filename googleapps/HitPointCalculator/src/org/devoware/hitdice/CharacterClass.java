package org.devoware.hitdice;

import static org.devoware.hitdice.HitDie.*;

public enum CharacterClass {
	BARBARIAN(D12),
	FIGHTER(D10),
	MONK(D8),
	PALADIN(D10);
    
	private final HitDie hitDie;
	
	private CharacterClass(HitDie hitDie) {
		this.hitDie = hitDie;
	}
	
	public HitDie getHitDie () {
		return this.hitDie;
	}
}
