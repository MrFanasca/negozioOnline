package org.generation.italy;

public class Prodotto {

	private String codice, descrizione;
	private Float prezzo, sconto;
	private Integer quantitàDisponibile;
	
	public Prodotto(String codice, String descrizione, Float prezzo, Integer quantitàDisponibile) 
	{
		this.codice = codice;
		this.descrizione = descrizione;
		this.prezzo = prezzo;
		sconto=0f;														// sconto pari allo 0% di default
		this.quantitàDisponibile = quantitàDisponibile;
	}

	
	
	
	public String getCodice() 
	{
		return codice;
	}

	public void setCodice(String codice) 
	{
		if (!codice.isEmpty())					
			this.codice = codice;
	}

	public String getDescrizione() 
	{
		return descrizione;
	}

	public void setDescrizione(String descrizione) 
	{
		if (!descrizione.isEmpty())
			this.descrizione = descrizione;
	}

	public Float getPrezzo() 
	{
		return prezzo;
	}

	public void setPrezzo(Float prezzo) 
	{
		if (prezzo>0)
			this.prezzo = prezzo;
		else
			System.out.println("Prezzo non valido");
	}

	public Float getSconto() 
	{
		return sconto;
	}

	public void setSconto(Float sconto) 
	{
		if (sconto>0 && sconto<100)
			this.sconto = sconto;
	}

	public Integer getQuantitàDisponibile() 
	{
		return quantitàDisponibile;
	}

	public void setQuantitàDisponibile(Integer quantitàDisponibile) 
	{
		if (quantitàDisponibile>0)
			this.quantitàDisponibile = quantitàDisponibile;
		else
			System.out.println("Quantità non valida");
	}

	
	
}
