package auftragsverwaltung.c.auftrag;

import java.util.ArrayList;

import auftragsverwaltung.s.auftrag.*;
import auftragsverwaltung.c.artikel.*;
import auftragsverwaltung.c.geschaeftspartner.*;
import auftragsverwaltung.ve.*;

/**
 * Auftragsverwaltung:<BR> Klasse des Auftrags<BR>
 * @author Jonas & Sven
 * @version  0.1
 */
public class Auftrag 
{
	
	/**
	  * der Kunde des Auftrags
	  */
	private Kunde kunde;
	
	
	/**
	 * @return Kundenobjekt
	 */
	public Kunde getKunde() 
	{
	     return kunde;
	}
	
	/**
	 * @param Kundenobjekt
	 */
	public void setKunde( Kunde kunde )	
	{
	     this.kunde = kunde;
	}
	
	
	/**
	  * die Liste der Auftragspositionen
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
	public void setAuftragspositionen( ArrayList<Auftragsposition> auftragaspositionen )	
	{
	     this.auftragaspositionen = auftragaspositionen;
	}
	
	/*
	public Date auftragsDatum() 
	{
		return ("TODAY");
	} 
	*/
	
	/*
	public RealPlus auftragspreis() 
	{
		double stand = 0.0;
		for ( Auftrag auftrag : auftraege )
		  stand += auftrag.getBetrag( );
		return stand;
	}
	*/
	
}
