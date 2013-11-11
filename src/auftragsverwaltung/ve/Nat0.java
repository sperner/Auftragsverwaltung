package auftragsverwaltung.ve;

/**
 * Auftragsverwaltung:<BR> Klasse zur Handhabung von natürlichen Zahlen, inklusive Null<BR>
 * @author Jonas & Sven
 * @version  0.1
 */
public class Nat0 extends Int
{
	
	/**
	 * @param Name
	 * @param Wert-String
	 */
	public void setWertAlsZeichenfolge( String varName, String sWert )
	{
	  	Integer x;
	  	x = zeichenfolgeAlsGanzeZahl( varName, sWert );
	  	if ( x >= 0 )
	  		wert = x;
	  	else
	  		throw new GanzeZahlKleinerGleichAusnahme( varName, 0 );
	}
  
}
