package auftragsverwaltung.s.artikel;

import java.sql.*;

import auftragsverwaltung.c.artikel.*;

/**
 * Auftragsverwaltung:<BR> Klasse des Artikels<BR>
 * @author Jonas & Sven
 * @version  0.1
 */
public class ArtikelZ 
{
	
	/**
	 * Artikel-Identifikationsnummer
	 */
	private int artikel_ID;
	
	/**
	 * Artikelnummer
	 */
	private int artikelNr;
	
	/**
	 * Artikelbezeichnung
	 */
	private String bezeichnung;
	
	/**
	 * Maßeinheit
	 */
	private String einheit;
	
	/**
	 * Preis pro Einheit
	 */
	private double preisProEinheit;
	
	/**
	 * Herkunft ( Eigenprodukt / Handelsware )
	 * @selector  "Eigenprodukt" -> Artikel ist Eigenprodukt
	 *			  "Handelsware"  -> Artikel ist Handelsware
	 */
	private String herkunft;
	
	
	/**
	 * @return artikel_ID
	 */
	public int getArtikel_ID() 
	{
		return artikel_ID;
	}
	
	/**
	 * @param artikel_ID
	 */
	public void setArtikel_ID(int artikel_ID) 
	{
		this.artikel_ID = artikel_ID;
	}
	
	/**
	 * @return artikelNr
	 */
	public int getArtikelNr() 
	{
		return artikelNr;
	}
	
	/**
	 * @param artikelNr
	 */
	public void setArtikelNr(int artikelNr) 
	{
		this.artikelNr = artikelNr;
	}
	
	/**
	 * @return bezeichnung
	 */
	public String getBezeichnung() 
	{
		return bezeichnung;
	}
	
	/**
	 * @param bezeichnung
	 */
	public void setBezeichnung(String bezeichnung) 
	{
		this.bezeichnung = bezeichnung;
	}
	
	/**
	 * @return einheit
	 */
	public String getEinheit() 
	{
		return einheit;
	}
	
	/**
	 * @param einheit
	 */
	public void setEinheit(String einheit) 
	{
		this.einheit = einheit;
	}
	
	/**
	 * @return preisProEinheit
	 */
	public double getPreisProEinheit() 
	{
		return preisProEinheit;
	}
	
	/**
	 * @param preisProEinheit
	 */
	public void setPreisProEinheit(double preisProEinheit) 
	{
		this.preisProEinheit = preisProEinheit;
	}
	
	/**
	 * @return herkunft
	 */
	public String getHerkunft() 
	{
		return herkunft;
	}
	
	/**
	 * @param herkunft
	 */
	public void setHerkunft(String herkunft) 
	{
		this.herkunft = herkunft;
	}
	
	/**
	 * @param artikel_ID
	 * @param artikelNr
	 * @param bezeichnung
	 * @param einheit
	 * @param preisProEinheit
	 * @param herkunft
	 */
	public ArtikelZ(int artikel_ID, int artikelNr, String bezeichnung, String einheit, double preisProEinheit, String herkunft) 
	{
		super();
		this.artikel_ID = artikel_ID;
		this.artikelNr = artikelNr;
		this.bezeichnung = bezeichnung;
		this.einheit = einheit;
		this.preisProEinheit = preisProEinheit;
		this.herkunft = herkunft;
	}
	
}
