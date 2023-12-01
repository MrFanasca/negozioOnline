package org.generation.italy;

import java.util.HashMap;

public class Negozio {

	public HashMap <String, Prodotto> prodottiMagazzino = new HashMap<>();

	// metodo per inserire un nuovo prodotto
	public void aggiungiProdotto (String codice, String descrizione, Float prezzo, Integer quantitàDisponibile)
	{
		prodottiMagazzino.put(codice,new Prodotto(codice,descrizione,prezzo,quantitàDisponibile));
	}

	// metodo per elencare i prodotti tramite for each	
	public void elencoProdotti ()
	{
		for (String n:prodottiMagazzino.keySet())
		{
			System.out.println("\nCodice prodotto: "+ n +"\tDescrizione: "+ prodottiMagazzino.get(n).getDescrizione());
			System.out.println("Prezzo: " + prodottiMagazzino.get(n).getPrezzo() + "\tQuantità: " + prodottiMagazzino.get(n).getQuantitàDisponibile());
		}
			
	}
	
	// metodo per inserire lo sconto ad un determinato prodotto
	public void applicaSconto (String codice, Float sconto)
	{
		prodottiMagazzino.get(codice).setSconto(sconto);
		// (1-sconto/100)*prodottiMagazzino.get(codice).getPrezzo();
	}
	
	public void visualizzaSconto (String codice)
	{
		System.out.println(prodottiMagazzino.get(codice).getSconto() + "%");
	}
}
