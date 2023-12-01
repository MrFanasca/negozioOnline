package org.generation.italy;

import java.util.HashMap;
import java.util.Scanner;

public class Carrello {
	
	// HashMap simile a quello presente nell'oggetto Negozio
	Scanner sc = new Scanner(System.in);
	Negozio n = new Negozio();
	
	public HashMap <String, Prodotto> prodottiSelezionati = new HashMap<>();
	
	// metodo simile a quello in Negozio ma con il controllo sul prodotto, ossia verificare se esiste nel magazzino
	// e se si, si aggiunge al nuovo HashMap del carrello
	public void aggiungiCarrello ()
	{
		String risposta;
		
		System.out.println("Inserisci il codice del prodotto");
		risposta=sc.nextLine();
		if (n.prodottiMagazzino.containsKey(risposta))
		{
			prodottiSelezionati.put(risposta, new Prodotto(n.prodottiMagazzino().getCodice(),n.prodottiMagazzino().getDescrizione(),n.prodottiMagazzino().getPrezzo(),n.prodottiMagazzino().getQuantitàDisponibile());
		}
	}
	
	// metodo per elencare i prodotti nel carrello tramite for each
	
	// ?se volessi inserire un prodotto nel carrello, ho bisogno di reinserire tutte le caratteristiche?
	
}
