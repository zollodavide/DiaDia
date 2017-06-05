package it.uniroma3.diadia.ambienti;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.personaggi.AbstractPersonaggio;
import it.uniroma3.diadia.personaggi.Cane;
import it.uniroma3.diadia.personaggi.Mago;
import it.uniroma3.diadia.personaggi.Strega;

public class CaricatoreLabirinto {

	/* prefisso di una singola riga di testo contenente tutti i nomi delle stanze */
	private static final String STANZE_MARKER = "Stanze:";             

	/* prefisso di una singola riga contenente il nome della stanza iniziale */
	private static final String STANZA_INIZIALE_MARKER = "Inizio:";    

	/* prefisso della riga contenente il nome stanza vincente */
	private static final String STANZA_VINCENTE_MARKER = "Vincente:";  

	/* prefisso della riga contenente le specifiche degli attrezzi da collocare nel formato <nomeAttrezzo> <peso> <nomeStanza> */
	private static final String ATTREZZI_MARKER = "Attrezzi:";

	/* prefisso della riga contenente le specifiche dei collegamenti tra stanza nel formato <nomeStanzaDa> <direzione> <nomeStanzaA> */
	private static final String USCITE_MARKER = "Uscite:";
	
	private static final String PERSONAGGI_MARKER = "Personaggi:";

	/*
	 *  Esempio di un possibile file di specifica di un labirinto (vedi POO-26-eccezioni-file.pdf)

		Stanze: biblioteca, N10, N11
		Inizio: N10
		Vincente: N11
		Attrezzi: martello 10 biblioteca, pinza 2 N10
		Uscite: biblioteca nord N10, biblioteca sud N11

	 */
	private LineNumberReader reader;

	private Map<String, Stanza> nome2stanza;

	private Stanza stanzaIniziale;
	private Stanza stanzaVincente;


	public CaricatoreLabirinto(String nomeFile) throws FileNotFoundException {
		this.nome2stanza = new HashMap<String,Stanza>();
		this.reader = new LineNumberReader(new FileReader(nomeFile));
	}

	public void carica() throws FormatoFileNonValidoException {
		try {
			this.leggiECreaStanze();
			this.leggiInizialeEvincente();
			this.leggiECollocaAttrezzi();
			this.leggiEImpostaUscite();
			this.leggiEImpostaPersonaggi();
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}

	}

	private String leggiRigaCheCominciaPer(String marker) throws FormatoFileNonValidoException {
		try {
			String riga = this.reader.readLine();
			check(riga.startsWith(marker),"era attesa una riga che cominciasse per "+marker);
			return riga.substring(marker.length());
		} catch (IOException e) {
			throw new FormatoFileNonValidoException(e.getMessage());
		}
	}

	private void leggiECreaStanze() throws FormatoFileNonValidoException  {
		String nomiStanze = this.leggiRigaCheCominciaPer(STANZE_MARKER);
		
		for(String specificheStanza : separaStringheAlleVirgole(nomiStanze)) {
			String nomeStanza = null;
			String tipoStanza = null;
			Stanza stanza = null;
			
			Scanner scannerLinea = new Scanner(specificheStanza);	
			check(scannerLinea.hasNext(),msgTerminazionePrecoce("il nome della stanza da creare"));
			nomeStanza = scannerLinea.next();
			if(scannerLinea.hasNext()) {
				tipoStanza = scannerLinea.next();

				if(tipoStanza.equals("Magica")) {
					if(!scannerLinea.hasNext())
						stanza = new StanzaMagica(nomeStanza);
					else {
						String soglia = scannerLinea.next();
						stanza = new StanzaMagica(nomeStanza, Integer.parseInt(soglia));
					}
				}
				if(tipoStanza.equals("Bloccata")) {
					check(scannerLinea.hasNext(),msgTerminazionePrecoce("il nome dell'attrezzo sbloccante della stanza da creare"));
					String sbloccante = scannerLinea.next();
					check(scannerLinea.hasNext(),msgTerminazionePrecoce("la direzione bloccata della stanza da creare"));
					String bloccata = scannerLinea.next();
					stanza = new StanzaBloccata(nomeStanza, sbloccante, bloccata);
					System.out.println(nomeStanza);
				}
				if(tipoStanza.equals("Buia")) {
					check(scannerLinea.hasNext(),msgTerminazionePrecoce("il nome dell'attrezzo luminoso della stanza da creare"));
					String luminoso = scannerLinea.next();
					stanza = new StanzaBuia(nomeStanza, luminoso);
				}

			}
			
			else 
				stanza = new Stanza(nomeStanza);
			
			if(stanza!=null)
				this.nome2stanza.put(nomeStanza, stanza);
			
			scannerLinea.close();
		}
		
		System.out.println(this.nome2stanza.keySet());
	}
	
