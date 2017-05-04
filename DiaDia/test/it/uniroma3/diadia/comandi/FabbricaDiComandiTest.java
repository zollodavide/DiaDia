package it.uniroma3.diadia.comandi; 

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FabbricaDiComandiTest {

	FabbricaDiComandi factory;

	@Before
	public void setUp() {
		factory = new FabbricaDiComandiFisarmonica();
	}

	@Test
	public void testGuarda() {
		assertEquals(new ComandoGuarda() ,factory.costruisciComando("guarda"));		
	}
	
	@Test
	public void testNonValido() {
		assertEquals(new ComandoNonValido(), factory.costruisciComando("non valido"));
		
	}
	
	@Test
	public void testVuoto() {
		assertEquals(new ComandoNonValido(), factory.costruisciComando(""));
		
	}
	
	@Test
	public void testNull() {
		assertEquals(new ComandoNonValido(), factory.costruisciComando(null));
		
	}
	
	public void testVai() {
		//assertEquals(,)
	}
	
	

}
