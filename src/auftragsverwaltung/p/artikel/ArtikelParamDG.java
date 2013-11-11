package auftragsverwaltung.p.artikel;

import javax.swing.*;
import javax.swing.border.*;

import auftragsverwaltung.c.*;

/**
 * Auftragsverwaltung:<BR> Klasse der Dialogobjektegruppen mit den Parametern zur Suche nach Artikeln<BR>
 * @author Jonas & Sven
 * @version  0.1
 */
public class ArtikelParamDG extends JPanel
{
	
	/** Info-Platte */
	private JPanel textfelderPlatte = new JPanel( );

	/** Beschriftung: Artikelnr. */
	private JLabel artikelNrParamDB = new JLabel( "Artikelnr." );

	/** Textfeld: Artikelnr. */
	private JTextField artikelNrParamDW = new JTextField( 20 );

	/** Beschriftung: Bezeichnung */
	private JLabel bezeichnungParamDB = new JLabel( "Bezeichnung" );

	/** Textfeld: Bezeichnung */
	private JTextField bezeichnungParamDW = new JTextField( );
  
	/**
	 * Klasse der DialogAnkreuzkästchenGruppe zur Auswahl von Artikeln 
	 * <BR>anhand ihrer Zugehörigkeit zu den Unterklassen \"Eigenprodukt\" bzw. \"Handelsware\". 
	 */
	private EigenproduktHandelswareDAG eigenproduktHandelswareDAG = new EigenproduktHandelswareDAG( this );

	/** Behälterfenster zur Auswahl von Artikeln */
	private ArtikelAuswDAF artikelAuswDAF;
  
	/** Datenobjekt: ArtikelParam */
	/* Auskommentiert da nicht genutzt
  	private ArtikelParam artikelParam;
	*/
  
	public ArtikelParamDG( ArtikelAuswDAF artikelAuswDAF )
	{
	  	this.artikelAuswDAF = artikelAuswDAF; 
	  	
	  	/* Auskommentiert da nicht genutzt
	    artikelParam = new ArtikelParam( );
	    */
	  	
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
	  
	  	// voreingestellte Lücken verwenden
	  	dgLayout.setAutoCreateGaps( true );
	  	dgLayout.setAutoCreateContainerGaps( true );
	  
	  	// senkrechte Gruppierung vereinbaren
	  	dgLayout.setVerticalGroup(
			dgLayout.createParallelGroup( ).
	      		addComponent( textfelderPlatte ).
	      		addComponent( eigenproduktHandelswareDAG )
	  	);
	
	  	// waagerechte Gruppierung vereinbaren
	  	dgLayout.setHorizontalGroup(
	  		dgLayout.createSequentialGroup( ).
	  			addComponent( textfelderPlatte ).
	  			addComponent( eigenproduktHandelswareDAG )
	  	);
	  
	  	// die Komponenten in infoPlatte anordnen
	  	textfelderPlatteAnordnen( );
	}

	/**
		legt die Anordnung der Komponenten in der Info-Platte fest
	 */
	public void textfelderPlatteAnordnen( )
	{
	    // Rahmen erzeugen
	    TitledBorder dgR = BorderFactory.createTitledBorder( "" );
	    setBorder( dgR );
	  
	    // Anordnung vereinbaren
	    GroupLayout paramDGLayout = new GroupLayout( textfelderPlatte );
	    textfelderPlatte.setLayout( paramDGLayout );
	
	    // voreingestellte Lücken verwenden
	    paramDGLayout.setAutoCreateGaps( true );
	    paramDGLayout.setAutoCreateContainerGaps( true );
	
	    // senkrechte Gruppierung vereinbaren
	    paramDGLayout.setVerticalGroup(
	    	paramDGLayout.createSequentialGroup( ).
	        	addGroup( paramDGLayout.createParallelGroup( GroupLayout.Alignment.BASELINE ).
	        		addComponent( artikelNrParamDB ).
	        		addComponent( artikelNrParamDW )
	        	).
	        	addGroup( paramDGLayout.createParallelGroup( GroupLayout.Alignment.BASELINE ).
	        		addComponent( bezeichnungParamDB ).
	        		addComponent( bezeichnungParamDW )
	        	)
	    );

	    // waagerechte Gruppierung vereinbaren
	    paramDGLayout.setHorizontalGroup(
	    	paramDGLayout.createSequentialGroup( ).
	        	addGroup( paramDGLayout.createParallelGroup( GroupLayout.Alignment.LEADING, false ).
	        		addComponent( artikelNrParamDB, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE ).
	        		addComponent( bezeichnungParamDB, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE )
	        	).
	        	addGroup( paramDGLayout.createParallelGroup( GroupLayout.Alignment.LEADING, false ).
	        		addComponent( artikelNrParamDW, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE ).
	        		addComponent( bezeichnungParamDW, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE )
	        	)
	    );
	}
  
	public void radieren( )
	{
	  	artikelNrParamDW.setText( "" );
	  	bezeichnungParamDW.setText( "" );
	  	eigenproduktHandelswareDAG.radieren( );
	}
  
/*
  	public void ausgeben( ArtikelParam artikelParam )
  	{
	    this.artikelParam = artikelParam;
	    	
	    artikelNrParamDW.setText( artikelParam.artikelnrParamHolen( ) );
	    bezeichnungParamDW.setText( artikelParam.bezeichnungParamHolen( ) );
  	}

   
  	public ArtikelParam entgegennehmen( )
  	{
	    artikelParam = new ArtikelParam( );
	    	
	  	artikelParam.artikelnrParamZuweisen( artikelNrParamDW.getText( ) ) ; 
	  	artikelParam.bezeichnungParamZuweisen( bezeichnungParamDW.getText( ) );
	  	
	  	return artikelParam;
  	}
*/
}

