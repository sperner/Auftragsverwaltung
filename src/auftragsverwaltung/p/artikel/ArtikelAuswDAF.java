package auftragsverwaltung.p.artikel;

import java.awt.event.*;
import java.util.*;
import javax.swing.*;

import auftragsverwaltung.c.*;
import auftragsverwaltung.c.artikel.Artikel;

/**
 * Auftragsverwaltung:<BR> Klasse der Fenster zum Auswählen der Daten eines Artikels<BR>
 * @author Jonas & Sven
 * @version  0.1
 */
public class ArtikelAuswDAF extends JDialog implements ActionListener
{
	
	/** x-Koordinate der linken, oberen Ecke des Fensters */
	private final int X0 = 200;
  
	/** y-Koordinate der linken, oberen Ecke des Fensters */
	private final int Y0 = 150;
  
	/** Parametergruppe */
	private ArtikelParamDG artikelParamDG = new ArtikelParamDG( this );

	/** Treffertabelle */
	private ArtikelDT1 artikelDT1 = new ArtikelDT1( this );

	/** Trefferplatte */
	private JScrollPane trefferPlatte = new JScrollPane( artikelDT1,
			JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
			JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS );

	/** Steuerungsplatte */
	private JPanel strgPlatte = new JPanel( );

	/** DialogAuslöseSchalter zum Radieren der Werte der Wertefelder*/
	private JButton neuDAS        = new JButton( "neu" );

	/** DialogAuslöseSchalter zum Schließen des Fensters */
	private JButton schliessenDAS = new JButton( "schließen" );

	/** DialogAuslöseSchalter zum Suchen der Treffer in der Datenbasis */
	private JButton suchenDAS     = new JButton( "suchen" );

	/** DialogAuslöseSchalter zum Übergeben eines Treffers an das Bearbeitungsfenster */
	private JButton uebergebenDAS = new JButton( "Übergeben" );

	/** Verweis auf dasjenige Fenster zum Bearbeiten eines Artikels, innerhalb dessen dieses Fenster geöffnet wurde */
	private ArtikelBearbDAF artikelBearbDAF;
  
	/** Suchparameter */
	/* Auskommentiert da nicht genutzt
  	private ArtikelParam artikelParam;
	 */
  
	/** Datenobjekt: Artikel */
	private Artikel artikel;

	/** Datenobjekt: Liste von Artikeln */
	private ArrayList< Artikel > artikelL;

	
	/**
    	erzeugt ein DialogAnwendungsFenster der Anwendung: Artikeldaten auswählen
	 */
	public ArtikelAuswDAF( ArtikelBearbDAF artikelBearbDAF )
	{
	    setTitle( "Artikeldaten auswählen" );
	  	setDefaultCloseOperation( WindowConstants.DISPOSE_ON_CLOSE );
	  	
	  	/* Auskommentiert da nicht genutzt
	  	artikelParam = new ArtikelParam( );
	  	*/
	  	
	    this.artikelBearbDAF = artikelBearbDAF;
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
    	legt die Anordnung der Parametergruppe, der Trefferplatte und der Steuerungsgruppe im Fenster fest
	 */
	public void bestandteileAnordnen( )
	{
	    // Anordnung vereinbaren
	    GroupLayout layout = new GroupLayout( getContentPane( ) );
	    getContentPane( ).setLayout( layout );
	    
	    // voreingestellte Lücken verwenden
	    layout.setAutoCreateGaps( true );
	    layout.setAutoCreateContainerGaps( true );
	    
	    // senkrechte Gruppierung vereinbaren
	    layout.setVerticalGroup(
	    	layout.createSequentialGroup( ).
		        addComponent( artikelParamDG ).
		        addComponent( trefferPlatte ).
		        addComponent( strgPlatte )
	    );

	    // waagerechte Gruppierung vereinbaren
	    layout.setHorizontalGroup(
	    	layout.createParallelGroup( ).
		        addComponent( artikelParamDG ).
		        addComponent( trefferPlatte ).
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
	
	  	// voreingestellte Lücken verwenden
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
	  	neuDAS.       addActionListener( this );
	  	schliessenDAS.addActionListener( this );
	  	suchenDAS. 		addActionListener( this );
	  	uebergebenDAS.addActionListener( this );
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
		artikelParamDG.radieren( );
		artikelDT1.radieren( );
    	uebergebenDAS.setEnabled( false );
	}

	/**
		schließt das Fenster
	 */
	public void schliessen( )
	{
		dispose( );
	}

	/**
		sucht nach denjenigen Artikeln, die zum Suchparameter passen, und gibt sie in der Treffertabelle aus
	 */
	public void suchen( )
	{
		JOptionPane.showMessageDialog( this,
  			"Anwendung \"Artikel auswählen\":\n" +
  			"Operation \"suchen\" noch in Arbeit",
  			"Baustelle",
  			JOptionPane.INFORMATION_MESSAGE );
	}

	/**
		gibt einen ausgewählten Artikel im Bearbeitungsfenster aus
	 */
	public void uebergeben( )
	{
		JOptionPane.showMessageDialog( this,
  			"Anwendung \"Artikel auswählen\":\n" +
  			"Operation \"Übergeben\" noch in Arbeit",
  			"Baustelle",
  			JOptionPane.INFORMATION_MESSAGE );
	}
  
}


