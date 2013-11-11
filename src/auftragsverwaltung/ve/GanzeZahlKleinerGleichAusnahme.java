package auftragsverwaltung.ve;

/**
 * Auftragsverwaltung:<BR> Klasse um zu pruefen, ob ein Wert zu klein ist.
 * 						   Ausserdem wird angezeigt welche Groese der Wert ueberschreiten muss<BR>
 * @author Jonas & Sven
 * @version  0.1
 */
public class GanzeZahlKleinerGleichAusnahme extends ArithmeticException
{
	
	/**
	 * @param Name
	 * @param mindestens gültig
	 */
	public GanzeZahlKleinerGleichAusnahme( String varName, int minGueltig )
	{
		System.out.println( "Eingabefehler: " + varName + " : Wert zu klein, muss groeser als " + minGueltig + " sein" );
	}
  
}


