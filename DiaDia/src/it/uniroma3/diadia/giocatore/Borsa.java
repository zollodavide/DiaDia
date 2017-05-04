package it.uniroma3.diadia.giocatore;

import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * Questa classe ha la responsabilità di memorizzare l'insieme di attrezzi che 
 * il giocatore porta con se durante la partita. Questi si aggiungono e si 
 * rimuovono durante il trascorso della partita.
 * 	
 * @author Davide Zollo & Fabio Ramohitaj
 * @see Attrezzo
 * @version Base
 *
 */
public class Borsa {

	public final static int DEFAULT_PESO_MAX_BORSA = 10;
	
	private Attrezzo[] attrezzi;
	private int numeroAttrezzi;
	private int pesoMax;
	
	
	/**
	 * Crea l'oggetto borsa
	 *  
	 */
	public Borsa() {
		this(DEFAULT_PESO_MAX_BORSA);
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
		this.attrezzi = new Attrezzo[10]; // speriamo che bastino...
		this.numeroAttrezzi = 0;

	}
	
	/**
	 * Aggiunge un attrezzo alla borsa. Il metodo compire quest'azione
	 * riempendo i "buchi" nell'array, cioè, gli attrezzi vengono 
	 * aggiunti nel primo elemento null dell'array
	 * 
	 * @param attrezzo
	 * @return true se l'attrezzo è stato aggiunto, false altrimenti
	 * 
	 */
	public boolean addAttrezzo(Attrezzo attrezzo) {
		
		if(attrezzo == null)
			return false;
		
		else if(attrezzo.getNome().equals(""))
			return false;

		else if (this.getPeso() + attrezzo.getPeso() > this.getPesoMax())
			return false;
	
		else if (this.numeroAttrezzi==10)
			return false;
		
		else {
			
			for(int i =0; i<this.attrezzi.length; i++) {
				if(this.attrezzi[i]==null) {
					this.attrezzi[i] = attrezzo;
					this.numeroAttrezzi++;
					return true; 
				}	
			}		
			return false; 	//Se c'è qualche tipo di problema al momento di aggiungere un oggetto ritorna false
		}
	}
	 
	/**
	 * Restituisce il peso totale degli attrezzi contenuti nella borsa
	 * 
	 * @return peso totale
	 * 
	 */
	public int getPeso() {
		int peso=0;
		
		for(Attrezzo elemento : this.attrezzi)
			if(elemento!=null)
				peso += elemento.getPeso();
	
		return peso;
	}
	
	/**
	 * Restituisce il peso massimo che si può contenere nella borsa
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
		Attrezzo a = null;
	
		for (int i= 0; i<this.attrezzi.length; i++)
			if (this.attrezzi[i]!=null && this.attrezzi[i].getNome().equals(nomeAttrezzo))
					a = attrezzi[i];
		
		return a;
				
	}
	

	/**
	 * Metodo che verifica che la quantità di attrezzi nella borsa siano zero
	 * 
	 * @return true se è vuota, false altrimenti
	 * 
	 */
	public boolean isEmpty() {
		return this.numeroAttrezzi == 0;
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
	 * @return l'attrezzo che è stato rimosso, null nel caso in cui non è stato rimosso nessun oggetto
	 * 
	 */
	public Attrezzo removeAttrezzo(String nomeAttrezzo) {

		Attrezzo a = null;
		
		if (this.isEmpty())
			return a;
		
		
		int i = 0;
		boolean rimosso = false;
		
		while(i<this.attrezzi.length && !rimosso) {
			if(this.attrezzi[i]!=null && this.attrezzi[i].getNome().equals(nomeAttrezzo)) {
				a = this.attrezzi[i];
				this.attrezzi[i] = null;
				this.numeroAttrezzi--;
				rimosso = true;
			}
			else
				i++;
				
		}
		
		return a;			

	}
	
	/** 
	 * Restituisce l'insieme di attrezzi presente nella borsa
	 * 
	 * @return l'insieme di attrezzi nella borsa
	 * 
	 */
	public Attrezzo[] getAttrezzi() {
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
			s.append("Contenuto borsa ("+this.getPeso()+"kg/"+this.getPesoMax()+"kg): ");

			for (int i= 0; i<this.attrezzi.length; i++)
				if(attrezzi[i]!=null)
					s.append(attrezzi[i].toString()+" ");
		}
		else
			s.append("Borsa vuota");

		return s.toString();

	}

}
