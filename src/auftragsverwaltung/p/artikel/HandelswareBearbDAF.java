package auftragsverwaltung.p.artikel;

import java.text.NumberFormat;
import javax.swing.*;

/**
 * Auftragsverwaltung:<BR> Klasse der Fenster zum Bearbeiten der Daten einer Handelsware<BR>
 * @author Jonas & Sven
 * @version  0.1
 */
public class HandelswareBearbDAF extends JDialog
{
	
	/** x-Koordinate der linken, oberen Ecke des Fensters */
	private final int X0 = 510;
  
	/** y-Koordinate der linken, oberen Ecke des Fensters */
	private final int Y0 = 240;
  
	/** Beschriftung: Preis pro Einheit */
	private JLabel einkaufspreisProEinheitL = new JLabel( "Einkaufspreis pro Einheit" );
  
	/** formatiertes Textfeld: Preis pro Einheit */
	private JFormattedTextField einkaufspreisProEinheitDW = new JFormattedTextField( NumberFormat.getCurrencyInstance( ) );

	/** Verweis auf das Eigentümerfenster zum Bearbeiten eines Artikels */
	private ArtikelBearbDAF artikelBearbDAF;

  
	/**
  		erzeugt ein DialogAnwendungsFenster der Anwendung: Artikeldaten bearbeiten
	 */
	public HandelswareBearbDAF( ArtikelBearbDAF artikelBearbDAF )
	{
	  	super( artikelBearbDAF );
	  	this.artikelBearbDAF = artikelBearbDAF;
	  	
	  	setTitle( "Handelsware bearbeiten" );
	  	setDefaultCloseOperation( WindowConstants.DO_NOTHING_ON_CLOSE );
	
	  	// Breite des Dialogwertefelds einkaufspreisProEinheitDW setzen
	  	einkaufspreisProEinheitDW.setColumns( 20 );
	  	einkaufspreisProEinheitDW.setHorizontalAlignment( JTextField.LEFT );
	  	bestandteileAnordnen( );
	  	
	  	// Fenstergröße aus der Größe der Komponenten bestimmen
	  	pack( );
	  
	  	// Lage bestimmen
	  	setLocation( X0, Y0 );
	
	  	setVisible( true );
	}
  
	/**
  		legt die Anordnung des beschrifteten Dialogwertefelds einkaufspreisProEinheitDW im Fenster fest
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
	  		dafLayout.createParallelGroup( ).
	  			addComponent( einkaufspreisProEinheitL ).
	  			addComponent( einkaufspreisProEinheitDW )
	  	);
	
	  	// waagerechte Gruppierung vereinbaren
	  	dafLayout.setHorizontalGroup(
	  		dafLayout.createSequentialGroup( ).
	      		addComponent( einkaufspreisProEinheitL ).
	      		addComponent( einkaufspreisProEinheitDW )
	  	);
	}
	
}
