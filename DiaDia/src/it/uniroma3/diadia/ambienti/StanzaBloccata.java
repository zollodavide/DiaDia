package it.uniroma3.diadia.ambienti;

/**
 * Classe che rappresenta una stanza bloccata del gioco. Questa può essere sbloccata solo quando c'è 
 * l'attrezzo sbloccante nella stanza adiacente.
 * 
 * @author Davide Zollo
 * @see Stanza
 *
 */

public class StanzaBloccata extends Stanza {
	
	private String attrezzoSbloccante;
	private String direzioneBloccata; 
	
	public StanzaBloccata (String nome, String attrezzoSbloccante, String direzioneBloccata) {
		 super(nome);
		 this.attrezzoSbloccante= attrezzoSbloccante;
		 this.direzioneBloccata= direzioneBloccata;
	}
	
	@Override
	public Stanza getStanzaAdiacente(String direzione) {
		if (!direzione.equals(this.getDirezioneBloccata()))
			return super.getStanzaAdiacente(direzione);
		else{
			if (this.hasAttrezzo(this.getAttrezzoSbloccante()))
				return super.getStanzaAdiacente(direzione);
			else 
				return this;
		}
	}
	
	/**
	 * Restituisce la stringa del nome dell'attrezzo sbloccante
	 * @return la stringa del nome dell'attrezzo sbloccante
	 */
	public String getAttrezzoSbloccante() {
		return this.attrezzoSbloccante;
	}
	
	/**
	 * Restituisce la stringa del nome della direzione bloccata
	 * @return la stringa del nome della direzione bloccata
	 */
	public String getDirezioneBloccata() {
		return this.direzioneBloccata;
	}
	
	
}