	private List<String> separaStringheAlleVirgole(String string) {
		List<String> result = new LinkedList<>();
		Scanner scanner = new Scanner(string);
		scanner.useDelimiter(",");
		try (Scanner scannerDiParole = scanner) {
			while(scannerDiParole.hasNext())
			result.add(scannerDiParole.next());
		}
		return result;
	}


	private void leggiInizialeEvincente() throws FormatoFileNonValidoException {
		String nomeStanzaIniziale = null;
		nomeStanzaIniziale = this.leggiRigaCheCominciaPer(STANZA_INIZIALE_MARKER);

		check(this.isStanzaValida(nomeStanzaIniziale), nomeStanzaIniziale +" non definita");
		String nomeStanzaVincente = this.leggiRigaCheCominciaPer(STANZA_VINCENTE_MARKER);

		check(this.isStanzaValida(nomeStanzaVincente), nomeStanzaVincente + " non definita");
		this.stanzaIniziale = this.nome2stanza.get(nomeStanzaIniziale);
		this.stanzaVincente = this.nome2stanza.get(nomeStanzaVincente);
	}

	private void leggiECollocaAttrezzi() throws FormatoFileNonValidoException {
		String specificheAttrezzi = this.leggiRigaCheCominciaPer(ATTREZZI_MARKER);

		for(String specificaAttrezzo : separaStringheAlleVirgole(specificheAttrezzi)) {
			String nomeAttrezzo = null;
			String pesoAttrezzo = null;
			String nomeStanza = null; 
			try (Scanner scannerLinea = new Scanner(specificaAttrezzo)) {
				check(scannerLinea.hasNext(),msgTerminazionePrecoce("il nome di un attrezzo."));
				nomeAttrezzo = scannerLinea.next();
				check(scannerLinea.hasNext(),msgTerminazionePrecoce("il peso dell'attrezzo "+nomeAttrezzo+"."));
				pesoAttrezzo = scannerLinea.next();
				check(scannerLinea.hasNext(),msgTerminazionePrecoce("il nome della stanza in cui collocare l'attrezzo "+nomeAttrezzo+"."));
				nomeStanza = scannerLinea.next();
			}				
			posaAttrezzo(nomeAttrezzo, pesoAttrezzo, nomeStanza);
		}
	}
	
