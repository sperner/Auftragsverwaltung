package auftragsverwaltung.p.geschaeftspartner;

import java.awt.event.*;
import java.text.NumberFormat;
import javax.swing.*;

import auftragsverwaltung.c.*;
import auftragsverwaltung.c.geschaeftspartner.Lieferant;
import auftragsverwaltung.p.geschaeftspartner.*;

/**
 * Auftragsverwaltung:<BR> Klasse der DialogAnwendungsFenster zum bearbeiten der Bankverbindung eines Lieferanten<BR>
 * @author Jonas & Sven
 * @version  0.1
 */
public class LieferantenBearbDAF extends JDialog
{
	
	/** x-Koordinate der linken, oberen Ecke des Fensters */
	private final int X0 = 720;
  
	/** y-Koordinate der linken, oberen Ecke des Fensters */
	private final int Y0 = 205;
  
	/** Info-Platte */
	private JPanel infoPlatte = new JPanel( );

	/** DialogObjektGruppe: Anschrift */
	private BankverbindungDG bankverbindungDG = new BankverbindungDG( this );
  
	/** Steuerungsplatte */
	private JPanel strgPlatte = new JPanel( );

	/** Verweis auf das Eigentümerfenster zum Bearbeiten eines Geschaeftspartners */
	private GeschaeftspartnerBearbDAF geschaeftspartnerBearbDAF;
  
	
	/**
    	erzeugt ein DialogAnwendungsFenster der Anwendung: Lieferantendaten bearbeiten
	 */
	public LieferantenBearbDAF( GeschaeftspartnerBearbDAF geschaeftspartnerBearbDAF )
	{
	  	super( geschaeftspartnerBearbDAF );
	  	this.geschaeftspartnerBearbDAF = geschaeftspartnerBearbDAF;
	  	
	  	setTitle( "Daten eines Lieferanten bearbeiten" );
	  	setDefaultCloseOperation( WindowConstants.DO_NOTHING_ON_CLOSE );
	
	  	bestandteileAnordnen( );

	  	// Fenstergröße aus Größe der Komponenten bestimmen
	  	pack( );
	  
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
	    
	    // voreingestellte Liecken verwenden
	    dafLayout.setAutoCreateGaps( true );
	    dafLayout.setAutoCreateContainerGaps( true );
	    
	    // senkrechte Gruppierung vereinbaren
	    dafLayout.setVerticalGroup(
	     dafLayout.createSequentialGroup( ).
	      addComponent( bankverbindungDG )
	    );
	
	    // waagerechte Gruppierung vereinbaren
	    dafLayout.setHorizontalGroup(
	     dafLayout.createParallelGroup( ).
	      addComponent( bankverbindungDG, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE )
	    );
	}

   /**
	  Methode um Standardwerte zu setzen
	*/
	public void radieren( )
	{
		bankverbindungDG.radieren();
	}
  
}


