package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;
import static it.uniroma3.diadia.properties.Costanti.CFU_INIZIALI;

import org.junit.Before;
import org.junit.Test;

public class LabirintoTest {
	
	private Labirinto a; 

	@Before
	public void setUp() {
		this.a = new Labirinto();
	}

	@Test
	public void testGetStanzaIniziale() {		
		Stanza stanzaIniziale = new Stanza("stanza iniziale");
		a.setEntrata(stanzaIniziale);
		assertSame(stanzaIniziale, a.getEntrata());
	}
	
	@Test
	public void testGetStanzaVincente() {		
		Stanza stanzaVincente = new Stanza("stanza vincente");
		a.setUscita(stanzaVincente);
		assertEquals(stanzaVincente, a.getUscita());
	}

}
