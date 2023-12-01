package org.generation.italy;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		/* Scrivere un programma che simula il funzionamento di un negozio online.
		Le funzionalità da realizzare sono:
		1)Inserimento prodotto: consente di inserire i dati di un nuovo prodotto al negozio. 
		Ogni prodotto è caratterizzato da:
		-codice (String): codice identificativo del prodotto (non è possibile inserire due prodotti con lo stesso 
						codice)
		-Descrizione (String)
		-Prezzo (float)
		-Sconto (float): percentuale di sconto da applicare eventualmente al prodotto (di default 0)
		-Quantità disponibile
		2)Elenco prodotti: per ogni prodotto vengono visualizzate le informazioni
		3)Applica sconto: si inserisce il codice di un prodotto e la percentuale di sconto da applicare
		4)Vendita prodotti:
		-si chiede all'utente di scegliere un prodotto dall'elenco (inserendo il codice);
		-si visualizzano le informazioni del prodotto scelto;
		-si chiede la quantità da acquistare;
		-se la quantità disponibile è sufficiente, il prodotto si aggiunge al "carrello della spesa" applicando 
		 eventuali sconti (in questo caso mostrare sia il prezzo originale che il prezzo scontato)
		-si visualizza il carrello attuale
		-si chiede se si vuole procedere all'acquisto (in caso positivo si mostra il totale e si aggiornano le 
		 quantità disponibili) */
		
		Scanner sc = new Scanner(System.in);
		Negozio n = new Negozio();
		Carrello c = new Carrello();
		
		String codice, descrizione, risposta;
		Float prezzo, sconto;
		Integer quantità;
		
		// syso per le 4 possibilità di interazione. Per l'inserimento dei prodotti e dell'applicazione dello sconto
		// richiedere la password, per gli altri due indirizzare ad un metodo specifico
		System.out.println("Benvenuto, nell' e-commerce der mejo gruppo?");
		do
		{
		System.out.println("1 - Inserimento prodotto");
		System.out.println("2 - Elenco prodotti");
		System.out.println("3 - Applica sconto");
		System.out.println("4 - Vendita prodotti");
		System.out.print("\nChe operazione vuoi compiere?");

		risposta = sc.nextLine();
		switch (risposta) {
		case "1":									// Inserimento prodotti
			System.out.println("Inserisci la Password");
			risposta=sc.nextLine();
			if (risposta.equals("EnzoSan"))
			{
				System.out.println("Inserisci il prodotto seguendo le indicazioni");
				System.out.println("Inserisci il codice");
				codice=sc.nextLine();
				System.out.println("Inserisci la descrizione");
				descrizione=sc.nextLine();
				System.out.println("Inserisci il prezzo");
				prezzo=Float.parseFloat(sc.nextLine());
				System.out.println("Inserisci la quantità");
				quantità= Integer.parseInt(sc.nextLine());
				n.aggiungiProdotto(codice, descrizione, prezzo, quantità);
			}
				
			break;
		case "2":									// Elenco dei prodotti disponibili
			System.out.println("Questi sono i nostri prodotti disponibili");
			n.elencoProdotti();
			break;
		case "3":									// Applica uno sconto
			System.out.println("Inserisci la Password");
			risposta=sc.nextLine();
			if (risposta.equals("EnzoSan"))
			{
				System.out.println("Inserisci il codice del prodotto a cui vuoi cambiare lo sconto");
				codice=sc.nextLine();
				System.out.println("Inserire lo sconto voluto");
				sconto=Float.parseFloat(sc.nextLine());
				n.applicaSconto(codice,sconto);
			}
			break;
		case "4": 									// Aggiungi al carrello
			do
			{
				n.elencoProdotti();
				System.out.println("Quale prodotto vuoi comperare?");
				// inserire codice e quantità
				System.out.println("\nInserire il codice del prodotto da inserire nel carrello");
				codice=sc.nextLine();
				// visualizziamo il prodotto desiderato
				System.out.println("\nCodice prodotto: "+ codice +"\tDescrizione: "+ n.prodottiMagazzino.get(codice).getDescrizione());
				System.out.println("Prezzo: " + n.prodottiMagazzino.get(codice).getPrezzo() + "\tQuantità: " + n.prodottiMagazzino.get(codice).getQuantitàDisponibile());
				// visualizza un possibile sconto
				if (n.prodottiMagazzino.get(codice).getSconto()>0)
				{
					System.out.println("\nSconto su questo articolo:");
				 	n.visualizzaSconto(codice);
				 	
				}
				// inserire la quantità richiesta
				System.out.println("\nInserire la quantità del prodotto da inserire nel carrello");
				quantità=Integer.parseInt(sc.nextLine());
				c.aggiungiCarrello(codice, quantità);	
				System.out.println("Vuoi proseguire con la spesa? (s/n)");
			}	while (risposta.equals("n"));
			
			System.out.println("\nQuesti sono i prodotti nel carrello");
			c.elencoProdottiCarrello();
			
			
			break;
		default:
			System.out.println("Scelta non valida");
			}
		System.out.println("\nVuoi fare altro? (s/n)");
		risposta=sc.nextLine();
		}while (risposta.equals("s"));
		
		
		
		
		
		
		
		
		
		
		
		
		
				
	
		
		
		

		
		

		
	}

}
