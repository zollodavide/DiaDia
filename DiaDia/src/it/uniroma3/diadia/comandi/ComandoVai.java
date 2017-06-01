package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

/**
 * Classe che rappresenta un comando che cerca di spostarsi in una direzione. Se c'e' una stanza ci entra 
 * e ne stampa il nome, altrimenti stampa un messaggio di errore
 * 
 */
public class ComandoVai extends AbstractComando {

	private String direzione;

	public ComandoVai() {
		super("vai");
	}

	@Override
	public String esegui(Partita partita) {

		if(direzione==null)
			return ("Dove vuoi andare ?");

		else {

			Stanza prossimaStanza = null;
			prossimaStanza = partita.getStanzaCorrente().getStanzaAdiacente(direzione);
		
			if (prossimaStanza == null)
				return ("Direzione inesistente");

			else {
				partita.setStanzaCorrente(prossimaStanza);
				int cfu = partita.getGiocatore().getCfu();
				cfu--;
				partita.getGiocatore().setCfu(cfu);
				return "Stanza: " + partita.getStanzaCorrente().getNome();

			}

		}
	}

	@Override
	public void setParametro(String parametro) {
		this.direzione = parametro;
	}

	@Override
	public String getParametro() {
		return this.direzione;
	}

}
