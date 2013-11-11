package auftragsverwaltung.p.geschaeftspartner;

import javax.swing.*;
import javax.swing.border.*;

import auftragsverwaltung.c.*;

/**
 * Auftragsverwaltung:<BR> Klasse der Dialogobjektegruppen mit den Parametern zur Suche nach Geschaeftspartnern<BR>
 * @author Jonas & Sven
 * @version  0.1
 */
public class GeschaeftspartnerParamDG extends JPanel
{
	
	/** Info-Platte */
	private JPanel gPParamDWPlatte = new JPanel( );

	/** Beschriftung: Name */
	private JLabel nameParamDB = new JLabel( "Name" );

	/** Textfeld: Name */
	private JTextField nameParamDW = new JTextField( 20 );

	/** Beschriftung: PLZ */
	private JLabel plzParamDB = new JLabel( "PLZ" );

	/** Textfeld: PLZ */
	private JTextField plzParamDW = new JTextField( );
  
	/** Beschriftung: Ort */
	private JLabel ortParamDB = new JLabel( "Ort" );

	/** Textfeld: Ort */
	private JTextField ortParamDW = new JTextField( );
  
	/** DialogObjektGruppe: KundeLieferant */
	private KundeLieferantParamDG kundeLieferantParamDG = new KundeLieferantParamDG( null );
  
	/** Behaelterfenster zur Auswahl von Geschaeftspartnern */
	private GeschaeftspartnerAuswDAF geschaeftspartnerAuswDAF;
  
	
	/**
	   erzeugt eine DialogObjektGruppe der Anwendung:<BR> Geschaeftspartner Daten Auswaehlen
	 */
	public GeschaeftspartnerParamDG( GeschaeftspartnerAuswDAF geschaeftspartnerAuswDAF )
	{
		this.geschaeftspartnerAuswDAF = geschaeftspartnerAuswDAF; 
	
		bestandteileAnordnen( );
	}
  
	/**
    	legt die Anordnung der Komponenten in der Dialogobjektegruppe fest
	 */
	public void bestandteileAnordnen( )
	{
		// Anordnung vereinbaren
		GroupLayout dgLayout = new GroupLayout( this );
		setLayout( dgLayout );
		  
		// voreingestellte Luecken verwenden
		dgLayout.setAutoCreateGaps( true );
		dgLayout.setAutoCreateContainerGaps( true );
		  
		// senkrechte Gruppierung vereinbaren
		dgLayout.setVerticalGroup(
			dgLayout.createParallelGroup( ).
		    	addComponent( gPParamDWPlatte ).
		    	addComponent( kundeLieferantParamDG )
		  );
		
		// waagerechte Gruppierung vereinbaren
		dgLayout.setHorizontalGroup(
			dgLayout.createSequentialGroup( ).
		    	addComponent( gPParamDWPlatte ).
		    	addComponent( kundeLieferantParamDG )
		);
		  
		// die Komponenten in infoPlatte anordnen
		gPParamDWPlatteAnordnen( );
	}

	/**
		legt die Anordnung der Komponenten in der Info-Platte fest
	 */
	public void gPParamDWPlatteAnordnen( )
	{
	    // Rahmen erzeugen
	    TitledBorder dgR = BorderFactory.createTitledBorder( "" );
	    setBorder( dgR );
	  
	    // Anordnung vereinbaren
	    GroupLayout paramDGLayout = new GroupLayout( gPParamDWPlatte );
	    gPParamDWPlatte.setLayout( paramDGLayout );
	
	    // voreingestellte Luecken verwenden
	    paramDGLayout.setAutoCreateGaps( true );
	    paramDGLayout.setAutoCreateContainerGaps( true );
	
	    // senkrechte Gruppierung vereinbaren
	    paramDGLayout.setVerticalGroup(
	    	paramDGLayout.createSequentialGroup( ).
	        	addGroup( paramDGLayout.createParallelGroup( GroupLayout.Alignment.BASELINE ).
	        		addComponent( nameParamDB ).
	        		addComponent( nameParamDW )
	        	).
	        	addGroup( paramDGLayout.createParallelGroup( GroupLayout.Alignment.BASELINE ).
	        		addComponent( plzParamDB ).
	        		addComponent( plzParamDW )
	        	).
	        	addGroup( paramDGLayout.createParallelGroup( GroupLayout.Alignment.BASELINE ).
	        		addComponent( ortParamDB ).
	        		addComponent( ortParamDW )
	        	)
	    );

	    // waagerechte Gruppierung vereinbaren
	    paramDGLayout.setHorizontalGroup(
	    	paramDGLayout.createSequentialGroup( ).
	        	addGroup( paramDGLayout.createParallelGroup( GroupLayout.Alignment.LEADING, false ).
	        		addComponent( nameParamDB, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE ).
	        		addComponent( plzParamDB, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE ).
	        		addComponent( ortParamDB, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE )
	        	).
	        	addGroup( paramDGLayout.createParallelGroup( GroupLayout.Alignment.LEADING, false ).
	        		addComponent( nameParamDW, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE ).
	        		addComponent( plzParamDW, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE ).
	        		addComponent( ortParamDW, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE )
	        	)
	    );
	}
  
   /**
	  Methode um Standardwerte zu setzen
	*/
	public void radieren( )
  	{
  		nameParamDW.setText( "" );
  		plzParamDW.	setText( "" );
  		ortParamDW.	setText( "" );
  		kundeLieferantParamDG.radieren();
  	}
	
}

