package auftragsverwaltung.p.geschaeftspartner;

import java.awt.event.ActionEvent;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.event.*;
import java.text.NumberFormat;

import auftragsverwaltung.p.geschaeftspartner.GeschaeftspartnerBearbDAF;

/**
 * Auftragsverwaltung:<BR>Klasse der DialogAnwendungsFenster zur Bearbeitung eines Kunden<BR>
 * @author Jonas & Sven
 * @version  0.1
 */
public class KundenBearbDAF extends JDialog
{
	
	/** x-Koordinate der linken, oberen Ecke des Fensters */
	private final int X0 = 720;
  
	/** y-Koordinate der linken, oberen Ecke des Fensters */
	private final int Y0 = 60;
  
	/** Beschriftung: Kreditlimit */
	private JLabel kreditlimitDB = new JLabel( "Kreditlimit" );
	
	/** formatiertes Textfeld: Kreditlimit */
	private JTextField kreditlimitDW = new JTextField( 20 );

	/** Verweis auf das Eigentuemerfenster zum Bearbeiten eines Geschaeftspartners */
	private GeschaeftspartnerBearbDAF geschaeftspartnerBearbDAF;

  
	/**
  		erzeugt ein DialogAnwendungsFenster der Anwendung: Kunde bearbeiten
	 */
	public KundenBearbDAF( GeschaeftspartnerBearbDAF geschaeftspartnerBearbDAF )
	{
	  	super( geschaeftspartnerBearbDAF );
	  	this.geschaeftspartnerBearbDAF = geschaeftspartnerBearbDAF;
	  	
	  	setTitle( "Daten eines Kunden bearbeiten" );
	  	setDefaultCloseOperation( WindowConstants.DO_NOTHING_ON_CLOSE );
	
	  	// Breite des DialogWertefelds kreditlimitDW festlegen
	  	kreditlimitDW.setColumns( 20 );
	  	
	  	bestandteileAnordnen( );
	  	
	  	// Fenstergröße aus Größe der Komponenten bestimmen
	  	pack( );
	  
	  	// Lage bestimmen
	  	setLocation( X0, Y0 );
	
	  	setVisible( true );
	}
	
	/**
  		legt die Anordnung des beschrifteten Dialogwertefelds Kreditlimt fest
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
	  		dafLayout.createParallelGroup( ).
	  			addComponent( kreditlimitDB ).
	  			addComponent( kreditlimitDW )
	  	);
	
	  	// waagerechte Gruppierung vereinbaren
	  	dafLayout.setHorizontalGroup(
	  		dafLayout.createSequentialGroup( ).
	      		addComponent( kreditlimitDB ).
	      		addComponent( kreditlimitDW )
	  	);
	}
	
}
