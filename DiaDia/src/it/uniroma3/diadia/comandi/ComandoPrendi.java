package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * Classe che rappresenta un comando che cerca di prendere un oggetto se presente nella stanza, nel caso in cui non c'�
 * stampa un messaggio di errore
 * 
 */
public class ComandoPrendi extends AbstractComando {
	
	private String attrezzoDaPrendere;
	
	public ComandoPrendi() {
		super("prendi");
	}

	@Override
	public String esegui(Partita partita) {

		if(attrezzoDaPrendere==null) 
			return ("Che attrezzo vuoi prendere?");

		else if(!partita.getStanzaCorrente().hasAttrezzo(attrezzoDaPrendere))
			return ("L'attrezzo " + attrezzoDaPrendere + " non � presente nella stanza");

		else {
			Attrezzo attrezzo = partita.getStanzaCorrente().getAttrezzo(attrezzoDaPrendere);
			
			if(partita.getGiocatore().getBorsa().getPeso()>=partita.getGiocatore().getBorsa().getPesoMax())
				return ("Hai la borsa piena!");
			
			else if(partita.getGiocatore().getBorsa().getPeso() + attrezzo.getPeso() > partita.getGiocatore().getBorsa().getPesoMax())
				return ("L'attrezzo pesa troppo!");
			
			else if(partita.getGiocatore().getBorsa().addAttrezzo(attrezzo)) {
				partita.getStanzaCorrente().removeAttrezzo(attrezzo);
				return ("attrezzo " + attrezzoDaPrendere + " � stato preso!");
			}
			else 
				return ("L'attrezzo non è stato preso");
		}
	}
	
	
	/**
	 * 	@param nomeAttrezzo il nome dell'attrezzo che si vuole prendere
	 */
	@Override
	public void setParametro(String nomeAttrezzo) {
		this.attrezzoDaPrendere = nomeAttrezzo;
	}
	

	@Override
	public String getParametro() {
		return this.attrezzoDaPrendere;
	}

}
