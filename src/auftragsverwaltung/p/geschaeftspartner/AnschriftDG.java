package auftragsverwaltung.p.geschaeftspartner;

import java.awt.event.ActionEvent;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.event.*;

/**
 * Auftragsverwaltung:<BR>Klasse der DialogObjektGruppe zur Bearbeitung der Anschrift des Geschaeftspartners<BR>
 * @author Jonas & Sven
 * @version  0.1
 */
public class AnschriftDG extends JPanel 
{
	
	/** Beschriftung: Strasse, Hausnr. */
	private JLabel strasseHausnrDB = new JLabel( "Strasse, Hausnr." );

	/** Textfeld: Strasse, Hausnr. */
	private JTextField strasseHausnrDW = new JTextField( 20 );
	 
	/** Beschriftung: Postleitzahl */
	private JLabel plzDB = new JLabel( "Postleitzahl" );
	
	/** Textfeld: Postleitzahl */
	private JTextField plzDW = new JTextField( 20 );
	  
	/** Beschriftung: Ort */
	private JLabel ortDB = new JLabel( "Ort" );
	
	/** Textfeld: Ort */
	private JTextField ortDW = new JTextField( 20 );
	  
	  	
    /** Verweis auf das Behaelterfenster zum Bearbeiten der Anschrift */
	private GeschaeftspartnerBearbDAF geschaeftspartnerBearbDAF;
	
	
	/**
	 * erzeugt eine DialogObjektGruppe der Anwendung:<BR> Anschrift bearbeiten
	 */
	public AnschriftDG( GeschaeftspartnerBearbDAF geschaeftspartnerBearbDAF )
	{
		this.geschaeftspartnerBearbDAF = geschaeftspartnerBearbDAF;

		bestandteileAnordnen( );
		radieren( );
	}

	/**
  		legt die Anordnung der Textfelder in der Gruppe fest
	 */
	public void bestandteileAnordnen( )
	{
	    // Rahmen erzeugen
	    TitledBorder dgR = BorderFactory.createTitledBorder( "Anschrift" );
	    setBorder( dgR );
  
		// Anordnung vereinbaren
		GroupLayout infoLayout = new GroupLayout( this );
		setLayout( infoLayout );
  
		// voreingestellte Luecken verwenden
		infoLayout.setAutoCreateGaps( true );
		infoLayout.setAutoCreateContainerGaps( true );
  
	
		// senkrechte Gruppierung vereinbaren
		infoLayout.setVerticalGroup(
			infoLayout.createSequentialGroup( ).
			    addGroup( infoLayout.createParallelGroup( GroupLayout.Alignment.BASELINE ).
			    	addComponent( strasseHausnrDB ).
			        addComponent( strasseHausnrDW )
			        ).
			    addGroup( infoLayout.createParallelGroup( GroupLayout.Alignment.BASELINE ).
			        addComponent( plzDB ).
			        addComponent( plzDW )
			        ).
			    addGroup( infoLayout.createParallelGroup( GroupLayout.Alignment.BASELINE ).
			        addComponent( ortDB ).
		            addComponent( ortDW )
			        )       
		);

		// waagerechte Gruppierung vereinbaren
		infoLayout.setHorizontalGroup(
			infoLayout.createParallelGroup( ).
				addGroup(infoLayout.createSequentialGroup( ).
					addGroup( infoLayout.createParallelGroup( GroupLayout.Alignment.LEADING, false ).
						addComponent( strasseHausnrDB, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE ).
						addComponent( plzDB, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE ).
						addComponent( ortDB, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE )
			    	  	).
			    	addGroup( infoLayout.createParallelGroup( GroupLayout.Alignment.LEADING, false ).
			    		addComponent( strasseHausnrDW, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE ).
			    		addComponent( plzDW, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE ).
			    		addComponent( ortDW, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE )
			    		) 
			        )
		);
	}
	
   /**
	  Methode um Standardwerte zu setzen
	*/
	public void radieren( )
	{
		strasseHausnrDW.setText( "" );
		plzDW.setText( "" );
		ortDW.setText( "" );
	}
	
}
