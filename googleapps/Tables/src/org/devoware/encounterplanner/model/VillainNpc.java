package org.devoware.encounterplanner.model;

public class VillainNpc {
	
	private final Villain villain;
	private final Npc npc;
	
	public static VillainNpc newVillainNpc (Villain villain, Npc npc) {
        return new VillainNpc(villain, npc);
	}
	
	private VillainNpc(Villain villain, Npc npc) {
		this.villain = villain;
		this.npc = npc;
	}

	public Villain getVillain() {
		return villain;
	}

	public Npc getNpc() {
		return npc;
	}

}
