package auftragsverwaltung.s.geschaeftspartner;

import java.sql.*;

import auftragsverwaltung.c.geschaeftspartner.*;

/**
 * Auftragsverwaltung:<BR> Klasse des Geschaeftspartners<BR>
 * @author Jonas & Sven
 * @version  0.1
 */
public class GeschaeftspartnerZ 
{

	/**
	 * Geschaeftspartner-Identifikationsnummer
	 */
	private int gp_ID;
	
	/**
	 * Name des Geschäftspartners
	 */
	private String name;

	/**
	 * Geschaeftspartner ist Kunde
	 * @classifier istKunde -> Geschaeftspartner ist ein Kunde
	 */
	private boolean istKunde;
	
	/**
	 * Geschaeftspartner ist Lieferant
	 * @classifier istLieferant -> Geschaeftspartner ist ein Lieferant
	 */
	private boolean istLieferant;
	
	/**
	 * Anschrift des Geschäftspartners
	 */
	private int anschrift;
	
	
	/**
	 * @return Geschaeftspartner-Identifikationsnummer
	 */
	public int getGp_ID() 
	{
		return gp_ID;
	}
	
	/**
	 * @param Geschaeftspartner-Identifikationsnummer
	 */
	public void setGp_ID(int gp_ID) 
	{
		this.gp_ID = gp_ID;
	}
	
	/**
	 * @return Name des Geschaeftspartners
	 */
	public String getName() 
	{
		return name;
	}
	
	/**
	 * @param Name des Geschaeftspartners
	 */
	public void setName(String name) 
	{
		this.name = name;
	}
	
	/**
	 * @return istKunde
	 */
	public boolean getIstKunde() 
	{
		return istKunde;
	}
	
	/**
	 * @param istKunde
	 */
	public void setIstKunde(boolean istKunde) 
	{
		this.istKunde = istKunde;
	}
	
	/**
	 * @return istLieferant
	 */
	public boolean getIstLieferant() 
	{
		return istLieferant;
	}
	
	/**
	 * @param istLieferant
	 */
	public void setIstLieferant(boolean istLieferant) 
	{
		this.istLieferant = istLieferant;
	}
	
	/**
	 * @return Anschrift
	 */
	public int getAnschrift() 
	{
		return anschrift;
	}
	
	/**
	 * @param Anschrift
	 */
	public void setAnschrift(int anschrift) 
	{
		this.anschrift = anschrift;
	}
	
	/**
	 * @param gp_ID
	 * @param name
	 * @param istKunde
	 * @param istLieferant
	 * @param anschrift
	 */
	public GeschaeftspartnerZ(int gp_ID, String name, boolean istKunde, boolean istLieferant, int anschrift) 
	{
		super();
		this.gp_ID = gp_ID;
		this.name = name;
		this.istKunde = istKunde;
		this.istLieferant = istLieferant;
		this.anschrift = anschrift;
	}
	
}
