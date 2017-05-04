package it.uniroma3.diadia.giocatore;

/**
 * Questa classe ha la responsabilità di gestire le caratteristiche del giocatore.
 * Gestisce quindi i cfu del giocatore, e la borsa (quindi l'insieme di attrezzi che 
 * il giocatore porta con se stesso.
 *
 * @author Davide Zollo & Fabio Ramohitaj
 * @see Partita
 * @version Base
 *
 */
public class Giocatore {
	
	static final private int CFU_INIZIALI = 20;
	
	private Borsa borsa;
	private int cfu;
	
	/**
	 * Crea un nuovo oggetto giocatore così impostando i cfu iniziali
	 * e creando una nuova borsa vuota
	 */
	public Giocatore() {
		this.cfu = CFU_INIZIALI;
		borsa = new Borsa();
	}
	
	/**
	 * Restituisce i cfu correnti
	 * @return cfu
	 */
	public int getCfu() {
		return this.cfu;
	}
	
	/**
	 * Imposta i cfu del giocatore
	 * @param cfu
	 */
	public void setCfu(int cfu) {
		this.cfu = cfu;		
	}	
	
	/**
	 * Restituisce la borsa contenente gli 
	 * attrezzi presi dal giocatore
	 * 
	 * @return borsa
	 */
	public Borsa getBorsa() {
		return this.borsa;	
	}
	
	/**
	 * Restituisce una descrizione del giocatore, quindi 
	 * dei suoi attrezzi presenti nella borsa e il
	 * numero di cfu rimanenti
	 * 
	 */
	public String toString() {
		String s;	
		s = this.borsa.toString() + "\n" + "CFU DISPONIBILI: " + this.cfu;
	
		return s;
	}
	


}
