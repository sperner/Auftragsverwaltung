package auftragsverwaltung.p.geschaeftspartner;

import java.awt.event.*;
import java.text.NumberFormat;
import javax.swing.*;

import auftragsverwaltung.c.*;
import auftragsverwaltung.c.geschaeftspartner.Geschaeftspartner;
import auftragsverwaltung.p.artikel.EigenproduktBearbDAF;
import auftragsverwaltung.p.artikel.HandelswareBearbDAF;
import auftragsverwaltung.p.geschaeftspartner.*;

/**
 * Auftragsverwaltung:<BR> Klasse der DialogAnwendungsFenster zum Bearbeiten der Daten eines Geschaeftspartners<BR>
 * @author Jonas & Sven
 * @version  0.1
 */
public class GeschaeftspartnerBearbDAF extends JDialog implements ActionListener
{
	
	/** x-Koordinate der linken, oberen Ecke des Fensters */
	private final int X0 = 80;
  
	/** y-Koordinate der linken, oberen Ecke des Fensters */
	private final int Y0 = 60;
  
	/** Info-Platte */
	private JPanel infoPlatte = new JPanel( );

	/** Steuerungsplatte */
	private JPanel namensPlatte = new JPanel( );

	/** Steuerungsplatte */
	private JPanel anschriftPlatte = new JPanel( );

	/** Steuerungsplatte */
	private JPanel ankreuzkaestchenPlatte = new JPanel( );

	/** Steuerungsplatte */
	private JPanel strgPlatte = new JPanel( );

	/** Steuerungsplatte */
	private JPanel telefonPlatte = new JPanel( );

	/** Beschriftung: Name */
	private JLabel NameDB = new JLabel( "Name" );

	/** Textfeld: Name */
	private JTextField NameDW = new JTextField( 20 );
  

	/** DialogAuslöseSchalter zum Radieren der Werte der Wertefelder*/
	private JButton neuDAS        = new JButton( "neu" );

	/** DialogAuslöseSchalter zum Schließen des Fensters */
	private JButton schliessenDAS = new JButton( "schliessen" );

	/** DialogAuslöseSchalter zum Einfügen der Daten eines Geschaeftspartners in die Datenbank */
	private JButton einfuegenDAS  = new JButton( "einfuegen" );

	/** DialogAuslöseSchalter zum Öffnen des Auswahlfensters  */
	private JButton auswaehlenDAS = new JButton( "auswaehlen" );

	/** DialogAuslöseSchalter zum Ändern der Daten eines Geschaeftspartners in der Datenbank */
	private JButton aendernDAS    = new JButton( "aendern" );

	/** DialogAuslöseSchalter zum Löschen der Daten eines Geschaeftspartners in der Datenbank */
	private JButton loeschenDAS   = new JButton( "loeschen" );
  
	/** DialogObjektGruppe: Anschrift */
	private AnschriftDG anschriftDG = new AnschriftDG( this );
  
	/** DialogObjektGruppe: Telefon */
	private TelefonDG telefonDG = new TelefonDG( this );
  
	/** Verweis auf ein Fenster zum Auswählen eines Geschaeftspartners */
	private GeschaeftspartnerAuswDAF geschaeftspartnerAuswDAF;

	/** DialogObjektGruppe: Telefon */
	private TelefonBearbDAF telefonBearbDAF;
  
	/** DialogAnkreuzGruppe: Kunde / Lieferant */
	private KundeLieferantDAG kundeLieferantDAG = new KundeLieferantDAG( this );

	/** Verweis auf ein Fenster zum Auswählen eines Geschaeftspartners */
	private KundenBearbDAF kundenBearbDAF;

	/** Verweis auf ein Fenster zum Auswählen eines Geschaeftspartners */
	private LieferantenBearbDAF lieferantenBearbDAF;

	/** Datenobjekt: Geschaeftspartner */
	private Geschaeftspartner geschaeftspartner;


