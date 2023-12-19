package org.generation.italy.model;

import java.util.HashMap;

public class GestoreUtenti {

	/*La classe GestoreUtenti contiene i seguenti metodi:
		-aggiungiUtente(account)
		 (aggiunge un utente all'elenco, se non esiste già un utente con quell'account)
		-rimuoviUtente(userName)
	     (rimuove un utente dall'elenco)
		-loginUtente(userName, password)
		 (verifica se un utente con quell'userName e quella password esiste all'interno dell'elenco, in caso positivo restituisce l'oggetto
		 corrispondente)
		-resettaPassword(username)
		 (resetta la password di uno specifico utente a "12345")
		Scrivere inoltre una classe GestoreUtenti che contiene un elenco di  generici oggetti Account (che possono essere di volta in 
		volta User o Administrator)*/
	
	private HashMap <String, Account> listaAccount = new HashMap <>() {{
		put("EnzoSan", new Administrator("EnzoSan", "JAITA101", "Robenzo", "Colluso", 0001));
		put("Fagiano", new Administrator("Fagiano", "4$$", "Federico", "Falasca", 0002));
		put("NonnaPapera", new User("NonnaPapera", "01234", "Franca", "Cera", "20/11/23", "5551231234"));
		put("Maizena02", new User("Maizena02", "00000", "Maisena", "Buttaqui", "05/05/23", "066988456"));
		put("MrSatan", new User("MrSatan", "666", "Maurizio", "Baciacani", "01/06/23", "3974671204"));
	}};
	
	public boolean aggiungiUser(String username, String password, String nome, String cognome, String dataRegistrazione, String nrTelefono) { 
		boolean esito = false;																					
		if (!listaAccount.containsKey(username))
		{
			listaAccount.put(username, new User(username, password, nome, cognome, dataRegistrazione, nrTelefono));
			esito = true;
		}
			
		return esito;
	}
	
	public boolean rimuoviUtente (String username) {							// rimuove un utente dall'elenco
		boolean esito = false;
		if (listaAccount.containsKey(username))
		{
			listaAccount.remove(username);
			esito = true;
		}
		
		return esito;
	}
	
	public String loginUtente (String username, String password) {														// verifica se un utente con quell'userName e quella                   
		 if (listaAccount.containsKey(username) && listaAccount.get(username).getPassword().equals(password))			// password esiste all'interno dell'elenco, in caso
		 {																												// positivo restituisce l'oggetto corrispondente
			return listaAccount.get(username).toString();
		 }
		 else
			 return "Password o Username non validi";
	}
	
	public boolean resettaPassword (String username) {							// resetta la password di uno specifico utente a "12345"
		boolean esito = false;
		if (listaAccount.containsKey(username))
		{
			listaAccount.get(username).setPassword("12345");
			esito = true;
		}
		
		return esito;
	}
	
	public boolean tipologiaUtente (String username, String password) {
		boolean esito = false;
		if (listaAccount.get(username) instanceof Administrator)
			esito = true;
		return esito;
	}
	
	public boolean cambiaPassword (String username, String vecchiaPassword, String nuovaPassword, String confermaNuovaPassword)
	{
		boolean esito = false;
		if (!vecchiaPassword.equals(nuovaPassword) && nuovaPassword.equals(confermaNuovaPassword))
		{
			listaAccount.get(username).setPassword(nuovaPassword);
			esito = true;
		}
		return esito;
	}
}
