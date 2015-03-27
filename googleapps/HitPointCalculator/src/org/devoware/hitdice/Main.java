package org.devoware.hitdice;

public class Main {
	
	public static void main(String[] args) {
		PlayerCharacter pc = PlayerCharacter.newPlayerCharacter()
				.withConstitution(16)
				.withLevels(CharacterClass.BARBARIAN, 4)
				.build();
		
		System.out.println(pc.getHitPoints());
		    
	}

}
