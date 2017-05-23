package it.uniroma3.diadia.personaggi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Cane extends AbstractPersonaggio {
	
	String ciboPreferito;

	private static final String MESSAGGIO_MORSO = "Il cane ti ha morso i cfu!";
	private static final String MESSAGGIO_REGALOGRADITO = "Wuf Wuf! (Il cane salta e sembra felice del tuo regalo)";
	private static final String MESSAGGIO_REGALONONGRADITO= "Grrrr! (Il cane sembra non gradire il tuo regalo)";

			
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
