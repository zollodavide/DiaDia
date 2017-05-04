package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

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


	private Attrezzo modificaAttrezzo(Attrezzo attrezzo) {

		StringBuilder nomeInvertito;

		int pesoX2 = attrezzo.getPeso()*2;
		nomeInvertito = new StringBuilder(attrezzo.getNome());
		nomeInvertito = nomeInvertito.reverse();

		attrezzo = new Attrezzo(nomeInvertito.toString(), pesoX2);

		return attrezzo;

	}


}
