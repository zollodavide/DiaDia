package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoRegala extends AbstractComando {
	
	private String attrezzoDaRegalare;

	public ComandoRegala() {
		super("regala");
	}

	@Override
	public String esegui(Partita partita) {
		
		if(partita.getGiocatore().getBorsa().hasAttrezzo(attrezzoDaRegalare)) {
			Attrezzo regalo = partita.getGiocatore().getBorsa().getAttrezzo(attrezzoDaRegalare);
			partita.getGiocatore().getBorsa().removeAttrezzo(attrezzoDaRegalare);
			return (partita.getStanzaCorrente().getPersonaggio().riceviRegalo(regalo, partita));
		}
		else
			return ("Questo attrezzo non è presente nella borsa");
	}
	
	@Override
	public void setParametro(String attrezzo) {
		this.attrezzoDaRegalare = attrezzo;
	}

	@Override 
	public String getParametro() {
		return this.attrezzoDaRegalare;
	}
}
