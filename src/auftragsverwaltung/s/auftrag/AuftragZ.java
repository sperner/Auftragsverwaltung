package auftragsverwaltung.s.auftrag;

import java.sql.*;

import auftragsverwaltung.c.auftrag.*;

/**
 * Auftragsverwaltung:<BR> Klasse des Auftrags<BR>
 * @author Jonas & Sven
 * @version  0.1
 */
public class AuftragZ 
{

	/**
	 * Auftrags-Identifikationsnummer
	 */
	private int auftrag_ID;
	
	/**
	 * Auftragsnummer
	 */
	private String auftragNr;
	
	/**
	 * Datum des Auftrags
	 */
	private Date auftragsdatum;
	
	/**
	 * Kunde
	 */
	private int kunde;
	
	
	/**
	 * @return auftrag_ID
	 */
	public int getAuftrag_ID() 
	{
		return auftrag_ID;
	}
	
	/**
	 * @param auftrag_ID
	 */
	public void setAuftrag_ID(int auftrag_ID) 
	{
		this.auftrag_ID = auftrag_ID;
	}
	
	/**
	 * @return auftragNr
	 */
	public String getAuftragNr() 
	{
		return auftragNr;
	}
	
	/**
	 * @param auftragNr
	 */
	public void setAuftragNr(String auftragNr) 
	{
		this.auftragNr = auftragNr;
	}
	
	/**
	 * @return auftragsdatum
	 */
	public Date getAuftragsdatum() 
	{
		return auftragsdatum;
	}
	
	/**
	 * @param auftragsdatum
	 */
	public void setAuftragsdatum(Date auftragsdatum) 
	{
		this.auftragsdatum = auftragsdatum;
	}
	
	/**
	 * @return kunde
	 */
	public int getKunde() 
	{
		return kunde;
	}
	
	/**
	 * @param kunde
	 */
	public void setKunde(int kunde) 
	{
		this.kunde = kunde;
	}
	
	/**
	 * @param auftrag_ID
	 * @param auftragNr
	 * @param auftragsdatum
	 * @param kunde
	 */
	public AuftragZ(int auftrag_ID, String auftragNr, Date auftragsdatum, int kunde) 
	{
		super();
		this.auftrag_ID = auftrag_ID;
		this.auftragNr = auftragNr;
		this.auftragsdatum = auftragsdatum;
		this.kunde = kunde;
	}
	
	/**
	 * @return Auftragspreis
	 */
/*	
	public double auftragspreis() 
	{
		for(int i; i<sizeof(auftragspositionen); i++)
		{
			
		}
		return(0.0);
	}
*/
	
	/**
	 * @return heutiges Datum
	 */
/*
	public Date auftragsdatum() 
	{
		return("TODAY");
	}
*/
	
}
