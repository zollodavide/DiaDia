package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

/**
 * Classe che rappresenta il comando che stampa informazioni di aiuto.
 */
public class ComandoAiuto implements Comando {
	
	private final String nomeComando;
	
	public ComandoAiuto() {
		this.nomeComando = "aiuto";
	}

	static final private String[] elencoComandi = {"vai", "aiuto", "fine", "prendi" , "posa", "guarda"};
	
	@Override
	public void esegui(Partita partita) {
		for(int i=0; i< elencoComandi.length; i++) 
			System.out.print(elencoComandi[i]+" ");
		System.out.println();
	}
	
	@Override
	public String getNomeComando() {
		return nomeComando;
	}
	
	@Override
	public String getParametro() {
		return null;
	}

	@Override
	public void setParametro(String parametro) {

	}
	
	@Override
	public boolean equals(Object o) {
		ComandoAiuto that = (ComandoAiuto)o;
		return this.nomeComando.equals(that.getNomeComando());
	}
	
	@Override
	public int hashCode() {
		return 0;
	}
	
	
	
	

}
