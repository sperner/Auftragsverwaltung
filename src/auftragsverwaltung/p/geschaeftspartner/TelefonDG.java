package auftragsverwaltung.p.geschaeftspartner;

import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

import auftragsverwaltung.c.*;
import auftragsverwaltung.c.geschaeftspartner.Geschaeftspartner;

/**
 * Auftragsverwaltung:<BR> Klasse der DialogObjektGruppe zur Bearbeitung der Telefon Daten eines Geschaeftspartners<BR>
 * @author Jonas & Sven
 * @version  0.1
 */
public class TelefonDG extends JPanel implements ActionListener
{
	
	/** x-Koordinate der linken, oberen Ecke des Fensters */
	private final int X0 = 200;
  
	/** y-Koordinate der linken, oberen Ecke des Fensters */
	private final int Y0 = 150;
  
	/** TelefonDatentabelle */
	private TelefonDT1 telefonDT1 = new TelefonDT1( this );

	/** tabellenplatte */
	private JScrollPane tabellenPlatte = new JScrollPane( telefonDT1,
			JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
			JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS );

  
	/** Steuerungsplatte */
	private JPanel strgPlatte = new JPanel( );

	/** Steuerungsplatte */
	private JPanel infoPlatte = new JPanel( );
  
	/** DialogAusloeseSchalter zum Radieren der Werte der Wertefelder */
	private JButton neuDAS        = new JButton( "neu" );

	/** DialogAusloeseSchalter zum Schliessen des Fensters */
	private JButton bearbeitenDAS = new JButton( "bearbeiten" );

	/** Verweis auf dasjenige Fenster zum Bearbeiten eines Geschaeftspartners, innerhalb dessen dieses Fenster geöffnet wurde */
	private GeschaeftspartnerBearbDAF geschaeftspartnerBearbDAF;
  
	/** Verweis auf dasjenige Fenster zum Bearbeiten der Telefon Daten, innerhalb dessen dieses Fenster geöffnet wurde */
	private TelefonBearbDAF telefonBearbDAF;
  
	/** Datenobjekt: Geschaeftspartner */
	private Geschaeftspartner geschaeftspartner;

	/** Datenobjekt: Liste von Geschaeftspartnern */
	private ArrayList< Geschaeftspartner > geschaeftspartnerL;

  
	/**
    	erzeugt eine DialogObjektGruppe der Anwendung: Telefon Daten auswaehlen
	*/
	public TelefonDG( GeschaeftspartnerBearbDAF geschaeftspartnerBearbDAF )
	{
  	
	    this.geschaeftspartnerBearbDAF = geschaeftspartnerBearbDAF;
	    bestandteileAnordnen( );
	    
	    setLocation( X0, Y0 );
	    verwanzen( );
	
	    setVisible( true );
	    radieren( );
	}

	/**
    	legt die Anordnung der Parametergruppe, der tabellenplatte und der Steuerungsgruppe im Fenster fest
	*/
	public void bestandteileAnordnen( )
	{
		TitledBorder dgR = BorderFactory.createTitledBorder( "Telefon" );
		setBorder( dgR );
	    
		// Anordnung vereinbaren
		GroupLayout layout = new GroupLayout( this );
		this.setLayout( layout );
    
		// voreingestellte Lücken verwenden
		layout.setAutoCreateGaps( true );
		layout.setAutoCreateContainerGaps( true );
    
		// senkrechte Gruppierung vereinbaren
		layout.setVerticalGroup(
			layout.createSequentialGroup( ).
				addComponent( infoPlatte ).
				addComponent( strgPlatte )
		);

		// waagerechte Gruppierung vereinbaren
		layout.setHorizontalGroup(
			layout.createParallelGroup( ).
				addComponent( infoPlatte ).
				addComponent( strgPlatte )
		);

		//  die Komponenten in strgPlatte anordnen
		infoPlatteAnordnen( );
		// die Komponenten in strgPlatte anordnen
		strgPlatteAnordnen( );
	}

