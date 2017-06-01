package it.uniroma3.diadia.properties;

public enum Costanti {
	
	CFU_INIZIALI (20),	 
	DEFAULT_PESO_MAX_BORSA (10); 
	
	private final int costante;
	
	private Costanti(int costante) {
		this.costante = costante;
	}
	
	public int getCostant() {
		return this.costante;
		
	}

}
