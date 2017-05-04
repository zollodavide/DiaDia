package it.uniroma3.diadia;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.Stanza;

public class PartitaTest {
	
	private Partita prova;
	
	@Before
	public void setUp() {		
		this.prova = new Partita();	
	}
	
	@Test
	public void testGetStanzaCorrente() {
		Stanza stanzaCorrente = new Stanza("stanza corrente");
		this.prova.setStanzaCorrente(stanzaCorrente);
		assertSame(stanzaCorrente, prova.getStanzaCorrente());
	}

	@Test
	public void testGetStanzaCorrenteQuandoSeiNellaStanzaIniziale() {
		assertSame(this.prova.getLabirinto().getEntrata() ,prova.getStanzaCorrente());
		
	}
	
	@Test
	public void testVinta() {
		this.prova.setStanzaCorrente(this.prova.getLabirinto().getUscita());
		assertTrue(this.prova.vinta());
	}
	
	@Test
	public void testVintaQuandoNonVinta() {
		assertFalse(this.prova.vinta());
	}
	
	@Test
	public void testFinita() {
		this.prova.setFinita();
		assertTrue(this.prova.isFinita());
	}
	
	@Test
	public void testVintaQuandoFinita() {
		this.prova.setFinita();
		assertFalse(this.prova.vinta());
	}
	
	@Test
	public void testFinitaQuandoCfuZero() {
		this.prova.getGiocatore().setCfu(0);
		assertTrue(this.prova.isFinita());
	}
	
	@Test
	public void testVintaEFinitaAlloStessoTempo() {
		this.prova.setFinita();
		this.prova.setStanzaCorrente(this.prova.getLabirinto().getUscita());
		assertTrue(this.prova.vinta() && this.prova.isFinita());
	}
	
	

}
