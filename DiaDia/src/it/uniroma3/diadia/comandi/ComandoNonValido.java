package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

/**
 * Classe che rappresenta un comando non valido, cioè che non rappresenta nessun comando del gioco
 *  
 * @author Davide Zollo
 *
 */
public class ComandoNonValido extends AbstractComando{
		
	public ComandoNonValido() {
		super("non valido");
	}	
	
	@Override
	public String esegui(Partita partita) {
		return ("Inserisci un comando valido");
	}

}
