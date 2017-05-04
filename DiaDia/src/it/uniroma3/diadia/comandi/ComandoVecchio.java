package it.uniroma3.diadia.comandi;

import java.util.Scanner;

/**
 * Questa classe modella un comando.
 * Un comando consiste al piu' di due parole:
 * il nome del comando ed un parametro
 * su cui si applica il comando.
 * (Ad es. alla riga digitata dall'utente "vai nord"
 *  corrisponde un comando di nome "vai" e parametro "nord").
 *
 * @author  docente di POO
 * @version base
 */

public class ComandoVecchio {

    private String nome;
    private String parametro;
    
    /**
     * Crea un nuovo comando, dividendo 
     * le due stringhe in nome e parametro
     * @param istruzione
     * 
     */
    public ComandoVecchio(String istruzione) {
		Scanner scannerDiParole = new Scanner(istruzione);

		// prima parola: nome del comando
		if (scannerDiParole.hasNext())
			this.nome = scannerDiParole.next(); 

		// seconda parola: eventuale parametro
		if (scannerDiParole.hasNext())
			this.parametro = scannerDiParole.next();
    }
    
    /**
     * Restituisce il "nome" del comando, cioè
     * la prima stringa dell'istruzione
     * @return parametro
     * 
     */
    public String getNome() {
        return this.nome;
    }
    
    /**
     * Restituisce il "parametro" del comando, cioè 
     * la seconda stringa dell'istruzione
     * @return parametro
     * 
     */
    public String getParametro() {
        return this.parametro;
    }
    
    /**
     * Controlla se l'istruzione inserita è nulla
     * @return true se è nulla, false altrimenti
     */
    public boolean sconosciuto() {
        return (this.nome == null);
    }
}