package it.uniroma3.diadia.ambienti;

import java.io.FileNotFoundException;

import it.uniroma3.diadia.Partita;

/**
 * Questa classe ha la responsabilit� di creare il labirinto del gioco,
 * cio� di creare e collegare tutte le stanze. Inoltre, memorizza la stanza
 * vincente e quella iniziale.
 * 
 * @author Davide Zollo & Fabio Ramohitaj
 * @see Stanza
 * @see Partita
 * @version Base
 */
public class Labirinto {
	
	private Stanza entrata;
	private Stanza uscita;
	private CaricatoreLabirinto caricatore;
		
	/**
	 * Crea il Labirinto
	 * @param La stanza iniziale del gioco
	 * @param La stanza finale o vincente del gioco
	 * 
	 */
    public Labirinto(String nomeFile) {
    	try {
			caricatore = new CaricatoreLabirinto(nomeFile);
			caricatore.carica();
			this.entrata = caricatore.getStanzaIniziale();
	    	this.uscita =  caricatore.getStanzaVincente();
    	}
    	catch (FileNotFoundException e) {
			e.printStackTrace();
		}
    	catch (FormatoFileNonValidoException e) {
			e.printStackTrace();
		}
	}
    
    /**
     * Crea tutte le stanze e i collegamenti tra esse aggiungendo 
     * tutti gli attrezzi presenti nel gioco
     */
//	private void init() {
//
//		/* crea gli attrezzi */
//    	Attrezzo lanterna = new Attrezzo("lanterna",3);
//		Attrezzo osso = new Attrezzo("osso",1);
//		Attrezzo tazza = new Attrezzo("tazzina", 2);
//		Attrezzo spada = new Attrezzo("spada", 10);
//    	
//		/* crea stanze del labirinto */
//		Stanza atrio = new Stanza("Atrio");
//		Stanza aulaN11 = new Stanza("Aula N11");
//		Stanza aulaN10 = new Stanza("Aula N10");
//		Stanza laboratorio = new Stanza("Aula Campus");
//		Stanza biblioteca = new Stanza("Biblioteca");
//		Stanza aulaN12 = new Stanza("Aula N12");
//		Stanza aulaN13 = new StanzaMagica("Aula N13");
//		Stanza aulaN9 = new Stanza("Aula N9");
//		Stanza portineria = new StanzaBuia("Portineria", "lanterna");
//		Stanza bagni = new Stanza("Bagni");
//		Stanza aulaDs2 = new Stanza("Aula DS2");
//		Stanza macchinette = new Stanza("Macchinette");
//		Stanza capannoni = new Stanza("Capannoni");
//		
//		/* crea i personaggi */
//		AbstractPersonaggio mago = new Mago("Mago Merlino", "", lanterna);
//
//		
//		/* collega le stanze */
//		atrio.impostaStanzaAdiacente("nord", aulaN10);
//		atrio.impostaStanzaAdiacente("est", aulaN13);
//		atrio.impostaStanzaAdiacente("sud", aulaN11);
//		atrio.impostaStanzaAdiacente("ovest", portineria);
//		
//		portineria.impostaStanzaAdiacente("est", atrio);
//		
//		aulaN11.impostaStanzaAdiacente("nord", atrio);
//		aulaN11.impostaStanzaAdiacente("sud", aulaN9);
//		
//		aulaN10.impostaStanzaAdiacente("nord", bagni);
//		aulaN10.impostaStanzaAdiacente("sud", atrio);
//		
//		aulaN13.impostaStanzaAdiacente("ovest", atrio);
//		aulaN13.impostaStanzaAdiacente("est", aulaDs2);
//		
//		bagni.impostaStanzaAdiacente("sud", aulaN10);
//		
//		aulaN9.impostaStanzaAdiacente("nord", aulaN11);
//		aulaN9.impostaStanzaAdiacente("est", aulaN12);
//		
//		aulaN12.impostaStanzaAdiacente("ovest", aulaN9);
//		aulaN12.impostaStanzaAdiacente("est", laboratorio);
//		
//		laboratorio.impostaStanzaAdiacente("nord", aulaDs2);
//		laboratorio.impostaStanzaAdiacente("ovest", aulaN12);
//		
//		aulaDs2.impostaStanzaAdiacente("ovest", aulaN13);
//		aulaDs2.impostaStanzaAdiacente("sud", laboratorio);
//		aulaDs2.impostaStanzaAdiacente("nord", macchinette);
//		
//		macchinette.impostaStanzaAdiacente("nord", capannoni);
//		macchinette.impostaStanzaAdiacente("sud", aulaDs2);
//		macchinette.impostaStanzaAdiacente("est", biblioteca);
//		
//		capannoni.impostaStanzaAdiacente("sud", macchinette);
//		
//		biblioteca.impostaStanzaAdiacente("ovest", macchinette);
//
//        /* pone gli attrezzi nelle stanze */
//		atrio.addAttrezzo(osso);
//		atrio.addAttrezzo(tazza);
//		atrio.addAttrezzo(spada);
//		
//		/* settaggio dei personaggi nelle stanze */
//		atrio.setPersonaggio(mago);
//
//		/* il gioco comincia nell'atrio */
//       entrata = atrio;  
//       uscita = biblioteca;
//    }
	
	/**
	 * Imposta la stanza vincente del gioco
	 * @param uscita
	 */
	public void setUscita(Stanza stanzaVincente) {
		this.uscita = stanzaVincente;
	}
	
	/**
	 * Restituisce la stanza vincente del gioco
	 * @return la stanza vincente
	 */
	public Stanza getUscita() {
		return this.uscita;
	}
	
	/**
	 * Imposta la stanza in cui ti trovi all'inizio del gioco
	 * @param entrata 
	 */
	public void setEntrata(Stanza stanzaIniziale) {
		this.entrata = stanzaIniziale;
	}
	
	/**
	 * Restituisce la stanza corrente del gioco
	 * @return la stanza corrente del gioco
	 */
	public Stanza getEntrata() {
		return this.entrata;
	}

}