	private void leggiEImpostaPersonaggi() throws FormatoFileNonValidoException {
		String specifichePersonaggi = this.leggiRigaCheCominciaPer(PERSONAGGI_MARKER);

		for(String specificaPersonaggio : separaStringheAlleVirgole(specifichePersonaggi)) {
			String tipoPersonaggio = null;
			String nomePersonaggio = null;
			String nomeStanza = null;
			Object aggiuntivo = null;
			
			try (Scanner scannerLinea = new Scanner(specificaPersonaggio)) {
				check(scannerLinea.hasNext(),msgTerminazionePrecoce("il tipo di un personaggio."));
				tipoPersonaggio = scannerLinea.next();
				check(scannerLinea.hasNext(),msgTerminazionePrecoce("il nome della stanza in cui collocare il personaggio "+tipoPersonaggio+"."));
				nomeStanza = scannerLinea.next();
				check(scannerLinea.hasNext(),msgTerminazionePrecoce("il nome di un personaggio."));
				nomePersonaggio = scannerLinea.next();

				if(tipoPersonaggio.equals("Cane")) {
					check(scannerLinea.hasNext(),msgTerminazionePrecoce("il cibo preferito del cane"));
					aggiuntivo = scannerLinea.next();
				}
				
				if(tipoPersonaggio.equals("Mago")) {
					check(scannerLinea.hasNext(),msgTerminazionePrecoce("il nome dell'attrezzo del mago"));
					String ausiliare1 = scannerLinea.next();
					check(scannerLinea.hasNext(),msgTerminazionePrecoce("il peso dell'attrezzo del mago"));
					String ausiliare2 = scannerLinea.next();
					aggiuntivo = new Attrezzo(ausiliare1, Integer.parseInt(ausiliare2));
				}

			}
			
			try {
				
				StringBuilder nomeClasse = new StringBuilder("it.uniroma3.diadia.personaggi.");
				nomeClasse.append(tipoPersonaggio);
				Class<?> personaggio = (Class<?>) Class.forName(nomeClasse.toString());

				creaEImpostaPersonaggio(personaggio, nomeStanza, nomePersonaggio, aggiuntivo);
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
		}
		
		
	}

	private void creaEImpostaPersonaggio(Class<?> tipo, String nomeStanza, String nomePersonaggio, Object aggiuntivo) throws FormatoFileNonValidoException  {
		AbstractPersonaggio personaggio = null;

		check(isStanzaValida(nomeStanza),"Personaggio "+ nomePersonaggio+" non collocabile: stanza " +nomeStanza+" inesistente");

		if(tipo == Cane.class)
			personaggio = new Cane(nomePersonaggio, "", (String)aggiuntivo);
		else if(tipo == Strega.class)
			personaggio = new Strega(nomePersonaggio, "");
		else if(tipo == Mago.class) 
			personaggio = new Mago(nomePersonaggio, "", (Attrezzo)aggiuntivo);

		if(personaggio!=null)
			this.nome2stanza.get(nomeStanza).setPersonaggio(personaggio);

	}

	private void posaAttrezzo(String nomeAttrezzo, String pesoAttrezzo, String nomeStanza) throws FormatoFileNonValidoException {
		int peso;
		try {
			peso = Integer.parseInt(pesoAttrezzo);
			Attrezzo attrezzo = new Attrezzo(nomeAttrezzo, peso);
			check(isStanzaValida(nomeStanza),"Attrezzo "+ nomeAttrezzo+" non collocabile: stanza " +nomeStanza+" inesistente");
			this.nome2stanza.get(nomeStanza).addAttrezzo(attrezzo);
		}
		catch (NumberFormatException e) {
			check(false, "Peso attrezzo "+nomeAttrezzo+" non valido");
		}
	}


	private boolean isStanzaValida(String nomeStanza) {
		return this.nome2stanza.containsKey(nomeStanza);
	}

	private void leggiEImpostaUscite() throws FormatoFileNonValidoException {
		String specificheUscite = this.leggiRigaCheCominciaPer(USCITE_MARKER);
		try (Scanner scannerDiLinea = new Scanner(specificheUscite)) {			

			while (scannerDiLinea.hasNext()) {
				check(scannerDiLinea.hasNext(),msgTerminazionePrecoce("le uscite di una stanza."));
				String stanzaPartenza = scannerDiLinea.next();
				check(scannerDiLinea.hasNext(),msgTerminazionePrecoce("la direzione di una uscita della stanza "+stanzaPartenza));
				String dir = scannerDiLinea.next();
				check(scannerDiLinea.hasNext(),msgTerminazionePrecoce("la destinazione di una uscita della stanza "+stanzaPartenza+" nella direzione "+dir));
				String stanzaDestinazione = scannerDiLinea.next();
				
				impostaUscita(stanzaPartenza, dir, stanzaDestinazione);
			}
		} 
	}
	
	private String msgTerminazionePrecoce(String msg) {
		return "Terminazione precoce del file prima di leggere "+msg;
	}

	private void impostaUscita(String stanzaDa, String dir, String nomeA) throws FormatoFileNonValidoException {

		check(isStanzaValida(stanzaDa),"Stanza di partenza sconosciuta "+dir);
		check(isStanzaValida(nomeA),"Stanza di destinazione sconosciuta "+ dir);
		Stanza partenzaDa = this.nome2stanza.get(stanzaDa);
		Stanza arrivoA = this.nome2stanza.get(nomeA);
		partenzaDa.impostaStanzaAdiacente(dir, arrivoA);
	}


	final private void check(boolean condizioneCheDeveEsseraVera, String messaggioErrore) throws FormatoFileNonValidoException {
		if (!condizioneCheDeveEsseraVera)
			throw new FormatoFileNonValidoException("Formato file non valido [" + this.reader.getLineNumber() + "] "+messaggioErrore);		
	}

	public Stanza getStanzaIniziale() {
		return this.stanzaIniziale;
	}

	public Stanza getStanzaVincente() {
		return this.stanzaVincente;
	}
}
