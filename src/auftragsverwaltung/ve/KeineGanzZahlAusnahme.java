package auftragsverwaltung.ve;

/**
 * Auftragsverwaltung:<BR> Klasse um zu pruefen, ob ein Wert eine Ganzzahl ist<BR>
 * @author Jonas & Sven
 * @version  0.1
 */
public class KeineGanzZahlAusnahme extends NumberFormatException
{
	
	/**
	 * @param Name
	 */
	public KeineGanzZahlAusnahme( String varName )
	{
		System.out.println( "Eingabefehler: " + varName + " : Wert muss eine Ganzezahl sein." );
	}
	
}


