package auftragsverwaltung.c.geschaeftspartner;

import auftragsverwaltung.s.geschaeftspartner.*;
import auftragsverwaltung.c.auftrag.*;
import auftragsverwaltung.c.artikel.*;

/**
 * Auftragsverwaltung:<BR> Klasse des Telefonanschlusses<BR>
 * @author Jonas & Sven
 * @version  0.1
 */
public class Telefon 
{

	/**
	  * der Geschaeftspartner des Telefonanschlusses
	  */
	private Geschaeftspartner geschaeftspartner;
	
	
	/**
	 * @return Geschaeftspartnerobjekt
	 */
	public Geschaeftspartner getGeschaeftspartner() 
	{
	     return geschaeftspartner;
	}
	
	/**
	 * @param Geschaeftspartnerobjekt
	 */
	public void setGeschaeftspartner( Geschaeftspartner geschaeftspartner )	
	{
	     this.geschaeftspartner = geschaeftspartner;
	}
	
}
