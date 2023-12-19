package org.generation.italy.model;

public class User extends Account {
	/*La classe User ha come attributi specifici:
	-dataRegistrazione (String)
	-nrTelefono (String)
	e come metodi:
	-toString()    (customizzato per mostrare i dati dello User)*/
	
	protected String dataRegistrazione, nrTelefono;

	protected User(String username, String password, String nome, String cognome, String dataRegistrazione, String nrTelefono) {
		super(username, password, nome, cognome);
		this.dataRegistrazione=dataRegistrazione;
		this.nrTelefono=nrTelefono;
	}

	@Override
	public String toString() {
		return "User [dataRegistrazione=" + dataRegistrazione + ", nrTelefono=" + nrTelefono + "]";
	}

	
	
}
