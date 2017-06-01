package it.uniroma3.diadia.properties;

public enum Direzione {

	NORD ("nord"),
	SUD ("sud"),
	EST ("est"),
	OVEST ("ovest");

	
	private final String direzione;
	
	private Direzione(String dir) {
		this.direzione = dir;
	}
	
	public String getDirezione() {
		return this.direzione;
	}

}
