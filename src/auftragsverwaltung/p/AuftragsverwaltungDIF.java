package auftragsverwaltung.p;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

import auftragsverwaltung.p.artikel.*;
import auftragsverwaltung.p.geschaeftspartner.GeschaeftspartnerBearbDAF;

/**
 * Auftragsverwaltung:<BR> Klasse der Hauptfenster mit Menue<BR>
 * @author Jonas & Sven
 * @version  0.1
 */
public class AuftragsverwaltungDIF extends JFrame implements ActionListener
{
	
	/** Menübalken fuer das Hauptmenue */
	private JMenuBar auftragsverwaltungDHM;
	
	/** Untermenue zum Bearbeiten einer Entitaet */
	private JMenu bearbeitenDUM;
  
	/** Menuepunkt zum Oeffnen eines Fensters zum Bearbeiten der Daten eines Geschaeftspartners */
	private JMenuItem geschaeftspartnerDMB;
  
	/** Menuepunkt zum oeffnen eines Fensters zum Bearbeiten der Informationen zu einem Artikel */
	private JMenuItem artikelDMB;
  
	/** Menuepunkt zum oeffnen eines Fensters zum Bearbeiten eines Auftrags */
	private JMenuItem auftragDMB;

	/** Untermenue fuer die Auswertungen */
	private JMenu auswertenDUM;
  
	/** Menuepunkt zum Ausfuehren der Umsatzauswertung */
	private JMenuItem umsatzDMB;

	/** Untermenue zum Beenden der Ausfuehrung */
	private JMenu beendenDUM;
  
	/** Menuepunkt zum Beenden der Ausfuehrung */
	private JMenuItem beendenDMB;
  
	private final int BREITE = 600;
	private final int HOEHE  = 400;

	/** x-Koordinate der linken, oberen Ecke des Fensters */
	private final int X0 = 40;

	/** x-Koordinate der linken, oberen Ecke des Fensters */
	private final int Y0  = 30;

	/** Verweis auf ein Fenster zum Bearbeiten der Daten eines Geschaeftspartners */
	private GeschaeftspartnerBearbDAF geschaeftspartnerBearbDAF;
  
	/** Verweis auf ein Fenster zum Bearbeiten der Informationen zu einem Artikel*/
	private ArtikelBearbDAF artikelBearbDAF;

	/** Verweis auf ein Fenster zum Bearbeiten eines Auftrags */
	// private AuftragBearbDAF auftragBearbDAF;
	/** Verweis auf ein Fenster fuer die Eingabe der Parameter der Umsatzauswertung */
	// private UmsatzAuswDAF umsatzAuswDAF;

	
	/**
    	erzeugt ein InformationsSystemFenster (Hauptfenster) fuer die Auftragsverwaltung
	 */
	public AuftragsverwaltungDIF( )
	{
		super( "Auftragsverwaltung" );

	    // Beim Schliessen dieses Fensters Programmausfuehrung beenden.
	    setDefaultCloseOperation( EXIT_ON_CLOSE );
	
	    // Groesse bestimmen
	    setSize( BREITE, HOEHE );
	    // Lage bestimmen
	    setLocation( X0, Y0 );

	    menueZusammenbauen( );
	    verwanzen( );
	        
	    setVisible( true );
	}
  
