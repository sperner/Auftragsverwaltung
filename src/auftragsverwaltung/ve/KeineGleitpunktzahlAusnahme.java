package auftragsverwaltung.ve;

/**
 * Auftragsverwaltung:<BR> Klasse um zu pruefen, ob ein Wert eine Gleitpunktzahl ist<BR>
 * @author Jonas & Sven
 * @version  0.1
 */
public class KeineGleitpunktzahlAusnahme extends NumberFormatException
{
	
	/**
	 * @param Name
	 */
	public KeineGleitpunktzahlAusnahme( String varName )
	{
		System.out.println( "Eingabefehler: " + varName + " : Wert muss eine Gleitpunktzahl sein." );
	}

}


