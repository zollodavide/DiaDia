package it.uniroma3.diadia;


import static it.uniroma3.diadia.properties.Properties.MESSAGGIO_BENVENUTO;

import java.io.FileNotFoundException;

import it.uniroma3.diadia.ambienti.FormatoFileNonValidoException;
import it.uniroma3.diadia.comandi.AbstractComando;
import it.uniroma3.diadia.comandi.FabbricaDiComandi;
import it.uniroma3.diadia.comandi.FabbricaDiComandiFisarmonica;
import it.uniroma3.diadia.comandi.FabbricaDiComandiRiflessiva;
 
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
	
	public DiaDia() throws FileNotFoundException, FormatoFileNonValidoException {
		this.partita = new Partita();
		this.interfaccia = new InterfacciaUtenteConsole();
	}

	/**
	 * Inizia la partita
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
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
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	private boolean processaIstruzione(String istruzione) {

		AbstractComando daEseguire;
		FabbricaDiComandi factory = new FabbricaDiComandiRiflessiva();
		daEseguire = factory.costruisciComando(istruzione);
		this.getInterfaccia().mostraMessaggio(daEseguire.esegui(this.partita));

		if (this.partita.vinta()) 
			this.getInterfaccia().mostraMessaggio("Hai vinto!");
		
		if(!this.partita.giocatoreIsVivo() && !this.partita.vinta())
			this.getInterfaccia().mostraMessaggio("Hai finito i cfu, hai perso!");

		return this.partita.isFinita();
	}   


	public static void main(String[] argc) throws FileNotFoundException, FormatoFileNonValidoException {
		DiaDia gioco = new DiaDia();
		gioco.gioca();
	}
}