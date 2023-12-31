package org.generation.italy;

import java.util.HashMap;

public class Carrello {
	
	// HashMap simile a quello presente nell'oggetto Negozio contenente il codice del prodotto e la quantità desiderata
	Negozio n;		// chiedere a Enzo Negozio n = new Negozio();
	
	public HashMap <String, Integer> prodottiSelezionati = new HashMap<>();		// la stringa è il codice del prodotto e l'intero è la quantità desiderata
	
	public Carrello (Negozio n)				// aggiunto dopo
	{
		this.n=n;
	}
	
	// metodo simile a quello in Negozio ma con il controllo sul prodotto, ossia verificare se esiste nel magazzino
	// e se si, si aggiunge al nuovo HashMap del carrello
	public void aggiungiCarrello (String codice, Integer quantità)
	{
		
		if (n.prodottiMagazzino.containsKey(codice))
		{
			if (quantità<=n.prodottiMagazzino.get(codice).getQuantitàDisponibile())		// controllo se la quantità inserita è minore della quantità disponibile
			{
				prodottiSelezionati.put(codice, quantità);
			}
			else
				System.out.println("Quantità non disponibile");
		}
		else
			System.out.println("Prodotto non presente");
	}
	
	// metodo per elencare i prodotti nel carrello tramite for each
	public void elencoProdottiCarrello ()
	{
		for (String i:prodottiSelezionati.keySet())
		{
			System.out.println("\nCodice prodotto: "+ i +"\tDescrizione: "+ n.prodottiMagazzino.get(i).getDescrizione());
			System.out.println("Prezzo: " + n.prodottiMagazzino.get(i).getPrezzo() + "\tQuantità: " + prodottiSelezionati.get(i));
		}
			
	}
	
	// calcolo del costo totale del carrello
	public void calcoloSpesa (Float costoTotale)
	{
		for (String i:prodottiSelezionati.keySet())
		{
			costoTotale+=(1-(n.prodottiMagazzino.get(i).getSconto()/100))*n.prodottiMagazzino.get(i).getPrezzo()*prodottiSelezionati.get(i).floatValue();
		}
		System.out.println(costoTotale);
	}
	
	// conferma il carrello
	public void confermaCarrello ()
	{
		for (String i:prodottiSelezionati.keySet())
		{
			n.prodottiMagazzino.get(i).setQuantitàDisponibile(n.prodottiMagazzino.get(i).getQuantitàDisponibile()-prodottiSelezionati.get(i));		// imposto la nuova quantità disponibile
		}
		
	}
	
}
