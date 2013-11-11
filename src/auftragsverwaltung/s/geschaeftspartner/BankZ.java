package auftragsverwaltung.s.geschaeftspartner;

import java.sql.*;

import auftragsverwaltung.c.geschaeftspartner.*;

/**
 * Auftragsverwaltung:<BR> Klasse der Bank<BR>
 * @author Jonas & Sven
 * @version  0.1
 */
public class BankZ 
{
	
	/**
	 * Name der Bank
	 */
	private String name;
	
	/**
	 * Bankleitzahl
	 */
	private String blz;
	
	
	/**
	 * @return Name der Bank
	 */
	public String getName() 
	{
		return name;
	}
	
	/**
	 * @param Name der Bank
	 */
	public void setName(String name) 
	{
		this.name = name;
	}
	
	/**
	 * @return Bankleitzahl
	 */
	public String getBlz() 
	{
		return blz;
	}
	
	/**
	 * @param Bankleitzahl
	 */
	public void setBlz(String blz) 
	{
		this.blz = blz;
	}
	
	/**
	 * @param Name der Bank
	 * @param Bankleitzahl
	 */
	public BankZ(String name, String blz) 
	{
		super();
		this.name = name;
		this.blz = blz;
	}
	
}
