package auftragsverwaltung.c.auftrag;

import auftragsverwaltung.s.auftrag.*;
import auftragsverwaltung.c.artikel.*;
import auftragsverwaltung.c.geschaeftspartner.*;

/**
 * Auftragsverwaltung:<BR> Klasse der Auftragsposition<BR>
 * @author Jonas & Sven
 * @version  0.1
 */
public class Auftragsposition 
{
	
	/**
	  * der Auftrags der Auftragsposition
	  */
	private Auftrag auftrag;
	
	/**
	  * der Artikel der Auftragsposition
	  */
	private Artikel artikel;
	
	
	/**
	 * @return Auftragsobjekt
	 */
	public Auftrag getAuftrag() 
	{
	     return auftrag;
	}
	
	/**
	 * @param Auftragsobjekt
	 */
	public void setAuftrag( Auftrag auftrag )	
	{
	     this.auftrag = auftrag;
	}
	
	/**
	 * @return Artikelobjekt
	 */
	public Artikel getArtikel() 
	{
	     return artikel;
	}
	
	/**
	 * @param Artikelobjekt
	 */
	public void setArtikel( Artikel auftrag )	
	{
	     this.artikel = artikel;
	}
	
	/*
	public REAL_PLUS positionsPreis() 
	{
		return (bestellmenge*artikel.preisProEinheit);
	} 
	*/

}
