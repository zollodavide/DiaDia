package it.uniroma3.diadia;


import java.util.Scanner;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comandi.*;
import it.uniroma3.diadia.comandi.ComandoVecchio;
 
/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il letodo gioca
 *
 * Questa e' la classe principale crea e istanzia tutte le altre
 *
 * @author  docente di POO 
 *         (da un'idea di Michael Kolling and David J. Barnes) 
 *          
 * @version base
 */ 

public class DiaDia {

	static final private String MESSAGGIO_BENVENUTO = ""+
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.";

	private Partita partita;

	public DiaDia() {
		this.partita = new Partita();
	}

	/**
	 * Inizia la partita
	 */
	public void gioca() {
		String istruzione; 
		Scanner scannerDiLinee;

		System.out.println(MESSAGGIO_BENVENUTO);
		scannerDiLinee = new Scanner(System.in);		
		do		
			istruzione = scannerDiLinee.nextLine();
		while (!processaIstruzione(istruzione) && !this.partita.isFinita());

	}   


	/**
	 * Processa una istruzione 
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 */
	private boolean processaIstruzione(String istruzione) {

		Comando daEseguire;
		FabbricaDiComandi factory = new FabbricaDiComandiFisarmonica();
		daEseguire = factory.costruisciComando(istruzione);
		daEseguire.esegui(this.partita);


		/*if(istruzione.equals("") || istruzione.isEmpty())
			System.out.println("Inserisci un comando valido");

		else { //////////////////////FABBRICACOMANDI

			ComandoVecchio comandoDaEseguire = new ComandoVecchio(istruzione);

			if(comandoDaEseguire.getNome()==(null)) {
				System.out.println("Inserisci un comando");
				return false;
			}

			else if (comandoDaEseguire.getNome().equals("fine")) {
				this.fine(); 
				return true;
			}

			else if (comandoDaEseguire.getNome().equals("vai"))
				this.vai(comandoDaEseguire.getParametro());
			else if (comandoDaEseguire.getNome().equals("aiuto"))
				this.aiuto();
			else if (comandoDaEseguire.getNome().equals("prendi"))
				this.prendi(comandoDaEseguire.getParametro());
			else if (comandoDaEseguire.getNome().equals("posa"))
				this.posa(comandoDaEseguire.getParametro());
			else 
				System.out.println("Comando sconosciuto");
		}*/

		if (this.partita.vinta()) 
			System.out.println("Hai vinto!");
		
		if(!this.partita.giocatoreIsVivo() && !this.partita.vinta())
			System.out.println("Hai finito i cfu, hai perso!");

		return this.partita.isFinita();
	}   


	public static void main(String[] argc) {
		DiaDia gioco = new DiaDia();
		gioco.gioca();
	}
}