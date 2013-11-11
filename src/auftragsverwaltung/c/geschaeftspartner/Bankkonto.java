package auftragsverwaltung.c.geschaeftspartner;

import auftragsverwaltung.s.geschaeftspartner.*;
import auftragsverwaltung.c.auftrag.*;
import auftragsverwaltung.c.artikel.*;

/**
 * Auftragsverwaltung:<BR> Klasse des Bankkontos<BR>
 * @author Jonas & Sven
 * @version  0.1
 */
public class Bankkonto 
{
	
	/**
	 * Das zugehoerige Objekt der Speicherschicht
	 */	
	private BankkontoZ bankkontoZ;
	
	/**
	 * ein Bankobjekt
	 */
	private Bank bank;
	
	/**
	 * ein Lieferantenobjekt
	 */
	private Lieferant lieferant;

	
	/**
	 * @return  bankkontoZ
	 */
	public BankkontoZ getBankkontoZ() 
	{
	 	return bankkontoZ;
	}

	/**
	 * @param bankkontoZ
	 */
	public void setBankkontoZ(BankkontoZ bankkontoZ) 
	{
	 	this.bankkontoZ = bankkontoZ;
	}

	/**
	 * @return bank
	 */
	public Bank getBank() 
	{
		return bank;
	}

	/**
	 * @param bank
	 */
	public void setBank(Bank bank) 
	{
		this.bank = bank;
	}

	/**
	 * @return lieferant
	 */
	public Lieferant getLieferant() 
	{
		return lieferant;
	}

	/**
	 * @param lieferant
	 */
	public void setLieferant(Lieferant lieferant) 
	{
		this.lieferant = lieferant;
	}
 
}
