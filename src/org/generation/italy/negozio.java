package org.generation.italy;

import java.util.HashMap;

public class negozio {

	public HashMap <String, prodotto> prodottiMagazzino = new HashMap<>();

	public negozio(HashMap<String, prodotto> prodottiMagazzino) 
	{
		this.prodottiMagazzino = prodottiMagazzino;
	}
	
	public void inserimentoMagazzino ()
	{
		System.out.println();
	}
	
}
