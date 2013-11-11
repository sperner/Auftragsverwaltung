package auftragsverwaltung.s.geschaeftspartner;

import java.sql.*;

import auftragsverwaltung.c.geschaeftspartner.*;

/**
 * Auftragsverwaltung:<BR> Klasse des Lieferanten<BR>
 * @author Jonas & Sven
 * @version  0.1
 */
public class LieferantZ 
{

	/**
	  * Bankverbindung des Lieferanten
	  */
	private int bankverbindung;

	/**
	 * @return Bankverbindung
	 */
	public int getBankverbindung() 
	{
		return bankverbindung;
	}
	/**
	 * @param Bankverbindung
	 */
	public void setBankverbindung(int bankverbindung) 
	{
		this.bankverbindung = bankverbindung;
	}
	
	/**
	 * @param Bankverbindung
	 */
	public LieferantZ(int bankverbindung) 
	{
		super();
		this.bankverbindung = bankverbindung;
	}

}
