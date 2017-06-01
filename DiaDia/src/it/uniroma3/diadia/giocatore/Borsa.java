package it.uniroma3.diadia.giocatore;

import static it.uniroma3.diadia.properties.Costanti.DEFAULT_PESO_MAX_BORSA;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Questa classe ha la responsabilit� di memorizzare l'insieme di attrezzi che 
 * il giocatore porta con se durante la partita. Questi si aggiungono e si 
 * rimuovono durante il trascorso della partita.
 * 	
 * @author Davide Zollo & Fabio Ramohitaj
 * @see Attrezzo
 * @version Base
 *
 */
public class Borsa {


	private Map<String, Attrezzo> attrezzi;
	private int pesoMax;
	
	
	/**
	 * Classe utilizzata per ordinare gli elementi di una collezione per peso
	 * 
	 * @author Davide Zollo
	 * 
	 */
	private class ComparatorePerPeso implements Comparator<Attrezzo> {

		@Override
		public int compare(Attrezzo o1, Attrezzo o2) {
			int ord = o1.getPeso() - o2.getPeso();
			if (ord==0)
				return o1.getNome().compareTo(o2.getNome());
			else
				return ord;
		}
		
	}
	
	
	/**
	 * Classe utilizzata per ordinare gli elementi di una collezione per nome
	 * 
	 * @author Davide Zollo
	 *
	 */
	private class ComparatorePerNome implements Comparator<Attrezzo> {

		@Override
		public int compare(Attrezzo o1, Attrezzo o2) {
			
			int ord = o1.getNome().compareTo(o2.getNome());
			
			if (ord == 0)
				return o2.getPeso() - o1.getPeso();
			else
				return ord;
		}
		
	}


	/**
	 * Crea l'oggetto borsa
	 *  
	 */
	public Borsa() {
		this(DEFAULT_PESO_MAX_BORSA.getCostant());
	}

	/**
	 * Crea l'oggetto borsa
	 * 
	 * @param pesoMax
	 * @param attrezzi
	 * @param numeroAttrezzi
	 * 
	 */
	public Borsa(int pesoMax) {
		this.pesoMax = pesoMax;
		this.attrezzi = new HashMap<String, Attrezzo>();
	}

	/**
	 * Aggiunge un attrezzo alla borsa. Il metodo compire quest'azione
	 * riempendo i "buchi" nell'array, cio�, gli attrezzi vengono 
	 * aggiunti nel primo elemento null dell'array
	 * 
	 * @param attrezzo
	 * @return true se l'attrezzo � stato aggiunto, false altrimenti
	 * 
	 */
	public boolean addAttrezzo(Attrezzo attrezzo) {

		if(attrezzo == null)
			return false;

		else if(attrezzo.getNome().equals(""))
			return false;

		else if (this.getPeso() + attrezzo.getPeso() > this.getPesoMax()) {
			System.out.println("Hai la borsa piena!");
			return false;
			
		}
		
		else if(this.attrezzi.put(attrezzo.getNome(),attrezzo)==null)
			return true;
		
		else
			return false;

	}

	/**
	 * Restituisce il peso totale degli attrezzi contenuti nella borsa
	 * 
	 * @return peso totale
	 * 
	 */
	public int getPeso() {
		int pesoTotale = 0;
		
		Collection<Attrezzo> valori= this.attrezzi.values();

		Iterator<Attrezzo> iteratore = valori.iterator();

		while (iteratore.hasNext()) {
			Attrezzo a = iteratore.next();
			pesoTotale += a.getPeso();
		}
		return pesoTotale;
	}

	/**
	 * Restituisce il peso massimo che si pu� contenere nella borsa
	 * 
	 * @return peso max
	 * 
	 */
	public int getPesoMax() {
		return this.pesoMax;
	}

