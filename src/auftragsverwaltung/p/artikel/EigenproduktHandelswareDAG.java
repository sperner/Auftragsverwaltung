package auftragsverwaltung.p.artikel;

import java.awt.event.ActionEvent;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.event.*;

/**
 * Auftragsverwaltung:<BR>Klasse der DialogAnkreuzkstchenGruppe, mit der die Artikelauswahl so gesteuert wird, dass Eigenprodukte und / oder Handelswaren einbezogen werden.<BR> 
 * @author Jonas & Sven
 * @version  0.1
 */
public class EigenproduktHandelswareDAG extends JPanel implements ActionListener
{
	
	/** DialogAnkreuzKästchen, mit dem die Auswahl von Eigenprodukten gewhlt wird */
	private JCheckBox eigenproduktDAK = new JCheckBox( "Eigenprodukt" );

	/** DialogAnkreuzKästchen, mit dem die Auswahl von Handelswaren gewhlt wird */
	private JCheckBox handelswareDAK = new JCheckBox( "Handelsware" );

	/** Verweis auf die Behältergruppe zur Steuerung der Auswahl von Artikeln */
	private ArtikelParamDG artikelParamDG;
	
	
	public EigenproduktHandelswareDAG( ArtikelParamDG artikelParamDG )
	{
		this.artikelParamDG = artikelParamDG;

		bestandteileAnordnen( );
	  	verwanzen( );
	  	radieren( );
	}

	/**
  		legt die Anordnung der Ankreuzkästchen in der Gruppe fest
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
				addComponent( eigenproduktDAK ).
				addComponent( handelswareDAK )
		);

		// waagerechte Gruppierung vereinbaren
		dagLayout.setHorizontalGroup(
			dagLayout.createParallelGroup( ).
				addComponent( eigenproduktDAK ).
				addComponent( handelswareDAK )
		);
	}
	
	/**
		Ereignissensoren anmelden
	 */
	public void verwanzen( )
	{
		eigenproduktDAK.addActionListener( this );
		handelswareDAK.	addActionListener( this );
	}

	/**
		Ereignisbehandlung
	 */
	public void actionPerformed( ActionEvent e )
	{
		if ( e.getSource( ) == eigenproduktDAK )
		{
			if( ! eigenproduktDAK.isSelected( ) )
			{
				if ( ! handelswareDAK.isSelected( ) )
				{
					eigenproduktDAK.setSelected( true );
				}
			}
		}
		else if ( e.getSource( ) == handelswareDAK )
		{
			if ( ! handelswareDAK.isSelected( ) )
			{
				if ( ! eigenproduktDAK.isSelected( ) )
				{
					handelswareDAK.setSelected( true );
				}
			}
		}
	}
	
	public void radieren( )
	{
		eigenproduktDAK.setSelected( true );
		handelswareDAK.setSelected( true );
	}
  
}
