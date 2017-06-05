package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

/**
 * Interfaccia utilizzata per trasformare i dati in input in comandi del gioco.
 * 
 * @author Davide Zollo
 * @see FabbricaDiComandiFisarmonica
 *
 */
public interface Comando {
	
	/**
	 * Metodo che esegue il comando.
	 * 
	 * @param partita corrente
	 */
	public String esegui(Partita partita);
	
	/**
	 * Metodo che imposta il parametro del comando
	 * 
	 * @param parametro
	 */
	public void setParametro(String parametro);
	
	/**
	 * Metodo che ritorna il nome del comando
	 * 
	 * @return il nome del comando
	 */
	public String getNomeComando();
	
	
	/**
	 * Metodo che ritorna il parametro del comando
	 * 
	 * @return il parametro del comando
	 */
	public String getParametro();
	
	

}
