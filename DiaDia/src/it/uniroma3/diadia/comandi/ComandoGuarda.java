package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita; 

/**
 * Classe che rappresenta il comando utilizzato per guardare cosa c'è dentro una stanza
 * 
 * @author Davide Zollo
 *
 */
public class ComandoGuarda extends AbstractComando {

	
	public ComandoGuarda() {
		super("guarda");
	}
	
	@Override
	public String esegui(Partita partita) {
		StringBuilder builder = new StringBuilder();
		
		builder.append(partita.getStanzaCorrente().getDescrizione() + "\n");
		builder.append(partita.getGiocatore().toString() + "\n");
		
		return builder.toString();
	}

}
