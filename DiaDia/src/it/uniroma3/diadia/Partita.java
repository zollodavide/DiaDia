package it.uniroma3.diadia;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.giocatore.Giocatore;

/**
 * Questa classe modella una partita del gioco
 *
 * @author  docente di POO
 * @see Stanza
 * @version base
 */

public class Partita {

	private Stanza stanzaCorrente;
	private boolean finita;
	private Labirinto labirinto;
	private Giocatore giocatore;
	
	/**
	 * Crea una nuova partita impostando il labirinto, il giocatore e 
	 * la stanza iniziale
	 */
	public Partita() {
		ClassLoader l = this.getClass().getClassLoader();
		labirinto = new Labirinto(l.getResource("labirinto.txt").getPath());
		giocatore = new Giocatore();
		this.finita = false;
		stanzaCorrente = labirinto.getEntrata();
	}
	
	/**
	 * Imposta la stanza dove si trova il giocatore
	 *
	 * @param stanzaCorrente 
	 */
	public void setStanzaCorrente(Stanza stanzaCorrente) {
		this.stanzaCorrente = stanzaCorrente;
	}
	
	/**
	 * Restituisce la stanza in cui si trova il giocatore
	 * @return stanzaCorrente
	 */
	public Stanza getStanzaCorrente() {
		return this.stanzaCorrente;
	}
	
	/**
	 * Restituisce vero se e solo se la partita e' stata vinta
	 * @return vero se partita vinta
	 */
	public boolean vinta() {
		return this.getStanzaCorrente()== this.labirinto.getUscita();
	}

	/**
	 * Restituisce vero se e solo se la partita e' finita
	 * @return vero se partita finita
	 */
	public boolean isFinita() {
		return this.finita || this.vinta() || (this.giocatore.getCfu() == 0);
	}

	/**
	 * Imposta la partita come finita
	 *
	 */
	public void setFinita() {
		this.finita = true;
	}
	
	/**
	 * Restituisce l'oggetto giocatore del gioco
	 * 
	 * @return giocatore
	 */
	public Giocatore getGiocatore(){
		return this.giocatore;
	}
	
	/**
	 * Restituisce il labirinto del gioco
	 * 
	 * @return labirinto
	 */
	public Labirinto getLabirinto(){
		return this.labirinto;
	}
	
	/**
	 * Controlla se il giocatore ha ancora dei CFU disponibili
	 * 
	 * @return true se i cfu sono maggiori di 0
	 */
	public boolean giocatoreIsVivo() {
		return this.giocatore.getCfu()>0;
	}

}
