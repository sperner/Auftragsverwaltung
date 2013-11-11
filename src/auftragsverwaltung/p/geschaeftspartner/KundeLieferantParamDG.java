package auftragsverwaltung.p.geschaeftspartner;

import java.awt.event.ActionEvent;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.event.*;

/**
 * Auftragsverwaltung:<BR>Klasse der DialogObjektGruppen welche die Paramter zur Suche nach geschaeftspartnern beinhaltet<BR> 
 * @author Jonas & Sven
 * @version  0.1
 */
public class KundeLieferantParamDG extends JPanel
{

	/** Verweis auf die Behltergruppe zur Steuerung der Auswahl von Geschaeftspartnern */
	private GeschaeftspartnerParamDG geschaeftspartnerParamDG;

	/** DialogAnkreuzGruppe: Kunde / nicht Kunde */
	private KundeNichtKundeDAG kundeNichtKundeDAG = new KundeNichtKundeDAG( null );
	
	/** DialogAnkreuzGruppe: Lieferant / nicht Lieferant */
	private LieferantNichtLieferantDAG lieferantNichtLieferantDAG = new LieferantNichtLieferantDAG(null );

	
	/**
	   erzeugt eine DialogObjektGruppe der Anwendung:<BR> Geschaeftspartner Daten Auswaehlen
	 */
	public KundeLieferantParamDG( GeschaeftspartnerParamDG geschaeftspartnerParamDG )
	{
		this.geschaeftspartnerParamDG = geschaeftspartnerParamDG;

		bestandteileAnordnen( );
	}

	/**
  		legt die Anordnung der Ankreuzkaestchen in der Gruppe fest
    */
	public void bestandteileAnordnen( )
	{
	    // Rahmen erzeugen
	    TitledBorder dgR = BorderFactory.createTitledBorder( "UND" );
	    setBorder( dgR );
	  
			// Anordnung vereinbaren
			GroupLayout dagLayout = new GroupLayout( this );
			setLayout( dagLayout );
	  
			// voreingestellte Lcken verwenden
			dagLayout.setAutoCreateGaps( true );
			dagLayout.setAutoCreateContainerGaps( true );
	  
			// senkrechte Gruppierung vereinbaren
			dagLayout.setVerticalGroup(
					dagLayout.createSequentialGroup( ).
				        addGroup( dagLayout.createParallelGroup( GroupLayout.Alignment.BASELINE ).
				          addComponent( kundeNichtKundeDAG ).
				          addComponent( lieferantNichtLieferantDAG )
				        )
		
			);
	
			// waagerechte Gruppierung vereinbaren
			
			dagLayout.setHorizontalGroup(
					dagLayout.createSequentialGroup( ).
				        addGroup( dagLayout.createParallelGroup( GroupLayout.Alignment.LEADING, false ).
				          addComponent( kundeNichtKundeDAG, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE )
				            ).
				        addGroup( dagLayout.createParallelGroup( GroupLayout.Alignment.LEADING, false ).
				          addComponent( lieferantNichtLieferantDAG, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE )
				            )
			);
	}
	
   /**
	  Methode um Standardwerte zu setzen
	*/
	public void radieren( )
	{
		 kundeNichtKundeDAG.radieren( );
		 lieferantNichtLieferantDAG.radieren( );
	}
}
