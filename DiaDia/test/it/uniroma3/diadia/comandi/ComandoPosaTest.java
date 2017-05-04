package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import org.junit.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPosaTest {

	@Test
	public void testComandoPosa() {
		Partita corrente = new Partita();
		Stanza stanzaCorr = new Stanza("Corrente");
		corrente.setStanzaCorrente(stanzaCorr);
		Attrezzo unit = new Attrezzo("unitario", 1);
		
		assertFalse(corrente.getGiocatore().getBorsa().hasAttrezzo("unitario"));
		corrente.getGiocatore().getBorsa().addAttrezzo(unit);
		assertTrue(corrente.getGiocatore().getBorsa().hasAttrezzo("unitario"));
				
		assertFalse(corrente.getStanzaCorrente().hasAttrezzo("unitario"));

		Comando posa = new ComandoPosa();
		posa.setParametro("unitario");
		posa.esegui(corrente);
		
		assertTrue(corrente.getStanzaCorrente().hasAttrezzo("unitario"));
		
		assertFalse(corrente.getGiocatore().getBorsa().hasAttrezzo("unitario"));

	}

}
