package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoFine implements Comando {

	private final String nomeComando;
	
	public ComandoFine() {
		this.nomeComando = "fine";
	}
	
	@Override
	public void esegui(Partita partita) {
		System.out.println("Grazie di aver giocato!");  // si desidera smettere
		partita.setFinita();
	}

	@Override
	public void setParametro(String parametro) {

	}
	
	@Override
	public boolean equals(Object o) {
		ComandoFine that = (ComandoFine)o;
		return this.nomeComando.equals(that.getNomeComando());
	}
	
	@Override
	public int hashCode() {
		return 0;
	}

	@Override
	public String getNomeComando() {
		return this.nomeComando;
	}

	@Override
	public String getParametro() {
		return null;
	}

}
