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
		negozio n = new negozio();
		
		String risposta;
		
		System.out.println("Benvenuto, è lei il mio dominatore? (s/n)");
		risposta=sc.nextLine().toLowerCase();
		if (risposta.equals("s"))
			
		
		System.out.println("Vuoi inserire un prodotto in magazzino");
		
	}

}
