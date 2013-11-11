package auftragsverwaltung.p.geschaeftspartner;

import java.awt.event.*;
import java.util.*;
import javax.swing.*;

import auftragsverwaltung.c.*;
import auftragsverwaltung.c.geschaeftspartner.Geschaeftspartner;

/**
 * Auftragsverwaltung:<BR> Klasse der DialogAnwendungsFenster zum Auswaehlen der Daten eines Geschaeftspartners<BR>
 * @author Jonas & Sven
 * @version  0.1
 */
public class GeschaeftspartnerAuswDAF extends JDialog implements ActionListener
{
	
	/** x-Koordinate der linken, oberen Ecke des Fensters */
	private final int X0 = 200;
  
	/** y-Koordinate der linken, oberen Ecke des Fensters */
	private final int Y0 = 150;
  
	/** Parametergruppe */
	private GeschaeftspartnerParamDG geschaeftspartnerParamDG = new GeschaeftspartnerParamDG( this );

	/** Treffertabelle */
	private GeschaeftspartnerDT1 geschaeftspartnerDT1 = new GeschaeftspartnerDT1( this );

	/** Tabellenplatte */
	private JScrollPane tabellenPlatte = new JScrollPane( geschaeftspartnerDT1,
			JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
			JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS );

	/** Steuerungsplatte */
	private JPanel strgPlatte = new JPanel( );

	/** DialogAusloeseSchalter zum Radieren der Werte der Wertefelder*/
	private JButton neuDAS        = new JButton( "neu" );

	/** DialogAusloeseSchalter zum Schließen des Fensters */
	private JButton schliessenDAS = new JButton( "schliessen" );
	
	/** DialogAusloeseSchalter zum Suchen der Treffer in der Datenbasis */
	private JButton suchenDAS     = new JButton( "suchen" );

	/** DialogAusloeseSchalter zum Uebergeben eines Treffers an das Bearbeitungsfenster */
	private JButton uebergebenDAS = new JButton( "uebergeben" );

	/** Verweis auf dasjenige Fenster zum Bearbeiten eines Geschaeftspartners, innerhalb dessen dieses Fenster geoeffnet wurde */
	private GeschaeftspartnerBearbDAF geschaeftspartnerBearbDAF;
  
  
	/** Datenobjekt: Geschaeftspartner */
	private Geschaeftspartner geschaeftspartner;

	/** Datenobjekt: Liste von Geschaeftspartnern */
	private ArrayList< Geschaeftspartner > geschaeftspartnerL;

  
	/**
    	erzeugt ein DialogAnwendungsFenster der Anwendung: Geschaeftspartnerdaten auswaehlen
	 */
	public GeschaeftspartnerAuswDAF( GeschaeftspartnerBearbDAF geschaeftspartnerBearbDAF )
	{
	    setTitle( "Geschaeftspartnerdaten auswaehlen" );
	  	setDefaultCloseOperation( WindowConstants.DISPOSE_ON_CLOSE );
	  	
	  	/* Auskommentiert da nicht genutzt
	  	geschaeftspartnerParam = new GeschaeftspartnerParam( );
	  	*/
	  	
	    this.geschaeftspartnerBearbDAF = geschaeftspartnerBearbDAF;
	    bestandteileAnordnen( );
	    // Fenstergroese aus der Groese der Komponenten bestimmen
	    pack( );
	    
	    // Lage bestimmen
	    setLocation( X0, Y0 );
	    verwanzen( );
	
	    setVisible( true );
	    radieren( );
	}

