package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * Cerca di prendere un oggetto se presente nella stanza, nel caso in cui non c'è
 * stampa un messaggio di errore
 * 
 */
public class ComandoPrendi implements Comando {
	
	private final String nomeComando;
	private String attrezzoDaPrendere;
	
	public ComandoPrendi() {
		this.nomeComando = "prendi";
	}

	@Override
	public void esegui(Partita partita) {

		if(attrezzoDaPrendere==null) 
			System.out.println("Che attrezzo vuoi prendere?");

		else if(!partita.getStanzaCorrente().hasAttrezzo(attrezzoDaPrendere))
			System.out.println("L'attrezzo " + attrezzoDaPrendere + " non è presente nella stanza");

		else {
			Attrezzo attrezzo = partita.getStanzaCorrente().getAttrezzo(attrezzoDaPrendere);
			
			if(partita.getGiocatore().getBorsa().getPeso()>=partita.getGiocatore().getBorsa().getPesoMax())
				System.out.println("Hai la borsa piena!");
			
			else if(partita.getGiocatore().getBorsa().getPeso() + attrezzo.getPeso() > partita.getGiocatore().getBorsa().getPesoMax())
				System.out.println("L'attrezzo pesa troppo!");
			
			else if(partita.getGiocatore().getBorsa().addAttrezzo(attrezzo)) {
				partita.getStanzaCorrente().removeAttrezzo(attrezzo);
				System.out.println("attrezzo " + attrezzoDaPrendere + " è stato preso!");
			}
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
	public String getNomeComando() {
		return this.nomeComando;
	}


	@Override
	public String getParametro() {
		return this.attrezzoDaPrendere;
	}


	@Override
	public boolean equals(Object o) {
		ComandoPrendi that = (ComandoPrendi)o;
		return this.nomeComando.equals(that.getNomeComando()) && this.attrezzoDaPrendere.equals(that.getParametro());
	}
	
	@Override
	public int hashCode() {
		return 0;
	}

}
