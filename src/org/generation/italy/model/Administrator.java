package org.generation.italy.model;

public class Administrator extends Account {

	/*La classe Administrator ha come attributi specifici:
		-codiceBadge (int)
		e come metodi:
		-toString()    (ereditato da Object, customizzato per mostrare i dati dell'Administrator)*/
	
	protected int codiceBadge;

	protected Administrator(String username, String password, String nome, String cognome, int codiceBadge) {
		super(username, password, nome, cognome);
		this.codiceBadge = codiceBadge;
	}

	@Override
	public String toString() {
		return "Administrator [codiceBadge=" + codiceBadge + "]";
	}
	
}
