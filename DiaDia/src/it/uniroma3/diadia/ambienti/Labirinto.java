package it.uniroma3.diadia.ambienti;

import java.io.FileNotFoundException;

import it.uniroma3.diadia.Partita;

/**
 * Questa classe ha la responsabilit� di creare il labirinto del gioco,
 * cio� di creare e collegare tutte le stanze. Inoltre, memorizza la stanza
 * vincente e quella iniziale.
 * 
 * @author Davide Zollo & Fabio Ramohitaj
 * @see Stanza
 * @see Partita
 * @version Base
 */
public class Labirinto {
	
	private Stanza entrata;
	private Stanza uscita;
	private CaricatoreLabirinto caricatore;
		
	/**
	 * Crea il Labirinto
	 * 
	 */
    public Labirinto(String nomeFile) {
    	try {
			caricatore = new CaricatoreLabirinto(nomeFile);
			caricatore.carica();
			this.entrata = caricatore.getStanzaIniziale();
	    	this.uscita =  caricatore.getStanzaVincente();
    	}
    	catch (FileNotFoundException e) {
			e.printStackTrace();
		}
    	catch (FormatoFileNonValidoException e) {
			e.printStackTrace();
		}
	}
    
	/**
	 * Imposta la stanza vincente del gioco
	 * @param uscita
	 */
	public void setUscita(Stanza stanzaVincente) {
		this.uscita = stanzaVincente;
	}
	
	/**
	 * Restituisce la stanza vincente del gioco
	 * @return la stanza vincente
	 */
	public Stanza getUscita() {
		return this.uscita;
	}
	
	/**
	 * Imposta la stanza in cui ti trovi all'inizio del gioco
	 * @param entrata 
	 */
	public void setEntrata(Stanza stanzaIniziale) {
		this.entrata = stanzaIniziale;
	}
	
	/**
	 * Restituisce la stanza corrente del gioco
	 * @return la stanza corrente del gioco
	 */
	public Stanza getEntrata() {
		return this.entrata;
	}

}
