package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoSaluta extends AbstractComando {

	public ComandoSaluta() {
		super("saluta");
	}

	@Override
	public String esegui(Partita partita) {
		partita.getStanzaCorrente().getPersonaggio().setSaluto();
		return (partita.getStanzaCorrente().getPersonaggio().saluta());
	}

}
