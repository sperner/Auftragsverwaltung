package auftragsverwaltung.c.geschaeftspartner;

import auftragsverwaltung.s.geschaeftspartner.*;
import auftragsverwaltung.c.*;
import auftragsverwaltung.c.artikel.*;
import auftragsverwaltung.c.auftrag.*;
import auftragsverwaltung.c.geschaeftspartner.*;

/**
 * Auftragsverwaltung:<BR> Klasse der Anschrift<BR>
 * @author Jonas & Sven
 * @version  0.1
 */
public class Anschrift {

	/**
	 * Das zugehörige Objekt der Speicherschicht
	 */
	private AnschriftZ anschriftZ;
	
	/**
	 * @super Der Geschaeftspartner, dem die Anschrift gehört
	 */
	private Geschaeftspartner gp;
 
	
	public Anschrift() { }

	/**
	 * @param gp
	 */
	public void setGp(Geschaeftspartner gp) 
	{
		this.gp = gp;
	}

	/**
	 * @return gp
	 */
	public Geschaeftspartner getGp() 
	{
		return gp;
	}

	/**
	 * @param anschriftZ
	 */
	public void setAnschriftZ(AnschriftZ anschriftZ) 
	{
		this.anschriftZ = anschriftZ;
	}

	/**
	 * @return anschriftZ
	 */
	public AnschriftZ getAnschriftZ() 
	{
		return anschriftZ;
	}

}
