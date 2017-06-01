package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoInteragisci extends AbstractComando {

	public ComandoInteragisci() {
		super("interagisci");
	}

	@Override
	public String esegui(Partita partita) {
		return (partita.getStanzaCorrente().getPersonaggio().agisci(partita));
	}

}
