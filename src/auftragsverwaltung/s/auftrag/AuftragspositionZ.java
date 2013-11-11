package auftragsverwaltung.s.auftrag;

import java.sql.*;

import auftragsverwaltung.c.auftrag.*;

/**
 * Auftragsverwaltung:<BR> Klasse der Auftragsposition<BR>
 * @author Jonas & Sven
 * @version  0.1
 */
public class AuftragspositionZ 
{

	/**
	 * laufende Nummer
	 */
	private int lfdNr;
	
	/**
	 * Bestellmenge
	 */
	private Double bestellmenge;
	
	/**
	 * Auftrag
	 */
	private int auftrag;
	
	/**
	 * Artikel
	 */
	private int artikel;
	
	
	/**
	 * @return lfdNr
	 */
	public int getLfdNr() 
	{
		return lfdNr;
	}
	
	/**
	 * @param lfdNr
	 */
	public void setLfdNr(int lfdNr) 
	{
		this.lfdNr = lfdNr;
	}
	
	/**
	 * @return bestellmenge
	 */
	public Double getBestellmenge() 
	{
		return bestellmenge;
	}
	
	/**
	 * @param bestellmenge
	 */
	public void setBestellmenge(Double bestellmenge) 
	{
		this.bestellmenge = bestellmenge;
	}
	
	/**
	 * @return auftrag
	 */
	public int getAuftrag() 
	{
		return auftrag;
	}
	
	/**
	 * @param auftrag
	 */
	public void setAuftrag(int auftrag) 
	{
		this.auftrag = auftrag;
	}
	
	/**
	 * @return artikel
	 */
	public int getArtikel() 
	{
		return artikel;
	}
	
	/**
	 * @param artikel
	 */
	public void setArtikel(int artikel) 
	{
		this.artikel = artikel;
	}
	
	/**
	 * @param lfdNr
	 * @param bestellmenge
	 * @param auftrag
	 * @param artikel
	 */
	public AuftragspositionZ(int lfdNr, Double bestellmenge, int auftrag, int artikel) 
	{
		super();
		this.lfdNr = lfdNr;
		this.bestellmenge = bestellmenge;
		this.auftrag = auftrag;
		this.artikel = artikel;
	}

	/**
	 * @return Positionspreis
	 */
/*
	public double positionspreis() {
		
		return(bestellmenge*artikel.preisProEinheit);
	} 
*/
	
}
