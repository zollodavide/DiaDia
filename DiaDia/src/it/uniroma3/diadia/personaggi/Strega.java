package it.uniroma3.diadia.personaggi;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Strega extends AbstractPersonaggio {
	
	private static final String MESSAGGIO_EDUCATO = "Visto che mi hai salutato, ti porterò a un luogo pieno di ricchezza!!";

	private static final String MESSAGGIO_MALEDUCATO = "Visto che sei un maleducato e non saluti ti"
													 + " porterò in un luogo pieno di povertà!!";

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
		
		list.sort(new ComparatorePerNumAttrezzi());
		
		if(super.haSalutato()) {
			msg = MESSAGGIO_EDUCATO;
			partita.setStanzaCorrente(list.get(list.size()-1));
		}
		
		else {
			msg = MESSAGGIO_MALEDUCATO;
			partita.setStanzaCorrente(list.get(0));
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
		// TODO Auto-generated method stub
		return null;
	}

}
