package it.uniroma3.diadia.ambienti;

/**
 * Classe che rappresenta una stanza buia del gioco. Cioè una stanza dove non si può
 * vedere niente a meno che sia presente l'attrezzo luminoso
 * 
 * @author Davide Zollo
 * @see Stanza
 *
 */
public class StanzaBuia extends Stanza {
		
	private String attrezzoLuminoso;
	
	public StanzaBuia(String nome, String attrezzo)  {
		super(nome);
		this.attrezzoLuminoso = attrezzo;
	}
	
	@Override
	public String getDescrizione() {
		if(!this.hasAttrezzo(this.attrezzoLuminoso))
			return "Qui c'� un buio pesto!";
		else
			return super.getDescrizione();
	}

}
