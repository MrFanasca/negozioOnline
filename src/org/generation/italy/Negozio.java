package org.generation.italy;

import java.util.HashMap;

public class Negozio {

	public HashMap <String, Prodotto> prodottiMagazzino = new HashMap<>();
	
	private HashMap <String, Utente> elencoUtenti = new HashMap <>() {{
		put("EnzoSan", new Utente("EnzoSan", "JAITA101", "Robenzo", "Colluso", "Amministratore"));
		put("Fagiano", new Utente("Fagiano", "4$$", "Federico", "Falasca", "Amministratore"));
		put("NonnaPapera", new Utente("NonnaPapera", "01234", "Franca", "Cera", "Cliente"));
		put("Maizena02", new Utente("Maizena02", "00000", "Maisena", "Buttaqui", "Cliente"));
		put("MrSatan", new Utente("MrSatan", "666", "Maurizio", "Baciacani", "Cliente"));
	}};

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
			if (prodottiMagazzino.get(n).getSconto()>0)
			{
				System.out.println("\nSconto su questo articolo:");
				visualizzaSconto(n);
			}
		}
			
	}
	
	// metodo per inserire lo sconto ad un determinato prodotto
	public void applicaSconto (String codice, Float sconto)
	{
		prodottiMagazzino.get(codice).setSconto(sconto);
	}
	
	public void visualizzaSconto (String codice)
	{
		System.out.println(prodottiMagazzino.get(codice).getSconto() + "%");
	}
	
	// metodo per il controllo dell'esistenza dell'utente
	public boolean controlloUtente (String username)
	{
		boolean esito = false;
		if (elencoUtenti.containsKey(username))
		{
			esito = true;
		}
		return esito;
	}
	
	// metodo per il controllo della password
	public boolean controlloPassword (String username, String password)
	{
		boolean esito = false;
		if (elencoUtenti.get(username).getPassword().equals(password))
		{
			esito = true;
		}
		return esito;
	}
	
	// metodo per l'apertura del menù in funzione alla tipologia dell'utente
	public String menù (String username)
	{
		return elencoUtenti.get(username).getTipologia();
	}
	
	public String benvenuto (String username) {
		
		return "Benvenuto " + elencoUtenti.get(username).getNome() + " " + elencoUtenti.get(username).getCognome() + ", " +
				elencoUtenti.get(username).getTipologia();
	}
}
