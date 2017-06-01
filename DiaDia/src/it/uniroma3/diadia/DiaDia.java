package it.uniroma3.diadia;


import static it.uniroma3.diadia.properties.Properties.MESSAGGIO_BENVENUTO;

import it.uniroma3.diadia.comandi.AbstractComando;
import it.uniroma3.diadia.comandi.FabbricaDiComandi;
import it.uniroma3.diadia.comandi.FabbricaDiComandiFisarmonica;
 
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

	private Partita partita;
	private InterfacciaUtente interfaccia;
	
	public DiaDia() {
		this.partita = new Partita();
		this.interfaccia = new InterfacciaUtenteConsole();
	}

	/**
	 * Inizia la partita
	 */
	public void gioca() {
		String istruzione; 
		
		this.getInterfaccia().mostraMessaggio(MESSAGGIO_BENVENUTO);
		do		
			istruzione = this.getInterfaccia().prendiIstruzione();
		
		while (!processaIstruzione(istruzione) && !this.partita.isFinita());

	}   


	public Partita getPartita() {
		return partita;
	}

	public InterfacciaUtente getInterfaccia() {
		return this.interfaccia;
	}

	/**
	 * Processa una istruzione 
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 */
	private boolean processaIstruzione(String istruzione) {

		AbstractComando daEseguire;
		FabbricaDiComandi factory = new FabbricaDiComandiFisarmonica();
		daEseguire = factory.costruisciComando(istruzione);
		this.getInterfaccia().mostraMessaggio(daEseguire.esegui(this.partita));

		if (this.partita.vinta()) 
			this.getInterfaccia().mostraMessaggio("Hai vinto!");
		
		if(!this.partita.giocatoreIsVivo() && !this.partita.vinta())
			this.getInterfaccia().mostraMessaggio("Hai finito i cfu, hai perso!");

		return this.partita.isFinita();
	}   


	public static void main(String[] argc) {
		DiaDia gioco = new DiaDia();
		gioco.gioca();
	}
}