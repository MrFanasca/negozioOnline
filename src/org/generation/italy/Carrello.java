package org.generation.italy;

import java.util.HashMap;
import java.util.Scanner;

public class Carrello {
	
	// HashMap simile a quello presente nell'oggetto Negozio contenente il codice del prodotto e la quantità desiderata
	Negozio n = new Negozio();
	
	public HashMap <String, Integer> prodottiSelezionati = new HashMap<>();
	
	// metodo simile a quello in Negozio ma con il controllo sul prodotto, ossia verificare se esiste nel magazzino
	// e se si, si aggiunge al nuovo HashMap del carrello
	public void aggiungiCarrello (String codice, Integer quantità)
	{
		
		if (n.prodottiMagazzino.containsKey(codice))
		{
			if (quantità<=n.prodottiMagazzino.get(codice).getQuantitàDisponibile())
			prodottiSelezionati.put(codice, quantità);
			n.prodottiMagazzino.get(codice).setQuantitàDisponibile(n.prodottiMagazzino.get(codice).getQuantitàDisponibile()-quantità);
		}
		else
			System.out.println("Prodotto non presente");
	}
	
	// metodo per elencare i prodotti nel carrello tramite for each
	
	// ?se volessi inserire un prodotto nel carrello, ho bisogno di reinserire tutte le caratteristiche?
	
}
