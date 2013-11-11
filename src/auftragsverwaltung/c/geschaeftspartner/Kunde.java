package auftragsverwaltung.c.geschaeftspartner;

import java.util.ArrayList;

import auftragsverwaltung.s.geschaeftspartner.*;
import auftragsverwaltung.c.auftrag.*;
import auftragsverwaltung.c.artikel.*;

/**
 * Auftragsverwaltung:<BR> Klasse des Kunden<BR>
 * @author Jonas & Sven
 * @version  0.1
 */
public class Kunde 
{
	
	/**
	  * der Geschaeftspartner des Kunde
	  * @super Geschaeftspartner
	  */
	private Geschaeftspartner geschaeftspartner;
	
	/**
	  * die Liste der Auftraege
	  */
	private ArrayList<Auftrag> auftraege;
	
	
	/**
	 * @return Listenobjekt
	 */
	public ArrayList<Auftrag> getAuftraege() 
	{
	     return auftraege;
	}
	
	/**
	 * @param Listenobjekt
	 */
	public void setAuftraege( ArrayList<Auftrag> auftraege )	
	{
	     this.auftraege = auftraege;
	}

}
