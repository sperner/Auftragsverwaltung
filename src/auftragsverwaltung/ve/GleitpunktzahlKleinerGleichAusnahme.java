package auftragsverwaltung.ve;

/**
 * Auftragsverwaltung:<BR> Klasse um zu pruefen, ob ein Wert zu klein ist. 
 * 						   Ausserdem wird angezeigt welche Groese der Wert ueberschreiten muss<BR>
 * @author Jonas & Sven
 * @version  0.1
 */
public class GleitpunktzahlKleinerGleichAusnahme extends ArithmeticException
{
	
	/**
	 * @param Name
	 * @param mindestens gültig
	 */
	public GleitpunktzahlKleinerGleichAusnahme( String varName, double minGueltig )
	{
		System.out.println( "Eingabefehler: " + varName + " : Wert zu klein, muss groeser als " + minGueltig + " sein" );
	}
  
}


