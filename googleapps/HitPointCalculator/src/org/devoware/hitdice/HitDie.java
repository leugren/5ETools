package org.devoware.hitdice;

public enum HitDie {
	D4(4),
	D6(6),
	D8(8),
	D10(10),
	D12(12);

	private final int type;
	
	private HitDie (int type) {
		this.type = type;
	}
	
	public int getMax () {
		return this.type;
	}
	
	public int getAverage () {
		return this.type / 2 + 1;
	}
}
