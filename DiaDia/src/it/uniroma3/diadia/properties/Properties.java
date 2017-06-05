package it.uniroma3.diadia.properties;

public interface Properties {

	static final public String MESSAGGIO_BENVENUTO = ""+
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.";
	
	public static final int CFU_INIZIALI = 20;
	
	public static final int DEFAULT_PESO_MAX_BORSA = 10;
	
	final static int SOGLIA_MAGICA_DEFAULT = 3;


	public static final String MESSAGGIO_MORSO = "Il cane ti ha morso i cfu!";

	public static final String MESSAGGIO_REGALOGRADITO = "Wuf Wuf! (Il cane salta e sembra felice del tuo regalo)";

	public static final String MESSAGGIO_REGALONONGRADITO= "Grrrr! (Il cane sembra non gradire il tuo regalo)";

	public static final String MESSAGGIO_EDUCATO = "Visto che mi hai salutato, ti porterò a un luogo "
			+ "pieno di ricchezza!!";

	public static final String MESSAGGIO_MALEDUCATO = "Visto che sei un maleducato e non saluti ti"
			+ " porterò in un luogo pieno di povertà!!";

	public static final String MESSAGGIO_RISATA = "Hahahaha!! (La strega sembra di non voler ridare indietro "
			+ "l'oggetto)";

	public static final String MESSAGGIO_DONO = "Sei un vero simpaticone, " +
											     "con una mia magica azione, troverai un nuovo oggetto " +
											     "per il tuo borsone!";

	public static final String MESSAGGIO_SCUSE = "Mi spiace, ma non ho piu' nulla...";
	
	public static final String MESSAGGIO_DIMEZZA = "Ora che mi hai fatto un regalo pure io "
												  + "ne ho uno per te! Controlla la stanza";
	

}
