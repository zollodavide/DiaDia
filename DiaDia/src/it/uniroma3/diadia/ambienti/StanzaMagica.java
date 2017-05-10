package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * Stanza che dopo aver posato attrezzi un tot numero di volte (soglia), questa modifica il nome dell'attrezzo
 * e ne raddoppia il peso.
 * 
 * @author Davide Zollo
 * @see Stanza
 *
 */

public class StanzaMagica extends Stanza {

	final static int SOGLIA_MAGICA_DEFAULT = 3;
	private int sogliaMagica;
	private int contatoreAttrezziPosati;

	public StanzaMagica(String nome, int soglia) {
		super(nome);
		this.sogliaMagica = soglia;
		this.contatoreAttrezziPosati = 0;

	}

	public StanzaMagica(String nome) {
		this(nome, SOGLIA_MAGICA_DEFAULT);
	}


	@Override
	public boolean addAttrezzo(Attrezzo attrezzo) {
		this.contatoreAttrezziPosati++;

		if (this.contatoreAttrezziPosati>this.sogliaMagica)
			attrezzo = this.modificaAttrezzo(attrezzo);

		return super.addAttrezzo(attrezzo);
	}

	/**
	 * Metodo che inverte il nome dell'attrezzo posato e ne raddoppia il peso
	 * 
	 * @param l'attrezzo posato
	 * @return l'attrezzo con nome invertito e peso doppio
	 */
	private Attrezzo modificaAttrezzo(Attrezzo attrezzo) {

		StringBuilder nomeInvertito;

		int pesoX2 = attrezzo.getPeso()*2;
		nomeInvertito = new StringBuilder(attrezzo.getNome());
		nomeInvertito = nomeInvertito.reverse();

		attrezzo = new Attrezzo(nomeInvertito.toString(), pesoX2);

		return attrezzo;

	}


}
