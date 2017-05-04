package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaTest {
	
	private Stanza prova;
	
	@Before
	public void setUp() {
		this.prova = new Stanza("stanza");
	}

	@Test
	public void testAddAttrezzo() {
		assertTrue(prova.addAttrezzo(new Attrezzo("prova", 2)));
	}
	
	@Test
	public void testAddAttrezzoStanzaPiena() {
		Attrezzo ogg = new Attrezzo("oggetto", 1);		
		for(int i=0;i<prova.getAttrezzi().length; i++)
			prova.getAttrezzi()[i] = ogg;
		
		assertFalse(prova.addAttrezzo(new Attrezzo("prova", 2)));
	}
	
	@Test
	public void testGetStanzaAdiacente() {
		Stanza stanzaAdiacente = new Stanza("stanza ad est");
		this.prova.impostaStanzaAdiacente("est", stanzaAdiacente);
		assertEquals(stanzaAdiacente, prova.getStanzaAdiacente("est"));
	}
	
	@Test
	public void testGetStanzaAdiacenteConDirezioneSbagliata() {
		prova.impostaStanzaAdiacente("est", new Stanza("stanza ad est"));
		assertNull(prova.getStanzaAdiacente("ovest"));
	}
	
	@Test
	public void testHasAttrezzo() {
		prova.addAttrezzo(new Attrezzo("presente", 2));
		assertTrue(prova.hasAttrezzo("presente"));
	}
	
	@Test
	public void testHasAttrezzoNonPresente() {
		this.prova.addAttrezzo(new Attrezzo("presente", 2));
		assertFalse(prova.hasAttrezzo("inesistente"));
	}
	
	@Test
	public void testHasAttrezzoStringaVuota() {
		this.prova.addAttrezzo(new Attrezzo("prova", 2));
		assertFalse(prova.hasAttrezzo(""));
	}
	
	@Test
	public void testGetAttrezzo() {
		Attrezzo attrezzo = new Attrezzo("prova", 2);
		prova.addAttrezzo(attrezzo);
		assertSame(attrezzo, prova.getAttrezzo("prova"));
	}
	
	@Test
	public void testGetAttrezzoOggettoNonPresente() {
		assertNull(prova.getAttrezzo("inesistente"));
	}
	
	@Test
	public void testRemoveAttrezzo() {
		Attrezzo attrezzoDaRimuovere = new Attrezzo("prova", 2);
		this.prova.addAttrezzo(attrezzoDaRimuovere);
		assertTrue(prova.removeAttrezzo(attrezzoDaRimuovere));
	}
	
	@Test
	public void testRemoveAttrezzoNonPresente() {
		Attrezzo attrezzoNonPresente = new Attrezzo("inesistente",5); 
		assertFalse(prova.removeAttrezzo(attrezzoNonPresente));
	}
	
	@Test
	public void testRemoveAttrezzoInSecondaPosizione() {
		this.prova.addAttrezzo(new Attrezzo("attrezzo in pos 1", 2));
		Attrezzo attrezzoInPos_2 = new Attrezzo("attrezzo in pos 2",5); 	
		this.prova.addAttrezzo(attrezzoInPos_2);
		assertTrue(prova.removeAttrezzo(attrezzoInPos_2));
	}
	
	@Test
	public void testRemoveAttrezzoInPrimaPosizione() {
		Attrezzo attrezzoInPos_1 = new Attrezzo("attrezzo in pos 1", 2);
		this.prova.addAttrezzo(attrezzoInPos_1);
		this.prova.addAttrezzo(new Attrezzo("attrezzo in pos 2",5));
		assertTrue(prova.removeAttrezzo(attrezzoInPos_1));
	}
	
	
	
	

}
