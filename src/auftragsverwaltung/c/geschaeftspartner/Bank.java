package auftragsverwaltung.c.geschaeftspartner;

import auftragsverwaltung.s.geschaeftspartner.*;
import auftragsverwaltung.c.*;
import auftragsverwaltung.c.artikel.*;
import auftragsverwaltung.c.auftrag.*;
import auftragsverwaltung.c.geschaeftspartner.*;

/**
 * Auftragsverwaltung:<BR> Klasse der Bank<BR>
 * @author Jonas & Sven
 * @version  0.1
 */
public class Bank 
{
 
	/**
	 * Das zugehoerige Objekt der Speicherschicht
	 */
	private BankZ bankZ;
	 
 
	public Bank() { }

	/**
	 * @param bankZ
	 */
	public void setBankZ(BankZ bankZ) 
	{
		this.bankZ = bankZ;
	}

    /**
  	 * @return bankZ
  	 */
	public BankZ getBankZ() 
	{
		return bankZ;
	}
 
}
