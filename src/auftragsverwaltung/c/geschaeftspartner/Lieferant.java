package auftragsverwaltung.c.geschaeftspartner;

import java.util.ArrayList;

import auftragsverwaltung.s.geschaeftspartner.*;
import auftragsverwaltung.c.auftrag.*;
import auftragsverwaltung.c.artikel.*;

/** 
 * Auftragsverwaltung:<BR> Klasse des Lieferanten<BR>
 * @author Jonas & Sven
 * @version  0.1
 */
public class Lieferant 
{

	/**
	  * der Geschaeftspartner des Lieferanten
	  * @super Geschaeftspartner
	  */
	private Geschaeftspartner geschaeftspartner;
	
	/**
	  * die Liste der Handelswaren
	  */
	private ArrayList<Handelsware> handelswaren;

	
	/**
	 * @return Listenobjekt
	 */
	public ArrayList<Handelsware> getHandelswaren() 
	{
	     return handelswaren;
	}
	
	/**
	 * @param Listenobjekt
	 */
	public void setHandelswaren( ArrayList<Handelsware> handelswaren )	
	{
	     this.handelswaren = handelswaren;
	}
	
}
