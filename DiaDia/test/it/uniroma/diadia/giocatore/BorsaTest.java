package it.uniroma.diadia.giocatore;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

public class BorsaTest {
	
	private Borsa prova;

	@Before
	public void setUp() {
		this.prova = new Borsa();
	}
	
	public Borsa borsaConOggetti() {
		Borsa borsaNonVuota = new Borsa();
		
		Attrezzo attrezzo_1 = new Attrezzo("attrezzoPos1", 1);
		Attrezzo attrezzo_2 = new Attrezzo("attrezzoPos2", 2);
		Attrezzo attrezzo_3 = new Attrezzo("attrezzoPos3", 5);
		borsaNonVuota.addAttrezzo(attrezzo_1);
		borsaNonVuota.addAttrezzo(attrezzo_2);
		borsaNonVuota.addAttrezzo(attrezzo_3);
		
		return borsaNonVuota;	
	}

	@Test
	public void testGetPesoMax() {
		assertEquals(10, prova.getPesoMax());
	}
	
	@Test
	public void testGetPesoMaxCostruttoreSovraccarico() {
		Borsa borsaConPesoMaggiore = new Borsa(15);
		assertEquals(15, borsaConPesoMaggiore.getPesoMax());
	}
	
	@Test
	public void testLunghezzaListaAttrezziVuota() {
		assertEquals(0, prova.getAttrezzi().size());
	}
	
	@Test
	public void testLunghezzaListaAttrezziNonVuota() {
		prova = this.borsaConOggetti();
		assertEquals(3, prova.getAttrezzi().size());
	}
	
	@Test
	public void testHasAttrezzo() {
		prova.addAttrezzo(new Attrezzo("presente", 2));
		assertTrue(prova.hasAttrezzo("presente"));
	}
	
	@Test
	public void testHasAttrezzoConAttrezzoNonPresente() {
		assertFalse(prova.hasAttrezzo("inesistente"));
	}
	
	@Test
	public void testHasAttrezzoConStringaNulla() {
		assertFalse(prova.hasAttrezzo(null));
	}
	
	@Test
	public void testAddAttrezzo() {
		Attrezzo attrezzoDaAggiungere = new Attrezzo("attrezzo", 1);
		assertTrue(prova.addAttrezzo(attrezzoDaAggiungere));
		assertTrue(prova.hasAttrezzo(attrezzoDaAggiungere.getNome()));
	}
	
	@Test
	public void testAddAttrezzoConAttrezzoNullo() {
		Attrezzo attrezzoNullo = null;
		assertFalse(prova.addAttrezzo(attrezzoNullo));
	}
	
	@Test
	public void testAddAttrezzoConAttrezzoSenzaNome() {
		assertFalse(prova.addAttrezzo(new Attrezzo("", 9)));
	}
	
	@Test
	public void testAddAttrezzoConPesoMax() {
		prova.addAttrezzo(new Attrezzo("spadone",10));
		Attrezzo inaggiungibile = new Attrezzo("oggetto", 4);
		assertFalse(prova.addAttrezzo(inaggiungibile));
	}
	
	/*@Test
	public void testAddAttrezzoConBorsaPiena() {
		Attrezzo attrezzo = new Attrezzo("att", 1);
		for(int i=0; i<prova.getAttrezzi().len; i++)
			prova.addAttrezzo(attrezzo);
		
		assertFalse(prova.addAttrezzo(attrezzo));	
	}*/
	
	@Test
	public void testAddAttrezzoConPesoComplessivoMaggioreDelMassimo() {
		prova.addAttrezzo(new Attrezzo("attrezzo pesante",9));
		assertFalse(prova.addAttrezzo(new Attrezzo("oggetto", 2)));	
	}
	
	@Test
	public void testGetPeso() {
		prova = this.borsaConOggetti();
		assertEquals(8, prova.getPeso());
	}
	
	@Test
	public void testGetPesoBorsaVuota() {
		assertEquals(0, prova.getPeso());
	}
	
	@Test
	public void testGetAttrezzo() {
		prova = this.borsaConOggetti();
		assertNotNull(prova.getAttrezzo("attrezzoPos1"));
	}
	
	@Test
	public void testGetAttrezzoNonEsistente() {
		prova = this.borsaConOggetti();
		assertNull(prova.getAttrezzo("inesistente"));
	}
	
	@Test
	public void testGetAttrezzoStringaVuota() {
		prova = this.borsaConOggetti();
		assertNull(prova.getAttrezzo(""));
	}
	
	@Test
	public void testGetAttrezzoStringaNulla() {
		prova = this.borsaConOggetti();
		assertNull(prova.getAttrezzo(null));
	}
	
	@Test
	public void testGetAttrezzoBorsaVuota() {
		assertNull(prova.getAttrezzo("inesistente"));
	}
	
	@Test
	public void testRemoveAttrezzo() {
		prova = this.borsaConOggetti();
		assertNotNull(prova.removeAttrezzo("attrezzoPos1"));
	}
	
	@Test
	public void testRemoveAttrezzoNonPresente() {
		prova = this.borsaConOggetti();
		assertNull(prova.removeAttrezzo("inesistente"));
	}
	
	@Test
	public void testRemoveAttrezzoStringaVuota() {
		assertNull(prova.removeAttrezzo(""));
	}
	
	@Test
	public void testRemoveAttrezzoNull() {
		String stringaNulla = null;
		assertNull(prova.removeAttrezzo(stringaNulla));
	}
	
	@Test
	public void testGetContenutoPerPeso() {
		Attrezzo attrezzo_1 = new Attrezzo("attrezzoPos1", 5);
		Attrezzo attrezzo_2 = new Attrezzo("attrezzoPos2", 2);
		Attrezzo attrezzo_3 = new Attrezzo("attrezzoPos3", 3);
		prova.addAttrezzo(attrezzo_1);
		prova.addAttrezzo(attrezzo_2);
		prova.addAttrezzo(attrezzo_3);
		List<Attrezzo> ordinato = prova.getContenutoOrdinatoPerPeso();
		assertEquals(attrezzo_2, ordinato.get(0));
		assertEquals(attrezzo_3, ordinato.get(1));
		assertEquals(attrezzo_1, ordinato.get(2));
		
	}
	
}
