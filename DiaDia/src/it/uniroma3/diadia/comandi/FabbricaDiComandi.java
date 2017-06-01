package it.uniroma3.diadia.comandi;

public interface FabbricaDiComandi {
	/**
	 * Metodo che costruisce il comando data un istruzione in input
	 * 
	 * @param l'istruzione corrente
	 * @return il comando costruito
	 */
	public AbstractComando costruisciComando(String istruzione);	
}

