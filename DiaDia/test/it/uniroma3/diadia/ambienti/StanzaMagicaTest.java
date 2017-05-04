package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaMagicaTest {
	
	private StanzaMagica stanzaSoglia2;
	private Attrezzo chiave;
	private Attrezzo spada;

	@Before
	public void setUp(){
		
		stanzaSoglia2 = new StanzaMagica("magica",1);
		chiave = new Attrezzo("chiave",1);
		spada = new Attrezzo("spada", 2);
		
	}

	@Test
	public void test_addAttrezzo_sottoLaSoglia() {
		stanzaSoglia2.addAttrezzo(chiave);
		assertTrue(stanzaSoglia2.hasAttrezzo("chiave"));
		
	}
	

	@Test
	public void test_addAttrezzo_sopraLaSoglia() {
		stanzaSoglia2.addAttrezzo(chiave);
		stanzaSoglia2.addAttrezzo(spada);
		assertTrue(stanzaSoglia2.hasAttrezzo("chiave"));
		assertFalse(stanzaSoglia2.hasAttrezzo("spada"));
		assertTrue(stanzaSoglia2.hasAttrezzo("adaps"));
		assertTrue(stanzaSoglia2.getAttrezzo("adaps").getPeso() == 4);
		
	}

}
