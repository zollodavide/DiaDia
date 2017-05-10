package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import java.util.List;
import java.util.*;

/**
 * Classe Stanza - una stanza in un gioco di ruolo.
 * Una stanza e' un luogo fisico nel gioco.
 * E' collegata ad altre stanze attraverso delle uscite.
 * Ogni uscita e' associata ad una direzione.
 * 
 * @author docente di POO 
 * @see Attrezzo
 * @version base
 */
public class Stanza {

	//static final private int NUMERO_MASSIMO_DIREZIONI = 4;
	//static final private int NUMERO_MASSIMO_ATTREZZI = 10;

	private String nome;
	private Map<String,Attrezzo> attrezzi;
	//private int numeroAttrezzi;
	//private Stanza[] stanzeAdiacenti;
	//private int numeroStanzeAdiacenti;
	//private String[] direzioni;
	private Map<String, Stanza> stanzeAdiacenti;

	/**
	 * Crea una stanza. Non ci sono stanze adiacenti, non ci sono attrezzi.
	 * @param nome il nome della stanza
	 */
	public Stanza(String nome) {
		this.nome = nome;
		//this.numeroStanzeAdiacenti = 0;
		// this.numeroAttrezzi = 0;
		//this.direzioni = new String[NUMERO_MASSIMO_DIREZIONI];
		this.stanzeAdiacenti = new HashMap<>();
		this.attrezzi = new HashMap<String,Attrezzo>();
		//this.attrezzi = new Attrezzo[NUMERO_MASSIMO_ATTREZZI];
	}

	/**
	 * Imposta una stanza adiacente.
	 *
	 * @param direzione direzione in cui sara' posta la stanza adiacente.
	 * @param stanza stanza adiacente nella direzione indicata dal primo parametro.
	 */
	public void impostaStanzaAdiacente(String direzione, Stanza stanza) {
		this.stanzeAdiacenti.put(direzione, stanza);
		
		/*boolean aggiornato = false;
		for(int i=0; i<this.direzioni.length; i++)
			if (direzione.equals(this.direzioni[i])) {
				this.stanzeAdiacenti[i] = stanza;
				aggiornato = true;
			}
		if (!aggiornato)
			if (this.numeroStanzeAdiacenti < NUMERO_MASSIMO_DIREZIONI) {
				this.direzioni[numeroStanzeAdiacenti] = direzione;
				this.stanzeAdiacenti[numeroStanzeAdiacenti] = stanza;
				this.numeroStanzeAdiacenti++;
			}*/
	}

	/**
	 * Restituisce la stanza adiacente nella direzione specificata
	 * @param direzione
	 */
	public Stanza getStanzaAdiacente(String direzione) {
		return this.stanzeAdiacenti.get(direzione);
		
		/*Stanza stanza = null;
		for(int i=0; i<this.numeroStanzeAdiacenti; i++)
			if (this.direzioni[i].equals(direzione))
				stanza = this.stanzeAdiacenti[i];
		return stanza;*/
	}

	/**
	 * Restituisce la nome della stanza.
	 * @return il nome della stanza
	 */
	public String getNome() {
		return this.nome;
	}

	/**
	 * Restituisce la descrizione della stanza.
	 * @return la descrizione della stanza
	 */
	public String getDescrizione() {
		return this.toString();
	}

	/**
	 * Restituisce la collezione di attrezzi presenti nella stanza.
	 * @return la collezione di attrezzi nella stanza.
	 */
	public Map<String,Attrezzo> getAttrezzi() {
		return this.attrezzi;
	}

	/**
	 * Mette un attrezzo nella stanza.
	 * @param attrezzo l'attrezzo da mettere nella stanza.
	 * @return true se riesce ad aggiungere l'attrezzo, false atrimenti.
	 */
	public boolean addAttrezzo(Attrezzo attrezzo) {
		/*if (this.numeroAttrezzi < NUMERO_MASSIMO_ATTREZZI) {

        	int i =0;
        	boolean aggiunto = false;

        	while(i<this.attrezzi.length && !aggiunto) {
        		if(this.attrezzi[i]==null) {
		        	this.attrezzi[i] = attrezzo;
		        	this.numeroAttrezzi++;
		        	aggiunto = true;
        		}
        		else
        			i++;	
        	}    */

		if(attrezzo==null)
			return false;
	
		else if(attrezzo.getNome().equals(""))
			return false;
		
		else if(this.attrezzi.put(attrezzo.getNome(),attrezzo)==null)
			return true;
		
		else 
			return false;

	}

