package org.generation.italy;

import java.util.Scanner;

import org.generation.italy.model.GestoreUtenti;

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
		Carrello c = new Carrello(n);			// Carrello c = new Carrello
		GestoreUtenti gu = new GestoreUtenti();
		
		String codice, descrizione, risposta, usernameIngresso, username, password, confermaPassword, vecchiaPassword, nome, cognome, dataRegistrazione, nrTelefono;
		Float prezzo, sconto, costoTotale=0f;
		int quantità;
		boolean esito=true;
		
		// syso per le 4 possibilità di interazione. Per l'inserimento dei prodotti e dell'applicazione dello sconto
		// richiedere la password, per gli altri due indirizzare ad un metodo specifico
		System.out.println("Benvenuto, nell' e-commerce der mejo gruppo");
		do
		{
			System.out.println("Inserisci l'username");
			usernameIngresso=sc.nextLine();
			System.out.println("Inserisci la password");
			password=sc.nextLine();
			gu.loginUtente(usernameIngresso, password);
			if (gu.loginUtente(usernameIngresso, password).equals("Password o Username non validi"))
				esito=false;
			else
			{
				////////////////////////////////////////////////////////////////
				if (gu.tipologiaUtente(usernameIngresso, password))						// menu amministratore
				{
					do
					{
						System.out.println("\n\nScegli un opzione dal menù");
						System.out.println("\n1 - Gestione utenti");
						System.out.println("2 - Gestione negozio");
						risposta=sc.nextLine();
						switch (risposta)
						{
						case "1":													// menu gestione utenti da amministratore
							do
							{
								System.out.println("\n\nScegli un opzione dal menù");
								System.out.println("\n1 - Rimuovi utente");
								System.out.println("2 - Resetta password utente");
								System.out.println("3 - Aggiungi utente");
								System.out.println("4 - Cambia la propria password");
								risposta=sc.nextLine();
						
								switch (risposta)
								{
								case "1":												// rimuovi utente
									System.out.println("\nInserisci l'username dell'utente da rimuovere");
									username=sc.nextLine();
							
									if (gu.rimuoviUtente(username))
										System.out.println("Utente rimosso");
									
									else
										System.out.println("Rimozione non riuscita");
									break;
							
								case "2":												// resettare la password di uno specifico utente
									System.out.println("\nInserisci l'username dell'utente al quale si vuole resettare la password");
									username=sc.nextLine();
							
									if (gu.resettaPassword(username))
										System.out.println("Password resettata");
									else
										System.out.println("Operazione non riuscita");
									break;
							
								case "3":												// aggiungere un nuovo utente
									
									System.out.println("\nSegui le indicazioni per aggiungere il nuovo utente\\nInserisci l'username");
									username=sc.nextLine();
									System.out.println("Inserisci la password");
									password=sc.nextLine();
									System.out.println("Inserisci il nome");
									nome=sc.nextLine();
									System.out.println("Rinserisci il cognome");
									cognome=sc.nextLine();
									System.out.println("Inserisci la data di registrazione");
									dataRegistrazione=sc.nextLine();
									System.out.println("Rinserisci il numero di telefono");
									nrTelefono=sc.nextLine();
							
									if (gu.aggiungiUser(username, password, nome, cognome, dataRegistrazione, nrTelefono))
										System.out.println("Utente aggiunto correttamente");
									else
										System.out.println("Operazione non riuscita");
									break;
							
								case "4":												// cambiare la propropria password
									
									System.out.println("\nInserisci la vecchia password");
									vecchiaPassword=sc.nextLine();
									System.out.println("Inserisci la nuova password");
									password=sc.nextLine();
									System.out.println("Rinserisci la nuova password");
									confermaPassword=sc.nextLine();
									if (gu.cambiaPassword(usernameIngresso, vecchiaPassword, password, confermaPassword))
										System.out.println("Password cambiata con successo");
									else
										System.out.println("Operazione non riuscita");
									break;
							
								default:
									System.out.println("\nScelta non valida");
									break;
								}
							
								System.out.println("\nVuoi apportare altre moddifiche al menù utente? (s/n)");
								risposta=sc.nextLine();
							
							}	while (risposta.equalsIgnoreCase("s"));
						
							break;
						
						case "2":
							do
							{
								System.out.println("\n\nScegli un opzione dal menù");
								System.out.println("\n1 - Inserimento prodotto");
								System.out.println("2 - Elenco prodotti");
								System.out.println("3 - Applica sconto");
								System.out.print("\nChe operazione vuoi compiere?");

								risposta = sc.nextLine();
								switch (risposta) 
								{
									case "1":									// Inserimento prodotti
										System.out.println("\nSegui le indicazioni per aggiungere il prodotto\nInserisci il codice");
										codice=sc.nextLine();
										System.out.println("Inserisci la descrizione");
										descrizione=sc.nextLine();
										System.out.println("Inserisci il prezzo");
										prezzo=Float.parseFloat(sc.nextLine());
										System.out.println("Inserisci la quantità");
										quantità= Integer.parseInt(sc.nextLine());
										n.aggiungiProdotto(codice, descrizione, prezzo, quantità);
										break;
										
									case "2":									// Elenco dei prodotti disponibili
										System.out.println("\nQuesti sono i nostri prodotti disponibili");
										n.elencoProdotti();
										break;
									case "3":									// Applica uno sconto
										System.out.println("\nInserisci il codice del prodotto a cui vuoi cambiare lo sconto");
										codice=sc.nextLine();
										System.out.println("Inserire lo sconto voluto");
										sconto=Float.parseFloat(sc.nextLine());
										n.applicaSconto(codice,sconto);
										break;
									default:
										System.out.println("Scelta non valida");
										break;
								}
					
								System.out.println("\nVuoi continuare ad operare nel negozio? (s/n)");
								risposta=sc.nextLine();
						
							}	while (risposta.equalsIgnoreCase("s"));
						
							break;
						
						default:
							System.out.println("\nScelta non valida");
							break;
						}
						
						System.out.println("\nVuoi disconnetterti come amministratore? (s/n)");
						risposta=sc.nextLine();
						
					}	while (risposta.equalsIgnoreCase("n"));
						
				}
				////////////////////////////////////////////////////////////////
				else															// menu user
				{
					do
					{
						System.out.println("\n\nScegli un opzione dal menù");
						System.out.println("\n1 - Cambia Password");
						System.out.println("2 - Entra nel negozio");
						risposta=sc.nextLine();
						
						switch (risposta)
						{
						case "1":												// cambia password 
							
							
							System.out.println("\nInserisci la vecchia password");
							vecchiaPassword=sc.nextLine();
							System.out.println("Inserisci la nuova password");
							password=sc.nextLine();
							System.out.println("Rinserisci la nuova password");
							confermaPassword=sc.nextLine();
							
							if (gu.cambiaPassword(usernameIngresso, vecchiaPassword, password, confermaPassword))
								System.out.println("Password cambiata con successo");
							else
								System.out.println("Operazione non riuscita");
							break;
							
						case "2":												// menù interazione negozio da user 
							do
							{
								System.out.println("\n\nScegli un opzione dal menù");
								System.out.println("\n1 - Elenco prodotti");
								System.out.println("2 - Vendita prodotti");
								System.out.print("\nChe operazione vuoi compiere?");

								risposta = sc.nextLine();
								switch (risposta) 
								{
									case "1":									// Elenco dei prodotti disponibili
										System.out.println("\nQuesti sono i nostri prodotti disponibili");
										n.elencoProdotti();
										break;
									case "2": 									// Aggiungi al carrello
										do
										{
											System.out.println("\nI prodotti all'interno dello store sono i seguenti");
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
											System.out.println("\nQuesti sono i prodotti nel carrello");
											c.elencoProdottiCarrello();
											System.out.println("Vuoi terminare la spesa? (s/n)");
											risposta=sc.nextLine();
										}	while (risposta.equals("n"));
						
										System.out.println("Confermare l'ordine per procedere al pagamento (s/n)");
										risposta=sc.nextLine();
								
										if (risposta.equalsIgnoreCase("s"))
										{
											c.confermaCarrello();
											System.out.println("\nCosto totale: ");
											c.calcoloSpesa(costoTotale);
										}
										break;
								
									default:
										System.out.println("\nScelta non valida");
										break;
								}
					
								System.out.println("\nVuoi fare altro nel menù negozio? (s/n)");
								risposta=sc.nextLine();	
							}	while (risposta.equals("s"));
							
							break;
							
						default:
							System.out.println("\nScelta non valida");
							break;
						}
						
						System.out.println("\nVuoi disconnetterti come amministratore? (s/n)");
						risposta=sc.nextLine();
						
					} while (risposta.equalsIgnoreCase("n"));
				}
			}
			
		System.out.println("\nVuoi uscire dal negozio? (s/n)");	
		risposta=sc.nextLine();
		
		} while (risposta.equalsIgnoreCase("n"));	
		
		
		System.out.println("Arrivederci");
		
		sc.close();
	}

}