	/**
    	erzeugt ein DialogAnwendungsFenster der Anwendung: Geschaeftspartnerdaten bearbeiten
	 */
	public GeschaeftspartnerBearbDAF( )
	{
	  	setTitle( "Daten eines Geschaeftspartners bearbeiten" );
	  	setDefaultCloseOperation( WindowConstants.DISPOSE_ON_CLOSE );
	  	
	  	geschaeftspartner = new Geschaeftspartner( );
	  	bestandteileAnordnen( );
	  	// Fenstergroessee aus der Groesse der Komponenten bestimmen
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
	    
	    // voreingestellte Luecken verwenden
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
	        		addComponent( namensPlatte )
	        	).
	        	addGroup( infoLayout.createParallelGroup( GroupLayout.Alignment.BASELINE ).
	        		addComponent( anschriftPlatte ).
	        		addComponent( ankreuzkaestchenPlatte )
	        	).
	        	addGroup( infoLayout.createParallelGroup( GroupLayout.Alignment.BASELINE ).
	        		addComponent( telefonPlatte )
	        	)
	    );

	    // waagerechte Gruppierung vereinbaren
	    infoLayout.setHorizontalGroup(
	    	infoLayout.createParallelGroup( ).addGroup(
	    		infoLayout.createSequentialGroup( ).
	    			addGroup( infoLayout.createParallelGroup( GroupLayout.Alignment.LEADING, false ).
	    				addComponent( namensPlatte, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE ).
	    				addComponent( anschriftPlatte, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE ).
	    				addComponent( telefonPlatte, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE )
	    			).
	    			addGroup( infoLayout.createParallelGroup( GroupLayout.Alignment.LEADING, false ).
	    				addComponent( ankreuzkaestchenPlatte, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE )
	    			)
	      	  )
	    );
	    
	    // die Komponenten in Namens-Platte anordnen
	    namensPlatteAnordnen( );
	    
	    // die Komponenten in Anschrift-Platte anordnen
	    anschriftPlatteAnordnen( );
	    
	    // die Komponenten in AnkreuzKästchen-Platte anordnen
	    ankreuzkaestchenPlatteAnordnen( );
	    
	    //  die Komponenten in AnkreuzKästchen-Platte anordnen
	    telefonPlatteAnordnen( );
	}

	/**
  		legt die Anordnung der Komponenten in der Namens-Platte fest
	 */
	public void namensPlatteAnordnen( )
	{
		// Anordnung vereinbaren
		GroupLayout namensLayout = new GroupLayout( namensPlatte );
		namensPlatte.setLayout( namensLayout );
	
		// voreingestellte Luecken verwenden
		namensLayout.setAutoCreateGaps( true );
		namensLayout.setAutoCreateContainerGaps( true );
	
		// senkrechte Gruppierung vereinbaren
		namensLayout.setVerticalGroup(
			namensLayout.createSequentialGroup( ).
				addGroup( namensLayout.createParallelGroup( GroupLayout.Alignment.BASELINE ).
					addComponent( NameDB ).
					addComponent( NameDW )
				)
		);
	
		// waagerechte Gruppierung vereinbaren
		namensLayout.setHorizontalGroup(
			namensLayout.createParallelGroup( ). 
				addGroup(namensLayout.createSequentialGroup( ).
					addGroup( namensLayout.createParallelGroup( GroupLayout.Alignment.LEADING, false ).
						addComponent( NameDB, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE )
					).
					addGroup( namensLayout.createParallelGroup( GroupLayout.Alignment.LEADING, false ).
						addComponent( NameDW, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE )
					)
				)
		);
	}

	/**
  		legt die Anordnung der Komponenten in der Anschrift-Platte fest
	 */
	public void anschriftPlatteAnordnen( )
	{
		// Anordnung vereinbaren
		GroupLayout anschriftLayout = new GroupLayout( anschriftPlatte );
		anschriftPlatte.setLayout( anschriftLayout );
	
		// voreingestellte Lücken verwenden
		anschriftLayout.setAutoCreateGaps( true );
		anschriftLayout.setAutoCreateContainerGaps( true );
	
		// senkrechte Gruppierung vereinbaren
		anschriftLayout.setVerticalGroup(
			anschriftLayout.createSequentialGroup( ).
				addGroup( anschriftLayout.createParallelGroup( GroupLayout.Alignment.BASELINE ).
					addComponent( anschriftDG )
				)
		);
	
		// waagerechte Gruppierung vereinbaren
		anschriftLayout.setHorizontalGroup(
			anschriftLayout.createParallelGroup( ).
				addGroup(anschriftLayout.createSequentialGroup( ).
					addGroup( anschriftLayout.createParallelGroup( GroupLayout.Alignment.LEADING, false ).
						addComponent( anschriftDG, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE )
					)
				)
		);
	}

	/**
  		legt die Anordnung der Komponenten in der AnkreuzKaestchen-Platte fest
	 */
	public void ankreuzkaestchenPlatteAnordnen( )
	{
		// Anordnung vereinbaren
		GroupLayout ankreuzkaestchenLayout = new GroupLayout( ankreuzkaestchenPlatte );
		ankreuzkaestchenPlatte.setLayout( ankreuzkaestchenLayout );
	
		// voreingestellte Lücken verwenden
		ankreuzkaestchenLayout.setAutoCreateGaps( true );
		ankreuzkaestchenLayout.setAutoCreateContainerGaps( true );
	
		// senkrechte Gruppierung vereinbaren
		ankreuzkaestchenLayout.setVerticalGroup(
			ankreuzkaestchenLayout.createSequentialGroup( ).
				addGroup( ankreuzkaestchenLayout.createParallelGroup( GroupLayout.Alignment.BASELINE ).
					addComponent( kundeLieferantDAG )
				)
		);
	
		// waagerechte Gruppierung vereinbaren
		ankreuzkaestchenLayout.setHorizontalGroup(
			ankreuzkaestchenLayout.createParallelGroup( ).
				addGroup(ankreuzkaestchenLayout.createSequentialGroup( ).
					addGroup( ankreuzkaestchenLayout.createParallelGroup( GroupLayout.Alignment.LEADING, false ).
						addComponent( kundeLieferantDAG, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE )
					)
				)
		);
	}

	/**
		legt die Anordnung der Komponenten in der Telefon-Platte fest
	 */
	public void telefonPlatteAnordnen( )
	{
		// Anordnung vereinbaren
		GroupLayout telefonLayout = new GroupLayout( telefonPlatte );
		telefonPlatte.setLayout( telefonLayout );
	
		// voreingestellte Lücken verwenden
		telefonLayout.setAutoCreateGaps( true );
		telefonLayout.setAutoCreateContainerGaps( true );
	
		// senkrechte Gruppierung vereinbaren
		telefonLayout.setVerticalGroup(
			telefonLayout.createSequentialGroup( ).
				addGroup( telefonLayout.createParallelGroup( GroupLayout.Alignment.BASELINE ).
					addComponent( telefonDG )
				)
		);
	
		// waagerechte Gruppierung vereinbaren
		telefonLayout.setHorizontalGroup(
			telefonLayout.createParallelGroup( ).
		 		addGroup(telefonLayout.createSequentialGroup( ).
		 			addGroup( telefonLayout.createParallelGroup( GroupLayout.Alignment.LEADING, false ).
		 				addComponent( telefonDG, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE )
		 			)
		 		)
		);
	}
  
	
	/**
  		legt die Anordnung der Komponenten in der Steuerungs-Platte fest
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
  
	/**
	   Methode um alle  Werte auf Standard setzen
	 */
	public void radieren( )
	{
	  	NameDW.setText( "" );
	  	anschriftDG.radieren();
	  	kundeLieferantDAG.radieren();
	  	
	    aendernDAS.setEnabled( false );
	    loeschenDAS.setEnabled( false );
	}
  
	/**
		Methode zum schlissen des DAF GeschaeftsPartner bearbeiten
		@pre 	Das Geschaeftspartner Auswaelen Fenster ist geoeffnet
		@post 	Das Geschaeftspartner Auswaelen Fenster wird geschlossen
	 */
	public void schliessen( )
	{
	  	if ( geschaeftspartnerAuswDAF != null && geschaeftspartnerAuswDAF.isShowing( ) )
	  	{
	  		geschaeftspartnerAuswDAF.schliessen( );
	  	}
	    dispose( );
	}
  
	/**
		Methode zum einfuegen in das DAF GeschaeftsPartner bearbeiten
	 */
	public void einfuegen( )
	{
		JOptionPane.showMessageDialog( this,
  			"Anwendung \"Geschaeftspartner bearbeiten\":\n" +
  			"Operation \"Einfuegen\" noch in Arbeit", "Baustelle",
  			JOptionPane.INFORMATION_MESSAGE );
	}
  
	/**
		Methode zum auswaehlen im DAF GeschaeftsPartner bearbeiten
		@pre 	Das Fenster Geschaeftspartner bearbeiten ist geschlossen
    	@post 	Das Fenster Geschaeftspartner bearbeiten ist geoeffnet
	 */
	public void auswaehlen( )
	{
		geschaeftspartnerAuswDAF = new GeschaeftspartnerAuswDAF( this );
	}
  
	/**
		Methode um etwas im DAF GeschaeftsPartner bearbeiten zu aendern
	 */
	public void aendern( )
	{
		JOptionPane.showMessageDialog( this,
  			"Anwendung \"Geschaeftspartner bearbeiten\":\n" +
  			"Operation \"Aendern\" noch in Arbeit", "Baustelle",
  			JOptionPane.INFORMATION_MESSAGE );
	}
  
	/**
		Methode um etwas aus dem DAF GeschaeftsPartner bearbeiten zu loeschen
	 */
	public void loeschen( )
	{
		JOptionPane.showMessageDialog( this,
  			"Anwendung \"Geschaeftspartner bearbeiten\":\n" +
  			"Operation \"Loeschen\" noch in Arbeit", "Baustelle",
  			JOptionPane.INFORMATION_MESSAGE );
	}
  
	/**
		Methode zum oeffnen des Fensters "Kunden bearbeiten" 
		@pre 	Das Fenster Kunde bearbeiten ist geschlossen
    	@post 	Das Fenster Kunde bearbeiten ist geoeffnet
	 */
	public void kundenBearbDAFOeffnen( )
	{
		kundenBearbDAF = new KundenBearbDAF( this );
	}
  
	/**
		Methode zum schliessen des Fensters "Kunden bearbeiten" 
		@pre 	Das Fenster Kunde bearbeiten ist geoeffnet
    	@post 	Das Fenster Kunde bearbeiten ist geschlossen
	 */
	public void kundenBearbDAFSchliessen( )
	{
	  	if ( kundenBearbDAF != null )
	  	{
	  		kundenBearbDAF.dispose( );
	  		kundenBearbDAF = null;
	  	}
	}
  
	/**
		Methode zum oeffnen des Fensters "Lieferanten bearbeiten" 
		@pre 	Das Fenster Lieferant bearbeiten ist geschlossen
    	@post 	Das Fenster Lieferant bearbeiten ist geoeffnet
	 */
	public void lieferantenBearbDAFOeffnen( )
	{
		lieferantenBearbDAF = new LieferantenBearbDAF( this );
	}
  
	/**
    	Methode zum schliessen des Fensters "Lieferanten bearbeiten" 
    	@pre 	Das Fenster Lieferant bearbeiten ist geoeffnet
    	@post 	Das Fenster Lieferant bearbeiten ist geschlossen
	 */
	public void lieferantenBearbDAFSchliessen( )
	{
	  	if ( lieferantenBearbDAF != null )
	  	{
	  		lieferantenBearbDAF.dispose( );
	  		lieferantenBearbDAF = null;
	  	}
	}  
  
	/**
		Methode zum oeffnen des Fensters "Telefon Daten bearbeiten" 
		@pre 	Das Fenster Telefon Daten bearbeiten ist geschlossen
    	@post 	Das Fenster telefon Daten bearbeiten ist geoeffnet
	 */
	public void telefonBearbDAFOeffnen( )
	{
		telefonBearbDAF = new TelefonBearbDAF( this );
	}   
    
}


