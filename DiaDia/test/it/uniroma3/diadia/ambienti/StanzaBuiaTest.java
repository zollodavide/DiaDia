package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBuiaTest {
	
	final static private String STAMPA_BUIO = "Qui c'è un buio pesto!";
	private StanzaBuia stanzaBuia;
	private Attrezzo lanterna;

	@Before
	public void setUp() {
		stanzaBuia = new StanzaBuia("buia", "lanterna");
		lanterna = new Attrezzo("lanterna", 1);
	}

	@Test
	public void test_getDescrizione_senzaAttrezzoValido(){
		assertEquals(STAMPA_BUIO, stanzaBuia.getDescrizione());
	}

	@Test
	public void test_getDescrizione_conAttrezzoValido(){
		assertEquals(STAMPA_BUIO, stanzaBuia.getDescrizione());
		stanzaBuia.addAttrezzo(lanterna);
		assertFalse(STAMPA_BUIO.equals(stanzaBuia.getDescrizione()));
	}
}
