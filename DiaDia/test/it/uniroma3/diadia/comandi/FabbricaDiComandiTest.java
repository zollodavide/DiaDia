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
	public void testGuarda() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		assertEquals(new ComandoGuarda().getClass() ,factory.costruisciComando("guarda").getClass());		
	}
	
	@Test
	public void testNonValido() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		assertEquals(new ComandoNonValido().getClass(), factory.costruisciComando("non valido").getClass());
		
	}
	
	@Test
	public void testVuoto() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		assertEquals(new ComandoNonValido().getClass(), factory.costruisciComando("").getClass());
		
	}
	
	@Test
	public void testNull() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		assertEquals(new ComandoNonValido().getClass(), factory.costruisciComando(null).getClass());
		
	}
	
}
