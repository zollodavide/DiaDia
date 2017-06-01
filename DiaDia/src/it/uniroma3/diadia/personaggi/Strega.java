package it.uniroma3.diadia.personaggi;

import static it.uniroma3.diadia.properties.Properties.MESSAGGIO_EDUCATO;
import static it.uniroma3.diadia.properties.Properties.MESSAGGIO_MALEDUCATO;
import static it.uniroma3.diadia.properties.Properties.MESSAGGIO_RISATA;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Strega extends AbstractPersonaggio {
	

	public Strega(String nome, String presentaz) {
		super(nome, presentaz);
	}

	@Override
	public String agisci(Partita partita) {
		List<Stanza> list = new ArrayList<Stanza>();
		String msg;
		
		for(String dir : partita.getStanzaCorrente().getDirezioni()) {
			Stanza tmp = partita.getStanzaCorrente().getStanzaAdiacente(dir);
			list.add(tmp);
		}
				
		if(super.haSalutato()) {
			msg = MESSAGGIO_EDUCATO;
			partita.setStanzaCorrente(Collections.max(list, new ComparatorePerNumAttrezzi()));
		}
		
		else {
			msg = MESSAGGIO_MALEDUCATO;
			partita.setStanzaCorrente(Collections.min(list, new ComparatorePerNumAttrezzi()));
		}
		
		return msg;
	}
	
	private class ComparatorePerNumAttrezzi implements Comparator<Stanza> {

		@Override
		public int compare(Stanza o1, Stanza o2) {
			int comp = o1.getAttrezzi().size() - o2.getAttrezzi().size();
			
			if(comp==0)
				comp =o1.getNome().compareTo(o2.getNome());
			
			return comp;
		}
		
	}

	@Override
	public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
		partita.getGiocatore().getBorsa().removeAttrezzo(attrezzo.getNome());
		return MESSAGGIO_RISATA;
	}

}
