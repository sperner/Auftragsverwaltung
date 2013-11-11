package auftragsverwaltung.ve;

/**
 * Auftragsverwaltung:<BR> Klasse um zu pruefen, ob ueberhaupt ein Wert eingegeben wurde<BR>
 * @author Jonas & Sven
 * @version  0.1
 */
public class KeineEingabeAusnahme extends NullPointerException
{
	
	/**
	 * @param Name
	 */
	public KeineEingabeAusnahme( String varName )
	{
		System.out.println( "Eingabefehler: " + varName + " : Eingabe muss vorhanden sein" );
	}
  
}


