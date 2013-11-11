package auftragsverwaltung.p.geschaeftspartner;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.text.NumberFormat;

import auftragsverwaltung.p.geschaeftspartner.*;

/**
 * Auftragsverwaltung:<BR>Klasse der DialogobjektGruppe zur Bearbeitung der Bankverbindung eines Lieferanten<BR>
 * @author Jonas & Sven
 * @version  0.1
 */
public class BankverbindungDG extends JPanel
{
	
	/** Beschriftung: Bank */
	private JLabel bankDB = new JLabel( "Bank" );

	/** Textfeld: Bank */
	private JTextField bankDW = new JTextField( 20 );

	/** Beschriftung: Zweigstelle */
	private JLabel zweigstelleDB = new JLabel( "Zweigstelle" );

	/** Textfeld: Zweigstelle */
	private JTextField zweigstelleDW = new JTextField( 20 );

	/** Beschriftung: Bankleitzahl */
	private JLabel blzDB = new JLabel( "Bankleitzahl" );
  
	/** Textfeld: Bankleitzahl */
	private JTextField blzDW = new JTextField( 20 );

	/** Beschriftung: Kontonummer */
	private JLabel kontoNrDB = new JLabel( "Kontonummer" );

	/** Textfeld: Kontonummer */
	private JTextField kontoNrDW = new JTextField( 20 );

	/** Verweis auf das Eigentuemerfenster zum Bearbeiten eines lieferanten */
	private LieferantenBearbDAF lieferantenBearbDAF;

	
	/**
  		erzeugt ein DialogAnwendungsFenster der Anwendung:<BR> Bankverbindung bearbeiten
	 */
	public BankverbindungDG( LieferantenBearbDAF lieferantenBearbDAF )
	{
	  	this.lieferantenBearbDAF = lieferantenBearbDAF;
	  	
	  	bestandteileAnordnen( );
	  	radieren( );
	}
	
	/**
  		legt die Anordnung der beschrifteten Dialogwertefelder bankverbindungDW im Fenster fest
	 */
	public void bestandteileAnordnen( )
	{
	    // Rahmen erzeugen
	    TitledBorder dgR = BorderFactory.createTitledBorder( "Bankverbindung" );
	    setBorder( dgR );
	
		// Anordnung vereinbaren
		GroupLayout dafLayout = new GroupLayout( this );
		setLayout( dafLayout );
		
	  	// voreingestellte Lücken verwenden
	  	dafLayout.setAutoCreateGaps( true );
	  	dafLayout.setAutoCreateContainerGaps( true );
	  
	  	// senkrechte Gruppierung vereinbaren
	  	dafLayout.setVerticalGroup(
	  		dafLayout.createSequentialGroup( ).
		  		addGroup( dafLayout.createParallelGroup( GroupLayout.Alignment.BASELINE ).
				    addComponent( bankDB ).
				    addComponent( bankDW )
					).
			    addGroup( dafLayout.createParallelGroup( GroupLayout.Alignment.BASELINE ).
			  		addComponent( zweigstelleDB ).
			  		addComponent( zweigstelleDW )
					).
			    addGroup( dafLayout.createParallelGroup( GroupLayout.Alignment.BASELINE ).
			  		addComponent( blzDB ).
			  		addComponent( blzDW )
					).
			    addGroup( dafLayout.createParallelGroup( GroupLayout.Alignment.BASELINE ).
					addComponent( kontoNrDB ).
					addComponent( kontoNrDW )
					)
	  	);

	  	// waagerechte Gruppierung vereinbaren
	  	dafLayout.setHorizontalGroup(
	  		dafLayout.createParallelGroup( ).
				addGroup(dafLayout.createSequentialGroup( ).
				   addGroup( dafLayout.createParallelGroup( GroupLayout.Alignment.LEADING, false ).
					  addComponent( bankDB, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE ).
			    	  addComponent( zweigstelleDB, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE ).
			    	  addComponent( blzDB, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE ).
			    	  addComponent( kontoNrDB, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE )
			    	  ).
			       addGroup( dafLayout.createParallelGroup( GroupLayout.Alignment.LEADING, false ).
			          addComponent( bankDW, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE ).
			          addComponent( zweigstelleDW, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE ).
			          addComponent( blzDW, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE ).
			          addComponent( kontoNrDW, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE )
			          ) 
			        )
	  	);
	}

   /**
	  Methode um Standardwerte zu setzen
	*/
	public void radieren( )
	{
		bankDW.setText( "" );
		zweigstelleDW.setText( "" );
		blzDW.setText( "" );
		kontoNrDW.setText( "" );
	}
	
}
