package auftragsverwaltung.p.artikel;

import java.awt.event.ActionEvent;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.event.*;

/**
 * Auftragsverwaltung:<BR>Klasse der DialogRadioknopfGruppe zur Wahl zwischen der Bearbeitung eines Eigenprodukts und der Bearbeitung einer Handelware<BR>
 * @author Jonas & Sven
 * @version  0.1
 */
public class HerkunftDRG extends JPanel implements ActionListener
{
	
	/** DialogRadioKnopf, mit dem die Bearbeitung eines Eigenprodukts gewählt wird */
	private JRadioButton eigeneHerstellungDRK = new JRadioButton( "eigene Herstellung" );

	/** DialogRadioKnopf, mit dem die Bearbeitung einer Handelsware gewählt wird */
	private JRadioButton handelDRK = new JRadioButton( "Handel" );
	
	/** Verweis auf das Behlterfenster zum Bearbeiten eines Artikels */
	private ArtikelBearbDAF artikelBearbDAF;
	
	
	public HerkunftDRG( ArtikelBearbDAF artikelBearbDAF )
	{
		this.artikelBearbDAF = artikelBearbDAF;

		bestandteileAnordnen( );
		verwanzen( );
		radieren( );
	}

	/**
  		legt die Anordnung der Radioknpfe in der Gruppe fest
	 */
	public void bestandteileAnordnen( )
	{
	    // Rahmen erzeugen
	    TitledBorder dgR = BorderFactory.createTitledBorder( "Herkunft" );
	    setBorder( dgR );
  
		// Anordnung vereinbaren
		GroupLayout drgLayout = new GroupLayout( this );
		setLayout( drgLayout );
  
		// voreingestellte Lcken verwenden
		drgLayout.setAutoCreateGaps( true );
		drgLayout.setAutoCreateContainerGaps( true );
  
		// senkrechte Gruppierung vereinbaren
		drgLayout.setVerticalGroup(
			drgLayout.createSequentialGroup( ).
				addComponent( eigeneHerstellungDRK ).
				addComponent( handelDRK )
		);

		// waagerechte Gruppierung vereinbaren
		drgLayout.setHorizontalGroup(
			drgLayout.createParallelGroup( ).
				addComponent( eigeneHerstellungDRK ).
				addComponent( handelDRK )
		);
	}
	
	/**
		Ereignissensoren anmelden
	 */
	public void verwanzen( )
	{
		eigeneHerstellungDRK.addActionListener( this );
		handelDRK.           addActionListener( this );
	}

	/**
		Ereignisbehandlung
	 */
	public void actionPerformed( ActionEvent e )
	{
		if ( e.getSource( ) == eigeneHerstellungDRK )
		{
			eigenproduktBearbDAFSteuern( );
		}
		else if ( e.getSource( ) == handelDRK )
		{
			handelswareBearbDAFSteuern( );
		}
	}
	
	/**
	 	Öffnen und Schlieen des Fensters zur Bearbeitung von Eigenproduktdaten
	 	als Reaktion auf das Anklicken des Radioknopfes \"eigene Herstellung\"
	 */
	public void eigenproduktBearbDAFSteuern( )
	{
		if( eigeneHerstellungDRK.isSelected( ) )
		{
			handelDRK.setSelected( false );
			artikelBearbDAF.handelswareBearbDAFSchliessen( );
			artikelBearbDAF.eigenproduktBearbDAFOeffnen( );
		}
		else
		{
			eigeneHerstellungDRK.setSelected( true );
		}
	}

	/**
 		Öffnen und Schlieen des Fensters zur Bearbeitung von Daten einer Handelsware
 		als Reaktion auf das Anklicken des Radioknopfes \"Handel\"
	 */
	public void handelswareBearbDAFSteuern( )
	{
		if ( handelDRK.isSelected( ) )
		{
			eigeneHerstellungDRK.setSelected( false );
			artikelBearbDAF.eigenproduktBearbDAFSchliessen( );
			artikelBearbDAF.handelswareBearbDAFOeffnen( );
		}
		else
		{
			handelDRK.setSelected( true );
		}
	}
	
	public void radieren( )
	{
		eigeneHerstellungDRK.setSelected( true );
		handelDRK.setSelected( false );
	}
}
