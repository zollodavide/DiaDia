package it.uniroma3.diadia.ambienti;

public class StanzaBloccata extends Stanza {
	
	private String attrezzoSbloccante;
	private String direzioneBloccata; 
	
	public StanzaBloccata (String nome, String attrezzoSbloccante, String direzioneBloccata) {
		 super(nome);
		 this.attrezzoSbloccante= attrezzoSbloccante;
		 this.direzioneBloccata= direzioneBloccata;
	}
	
	@Override
	public Stanza getStanzaAdiacente(String direzione) {
		if (!direzione.equals(this.getDirezioneBloccata()))
			return super.getStanzaAdiacente(direzione);
		else{
			if (this.hasAttrezzo(this.getAttrezzoSbloccante()))
				return super.getStanzaAdiacente(direzione);
			else 
				return this;
		}
	}
	
	public String getAttrezzoSbloccante() {
		return this.attrezzoSbloccante;
	}
	
	public String getDirezioneBloccata() {
		return this.direzioneBloccata;
	}
	
	
}
