package auftragsverwaltung.p.artikel;

import java.awt.event.*;
import java.text.NumberFormat;
import javax.swing.*;

import auftragsverwaltung.c.*;
import auftragsverwaltung.c.artikel.Artikel;

/**
 * Auftragsverwaltung:<BR> Klasse der Fenster zum Bearbeiten der Daten eines Artikels <BR>
 * @author Jonas & Sven
 * @version  0.1
 */
public class ArtikelBearbDAF extends JDialog implements ActionListener
{
	
	/** x-Koordinate der linken, oberen Ecke des Fensters */
	private final int X0 = 80;
  
	/** y-Koordinate der linken, oberen Ecke des Fensters */
	private final int Y0 = 60;
  
	/** Info-Platte */
	private JPanel infoPlatte = new JPanel( );

	/** Beschriftung: Artikelnr. */
	private JLabel artikelNrDB = new JLabel( "Artikelnr." );
  
	/** Textfeld: Artikelnr. */
	private JTextField artikelNrDW = new JTextField( 20 );

	/** Beschriftung: Bezeichnung */
	private JLabel bezeichnungDB = new JLabel( "Bezeichnung" );
  
	/** Textfeld: Bezeichnung */
	private JTextField bezeichnungDW = new JTextField( );

	/** Beschriftung: Einheit */
	private JLabel einheitDB = new JLabel( "Einheit" );
  
	/** Textfeld: Einheit */
	private JTextField einheitDW = new JTextField( );

	/** Beschriftung: Preis pro Einheit */
	private JLabel preisProEinheitDB = new JLabel( "Preis pro Einheit" );
  
	/** formatiertes Textfeld: Preis pro Einheit */  
	private JFormattedTextField preisProEinheitDW = new JFormattedTextField( NumberFormat.getCurrencyInstance( ) );
  
	/** DialogRadioknopfGruppe: Herkunft */
	private HerkunftDRG herkunftDRG = new HerkunftDRG( this );
  
	/** Steuerungsplatte */
	private JPanel strgPlatte = new JPanel( );

	/** DialogAuslöseSchalter zum Radieren der Werte der Wertefelder*/
	private JButton neuDAS        = new JButton( "neu" );

	/** DialogAuslöseSchalter zum Schließen des Fensters */
	private JButton schliessenDAS = new JButton( "schließen" );

	/** DialogAuslöseSchalter zum Einfügen der Daten eines Artikels in die Datenbank */
	private JButton einfuegenDAS  = new JButton( "einfügen" );

	/** DialogAuslöseSchalter zum Öffnen des Auswahlfensters  */
	private JButton auswaehlenDAS = new JButton( "auswählen" );

	/** DialogAuslöseSchalter zum Ändern der Daten eines Artikels in der Datenbank */
	private JButton aendernDAS    = new JButton( "Ändern" );

	/** DialogAuslöseSchalter zum Löschen der Daten eines Artikels in der Datenbank */
	private JButton loeschenDAS   = new JButton( "löschen" );
  
	/** Verweis auf ein Fenster zum Auswählen eines Artikels */
	private ArtikelAuswDAF artikelAuswDAF;

	/** Verweis auf ein Fenster zum Auswählen eines Artikels */
	private EigenproduktBearbDAF eigenproduktBearbDAF;
	
	/** Verweis auf ein Fenster zum Auswählen eines Artikels */
	private HandelswareBearbDAF handelswareBearbDAF;

	/** Datenobjekt: Artikel */
	private Artikel artikel;

	
	/**
    	erzeugt ein DialogAnwendungsFenster der Anwendung: Artikeldaten bearbeiten
	 */
	public ArtikelBearbDAF( )
	{
	  	setTitle( "Artikeldaten bearbeiten" );
	  	setDefaultCloseOperation( WindowConstants.DISPOSE_ON_CLOSE );
	  	preisProEinheitDW.setHorizontalAlignment( JTextField.RIGHT );
	  	artikel = new Artikel( );
	  	bestandteileAnordnen( );

	  	// Fenstergröße aus der Größe der Komponenten bestimmen
	  	pack( );
	  	verwanzen( );
	    
	    // Lage bestimmen
	    setLocation( X0, Y0 );
	
	  	setVisible( true );
	  	radieren( );
	}
  
