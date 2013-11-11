package auftragsverwaltung.ve;

/**
 * Auftragsverwaltung:<BR> Klasse zur Handhabung von Gleitpunkt-Zahlen, ohne Null<BR>
 * @author Jonas & Sven
 * @version  0.1
 */
public class RealPlus extends Real
{
	
	/**
	 * @param Name
	 * @param Wert-String
	 */
	public void setWertAlsZeichenfolge( String varName, String sWert )
	{
	  	Double x;
	  	x = zeichenfolgeAlsReelleZahl( varName, sWert );
	  	if ( x > 0.0 )
	  	{
	  		wert = x;
	  	}
	  	else
	  	{
	  		throw new GleitpunktzahlKleinerAlsAusnahme( varName, 0.0 );
	  	}
	}
  
}
