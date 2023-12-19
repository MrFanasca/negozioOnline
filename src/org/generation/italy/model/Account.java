package org.generation.italy.model;

public class Account {

	/*Scrivere una classe Account con i seguenti attributi:
		-username (String)
		-password (String)
		-nome (String)
		-cognome (String)
		e i seguenti metodi:
		-cambiaPassword(String vecchiaPassword, String nuovaPassword, String confermaNuovaPassword)
		 (permette il cambio della password, verificando che si conosca la vecchiaPassword, e confermando la nuova password 2 volte)
		-toString()    
		 (ereditato da Object, customizzato per mostrare i dati dell'Account)
		Scrivere inoltre le classi User e Administrator che estendono la classe Account*/
	
	protected String username, password, nome, cognome;

	protected Account (String username, String password, String nome, String cognome) {
		this.username = username;
		this.password = password;
		this.nome = nome;
		this.cognome = cognome;
	}
	
	public String getPassword() {
		return password;
	}

	protected void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Account [username=" + username + ", password=" + password + ", nome=" + nome + ", cognome=" + cognome
				+ "]";
	}
	
}
