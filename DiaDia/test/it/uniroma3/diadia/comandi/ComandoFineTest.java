package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.Partita;

public class ComandoFineTest {

	

	@Test
	public void test() {
		Partita corrente = new Partita();
		assertFalse(corrente.isFinita());
		Comando fine = new ComandoFine();
		fine.esegui(corrente);
		assertTrue(corrente.isFinita());
	}

}