	/**
	 * Restituisce l'attrezzo cercato nella borsa se trovato
	 * 
	 * @param nomeAttrezzo string nome dell'attrezzo
	 * @return l'attrezzo cercato se trovato, altrimenti null
	 * 
	 */
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		return this.attrezzi.get(nomeAttrezzo);
	}


	/**
	 * Metodo che verifica che la quantit� di attrezzi nella borsa siano zero
	 * 
	 * @return true se � vuota, false altrimenti
	 * 
	 */
	public boolean isEmpty() {
		return this.attrezzi.isEmpty();
	}

	/**
	 * Metodo che verifica se esiste un attrezzo cercato nella borsa
	 * 
	 * @param nomeAttrezzo string nome dell'attrezzo cercato
	 * @return true se l'attrezzo esiste nella borsa, false altrimenti
	 * 
	 */
	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.getAttrezzo(nomeAttrezzo)!=null;
	}

	/**
	 * Metodo che rimuove (se esiste) un attrezzo dalla borsa
	 *  
	 * @param nomeAttrezzo nome dell'attrezzo che si desidera rimuovere
	 * @return l'attrezzo che � stato rimosso, null nel caso in cui non � stato rimosso nessun oggetto
	 * 
	 */
	public Attrezzo removeAttrezzo(String nomeAttrezzo) {

		Attrezzo a = null;

		if (this.isEmpty())
			return a;
		
		else if (!this.hasAttrezzo(nomeAttrezzo))
			return a;
		
		else
			return this.attrezzi.remove(nomeAttrezzo);
	}

	/** 
	 * Restituisce l'insieme di attrezzi presente nella borsa
	 * 
	 * @return l'insieme di attrezzi nella borsa
	 * 
	 */
	public Map<String, Attrezzo> getAttrezzi() {
		return this.attrezzi;
	}

	/**
	 * Metodo che stampa la descrizione della borsa compreso peso complessivo, 
	 * peso massimo ed ogni attrezzo contenuto
	 * 
	 */
	public String toString() {

		StringBuilder s = new StringBuilder();

		if (!this.isEmpty()) {
			s.append("Contenuto borsa ("+this.getPeso()+"kg/"+this.getPesoMax()+"kg):" + "\n");
			
			Collection<Attrezzo> coll = this.getSortedSetOrdinatoPerPeso();
		
			Iterator<Attrezzo> it = coll.iterator();
			
			while(it.hasNext()) {
				Attrezzo n = it.next();
				s.append("- " + n.toString()+"\n");
			}
		}
		
		else
			s.append("Borsa vuota");

		return s.toString();
	}
	
	
	/**
	 * Metodo che crea una nuova lista con gli attrezzi presenti nella borsa,
	 * la ordina per peso e poi la restituisce.
	 * 
	 * @return lista con gli attrezzi della borsa ordinati per peso
	 */
	public List<Attrezzo> getContenutoOrdinatoPerPeso() {
		List<Attrezzo> ordinata = new ArrayList<Attrezzo>(this.attrezzi.values());
		Collections.sort(ordinata, new ComparatorePerPeso());
		
		return ordinata; 
	}
	
	
	/**
	 * Metodo che crea un nuovo insieme ordinato per nome con gli attrezzi presenti nella borsa,
	 * lo restituisce.
	 * 
	 * @return insieme ordinato con gli attrezzi della borsa ordinati per nome
	 */
	public SortedSet<Attrezzo> getContenutoOrdinatoPerNome() {
		SortedSet<Attrezzo> ordinata = new TreeSet<>(new ComparatorePerNome());
		ordinata.addAll(this.attrezzi.values());
		
		return ordinata;
	}
	
	/**
	 * Metodo che crea un nuovo insieme ordinato per peso con gli attrezzi presenti nella borsa,
	 * lo restituisce.
	 * 
	 * @return insieme ordinato con gli attrezzi della borsa ordinati per peso
	 */
	public SortedSet<Attrezzo> getSortedSetOrdinatoPerPeso() {
		SortedSet<Attrezzo> ordinata = new TreeSet<>(new ComparatorePerPeso());
		ordinata.addAll(this.attrezzi.values());
		
		return ordinata;
	}
	
	
	/**
	 * Metodo che ritorna una mappa che associa attrezzi con lo stesso peso, utilizzando il peso come chiave.
	 * 
	 * @return map contenente attrezzi associati dallo stesso peso
	 */
	public Map<Integer,Set<Attrezzo>> getContenutoRaggruppatoPerPeso() {
		Set<Attrezzo> tmp;
		Map<Integer,Set<Attrezzo>> mappa = new HashMap<>();
		
		for (Attrezzo att : this.attrezzi.values()) {
			tmp = mappa.get(att.getPeso());
			
			if(tmp == null)
				tmp = new HashSet<>();
			
			tmp.add(att);
			mappa.put(att.getPeso(), tmp);
			
		}
		
		return mappa;
	}
	
	

}
