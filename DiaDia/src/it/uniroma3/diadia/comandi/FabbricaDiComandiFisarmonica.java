package it.uniroma3.diadia.comandi;

import java.util.Scanner;

/**
 * Classe che prendendo i dati da input si occupa di costruire l'opportuno comando.
 * 
 * @author Davide Zollo
 * 
 */
public class FabbricaDiComandiFisarmonica implements FabbricaDiComandi{

	/**
	 * Factory method che restituisce l'opportuno comando data una string in input.
	 * 
	 * @param stringa contente l'informazione (comando e parametro)
	 * @return l'opportuno comando
	 */
	public AbstractComando costruisciComando(String istruzione) {
		
		if(istruzione == null)
			return new ComandoNonValido();

		@SuppressWarnings("resource")
		Scanner scannerDiParole = new Scanner(istruzione);
		String nomeComando = null;
		String parametro = null;
		AbstractComando daEseguire;

		// prima parola: nome del comando
		if (scannerDiParole.hasNext())
			nomeComando = scannerDiParole.next(); 

		// seconda parola: eventuale parametro
		if (scannerDiParole.hasNext())
			parametro = scannerDiParole.next();
 
		
		if (nomeComando == null)
			daEseguire = new ComandoNonValido();

		else if (nomeComando.equals("vai"))
			daEseguire = new ComandoVai();

		else if (nomeComando.equals("prendi"))
			daEseguire = new ComandoPrendi();

		else if (nomeComando.equals("posa"))
			daEseguire = new ComandoPosa();

		else if (nomeComando.equals("aiuto"))
			daEseguire = new ComandoAiuto();

		else if (nomeComando.equals("fine"))
			daEseguire = new ComandoFine();

		else if (nomeComando.equals("guarda"))
			daEseguire = new ComandoGuarda();
		
		else if (nomeComando.equals("saluta"))
			daEseguire = new ComandoSaluta();
		
		else if (nomeComando.equals("interagisci"))
			daEseguire = new ComandoInteragisci();
		
		else if (nomeComando.equals("regala"))
			daEseguire = new ComandoRegala();
		
		else 
			daEseguire = new ComandoNonValido();

		daEseguire.setParametro(parametro);

		return daEseguire;
	}


}
