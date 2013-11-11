package auftragsverwaltung.ve;

/**
 * Auftragsverwaltung:<BR> Klasse um zu pruefen ob ein Wert zu klein ist.
 * 						   Ausserdem wird die Mindestgroese ausgegeben<BR>
 * @author Jonas & Sven
 * @version  0.1
 */
public class GanzeZahlKleinerAlsAusnahme extends ArithmeticException
{
	
	/**
	 * @param Name
	 * @param mindestens gueltig
	 */
	public GanzeZahlKleinerAlsAusnahme( String varName, int minGueltig )
	{
		System.out.println( "Eingabefehler: " + varName + " : Wert zu klein, muss mindestens " + minGueltig + " sein" );
	}
  
}


