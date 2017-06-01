package it.uniroma3.diadia;

import java.util.Scanner;

public class InterfacciaUtenteConsole implements InterfacciaUtente{

	@Override
	public void mostraMessaggio(String messaggio) {
		System.out.println(messaggio);
	}

	@SuppressWarnings("resource")
	@Override
	public String prendiIstruzione() {
		Scanner scannerDiLinee;
		scannerDiLinee = new Scanner(System.in);
		
		return scannerDiLinee.nextLine();
	}

}
