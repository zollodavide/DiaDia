package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import org.junit.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

public class ComandoVaiTest {

	@Test
	public void testComandoVai() {
		Partita corrente = new Partita();
		Stanza stanzaCorr = new Stanza("Corrente");
		Stanza adiacente = new Stanza("Adiacente");
		
		corrente.setStanzaCorrente(stanzaCorr);
		stanzaCorr.impostaStanzaAdiacente("nord", adiacente);
		
		Comando vai = new ComandoVai();
		vai.setParametro("nord");
		vai.esegui(corrente);
		assertSame(adiacente ,corrente.getStanzaCorrente());
	}

}
