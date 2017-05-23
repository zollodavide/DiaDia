package it.uniroma3.diadia.personaggi;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class CaneTest {
	
	private Stanza corrente;
	private Partita partita;
	private AbstractPersonaggio cane;
	
	@Before
	public void setUp() {
		partita = new Partita();
		corrente = new Stanza("stanzaCorrente");
		partita.setStanzaCorrente(corrente);
		cane = new Cane("cane", "pres", "osso");
		corrente.setPersonaggio(cane);
	}

	@Test
	public void testAgisci() {
		assertSame(20, this.partita.getGiocatore().getCfu());
		cane.agisci(partita);
		assertSame(19, this.partita.getGiocatore().getCfu());
	}
	
	@Test
	public void testRiceviRegalo_ConCiboPreferito() {
		Attrezzo regalo = new Attrezzo("osso", 1);
		cane.riceviRegalo(regalo, partita);
		assertTrue(corrente.hasAttrezzo("dono"));
	}
	
	@Test
	public void testRiceviRegalo_SenzaCiboPreferito() {
		Attrezzo regalo = new Attrezzo("non preferito", 1);
		cane.riceviRegalo(regalo, partita);
		assertTrue(corrente.hasAttrezzo("non preferito"));
		assertFalse(corrente.hasAttrezzo("dono"));	
	}

}
