package org.devoware.encounterplanner.model;

public class Treasure {
	
	private String data;
	
	public static Treasure newTreasure(String data) {
		return new Treasure(data);
	}
	
	private Treasure (String data) {
		this.data = data;
	}

	public String getData() {
		return data;
	}

}