	/**
    	baut das Menue des InformationsSystemFensters zusammen
	 */
	public void menueZusammenbauen( )
	{
	    // Hauptmenue erzeugen
	    auftragsverwaltungDHM = new JMenuBar( );
	    setJMenuBar( auftragsverwaltungDHM );
	
	    // Menuepunkt: Bearbeitungsanwendungen
	    bearbeitenDUM = new JMenu( "bearbeiten" );
	    auftragsverwaltungDHM.add( bearbeitenDUM );
	
	    // Menuepunkt: Daten eines Geschaeftspartners bearbeiten
	    geschaeftspartnerDMB = new JMenuItem( "Geschaeftspartner" );
	    geschaeftspartnerDMB.setAccelerator(
	    	KeyStroke.getKeyStroke(	KeyEvent.VK_P, InputEvent.CTRL_MASK ) );
	    bearbeitenDUM.add( geschaeftspartnerDMB );
	
	    // Menuepunkt: Artikeldaten bearbeiten
	    artikelDMB = new JMenuItem( "Artikel" );
	    artikelDMB.setAccelerator(
	    	KeyStroke.getKeyStroke(	KeyEvent.VK_A, InputEvent.CTRL_MASK ) );
	    bearbeitenDUM.add( artikelDMB );
	
	    // Menuepunkt: Auftrag bearbeiten
	    auftragDMB = new JMenuItem( "Auftrag" );
	    auftragDMB.setAccelerator(
	    	KeyStroke.getKeyStroke(	KeyEvent.VK_T, InputEvent.CTRL_MASK ) );
	    bearbeitenDUM.add( auftragDMB );
	    
	    // Menue: Auswertungsanwendungen
	    auswertenDUM = new JMenu( "auswerten" );
	    auftragsverwaltungDHM.add( auswertenDUM );
	
	    // Menuepunkt: Daten eines Geschaeftspartners bearbeiten
	    umsatzDMB = new JMenuItem( "Umsatz" );
	    umsatzDMB.setAccelerator(
	    	KeyStroke.getKeyStroke( KeyEvent.VK_U, InputEvent.CTRL_MASK ) );
	    auswertenDUM.add( umsatzDMB );
	    
	    // Menue beenden ganz nach rechts
	    auftragsverwaltungDHM.add(Box.createHorizontalGlue( ) );
	
	    // Menue: beenden
	    beendenDUM = new JMenu( "beenden" );
	    auftragsverwaltungDHM.add( beendenDUM );
	
	    // Menuepunkt: beenden
	    beendenDMB = new JMenuItem( "beenden" );
	    beendenDMB.setAccelerator(
	    	KeyStroke.getKeyStroke(	KeyEvent.VK_E, InputEvent.CTRL_MASK ) );
	    beendenDUM.add( beendenDMB );
	}
  
	/**
    	Ereignissensoren anmelden
	 */
	public void verwanzen( )
	{
	    // Menuepunkt: Daten eines Geschaeftspartners bearbeiten
	    geschaeftspartnerDMB.addActionListener( this );
	
	    // Menuepunkt: Artikeldaten bearbeiten
	    artikelDMB.addActionListener( this );
	
	    // Menuepunkt: Auftrag bearbeiten
	    auftragDMB.addActionListener( this );
	
	    // Menuepunkt: Umsatzauswertung ausfuehren
	    umsatzDMB.addActionListener( this );
	
	    // Menuepunkt: beenden
	    beendenDMB.addActionListener( this );
	}

	/**
    	Ereignisbehandlung
	 */
	public void actionPerformed( ActionEvent e )
	{
	    if ( e.getSource( ) == geschaeftspartnerDMB )
	    {
	    	geschaeftspartnerBearbDAF = new GeschaeftspartnerBearbDAF( );
	    	geschaeftspartnerBearbDAF.radieren( );
	    }
	    else if ( e.getSource( ) == artikelDMB )
	    {
	    	artikelBearbDAF = new ArtikelBearbDAF( );
	    	artikelBearbDAF.radieren( );
	    }
	    else if ( e.getSource( ) == auftragDMB )
	        JOptionPane.showMessageDialog( this,
	        "Anwendung \"Auftrag bearbeiten\" noch in Arbeit",
	        "Baustelle", JOptionPane.INFORMATION_MESSAGE );
	    
	    else if ( e.getSource( ) == umsatzDMB )
	    	JOptionPane.showMessageDialog( this,
	        "Anwendung \"Umsatz\" noch in Arbeit",
	        "Baustelle", JOptionPane.INFORMATION_MESSAGE );
	    
	    else if ( e.getSource( ) == beendenDMB )
	    {
	    	setVisible(false);
	    	dispose();
	    }
	}
	
}


