package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita; 

/**
 * Classe che rappresenta il comando utilizzato per guardare cosa c'è dentro una stanza
 * 
 * @author Davide Zollo
 *
 */
public class ComandoGuarda implements Comando {

	private final String nomeComando;
	
	public ComandoGuarda() {
		this.nomeComando = "guarda";
	}
	
	@Override
	public void esegui(Partita partita) {
		System.out.println(partita.getStanzaCorrente().getDescrizione() + "\n");
		System.out.println(partita.getGiocatore().toString() + "\n");
	}

	@Override
	public void setParametro(String parametro) {

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
	public boolean equals(Object o) {
		ComandoGuarda that = (ComandoGuarda)o;
		return this.nomeComando.equals(that.getNomeComando());
	}
	
	@Override
	public int hashCode() {
		return 0;
	}

}
