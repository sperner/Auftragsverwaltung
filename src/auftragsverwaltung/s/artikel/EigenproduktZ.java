package auftragsverwaltung.s.artikel;

import java.sql.*;

import auftragsverwaltung.c.artikel.*;

/**
 * Auftragsverwaltung:<BR> Klasse des Eigenprodukts<BR>
 * @author Jonas & Sven
 * @version  0.1
 */
public class EigenproduktZ 
{
	
	/**
	 * Herstellungskosten pro Einheit
	 */
	private double herstellungskostenProEinheit;

	
	/**
	 * @return herstellungskostenProEinheit
	 */
	public double getHerstellungskostenProEinheit() 
	{
		return herstellungskostenProEinheit;
	}
	
	/**
	 * @param herstellungskostenProEinheit
	 */
	public void setHerstellungskostenProEinheit(double herstellungskostenProEinheit) 
	{
		this.herstellungskostenProEinheit = herstellungskostenProEinheit;
	}
	
	/**
	 * @param herstellungskostenProEinheit
	 */
	public EigenproduktZ(double herstellungskostenProEinheit) 
	{
		super();
		this.herstellungskostenProEinheit = herstellungskostenProEinheit;
	}

}
