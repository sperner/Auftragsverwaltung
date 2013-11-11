package auftragsverwaltung.p.geschaeftspartner;

import java.awt.event.ActionEvent;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.event.*;

/**
 * Auftragsverwaltung:<BR>Klasse der DialogAnkreuzkaestchenGruppe, mit der zusaetzliche Bearbeitungsfenster fuer die Eingabe von Kunden- und Lieferantendaten geoeffnet bzw. geschlossen werden koennen.<BR>
 * @author Jonas & Sven
 * @version  0.1
 */
public class KundeLieferantDAG extends JPanel implements ActionListener
{
	
	/** DialogAnkreuzKaestchen, mit dem die Eingabe von Kundendaten ermoeglicht wird */
	private JCheckBox istKundeDAK = new JCheckBox( "Kunde" );
  
	/** DialogAnkreuzKaestchen, mit dem die Eingabe von Lieferantendaten durchgefhrt wird */
	private JCheckBox istLieferantDAK = new JCheckBox( "Lieferant" );

	/** Verweis auf das Fenster zur Bearbeitung der Daten eines Geschaeftspartners */
	private GeschaeftspartnerBearbDAF geschaeftspartnerBearbDAF;
  
	
	/**
	   erzeugt eine DialogAnkreuzkaestchenGruppe zur Festlegung ob die Fenster Kunde und / oder Lieferant geoeffnet sind
	 */
	public KundeLieferantDAG( GeschaeftspartnerBearbDAF geschaeftspartnerBearbDAF )
	{
	    this.geschaeftspartnerBearbDAF = geschaeftspartnerBearbDAF;
	    bestandteileAnordnen( );
	    verwanzen( );
	    radieren( );
	   
	    geschaeftspartnerBearbDAF.kundenBearbDAFOeffnen( );
	    geschaeftspartnerBearbDAF.lieferantenBearbDAFOeffnen( );
	}

	/**
	  	legt die Anordnung der Ankreuzkaestchen in der Gruppe fest
	 */
	public void bestandteileAnordnen( )
	{
		// Rahmen erzeugen
		TitledBorder dgR = BorderFactory.createTitledBorder( "" );
		setBorder( dgR );
		// Anordnung vereinbaren
		GroupLayout dagLayout = new GroupLayout( this );
		setLayout( dagLayout );
		// voreingestellte Luecken verwenden
		dagLayout.setAutoCreateGaps( true );
		dagLayout.setAutoCreateContainerGaps( true );
		// senkrechte Gruppierung vereinbaren
		dagLayout.setVerticalGroup(
		   dagLayout.createSequentialGroup( ).
		   addComponent( istKundeDAK ).
		   addComponent( istLieferantDAK )
		);
		// waagerechte Gruppierung vereinbaren
		dagLayout.setHorizontalGroup(
		   dagLayout.createParallelGroup( ).
		   addComponent( istKundeDAK ).
		   addComponent( istLieferantDAK )
		);
	}

	/**
    	Ereignissensoren anmelden
	 */
	public void verwanzen( )
	{
	    istKundeDAK.	addActionListener( this );
	    istLieferantDAK.addActionListener( this );
	}
  
	/**
    	Ereignisbehandlung
	 */
	public void actionPerformed( ActionEvent e )
	{
	    if ( e.getSource( ) == istKundeDAK )
	    {
	    	kundenBearbDAFSteuern( );
	    }
	    else if ( e.getSource( ) == istLieferantDAK )
	    {
	    	lieferantenBearbDAFSteuern( );
	    }
	}

	/**
       Ereignisbehandlung
     * @pre 	Ankreuzkaestchen "Kunde" ist markiert
     * @post 	Fenster zum Bearbeiten der Kundendaten wird geoeffnet 
     * 
     * @pre 	Ankreuzkaestchen "Kunde" ist nicht markiert  
     * @post 	Fenster zum Bearbeiten der Kundendaten wird geschlossen 
	 */
	public void kundenBearbDAFSteuern( )
	{
	    if( istKundeDAK.isSelected( ) )
	    {
	    	geschaeftspartnerBearbDAF.kundenBearbDAFOeffnen( );
	    }
	    else if ( istLieferantDAK.isSelected( ) )
	    {
	    	geschaeftspartnerBearbDAF.kundenBearbDAFSchliessen( );
	    }
	    else
	    {
	    	istKundeDAK.setSelected( true );
	    }
	}
  
	/**
  		Ereignisbehandlung
  	 * @pre 	Ankreuzkaestchen "Lieferant" ist markiert
     * @post 	Fenster zum Bearbeiten der Lieferantendaten wird geoeffnet 
     * 
     * @pre 	Ankreuzkaestchen "Lieferant" ist nicht markiert  
     * @post 	Fenster zum Bearbeiten der Lieferantendaten wird geschlossen	
	 */
	public void lieferantenBearbDAFSteuern( )
	{
		if( istLieferantDAK.isSelected( ) )
		{
			geschaeftspartnerBearbDAF.lieferantenBearbDAFOeffnen( );
		}
	    else if ( istKundeDAK.isSelected( ) )
	    {
	    	geschaeftspartnerBearbDAF.lieferantenBearbDAFSchliessen( );
	    }
	    else
	    {
	    	istLieferantDAK.setSelected( true );
	    }
	}
  
   /**
	  Methode um Standardwerte zu setzen
	*/
	public void radieren( )
	{
		istKundeDAK.setSelected( true );
		istLieferantDAK.setSelected( true );
	}
	
}
  