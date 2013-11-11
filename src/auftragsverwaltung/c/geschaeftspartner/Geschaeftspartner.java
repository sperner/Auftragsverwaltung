package auftragsverwaltung.c.geschaeftspartner;

import java.util.ArrayList;

import auftragsverwaltung.s.geschaeftspartner.*;
import auftragsverwaltung.c.auftrag.*;
import auftragsverwaltung.c.artikel.*;

/**
 * Auftragsverwaltung:<BR> Klasse des Geschaeftspartners<BR>
 * @author Jonas & Sven
 * @version  0.1
 */
public class Geschaeftspartner 
{

	/**
	 * @sub Kunde
	 */
	private Kunde kunde;

	/**
	 * @sub Lieferant
	 */
	private Lieferant lieferant;

	/**
	  * die Liste der Telefonnummern
	  */
	private ArrayList<Telefon> telefonnummern;
	
	
	/**
	 * @return Listenobjekt
	 */
	public ArrayList<Telefon> getTelefonnummern() 
	{
	     return telefonnummern;
	}
	
	/**
	 * @param Listenobjekt
	 */
	public void setTelefonnummern( ArrayList<Telefon> telefonnummern )	
	{
	     this.telefonnummern = telefonnummern;
	}

}
