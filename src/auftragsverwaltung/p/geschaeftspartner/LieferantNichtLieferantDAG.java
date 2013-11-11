package auftragsverwaltung.p.geschaeftspartner;

import java.awt.event.ActionEvent;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.event.*;

/**
 * Auftragsverwaltung:<BR>Klasse der DialogAnkreuzkaestchenGruppe, mit der bestimmt wird ob in der Geschaeftspartnerauswahl nach einem Lieferanten oder nichtLieferanten gesucht wird.<BR> 
 * @author Jonas & Sven
 * @version  0.1
 */
public class LieferantNichtLieferantDAG extends JPanel implements ActionListener
{
	
	/** DialogAnkreuzKaestchen, mit dem die Auswahl von "Lieferanten" gewaehlt wird */
	private JCheckBox lieferantDAK = new JCheckBox( "Lieferant" );

	/** DialogAnkreuzKaestchen, mit dem die Auswahl von "nicht Lieferanten" gewaehlt wird */
	private JCheckBox nichtLieferantDAK = new JCheckBox( "nicht Lieferant" );

	/** Verweis auf die Behaeltergruppe zur Steuerung der Auswahl von Geschaeftspartnern */
	private KundeLieferantParamDG kundeLieferantParamDG;
	
	
	/**
	   erzeugt eine DialogAnkreuzkaestchenGruppe um Festzulegen ob der Geschaeftspartner lieferant oder nicht Lieferant ist
	 */
	public LieferantNichtLieferantDAG( KundeLieferantParamDG artikelParamDG )
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
				addComponent( lieferantDAK ).
				addComponent( nichtLieferantDAK )
		);

		// waagerechte Gruppierung vereinbaren
		dagLayout.setHorizontalGroup(
			dagLayout.createParallelGroup( ).
				addComponent( lieferantDAK ).
				addComponent( nichtLieferantDAK )
		);
	}
	
	/**
		Ereignissensoren anmelden
	 */
	public void verwanzen( )
	{
		lieferantDAK.		addActionListener( this );
		nichtLieferantDAK.	addActionListener( this );
	}

	/**
		Ereignisbehandlung zu Regelung der Ankreutkaestchen bzw. ihrem Verhalten
	 */
	public void actionPerformed( ActionEvent e )
	{
		if ( e.getSource( ) == lieferantDAK )
		{			
				lieferantSteuern( e );
		}
			
		if ( e.getSource( ) == nichtLieferantDAK )
		{
				nichtLieferantSteuern( e );
		}
	}
	
	/**
	   Ereignissbehandlung
	 */
	public void lieferantSteuern( ActionEvent e)
	{
		if ( e.getSource( ) == lieferantDAK )
		{
			if( ! lieferantDAK.isSelected( ) )
			{
				lieferantDAK.setSelected( false );
				nichtLieferantDAK.setSelected( true );
			}
			else
			{
				lieferantDAK.setSelected( true );
				nichtLieferantDAK.setSelected( false );
			}
		}
		else if ( e.getSource( ) == nichtLieferantDAK )
		{
			if ( ! nichtLieferantDAK.isSelected( ) )
			{
				nichtLieferantDAK.setSelected( true ); 
				lieferantDAK.setSelected( false );
			}
			else
			{
				nichtLieferantDAK.setSelected( false ); 
				lieferantDAK.setSelected( true );
			}
		}
	}
	
	/**
	   Ereignissbehandlung
	 */
	public void nichtLieferantSteuern( ActionEvent e)
	{
		if ( e.getSource( ) == lieferantDAK )
		{
			if( ! lieferantDAK.isSelected( ) )
			{
				lieferantDAK.setSelected( true );
				nichtLieferantDAK.setSelected( false );
			}
			else
			{
				lieferantDAK.setSelected( false );
				nichtLieferantDAK.setSelected( true );
			}
		}
		else if ( e.getSource( ) == nichtLieferantDAK )
		{
			if ( ! nichtLieferantDAK.isSelected( ) )
			{
				nichtLieferantDAK.setSelected( false );
				lieferantDAK.setSelected( true );
			}
			else
			{
				nichtLieferantDAK.setSelected( true );
				lieferantDAK.setSelected( false );
			}
		}

	}
	
   /**
	  Methode um Standardwerte zu setzen
	*/
	public void radieren( )
	{
		lieferantDAK.		setSelected( true );
		nichtLieferantDAK.	setSelected( false );
	}
 
}