	/**
    	legt die Anordnung der infoPlatte und der strgPlatte im Fenster fest
	 */
	public void bestandteileAnordnen( )
	{
	    // Anordnung vereinbaren
	    GroupLayout dafLayout = new GroupLayout( getContentPane( ) );
	    getContentPane( ).setLayout( dafLayout );
	    
	    // voreingestellte Lücken verwenden
	    dafLayout.setAutoCreateGaps( true );
	    dafLayout.setAutoCreateContainerGaps( true );
	    
	    // senkrechte Gruppierung vereinbaren
	    dafLayout.setVerticalGroup(
	    	dafLayout.createSequentialGroup( ).
	        	addComponent( infoPlatte ).
	        	addComponent( strgPlatte )
	    );
	
	    // waagerechte Gruppierung vereinbaren
	    dafLayout.setHorizontalGroup(
	    	dafLayout.createParallelGroup( ).
	        	addComponent( infoPlatte ).
	        	addComponent( strgPlatte )
	    );
	    
	    // die Komponenten in infoPlatte anordnen
	    infoPlatteAnordnen( );
	    
	    // die Komponenten in strgPlatte anordnen
	    strgPlatteAnordnen( );
	}

	/**
    	legt die Anordnung der Komponenten in der Info-Platte fest
	 */
	public void infoPlatteAnordnen( )
	{
	    // Anordnung vereinbaren
	    GroupLayout infoLayout = new GroupLayout( infoPlatte );
	    infoPlatte.setLayout( infoLayout );
	
	    // voreingestellte Lücken verwenden
	    infoLayout.setAutoCreateGaps( true );
	    infoLayout.setAutoCreateContainerGaps( true );
	
	    // senkrechte Gruppierung vereinbaren
	    infoLayout.setVerticalGroup(
	    	infoLayout.createSequentialGroup( ).
	        	addGroup( infoLayout.createParallelGroup( GroupLayout.Alignment.BASELINE ).
	        		addComponent( artikelNrDB ).
	        		addComponent( artikelNrDW )
	        	).
	        	addGroup( infoLayout.createParallelGroup( GroupLayout.Alignment.BASELINE ).
	        		addComponent( bezeichnungDB ).
	        		addComponent( bezeichnungDW )
	        	).
	        	addGroup( infoLayout.createParallelGroup( GroupLayout.Alignment.BASELINE ).
	        		addComponent( einheitDB ).
	        		addComponent( einheitDW )
	        	).
	        	addGroup( infoLayout.createParallelGroup( GroupLayout.Alignment.BASELINE ).
	        		addComponent( preisProEinheitDB ).
	        		addComponent( preisProEinheitDW )
	        	).
	        	addComponent( herkunftDRG )
	    );

	    // waagerechte Gruppierung vereinbaren
	    infoLayout.setHorizontalGroup(
	    	infoLayout.createParallelGroup( ).addGroup(
	    		infoLayout.createSequentialGroup( ).
	    			addGroup( infoLayout.createParallelGroup( GroupLayout.Alignment.LEADING, false ).
	    				addComponent( artikelNrDB, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE ).
	    				addComponent( bezeichnungDB, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE ).
	    				addComponent( einheitDB, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE ).
	    				addComponent( preisProEinheitDB, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE )
	    			).
	    			addGroup( infoLayout.createParallelGroup( GroupLayout.Alignment.LEADING, false ).
	    					addComponent( artikelNrDW, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE ).
				            addComponent( bezeichnungDW, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE ).
				            addComponent( einheitDW, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE ).
				            addComponent( preisProEinheitDW, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE )
	    			) 
	        	).
	        	addComponent( herkunftDRG, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE )
	    );
	}

	/**
  		legt die Anordnung der Komponenten in der Steuerungsplatte fest
	 */
	public void strgPlatteAnordnen( )
	{
	  	// Anordnung vereinbaren
	  	GroupLayout strgLayout = new GroupLayout( strgPlatte );
	  	strgPlatte.setLayout( strgLayout );
	
	  	// voreingestellte Lücken verwenden
	  	strgLayout.setAutoCreateGaps( true );
	  	strgLayout.setAutoCreateContainerGaps( true );
	
	  	// senkrechte Gruppierung vereinbaren
	  	strgLayout.setVerticalGroup(
	  		strgLayout.createSequentialGroup( ).
	  			addGroup( strgLayout.createParallelGroup( GroupLayout.Alignment.BASELINE ).
	  				addComponent( neuDAS ).
	  				addComponent( einfuegenDAS ).
	  				addComponent( aendernDAS )
	  			).
	  			addGroup( strgLayout.createParallelGroup( GroupLayout.Alignment.BASELINE ).
	  				addComponent( schliessenDAS ).
	  				addComponent( auswaehlenDAS ).
	  				addComponent( loeschenDAS )
	  			)
	  	);

	  	// waagerechte Gruppierung vereinbaren
	  	strgLayout.setHorizontalGroup(
	  		strgLayout.createSequentialGroup( ).
		      	addGroup( strgLayout.createParallelGroup( GroupLayout.Alignment.LEADING, false ).
		      		addComponent( neuDAS, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE ).
		      		addComponent( schliessenDAS, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE )
		      	).
		      	addGroup( strgLayout.createParallelGroup( GroupLayout.Alignment.LEADING, false ).
		      		addComponent( einfuegenDAS, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE ).
		      		addComponent( auswaehlenDAS, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE )
		      	).
		      	addGroup( strgLayout.createParallelGroup( GroupLayout.Alignment.LEADING, false ).
		      		addComponent( aendernDAS, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE ).
		      		addComponent( loeschenDAS, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE )
		      	)
	  	);
	}

