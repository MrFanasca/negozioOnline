package org.generation.italy;

public class Utente {

	 /* Modificare l'esercizio "Negozio on line" in modo da gestirne l'utilizzo di due tipologie differenti di utenti: amministratore e cliente.
	  	Prevedere una classe Utente con i seguenti attributi:
 	  	-username
		-password
		-nome
		-cognome
		-tipologia
		All'avvio del programma verrà chiesto di inserire username e password dell'utilizzatore, che verranno verificati in un elenco di oggetti Utente 
		appositamente predisposto.
		Se il login riesce, visualizzare un messaggio del tipo "Benvenuto <nome> <cognome> - <tipologia>", e visualizzare le operazioni a lui consentite:
		Amministratore: inserimento prodotto, elenco prodotti, applicazione sconto
		Cliente: elenco prodotti, inserimento nel carrello, conferma carrello*/
	
	private String username, password, nome, cognome, tipologia;

	private Utente (String username, String password, String nome, String cognome, String tipologia) {
		this.username = username;
		this.password = password;
		this.nome = nome;
		this.cognome = cognome;
		this.tipologia = tipologia;
	}

	public String getNome() {
		return nome;
	}

	public String getCognome() {
		return cognome;
	}

	public String getTipologia() {
		return tipologia;
	}
	
	
	
}
