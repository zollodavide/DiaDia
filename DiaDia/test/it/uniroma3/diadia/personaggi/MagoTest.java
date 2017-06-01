package it.uniroma3.diadia.personaggi;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class MagoTest {
	Partita partita;
	Stanza corrente;
	AbstractPersonaggio mago;
	Attrezzo dono;
	
	@Before
	public void setUp() {
		partita = new Partita();
		corrente = new Stanza("corrente");
		partita.setStanzaCorrente(corrente);
		dono = new Attrezzo("dono", 1);
		mago = new Mago("mago", "pres", dono);
		
	}

	@Test
	public void testRegalo() {
		Attrezzo regalo = new Attrezzo("regalo", 2);
		mago.riceviRegalo(regalo, partita);
		assertTrue(corrente.hasAttrezzo(regalo.getNome()));
		assertEquals(new Attrezzo("regalo",1) , corrente.getAttrezzo(regalo.getNome()));
	}
	
	@Test
	public void testAgisci_EsecuzioneSingola() {
		mago.agisci(partita);
		assertTrue(corrente.hasAttrezzo("dono"));
	}
	
	@Test
	public void testAgisci_EsecuzioneDoppia() {
		mago.agisci(partita);
		assertTrue(corrente.hasAttrezzo("dono"));
		corrente.removeAttrezzo(dono);
		assertFalse(corrente.hasAttrezzo("dono"));
		mago.agisci(partita);
		assertFalse(corrente.hasAttrezzo("dono"));
	}

}
