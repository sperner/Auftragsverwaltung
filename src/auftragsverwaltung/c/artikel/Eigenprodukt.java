package auftragsverwaltung.c.artikel;

import auftragsverwaltung.s.artikel.*;
import auftragsverwaltung.c.auftrag.*;
import auftragsverwaltung.c.geschaeftspartner.*; 

/**
 * Auftragsverwaltung:<BR> Klasse des Eigenprodukts<BR>
 * @author Jonas & Sven
 * @version  0.1
 */
public class Eigenprodukt 
{
	
	/**
	  * der Artikel des Eigenprodukts
	  */
	private Artikel artikel;
	
	
	/**
	  * @param Eigenproduktobjekt
	  */
	public void setArtikelIstEigenprodukt( Artikel artikel ) 
	{
		 this.setArtikel(artikel);
		 artikel.getArtikelZ().setHerkunft("Eigenprodukt");
		 artikel.setEigenprodukt( this );
		 artikel.setHandelsware( null );
	}


	public void setArtikel(Artikel artikel) {
		this.artikel = artikel;
	}


	public Artikel getArtikel() {
		return artikel;
	}

}
