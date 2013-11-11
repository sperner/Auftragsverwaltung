package auftragsverwaltung.s.artikel;

import java.sql.*;

import auftragsverwaltung.c.artikel.*;

/**
 * Auftragsverwaltung:<BR> Klasse der Handelsware<BR>
 * @author Jonas & Sven
 * @version  0.1
 */
public class HandelswareZ 
{
	
	/**
	 * Einkaufspreis pro Einheit
	 */
	private double einkaufspreisProEinheit;
	
	/**
	 * Lieferant
	 */
	private int lieferant;
	
	
	/**
	 * @return einkaufspreisProEinheit
	 */
	public double getEinkaufspreisProEinheit() 
	{
		return einkaufspreisProEinheit;
	}
	
	/**
	 * @param einkaufspreisProEinheit
	 */
	public void setEinkaufspreisProEinheit(double einkaufspreisProEinheit) 
	{
		this.einkaufspreisProEinheit = einkaufspreisProEinheit;
	}
	
	/**
	 * @return lieferant
	 */
	public int getLieferant() 
	{
		return lieferant;
	}
	
	/**
	 * @param lieferant
	 */
	public void setLieferant(int lieferant) 
	{
		this.lieferant = lieferant;
	}
	
	/**
	 * @param einkaufspreisProEinheit
	 * @param lieferant
	 */
	public HandelswareZ(double einkaufspreisProEinheit, int lieferant) 
	{
		super();
		this.einkaufspreisProEinheit = einkaufspreisProEinheit;
		this.lieferant = lieferant;
	}
	
}
