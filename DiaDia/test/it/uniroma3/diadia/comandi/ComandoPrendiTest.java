package it.uniroma3.diadia.comandi;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendiTest {

	@Test
	public void test() {
		Partita corrente = new Partita();
		Stanza stanzaCorr = new Stanza("Corrente");
		corrente.setStanzaCorrente(stanzaCorr);

		Attrezzo unit = new Attrezzo("unitario", 1);

		assertFalse(stanzaCorr.hasAttrezzo("unitario"));

		stanzaCorr.addAttrezzo(unit);
		
		assertTrue(stanzaCorr.hasAttrezzo("unitario"));
		
		AbstractComando prendi = new ComandoPrendi();
		prendi.setParametro("unitario");
		prendi.esegui(corrente);
		
		assertFalse(corrente.getStanzaCorrente().hasAttrezzo("unitario"));
		assertTrue(corrente.getGiocatore().getBorsa().hasAttrezzo("unitario"));
		
	}

}