	/**
    	legt die Anordnung der Parametergruppe, der Tabellenplatte und der Steuerungsgruppe im Fenster fest
	 */
	public void bestandteileAnordnen( )
	{
	    // Anordnung vereinbaren
	    GroupLayout layout = new GroupLayout( getContentPane( ) );
	    getContentPane( ).setLayout( layout );
	    
	    // voreingestellte Luecken verwenden
	    layout.setAutoCreateGaps( true );
	    layout.setAutoCreateContainerGaps( true );
	    
	    // senkrechte Gruppierung vereinbaren
	    layout.setVerticalGroup(
	    	layout.createSequentialGroup( ).
	        	addComponent( geschaeftspartnerParamDG ).
	        	addComponent( tabellenPlatte ).
	        	addComponent( strgPlatte )
	    );
	
	    // waagerechte Gruppierung vereinbaren
	    layout.setHorizontalGroup(
	    	layout.createParallelGroup( ).
	        	addComponent( geschaeftspartnerParamDG ).
	        	addComponent( tabellenPlatte ).
	        	addComponent( strgPlatte )
	    );
	
	    // die Komponenten in strgPlatte anordnen
	    strgPlatteAnordnen( );
	}

	/**
		legt die Anordnung der Komponenten in der Steuerungsplatte fest
	 */
	public void strgPlatteAnordnen( )
	{
	  	// Anordnung vereinbaren
	  	GroupLayout strgLayout = new GroupLayout( strgPlatte );
	  	strgPlatte.setLayout( strgLayout );
	
	  	// voreingestellte Luecken verwenden
	  	strgLayout.setAutoCreateGaps( true );
	  	strgLayout.setAutoCreateContainerGaps( true );
	
	  	// senkrechte Gruppierung vereinbaren
	  	strgLayout.setVerticalGroup(
			strgLayout.createSequentialGroup( ).
				addGroup( strgLayout.createParallelGroup( GroupLayout.Alignment.BASELINE ).
					addComponent( neuDAS ).
					addComponent( suchenDAS )
				).
				addGroup( strgLayout.createParallelGroup( GroupLayout.Alignment.BASELINE ).
					addComponent( schliessenDAS ).
					addComponent( uebergebenDAS )
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
	    			addComponent( suchenDAS, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE ).
	    			addComponent( uebergebenDAS, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE )
	    		)
	  		);
	}

	/**
		Ereignissensoren anmelden
	 */
	public void verwanzen( )
	{
	  	neuDAS.       	addActionListener( this );
	  	schliessenDAS.	addActionListener( this );
	  	suchenDAS. 		addActionListener( this );
	  	uebergebenDAS.	addActionListener( this );
	}

	/**
		Ereignisbehandlung
	 */
	public void actionPerformed( ActionEvent e )
	{
	  	if 		( e.getSource( ) == neuDAS )
	  	{
	  		radieren( );
	  	}
	  	else if ( e.getSource( ) == schliessenDAS )
	  	{
	  		schliessen( );
	  	}
	  	else if ( e.getSource( ) == suchenDAS )
	  	{
	  		suchen( );
	  	}
	  	else if ( e.getSource( ) == uebergebenDAS )
	  	{
	  		uebergeben( );
	  	}
	}

	/**
  		leert alle Bestandteile des Auswahlfensters
	 */
	public void radieren( )
	{
		geschaeftspartnerParamDG.radieren( );
		geschaeftspartnerDT1.radieren( );
		uebergebenDAS.setEnabled( false );
	}

	/**
		schliesst das Fenster
	 */
	public void schliessen( )
	{
		dispose( );
	}

	/**
		sucht nach Geschaeftspartnern, die zum Suchparameter passen, und gibt sie in der Treffertabelle aus
	 */
	public void suchen( )
	{
		JOptionPane.showMessageDialog( this,
		 "Anwendung \"Geschaeftspartner auswaehlen\":\n" +
  		 "Operation \"suchen\" noch in Arbeit", "Baustelle",
  		JOptionPane.INFORMATION_MESSAGE );
	}

	/**
		gibt einen ausgewaehlten Geschaeftspartner im Bearbeitungsfenster aus
	 */
	public void uebergeben( )
	{
	  	JOptionPane.showMessageDialog( this,
  		 "Anwendung \"Geschaeftspartner auswählen\":\n" +
  		 "Operation \"Uebergeben\" noch in Arbeit", "Baustelle",
  		JOptionPane.INFORMATION_MESSAGE );
	}
  
}