	/**
  		Ereignissensoren anmelden
	 */
	public void verwanzen( )
	{
	  	neuDAS.       addActionListener( this );
	  	schliessenDAS.addActionListener( this );
	  	einfuegenDAS. addActionListener( this );
	  	auswaehlenDAS.addActionListener( this );
	  	aendernDAS.   addActionListener( this );
	  	loeschenDAS.  addActionListener( this );
	}

	/**
  		Ereignisbehandlung
	 */
	public void actionPerformed( ActionEvent e )
	{
	  	if ( e.getSource( ) == neuDAS )
	  	{
	  		radieren( );
	  	}
	  	else if ( e.getSource( ) == schliessenDAS )
	  	{
	  		schliessen( );
	  	}
	  	else if ( e.getSource( ) == einfuegenDAS )
	  	{
	  		einfuegen( );
	  	}
	  	else if ( e.getSource( ) == auswaehlenDAS )
	  	{
	  		auswaehlen( );
	  	}
	  	else if ( e.getSource( ) == aendernDAS )
	  	{
	  		aendern( );
	  	}
	  	else if ( e.getSource( ) == loeschenDAS )
	  	{
	  		loeschen( );
	  	}
	}
  
	public void radieren( )
	{
	  	artikelNrDW.setText( "" );
	  	bezeichnungDW.setText( "" );
	  	einheitDW.setText( "" );
	  	preisProEinheitDW.setValue( 0 );
	  	
	  	herkunftDRG.radieren( );
	  	
	  	eigenproduktBearbDAFSchliessen( );
	  	handelswareBearbDAFSchliessen( );
	  	eigenproduktBearbDAFOeffnen( );
	  	
	    aendernDAS.setEnabled( false );
	    loeschenDAS.setEnabled( false );
	}
  
	public void schliessen( )
	{
	  	if ( artikelAuswDAF != null && artikelAuswDAF.isShowing( ) )
	  	{
	  		artikelAuswDAF.schliessen( );
	  	}
	    dispose( );
	}

	public void einfuegen( )
	{
		JOptionPane.showMessageDialog( this,
  			"Anwendung \"Artikel bearbeiten\":\n" +
  			"Operation \"einfügen\" noch in Arbeit",
  			"Baustelle",
  			JOptionPane.INFORMATION_MESSAGE );
	}
  
	public void auswaehlen( )
	{
  	artikelAuswDAF = new ArtikelAuswDAF( this );
	}
  
	public void aendern( )
	{
		JOptionPane.showMessageDialog( this,
  			"Anwendung \"Artikel bearbeiten\":\n" +
  			"Operation \"Ändern\" noch in Arbeit",
  			"Baustelle",
  			JOptionPane.INFORMATION_MESSAGE );
	}
  
	public void loeschen( )
	{
		JOptionPane.showMessageDialog( this,
  			"Anwendung \"Artikel bearbeiten\":\n" +
  			"Operation \"löschen\" noch in Arbeit",
  			"Baustelle",
  			JOptionPane.INFORMATION_MESSAGE );
	}

	public void eigenproduktBearbDAFOeffnen( )
	{
		eigenproduktBearbDAF = new EigenproduktBearbDAF( this );
	}
  
	public void eigenproduktBearbDAFSchliessen( )
  	{
	  	if ( eigenproduktBearbDAF != null )
	  	{
	  		eigenproduktBearbDAF.dispose( );
	  	  	eigenproduktBearbDAF = null;
	  	}
  	}
  
	public void handelswareBearbDAFOeffnen( )
	{
		handelswareBearbDAF = new HandelswareBearbDAF( this );
	}
  
	public void handelswareBearbDAFSchliessen( )
	{
	  	if ( handelswareBearbDAF != null )
	  	{
	  		handelswareBearbDAF.dispose( );
	  		handelswareBearbDAF = null;
	  	}
	}

}


