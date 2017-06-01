package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * Classe che rappresenta un comando che cerca di posare un oggetto contenuto nella borsa, nel caso in cui l'attrezzo
 * non pu� essere posato o non esiste, stampa un messaggio di errore
 * 
 */
public class ComandoPosa extends AbstractComando {
	
	private String attrezzoDaPosare;
	
	public ComandoPosa() {
		super("posa");
	}

	@Override
	public String esegui(Partita partita) {
		
		if(attrezzoDaPosare==null)
			return ("Che attrezzo vuoi posare?");
		
		else if(!partita.getGiocatore().getBorsa().hasAttrezzo(attrezzoDaPosare))
			return ("L'attrezzo " + attrezzoDaPosare + " non � presente nella borsa");
			
		else {
			
			Attrezzo attrezzo = partita.getGiocatore().getBorsa().getAttrezzo(attrezzoDaPosare);
					
			if(partita.getStanzaCorrente().addAttrezzo(attrezzo)){
				partita.getGiocatore().getBorsa().removeAttrezzo(attrezzoDaPosare);
				return ("L'attrezzo " + attrezzoDaPosare + " � stato posato nella stanza!");
			}
			else
				return ("L'attrezzo " + attrezzoDaPosare + " non � stato posato nella stanza!");

		}	
	}
	
	/**
	 * 	@param nomeAttrezzo il nome dell'attrezzo che si vuole posare
	 */
	@Override
	public void setParametro(String nomeAttrezzo) {
		this.attrezzoDaPosare = nomeAttrezzo;
	}
	
	@Override
	public String getParametro() {
		return this.attrezzoDaPosare;
	}

}
