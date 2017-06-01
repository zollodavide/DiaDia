package it.uniroma3.diadia.giocatore;

import static it.uniroma3.diadia.properties.Costanti.CFU_INIZIALI;;

/**
 * Questa classe ha la responsabilit� di gestire le caratteristiche del giocatore.
 * Gestisce quindi i cfu del giocatore, e la borsa (quindi l'insieme di attrezzi che 
 * il giocatore porta con se stesso.
 *
 * @author Davide Zollo & Fabio Ramohitaj
 * @see Partita
 * @version Base
 *
 */
public class Giocatore {
	
	
	private Borsa borsa;
	private int cfu;
	
	/**
	 * Crea un nuovo oggetto giocatore cos� impostando i cfu iniziali
	 * e creando una nuova borsa vuota
	 */
	public Giocatore() {
		this.cfu = CFU_INIZIALI.getCostant();
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
