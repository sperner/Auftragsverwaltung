package auftragsverwaltung.ve;

/**
 * Auftragsverwaltung:<BR> Klasse zur Handhabung von Gleitpunkt-Zahlen<BR>
 * @author Jonas & Sven
 * @version  0.1
 */
public class Real
{
	
	/**
	 * Wert / Gleitpunkt-Zahl
	 */
	protected Double wert;
  

	/**
	 * @return Wert / Gleitpunkt-Zahl
	 */
	public double getWert()
	{
		return wert;
	}
  
	/**
	 * @param Wert / Gleitpunkt-Zahl
	 */
	public void setWert( Double wert )
	{
		this.wert = wert;
	}
  
	/**
	 * @param Wert vor Komma
	 * @param Wert nach Komma
	 * @return Wert als String
	 */
	public static String reelleZahlAlsZeichenfolge( Double x, int nachkomma )
	{
	  	long   lw;
	  	String sw, rw;
	  	boolean istNegativ = false;
	  	
	  	if ( x < 0 )
	  	{
	  		istNegativ = true;
	  		x = -x;
	  	}
	  	
	  	if ( nachkomma <= 0 )
	  	{
	  		return Double.toString( x );
	  	}
	  	else
	  	{
	  		for ( int i = 0; i < nachkomma; i++ )
	  		{
	  			x *= 10.0;
	  		}
	  	  	lw = Math.round( x );
	  	  	sw = Long.toString( lw );
	  		for ( int i = sw.length( ); i <= nachkomma; i++ )
	  		{
	  			sw = "0" + sw;
	  		}
	  		rw = sw.substring( 0, sw.length( ) - nachkomma );
	   		rw = rw + ".";
	  		rw = rw + sw.substring( sw.length( ) - nachkomma );
	  		if ( istNegativ )
	  		{
	  			rw = "-" + rw;
	  		}
	  		return rw;
	  	}
	}
  
	/**
	 * @param String
	 * @param Wert-String
	 * @return Wert als Double
	 */
	public static Double zeichenfolgeAlsReelleZahl( String varName, String s )
	{
	  	Double x = null;
	  	try 
	  	{
	  		x = Double.parseDouble( s );
	  	  	return x;
	  	}
	  	catch ( NumberFormatException nfe )
	  	{
	  		// throw new KeineGleitpunktzahlAusnahme( varName );
	    	System.out.println( "Eingabefehler: " + varName + " : Wert muss eine Gleitpunktzahl sein." );
	    	return null;
	  	}
	}
  
	/**
	 * @param Nachkommastelle
	 * @return Wert als String
	 */
	public String getWertAlsZeichenfolge( int nachkomma )
	{
		return reelleZahlAlsZeichenfolge( wert, nachkomma );
	}
  
	/**
	 * @param String
	 * @param Wert-String
	 */
	public void setWertAlsZeichenfolge( String varName, String sWert )
	{
		Double x;
		x = zeichenfolgeAlsReelleZahl( varName, sWert );
		wert = x;
	}
	
}
