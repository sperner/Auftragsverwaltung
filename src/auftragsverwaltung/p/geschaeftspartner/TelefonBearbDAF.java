package auftragsverwaltung.p.geschaeftspartner;

import java.awt.event.*;
import java.text.NumberFormat;
import javax.swing.*;

import auftragsverwaltung.c.*;
import auftragsverwaltung.c.geschaeftspartner.*;
import auftragsverwaltung.p.artikel.ArtikelAuswDAF;

/**
 * Auftragsverwaltung:<BR> Klasse der DialogAnwendungsFenster zum Bearbeiten der Telefon Daten<BR>
 * @author Jonas & Sven
 * @version  0.1
 */
public class TelefonBearbDAF extends JDialog implements ActionListener
{
	
	/** x-Koordinate der linken, oberen Ecke des Fensters */
	private final int X0 = 80;
  
	/** y-Koordinate der linken, oberen Ecke des Fensters */
	private final int Y0 = 60;
  
	/** Info-Platte */
	private JPanel infoPlatte = new JPanel( );

	/** Beschriftung: Telefonnummer */
	private JLabel telefonNrDB = new JLabel( "Telefonnr." );
	
	/** Textfeld: Telefonnummer */
	private JTextField telefonNrDW = new JTextField( 20 );

	/** Steuerungsplatte */
	private JPanel strgPlatte = new JPanel( );

	/** DialogAuslöseSchalter zum Radieren der Werte der Wertefelder*/
	private JButton neuDAS        = new JButton( "neu" );

	/** DialogAuslöseSchalter zum Schließen des Fensters */
	private JButton schliessenDAS = new JButton( "schliessen" );

	/** DialogAuslöseSchalter zum Einfügen der Daten einer Telefonnummer in die Datenbank */
	private JButton einfuegenDAS  = new JButton( "einfuegen" );

	/** DialogAuslöseSchalter zum Ändern der Daten einer Telefonnummer in der Datenbank */
	private JButton aendernDAS    = new JButton( "aendern" );

	/** DialogAuslöseSchalter zum Löschen der Daten einer Telefonnummer in der Datenbank */
	private JButton loeschenDAS   = new JButton( "loeschen" );
  
	/** Verweis auf ein Fenster zum Auswaehlen einer Telefonnummer */
	private TelefonBearbDAF telefonBearbDAF;
  
	/** Datenobjekt: Artikel */
	private Telefon telefon;

	/** Verweis auf das Eigentümerfenster zum Bearbeiten eines Geschaeftspartners */
	private GeschaeftspartnerBearbDAF geschaeftspartnerBearbDAF;
  
  
	/**
    	erzeugt ein DialogAnwendungsFenster der Anwendung: Telefonnummer bearbeiten
	 */
	public TelefonBearbDAF( GeschaeftspartnerBearbDAF geschaeftspartnerBearbDAF )
	{
		super( geschaeftspartnerBearbDAF );
		this.geschaeftspartnerBearbDAF = geschaeftspartnerBearbDAF;
	
		setTitle( "Telefonnummer bearbeiten" );
	  	setDefaultCloseOperation( WindowConstants.DISPOSE_ON_CLOSE );
	  	telefonNrDW.setHorizontalAlignment( JTextField.LEFT );
	  	telefon = new Telefon( );
	  	bestandteileAnordnen( );
	
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
	        		addComponent( telefonNrDB ).
	        		addComponent( telefonNrDW )
	        )
	    );
	
	    // waagerechte Gruppierung vereinbaren
	    infoLayout.setHorizontalGroup(
	    	infoLayout.createParallelGroup( ).addGroup(
	    		infoLayout.createSequentialGroup( ).
	    			addGroup( infoLayout.createParallelGroup( GroupLayout.Alignment.LEADING, false ).
	    				addComponent( telefonNrDB, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE )
	    				).
	    			addGroup( infoLayout.createParallelGroup( GroupLayout.Alignment.LEADING, false ).
	    				addComponent( telefonNrDW, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE )
	    				) 
	        )
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
	      			addComponent( einfuegenDAS, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE )
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
	  	else if ( e.getSource( ) == aendernDAS )
	  	{
	  		aendern( );
	  	}
	  	else if ( e.getSource( ) == loeschenDAS )
	  	{
	  		loeschen( );
	  	}
	}
  
	/**
	   Methode um Standardwerte zu setzen
	*/
	public void radieren( )
	{
	  	telefonNrDW.setText( "" );
	  	
	    aendernDAS.setEnabled( false );
	    loeschenDAS.setEnabled( false );
	}
  
	/**
    	Methode zum schliessen des Telefon Daten bearbeiten Fensters 
    	@pre 	Das Fenster Telefon bearbeiten ist geoeffnet
    	@post 	Das Fenster Telefon bearbeiten ist geschlossen
	 */
	public void schliessen( )
	{
	  	if ( telefonBearbDAF != null && telefonBearbDAF.isShowing( ) )
	  	{
	  		telefonBearbDAF.schliessen( );
	  	}
	    dispose( );	  
	}

	/**
    	Methode um einen Eintrag zum Telefon daten bearbeiten Fenster hinzuzufuegen 
	 */
	public void einfuegen( )
	{
		JOptionPane.showMessageDialog( this,
  			"Anwendung \"Telefonnummer bearbeiten\":\n" +
  			"Operation \"einfuegen\" noch in Arbeit",
  			"Baustelle",
  			JOptionPane.INFORMATION_MESSAGE );
	}
  
	/**
    	Methode um einen Eintrag im Telefon Daten bearbeiten Fenster zu aendern 
	 */
	public void aendern( )
	{
		JOptionPane.showMessageDialog( this,
  			"Anwendung \"Telefonnummer bearbeiten\":\n" +
  			"Operation \"Aendern\" noch in Arbeit",
  			"Baustelle",
  			JOptionPane.INFORMATION_MESSAGE );
	}
  
	/**
    	Methode um einen Eintrag im Telefon Daten bearbeiten Fenster zu loeschen 
	 */
	public void loeschen( )
	{
		JOptionPane.showMessageDialog( this,
  			"Anwendung \"Telefonnummer bearbeiten\":\n" +
  			"Operation \"loeschen\" noch in Arbeit",
  			"Baustelle",
  			JOptionPane.INFORMATION_MESSAGE );
	}
 
}


