package auftragsverwaltung.s.geschaeftspartner;

import java.sql.*;

import auftragsverwaltung.c.geschaeftspartner.*;

/**
 * Auftragsverwaltung:<BR> Klasse des Kunden<BR>
 * @author Jonas & Sven
 * @version  0.1
 */
public class KundeZ 
{
	
	/**
	  * Kreditlimit des Kunden
	  */
	private double kreditlimit;

	
	/**
	 * @return Kreditlimit
	 */
	public double getKreditlimit() 
	{
		return kreditlimit;
	}
	
	/**
	 * @param Kreditlimit
	 */
	public void setKreditlimit(double kreditlimit) 
	{
		this.kreditlimit = kreditlimit;
	}

}
