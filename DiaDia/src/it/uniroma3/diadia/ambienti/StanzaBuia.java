package it.uniroma3.diadia.ambienti;

public class StanzaBuia extends Stanza {
		
	private String attrezzoLuminoso;
	
	public StanzaBuia(String nome, String attrezzo)  {
		super(nome);
		this.attrezzoLuminoso = attrezzo;
	}
	
	@Override
	public String getDescrizione() {
		if(!this.hasAttrezzo(this.attrezzoLuminoso))
			return "Qui c'è un buio pesto!";
		else
			return super.getDescrizione();
	}

}
