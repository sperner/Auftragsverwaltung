package auftragsverwaltung.s.geschaeftspartner;

import java.sql.*;

import auftragsverwaltung.c.geschaeftspartner.*;

/**
 * Auftragsverwaltung:<BR> Klasse des Bankkontos<BR>
 * @author Jonas & Sven
 * @version  0.1
 */
public class BankkontoZ 
{
	
	/**
	 * Konto-Identifikationsnummer
	 */
	private int konto_ID;
	
	/**
	 * Kontonummer
	 */
	private String kontoNr;
	
	/**
	 * Lieferant
	 */
	private int lieferant;
	
	/**
	 * Bank
	 */
	private int bank;
	
	
	/**
	 * @return Konto-Identifikationsnummer
	 */
	public int getKonto_ID() 
	{
		return konto_ID;
	}
	
	/**
	 * @param Konto-Identifikationsnummer
	 */
	public void setKonto_ID(int konto_ID) 
	{
		this.konto_ID = konto_ID;
	}
	
	/**
	 * @return Kontonummer
	 */
	public String getKontoNr() 
	{
		return kontoNr;
	}
	
	/**
	 * @param Kontonummer
	 */
	public void setKontoNr(String kontoNr) 
	{
		this.kontoNr = kontoNr;
	}
	
	/**
	 * @return Lieferant
	 */
	public int getLieferant() 
	{
		return lieferant;
	}
	
	/**
	 * @param Lieferant
	 */
	public void setLieferant(int lieferant) 
	{
		this.lieferant = lieferant;
	}
	
	/**
	 * @return Bank
	 */
	public int getBank() 
	{
		return bank;
	}
	
	/**
	 * @param Bank
	 */
	public void setBank(int bank) 
	{
		this.bank = bank;
	}
	
	/**
	 * @param konto_ID
	 * @param kontoNr
	 * @param lieferant
	 * @param bank
	 */
	public BankkontoZ(int konto_ID, String kontoNr, int lieferant, int bank) 
	{
		super();
		this.konto_ID = konto_ID;
		this.kontoNr = kontoNr;
		this.lieferant = lieferant;
		this.bank = bank;
	}

}
