package org.generation.italy;

import java.util.HashMap;

public class Negozio {

	public HashMap <String, Prodotto> prodottiMagazzino = new HashMap<>();

	
	public void aggiungiProdotto ()
	{
		System.out.println();
		// creiamo delle variabili 'codice', 'descrizione', 'prezzo' e 'quantitàDisponibile' le chiediamo mano a mano
		// in questo metodo e poi le inseriamo nel put sottostante, il tutto in un cicli do-while cosi da ripetere
		// quante volte vogliamo
		
		prodottiMagazzino.put("codice", new Prodotto ("codice","descrizione","prezzo","quantitàDisponibile"));
	}
	
	// metodo per elencare i prodotti tramite for each
	
	// metodo per inserire lo sconto ad un determinato prodotto
	
}
