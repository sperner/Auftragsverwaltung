package auftragsverwaltung.p.geschaeftspartner;

import java.awt.event.ActionEvent;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.event.*;

/**
 * Auftragsverwaltung:<BR>Klasse der DialogAnkreuzkaestchenGruppe, mit der bestimmt wird ob in der Geschaeftspartnerauswahl nach einem Kunden oder nichtKunden gesucht wird.<BR> 
 * @author Jonas & Sven
 * @version  0.1
 */
public class KundeNichtKundeDAG extends JPanel implements ActionListener
{
	
	/** DialogAnkreuzKaestchen, mit dem die Auswahl von Kunden gewaehlt wird */
	private JCheckBox kundeDAK = new JCheckBox( "Kunde" );

	/** DialogAnkreuzKaestchen, mit dem die Auswahl von "nicht Kunden" gewaehlt wird */
	private JCheckBox nichtKundeDAK = new JCheckBox( "nicht Kunde" );

	/** Verweis auf die Behaeltergruppe zur Steuerung der Auswahl von Geschaeftspartnern */
	private KundeLieferantParamDG kundeLieferantParamDG;
	
	
	/**
	   erzeugt eine DialogAnkreuzkaestchenGruppe um Festzulegen ob der Geschaeftspartner Kunde oder nicht Kunde ist
	 */
	public KundeNichtKundeDAG( KundeLieferantParamDG kundeLieferantParamDG )
	{
		this.kundeLieferantParamDG = kundeLieferantParamDG;

		bestandteileAnordnen( );
		verwanzen( );
		radieren( );
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
	  
			// voreingestellte Lcken verwenden
			dagLayout.setAutoCreateGaps( true );
			dagLayout.setAutoCreateContainerGaps( true );
	  
			// senkrechte Gruppierung vereinbaren
			dagLayout.setVerticalGroup(
				dagLayout.createSequentialGroup( ).
					addComponent( kundeDAK ).
					addComponent( nichtKundeDAK )
			);
	
			// waagerechte Gruppierung vereinbaren
			dagLayout.setHorizontalGroup(
				dagLayout.createParallelGroup( ).
					addComponent( kundeDAK ).
					addComponent( nichtKundeDAK )
			);
	}

	/**
		Ereignissensoren anmelden
	 */
	public void verwanzen( )
	{
		kundeDAK.		addActionListener( this );
		nichtKundeDAK.	addActionListener( this );
	}

	/**
		Ereignisbehandlung zu Regelung der Ankreutkaestchen bzw. ihrem Verhalten
	 */
	public void actionPerformed( ActionEvent e )
	{
		if ( e.getSource( ) == kundeDAK )
		{			
			kundeSteuern( e );
		}
			
		if ( e.getSource( ) == nichtKundeDAK )
		{
			nichtKundeSteuern( e );		
		}
	}
	
	/**
	   Ereignisbehandlung
	 */
	public void kundeSteuern( ActionEvent e)
	{
		if ( e.getSource( ) == kundeDAK )
		{
			if( ! kundeDAK.isSelected( ) )
			{
				kundeDAK.setSelected( false );
				nichtKundeDAK.setSelected( true );
			}
			else
			{
				kundeDAK.setSelected( true );
				nichtKundeDAK.setSelected( false );
			}
		}
		else if ( e.getSource( ) == nichtKundeDAK )
		{
			if ( ! nichtKundeDAK.isSelected( ) )
			{
				nichtKundeDAK.setSelected( true ); 
				kundeDAK.setSelected( false );
			}
			else
			{
				nichtKundeDAK.setSelected( false ); 
				kundeDAK.setSelected( true );
			}
		}
	}
	
	/**
	   Ereignisbehandlung
	 */
	public void nichtKundeSteuern( ActionEvent e)
	{
		if ( e.getSource( ) == kundeDAK )
		{
			if( ! kundeDAK.isSelected( ) )
			{
				kundeDAK.setSelected( true );
				nichtKundeDAK.setSelected( false );
			}
			else
			{
				kundeDAK.setSelected( false );
				nichtKundeDAK.setSelected( true );
			}
		}
		else if ( e.getSource( ) == nichtKundeDAK )
		{
			if ( ! nichtKundeDAK.isSelected( ) )
			{
				nichtKundeDAK.setSelected( false );
				kundeDAK.setSelected( true );
			}
			else
			{
				nichtKundeDAK.setSelected( true );
				kundeDAK.setSelected( false );
			}
		}

	}
	
   /**
	  Methode um Standardwerte zu setzen
	*/
	public void radieren( )
	{
		kundeDAK.		setSelected( true );
		nichtKundeDAK.	setSelected( false );
	}
  
}
