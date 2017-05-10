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
	public Comando costruisciComando(String istruzione) {
		
		if(istruzione == null)
			return new ComandoNonValido();

		Scanner scannerDiParole = new Scanner(istruzione);
		String nomeComando = null;
		String parametro = null;
		Comando daEseguire = null;

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

		else 
			daEseguire = new ComandoNonValido();

		daEseguire.setParametro(parametro);

		return daEseguire;
	}


}
