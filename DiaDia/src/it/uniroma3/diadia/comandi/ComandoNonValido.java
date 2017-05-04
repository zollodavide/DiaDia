package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoNonValido implements Comando {
	
	private final String nomeComando;
	
	public ComandoNonValido() {
		this.nomeComando = "non valido";
	}	

	@Override
	public String getNomeComando() {
		return this.nomeComando;
	}

	@Override
	public String getParametro() {
		return null;
	}

	@Override
	public void esegui(Partita partita) {
		System.out.println("Inserisci un comando valido");
	}

	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub
	}
	
	@Override
	public boolean equals(Object o) {
		ComandoNonValido that = (ComandoNonValido)o;
		return this.nomeComando.equals(that.getNomeComando());
	}
	
	@Override
	public int hashCode() {
		return 0;
	}

}
