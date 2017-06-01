package it.uniroma3.diadia.personaggi;

import static it.uniroma3.diadia.properties.Properties.MESSAGGIO_DIMEZZA;
import static it.uniroma3.diadia.properties.Properties.MESSAGGIO_DONO;
import static it.uniroma3.diadia.properties.Properties.MESSAGGIO_SCUSE;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;



public class Mago extends AbstractPersonaggio {

	private Attrezzo dono;
	
	public Mago(String nome, String presentazione, Attrezzo attrezzo) {
		super(nome, presentazione);
		this.dono = attrezzo;
	}
	
	@Override
	public String agisci(Partita partita) {
		String msg;
		if (dono!=null) {
			partita.getStanzaCorrente().addAttrezzo(dono);
			this.dono = null;
			msg = MESSAGGIO_DONO;
		}
		else {
			msg = MESSAGGIO_SCUSE;
		}
		return msg;
	}

	@Override
	public String riceviRegalo(Attrezzo regalo, Partita partita) {
		partita.getGiocatore().getBorsa().removeAttrezzo(regalo.getNome());	
		Attrezzo half = new Attrezzo(regalo.getNome(), regalo.getPeso()/2);
		partita.getStanzaCorrente().addAttrezzo(half);	
		return MESSAGGIO_DIMEZZA;
	}

}
