package auftragsverwaltung.ve;

/**
 * Auftragsverwaltung:<BR> Klasse zur Handhabung von ganzen Zahlen<BR>
 * @author Jonas & Sven
 * @version  0.1
 */
public class Int
{
	
	/**
	 * Wert / ganze Zahl
	 */
	protected Integer wert;
  

	/**
	 * @return Wert / ganze Zahl
	 */
	public Integer getWert()
  	{
  		return wert;
  	}
  
	/**
	 * @param Wert / ganze Zahl
	 */
  	public void setWert( Integer wert )
  	{
  		this.wert = wert;
  	}
  
	/**
	 * @param Integer-Zahl
	 * @return String
	 */
  	public static String ganzeZahlAlsZeichenfolge( Integer x )
  	{
	  	String tmp;
	  	boolean istNegativ = false;
	  	
	  	if ( x < 0 )
	  	{
	  		istNegativ = true;
	  		x = -x;
	  	}
	  	
	  	tmp = Integer.toString( x );
		if ( istNegativ )
			tmp = "-" + tmp;
	  	return tmp;
  	}
  
	/**
	 * @param String
	 * @param String für Wert
	 * @return Integer-Zahl
	 */
  	public static Integer zeichenfolgeAlsGanzeZahl( String varName, String s )
  	{
		Integer x = null;
	  	try 
	  	{
	  		x = Integer.parseInt( s );
	  		return x;
	  	}
	  	catch ( NumberFormatException nfe )
	  	{
	  		// throw new KeineGanzZahlAusnahme( varName );
	    	System.out.println( "Eingabefehler: " + varName + " : Wert muss eine Gleitpunktzahl sein." );
	    	return null;
	  	}
  	}
  
  	/**
	 * @return String von Wert
	 */
  	public String getWertAlsZeichenfolge()
  	{
  		return ganzeZahlAlsZeichenfolge( wert);
  	}
  
	/**
	 * @param String
	 * @param String fuer Wert
	 */
  	public void setWertAlsZeichenfolge( String varName, String sWert )
  	{
	  	Integer x;
	  	x = zeichenfolgeAlsGanzeZahl( varName, sWert );
	  	wert = x;
  	}

}
