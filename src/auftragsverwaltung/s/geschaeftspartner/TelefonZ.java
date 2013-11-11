package auftragsverwaltung.s.geschaeftspartner;

import java.sql.*;

import auftragsverwaltung.c.geschaeftspartner.*;

/**
 * Auftragsverwaltung:<BR> Klasse des Telefonanschlusses<BR>
 * @author Jonas & Sven
 * @version  0.1
 */
public class TelefonZ 
{

	/**
	 * Telefonnummer
	 */
	private String telNr;
	
	/**
	 * Telefon-Identifikationsnummer
	 */
	private int telNr_ID;
	
	/**
	 * Geschaeftspartner
	 */
	private int gp;
	
	
	/**
	 * @return Telefonnummer
	 */
	public String getTelNr() 
	{
		return telNr;
	}
	
	/**
	 * @param Telefonnummer
	 */
	public void setTelNr(String telNr) 
	{
		this.telNr = telNr;
	}
	
	/**
	 * @return Telefon-Identifikationsnummer
	 */
	public int getTelNr_ID() 
	{
		return telNr_ID;
	}
	
	/**
	 * @param Telefon-Identifikationsnummer
	 */
	public void setTelNr_ID(int telNr_ID) 
	{
		this.telNr_ID = telNr_ID;
	}
	
	/**
	 * @return Geschaeftspartner
	 */
	public int getGp() 
	{
		return gp;
	}
	
	/**
	 * @param Geschaeftspartner
	 */
	public void setGp(int gp) 
	{
		this.gp = gp;
	}
	
	/**
	 * @param telNr_ID
	 * @param telNr
	 * @param gp
	 */
	public TelefonZ(int telNr_ID, String telNr, int gp) 
	{
		super();
		this.telNr_ID = telNr_ID;
		this.telNr = telNr;
		this.gp = gp;
	}
	
}
