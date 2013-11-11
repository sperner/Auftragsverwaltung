package auftragsverwaltung.s.geschaeftspartner;

import java.sql.*;

import auftragsverwaltung.c.geschaeftspartner.*;

/**
 * Auftragsverwaltung:<BR> Klasse der Anschrift<BR>
 * @author Jonas & Sven
 * @version  0.1
 */
public class AnschriftZ 
{

	/**
	 * Anschrift-Identifikationsnummer
	 */
	private int anschrift_ID;

	/**
	 * Strasse und Hausnummer
	 */
	private String strasseHausnr;
	
	/**
	 * Postleitzahl
	 */
	private String plz;
	
	/**
	 * Ort
	 */
	private String ort;
	
	/**
	 * Land
	 */
	private String land;

	/**
	 * Geschäftspartner
	 */
	private int gp;
		
	
	/**
	 * @return Anschrift-Identifikationsnummer
	 */
	public int getAnschrift_ID() 
	{
		return anschrift_ID;
	}
	
	/**
	 * @param Anschrift-Identifikationsnummer
	 */
	public void setAnschrift_ID(int anschrift_ID) 
	{
		this.anschrift_ID = anschrift_ID;
	}
	
	/**
	 * @return Strasse und Hausnummer
	 */
	public String getStrasseHausnr() 
	{
		return strasseHausnr;
	}
	
	/**
	 * @param Strasse und Hausnummer
	 */
	public void setStrasseHausnr(String strasseHausnr) 
	{
		this.strasseHausnr = strasseHausnr;
	}
	
	/**
	 * @return Postleitzahl
	 */
	public String getPlz() 
	{
		return plz;
	}
	
	/**
	 * @param Postleitzahl
	 */
	public void setPlz(String plz) 
	{
		this.plz = plz;
	}
	
	/**
	 * @return Ort
	 */
	public String getOrt() 
	{
		return ort;
	}
	
	/**
	 * @param Ort
	 */
	public void setOrt(String ort) 
	{
		this.ort = ort;
	}
	
	/**
	 * @return Land
	 */
	public String getLand()
	{
		return land;
	}
	
	/**
	 * @param Land
	 */
	public void setLand(String land) 
	{
		this.land = land;
	}
	
	/**
	 * @return Geschäftspartner
	 */
	public int getGp() 
	{
		return gp;
	}
	
	/**
	 * @param Geschäftspartner
	 */
	public void setGp(int gp) 
	{
		this.gp = gp;
	}

	/**
	 * @param anschrift_ID
	 * @param strasseHausnr
	 * @param plz
	 * @param ort
	 * @param land
	 * @param gp
	 */
	public AnschriftZ(int anschrift_ID, String strasseHausnr, String plz, String ort, String land, int gp) 
	{
		super();
		this.anschrift_ID = anschrift_ID;
		this.strasseHausnr = strasseHausnr;
		this.plz = plz;
		this.ort = ort;
		this.land = land;
		this.gp = gp;
	}
	
	/**
	 * @return Zeichenkette "Deutschland"
	 */
	public String land() 
	{
		return("Deutschland");
	}

}
