package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import org.junit.Before;
import org.junit.Test;

public class LabirintoTest {
	
	private Labirinto a; 

	@Before
	public void setUp() {
		this.a = new Labirinto("/home/davide.zollo/git/DiaDia/DiaDia/resources/labirinto.txt");
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