	/**
	 * Restituisce una rappresentazione stringa di questa stanza,
	 * stampadone la descrizione, le uscite e gli eventuali attrezzi contenuti
	 * @return la rappresentazione stringa
	 */
	public String toString() {
		StringBuilder risultato = new StringBuilder();
		risultato.append(this.nome);
		risultato.append("\nUscite: ");
		
		for (String direzione : this.stanzeAdiacenti.keySet())
			risultato.append(" " + direzione);
		risultato.append("\n\nAttrezzi nella stanza:" + "\n");
		Collection<Attrezzo> coll = this.attrezzi.values();
		
		for (Attrezzo attrezzo : coll) 
			risultato.append("- " + attrezzo.toString()+"\n");
		
		return risultato.toString();
	}

	/**
	 * Controlla se un attrezzo esiste nella stanza (uguaglianza sul nome).
	 * 
	 * @return true se l'attrezzo esiste nella stanza, false altrimenti.
	 */
	public boolean hasAttrezzo(String nomeAttrezzo) {

		if(this.attrezzi.isEmpty())
			return false;

		else
			return this.attrezzi.containsKey(nomeAttrezzo);
			
		
		/*Iterator<Attrezzo> it = this.attrezzi.iterator();

		while(it.hasNext() && !trovato) {
			Attrezzo cercato = it.next();

			if(cercato.getNome().equals(nomeAttrezzo)){
				trovato = true;
			}
		}*/

		/*for (Attrezzo attrezzo : this.attrezzi) {
			if (attrezzo!=null && attrezzo.getNome().equals(nomeAttrezzo))
				trovato = true;
		}*/
		
	}

	/**
	 * Restituisce l'attrezzo nomeAttrezzo se presente nella stanza.
	 * @param nomeAttrezzo
	 * @return l'attrezzo presente nella stanza.
	 * 		   null se l'attrezzo non e' presente.
	 */
	public Attrezzo getAttrezzo(String nomeAttrezzo) {

		if(!this.hasAttrezzo(nomeAttrezzo))
			return null;
		
		else
			return this.attrezzi.get(nomeAttrezzo);
		
		
		/*Iterator<Attrezzo> it = this.attrezzi.iterator();

		while(it.hasNext() && !trovato) {
			Attrezzo cercato = it.next();

			if(cercato.getNome().equals(nomeAttrezzo)){
				trovato = true;
				attrezzoCercato = cercato;
			}
		}*/ 

		/*for (Attrezzo attrezzo : this.attrezzi) {
			if (attrezzo!= null && attrezzo.getNome().equals(nomeAttrezzo))
				attrezzoCercato = attrezzo;
		}*/
	}

	/**
	 * Rimuove un attrezzo dalla stanza (ricerca in base al nome).
	 * @param nomeAttrezzo
	 * @return true se l'attrezzo e' stato rimosso, false altrimenti
	 */
	public boolean removeAttrezzo(Attrezzo attrezzo) {

		if(attrezzo == null) 
			return false;
		
		else if(!this.hasAttrezzo(attrezzo.getNome()))
			return false;

		else if (this.attrezzi.remove(attrezzo.getNome())!=null)
			return true;
		
		else 
			return false;

		/*while(i<this.attrezzi.length && !rimosso) {
			if(this.attrezzi[i]!=null && this.attrezzi[i].getNome().equals(nomeAttrezzo)) {
				this.attrezzi[i] = null;
				rimosso = true;
				this.numeroAttrezzi--;
			}
			else
				i++;
		}*/	

		//return rimosso;

	}

	/**
	 * Stampa le direzioni disponibili alle quali il giocatore pu� accedere,
	 * ovvero, le direzioni delle stanze adiacenti.
	 * 
	 * @return String[] 
	 */
	public Set<String> getDirezioni() {
		return this.stanzeAdiacenti.keySet();
	}


}