	public void infoPlatteAnordnen( )
	{
	  	// Anordnung vereinbaren
	  	GroupLayout infoLayout = new GroupLayout( infoPlatte );
	  	infoPlatte.setLayout( infoLayout );
	
	  	// voreingestellte Luecken verwenden
	  	infoLayout.setAutoCreateGaps( true );
	  	infoLayout.setAutoCreateContainerGaps( true );
	
	  	// senkrechte Gruppierung vereinbaren
	  	infoLayout.setVerticalGroup(
	  			infoLayout.createSequentialGroup( ).
				addGroup( infoLayout.createParallelGroup( GroupLayout.Alignment.BASELINE ).
					addComponent( tabellenPlatte, GroupLayout.PREFERRED_SIZE,100,300 )
					)
	  	);
	
	  	// waagerechte Gruppierung vereinbaren
	  	infoLayout.setHorizontalGroup(
	  		infoLayout.createSequentialGroup( ).
	  			addGroup( infoLayout.createParallelGroup( GroupLayout.Alignment.LEADING, false ).
	  				addComponent( tabellenPlatte, GroupLayout.PREFERRED_SIZE, 100, 200 )
	  				)
	  	);
	}

	public void tabellenPlatteAnordnen( )
	{
	  	// Anordnung vereinbaren
	  	GroupLayout tabellenLayout = new GroupLayout( tabellenPlatte );
	  	tabellenPlatte.setLayout( tabellenLayout );
	
	  	// voreingestellte Luecken verwenden
	  	tabellenLayout.setAutoCreateGaps( true );
	  	tabellenLayout.setAutoCreateContainerGaps( true );
	
	  	// senkrechte Gruppierung vereinbaren
	  	tabellenLayout.setVerticalGroup(
	  		tabellenLayout.createSequentialGroup( ).
				addGroup( tabellenLayout.createParallelGroup( GroupLayout.Alignment.BASELINE ).
					addComponent( telefonDT1 )
					)
	  	);

	  	// waagerechte Gruppierung vereinbaren
	  	tabellenLayout.setHorizontalGroup(
	  		tabellenLayout.createSequentialGroup( ).
	    		addGroup( tabellenLayout.createParallelGroup( GroupLayout.Alignment.LEADING, false ).
	    			addComponent( telefonDT1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE )
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
	
	  	// voreingestellte Luecken verwenden
	  	strgLayout.setAutoCreateGaps( true );
	  	strgLayout.setAutoCreateContainerGaps( true );
	
	  	// senkrechte Gruppierung vereinbaren
	  	strgLayout.setVerticalGroup(
				strgLayout.createSequentialGroup( ).
				addGroup( strgLayout.createParallelGroup( GroupLayout.Alignment.BASELINE ).
				  addComponent( neuDAS ).
				  addComponent( bearbeitenDAS )
			)
	  	);
	
	  	// waagerechte Gruppierung vereinbaren
	  	strgLayout.setHorizontalGroup(
	  		strgLayout.createSequentialGroup( ).
	    		addGroup( strgLayout.createParallelGroup( GroupLayout.Alignment.LEADING, false ).
	    			addComponent( neuDAS, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE )
	    			).
	    		addGroup( strgLayout.createParallelGroup( GroupLayout.Alignment.LEADING, false ).
	    			addComponent( bearbeitenDAS, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE )
	    			)
	  	);
	}
  
	/**
		Ereignissensoren anmelden
	*/
	public void verwanzen( )
	{
	  	neuDAS.       	addActionListener( this );
	  	bearbeitenDAS. 	addActionListener( this );
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
	  	else if ( e.getSource( ) == bearbeitenDAS )
	  	{
	  		geschaeftspartnerBearbDAF.telefonBearbDAFOeffnen( );
	  	}
  	}

   /**
	  Methode um Standardwerte zu setzen
	*/
	public void radieren( )
	{
		telefonDT1.radieren( );
	}
 
}


