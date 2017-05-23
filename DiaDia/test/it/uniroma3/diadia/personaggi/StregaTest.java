package it.uniroma3.diadia.personaggi;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StregaTest {
	
	Partita partita;
	private AbstractPersonaggio strega;
	private Stanza stanzaConMenoAttrezzi;
	private Stanza corrente;
	
	public StregaTest() {
	}

	@Before
	public void setUp() {
		this.partita = new Partita();
		this.corrente = new Stanza("corrente");
		this.strega = new Strega("st", "pres");
		this.stanzaConMenoAttrezzi = new Stanza("vicina");
		partita.setStanzaCorrente(corrente);
		corrente.setPersonaggio(strega);
		corrente.impostaStanzaAdiacente("nord", stanzaConMenoAttrezzi);
		stanzaConMenoAttrezzi.addAttrezzo(new Attrezzo("att", 1));

	}

	@Test
	public void testStrega_StanzaDoubletonSenzaSalutare() {				
		Stanza stanzaConPiuAttrezzi = new Stanza("aEst");
		corrente.impostaStanzaAdiacente("est", stanzaConPiuAttrezzi);
		
		assertTrue(stanzaConPiuAttrezzi.addAttrezzo(new Attrezzo("aas", 1)));
		assertTrue(stanzaConPiuAttrezzi.addAttrezzo(new Attrezzo("sda", 1)));
		
		strega.agisci(partita);
		
		assertSame(stanzaConMenoAttrezzi, partita.getStanzaCorrente());
	}
	
	@Test
	public void testStrega_StanzaDoubletonSalutando() {
		Stanza stanzaConPiuAttrezzi = new Stanza("aEst");
		corrente.impostaStanzaAdiacente("est", stanzaConPiuAttrezzi);
		
		assertTrue(stanzaConPiuAttrezzi.addAttrezzo(new Attrezzo("aas", 1)));
		assertTrue(stanzaConPiuAttrezzi.addAttrezzo(new Attrezzo("sda", 1)));
		
		strega.saluta();
		strega.agisci(partita);
		
		assertSame(stanzaConPiuAttrezzi, partita.getStanzaCorrente());	
	}
	
	@Test
	public void testStrega_StanzaSingleton() {
		assertSame(corrente, partita.getStanzaCorrente());
		strega.agisci(partita);
		assertSame(stanzaConMenoAttrezzi, partita.getStanzaCorrente());
	}
}
