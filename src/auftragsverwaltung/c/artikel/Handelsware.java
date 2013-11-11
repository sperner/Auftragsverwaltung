package auftragsverwaltung.c.artikel;

import auftragsverwaltung.s.artikel.*;
import auftragsverwaltung.c.auftrag.*;
import auftragsverwaltung.c.geschaeftspartner.*; 

/**
 * Auftragsverwaltung:<BR> Klasse der Handelsware<BR>
 * @author Jonas & Sven
 * @version  0.1
 */
public class Handelsware 
{
	
	/**
	  * der Artikel der Handelsware
	  */
	private Artikel artikel;

	/**
	  * der Lieferant der Handelsware
	  */
	private Lieferant lieferant;
	
	
	/**
	 * @return Lieferantenobjekt
	 */
	public Lieferant getLieferant() 
	{
	     return lieferant;
	}
	
	/**
	 * @param Lieferantenobjekt
	 */
	public void setLieferant( Lieferant lieferant )	
	{
	     this.lieferant = lieferant;
	}
	
	/**
	 * @return Handelswarenobjekt
	 */
	public void setArtikelIstHandelsware( Artikel artikel ) 
	{
		 this.artikel = artikel;
		 artikel.getArtikelZ().setHerkunft("Handelsware");
		 artikel.setHandelsware( this );
		 artikel.setEigenprodukt( null );
	}

}
