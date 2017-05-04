package it.uniroma.diadia.giocatore;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.giocatore.Borsa;
import it.uniroma3.diadia.giocatore.Giocatore;

public class GiocatoreTest {
	
	private Giocatore prova;

	@Before
	public void setUp() {
		this.prova = new Giocatore();
	}

	@Test
	public void testGetCfuIniziali() {
		assertEquals(20, prova.getCfu());
	}
	
	@Test
	public void testGetCfuAggiornati() {
		this.prova.setCfu(10);
		assertEquals(10, prova.getCfu());
	}
	
	@Test
	public void testGetBorsaMedianteDescrizione() {
		Borsa borsaVuota = new Borsa();
		assertEquals(borsaVuota.toString(),this.prova.getBorsa().toString());
	}

}
