package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

/**
 * Classe che rappresenta il comando che mette fine alla partita
 * 
 * @author Davide Zollo
 *
 */
public class ComandoFine extends AbstractComando {
	
	public ComandoFine() {
		super("fine");
	}
	
	@Override
	public String esegui(Partita partita) {
		partita.setFinita();
		return "Grazie di aver giocato!";  // si desidera smettere
	}

}
