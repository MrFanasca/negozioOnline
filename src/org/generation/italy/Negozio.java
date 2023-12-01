package org.generation.italy;

import java.util.HashMap;
import java.util.Scanner;

public class Negozio {

	public HashMap <String, Prodotto> prodottiMagazzino = new HashMap<>();
	Scanner sc = new Scanner (System.in);
	
	public void aggiungiProdotto ()
	{
		String codice, descrizione;
		Float prezzo;
		Integer quantità;
		
		System.out.println();
		System.out.println("Inserisci il codice");
		codice=sc.nextLine();
		System.out.println("Inserisci la descrizione");
		descrizione=sc.nextLine();
		System.out.println("Inserisci il prezzo");
		prezzo=Float.parseFloat(sc.nextLine());
		System.out.println("Inserisci la quantità");
		quantità= Integer.parseInt(sc.nextLine());
		prodottiMagazzino.put(codice,new Prodotto(codice,descrizione,prezzo,quantità));
	}
		
	public void elencoProdotti ()
	{
		for (String n:prodottiMagazzino.keySet())
		{
			System.out.println("\nCodice prodotto: "+ n +"\tDescrizione: "+ prodottiMagazzino.get(n).getDescrizione());
			System.out.println("Prezzo: " + prodottiMagazzino.get(n).getPrezzo() + "\tQuantità: " + prodottiMagazzino.get(n).getQuantitàDisponibile());
		}
			
	}
	
	
	// metodo per elencare i prodotti tramite for each
	
	// metodo per inserire lo sconto ad un determinato prodotto
	
}
