package it.uniroma3.diadia.personaggi;

import static  it.uniroma3.diadia.properties.Properties.MESSAGGIO_MORSO;
import static  it.uniroma3.diadia.properties.Properties.MESSAGGIO_REGALOGRADITO;
import static  it.uniroma3.diadia.properties.Properties.MESSAGGIO_REGALONONGRADITO;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Cane extends AbstractPersonaggio {
	
	String ciboPreferito;

	public Cane(String nome, String presentaz, String ciboPreferito) {
		super(nome, presentaz);
		this.ciboPreferito = ciboPreferito;
	}

	@Override
	public String agisci(Partita partita) {
		int cfu = partita.getGiocatore().getCfu();
		partita.getGiocatore().setCfu(--cfu);
		
		return MESSAGGIO_MORSO;
	}

	@Override
	public String saluta() {
		setSaluto();
		return "Wuf Wuf!!";
	}

	public String getCiboPreferito() {
		return this.ciboPreferito;
	}

	@Override
	public String riceviRegalo(Attrezzo regalo, Partita partita) {
		String msg;
		if(regalo.getNome().equals(this.getCiboPreferito())) {
			Attrezzo dono = new Attrezzo("dono", 1);
			partita.getStanzaCorrente().addAttrezzo(dono);
			partita.getGiocatore().getBorsa().removeAttrezzo(regalo.getNome());
			msg = MESSAGGIO_REGALOGRADITO;
		}
		else {
			partita.getStanzaCorrente().addAttrezzo(regalo);
			partita.getGiocatore().getBorsa().removeAttrezzo(regalo.getNome());
			msg = MESSAGGIO_REGALONONGRADITO;
		}

		return msg;
	}  

}
