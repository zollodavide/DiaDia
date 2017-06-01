package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public abstract class AbstractComando {
	
	private String nome;
	private String parametro;

	public AbstractComando(String nome) {
		this.nome = nome;
	}
	
	abstract public String esegui(Partita partita);

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getParametro() {
		return null;
	}

	public void setParametro(String parametro) {
	}
	
}
