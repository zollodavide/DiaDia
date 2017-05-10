package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * Classe che rappresenta un comando che cerca di posare un oggetto contenuto nella borsa, nel caso in cui l'attrezzo
 * non pu� essere posato o non esiste, stampa un messaggio di errore
 * 
 */
public class ComandoPosa implements Comando {
	
	private final String nomeComando;
	private String attrezzoDaPosare;
	
	public ComandoPosa() {
		this.nomeComando = "posa";
	}

	@Override
	public void esegui(Partita partita) {
		
		if(attrezzoDaPosare==null)
			System.out.println("Che attrezzo vuoi posare?");
		
		else if(!partita.getGiocatore().getBorsa().hasAttrezzo(attrezzoDaPosare))
			System.out.println("L'attrezzo " + attrezzoDaPosare + " non � presente nella borsa");
			
		else {
			
			Attrezzo attrezzo = partita.getGiocatore().getBorsa().getAttrezzo(attrezzoDaPosare);
					
			if(partita.getStanzaCorrente().addAttrezzo(attrezzo)){
				partita.getGiocatore().getBorsa().removeAttrezzo(attrezzoDaPosare);
				System.out.println("L'attrezzo " + attrezzoDaPosare + " � stato posato nella stanza!");
			}

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
	public String getNomeComando() {
		return this.nomeComando;
	}

	@Override
	public String getParametro() {
		return this.attrezzoDaPosare;
	}

	@Override
	public boolean equals(Object o) {
		ComandoPosa that = (ComandoPosa)o;
		return this.nomeComando.equals(that.getNomeComando()) && this.attrezzoDaPosare.equals(that.getParametro());
	}
	
	@Override
	public int hashCode() {
		return 0;
	}

}
