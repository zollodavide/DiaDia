package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

/**
 * Classe che rappresenta il comando che stampa informazioni di aiuto.
 */
public class ComandoAiuto extends AbstractComando {
	
	
	public ComandoAiuto() {
		super("aiuto");
	}

	static final private String[] elencoComandi = {"vai", "aiuto", "fine", "prendi" , "posa", "guarda", "saluta", "regala", "interagisci"};
	
	@Override
	public String esegui(Partita partita) {
		
		StringBuilder builder = new StringBuilder();
		
		for(int i=0; i< elencoComandi.length; i++) 
			builder.append(elencoComandi[i]+" ");
		
		return builder.toString();
	}

}
