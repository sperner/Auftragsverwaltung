package auftragsverwaltung.c.artikel;

import java.util.ArrayList;

import auftragsverwaltung.s.artikel.*;
import auftragsverwaltung.c.auftrag.*;
import auftragsverwaltung.c.geschaeftspartner.*; 

/**
 * Auftragsverwaltung:<BR> Klasse des Artikels<BR>
 * @author Jonas & Sven
 * @version  0.1
 */
public class Artikel 
{

	/**
	 * Verweis auf das entsprechende Objekt in der Speicherschicht
	 */
	private ArtikelZ artikelZ;
	
	/**
	 * @sub Verweis auf ein Objekt der Klasse Eigenprodukt
	 */
	private Eigenprodukt eigenprodukt;

	/**
	 * @sub Verweis auf ein Objekt der Klasse Handelsware
	 */
	private Handelsware handelsware;
	
	
	/**
	 * @return ArtikelZobjekt
	 */
	public ArtikelZ getArtikelZ() 
	{
		return artikelZ;
	}
	
	/**
	 * @param ArtikelZobjekt
	 */
	public void setArtikelZ(ArtikelZ artikelZ) 
	{
		this.artikelZ = artikelZ;
	}
	
	
	/**
	  * Komponentenverweis: die Liste der Auftragspositionen
	  */
	private ArrayList<Auftragsposition> auftragaspositionen;
	
	
	/**
	 * @return Listenobjekt
	 */
	public ArrayList<Auftragsposition> getAuftragspositionen() 
	{
	    return auftragaspositionen;
	}
	
	/**
	 * @param Listenobjekt
	 */
	public void setAuftragspositionen( ArrayList auftragaspositionen )	
	{
	    this.auftragaspositionen = auftragaspositionen;
	}
		
	/**
	 * @param Eigenproduktobjekt
	 */
	public void setEigenprodukt( Eigenprodukt eigenprodukt ) 
	{
		this.eigenprodukt = eigenprodukt;
	}
	
	/**
	 * @param Handelswarenobjekt
	 */
	public void setHandelsware( Handelsware handelsware ) 
	{
		this.handelsware = handelsware;
	}
	
}
