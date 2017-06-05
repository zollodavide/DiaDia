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
		assertEquals(new ComandoGuarda().getClass() ,factory.costruisciComando("guarda").getClass());		
	}
	
	@Test
	public void testNonValido() {
		assertEquals(new ComandoNonValido().getClass(), factory.costruisciComando("non valido").getClass());
		
	}
	
	@Test
	public void testVuoto() {
		assertEquals(new ComandoNonValido().getClass(), factory.costruisciComando("").getClass());
		
	}
	
	@Test
	public void testNull() {
		assertEquals(new ComandoNonValido().getClass(), factory.costruisciComando(null).getClass());
		
	}
	
}
