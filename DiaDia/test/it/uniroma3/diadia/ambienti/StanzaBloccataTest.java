package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBloccataTest {

	@Before
	public void setUp() {
	}

	@Test
	public void testGetStanzaAdiacente() {
		StanzaBloccata vuota= new StanzaBloccata("vuota", "chiave", "nord");
		assertSame(vuota, vuota.getStanzaAdiacente("nord"));
	}
	@Test
	public void testGetStanzaAdiacenteSbloccata() {
		StanzaBloccata sbloccata= new StanzaBloccata("vuota", "chiave", "nord");
		Stanza adiacente= new Stanza("vicina");
		sbloccata.impostaStanzaAdiacente("nord", adiacente);
		Attrezzo chiave= new Attrezzo ("chiave",2);
		sbloccata.addAttrezzo(chiave);
		assertSame(adiacente, sbloccata.getStanzaAdiacente("nord"));
	}
	@Test
	public void testGetStanzaAdiacente_DirezioneNonBloccata() {
		StanzaBloccata sbloccata= new StanzaBloccata("vuota", "chiave", "nord");
		Stanza adiacente= new Stanza("vicina");
		sbloccata.impostaStanzaAdiacente("sud", adiacente);
		Attrezzo chiave= new Attrezzo ("chiave",2);
		sbloccata.addAttrezzo(chiave);
		assertSame (adiacente, sbloccata.getStanzaAdiacente("sud"));
	}

}
