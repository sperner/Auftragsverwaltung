package auftragsverwaltung.p.geschaeftspartner;

import java.util.*;
import javax.swing.*;
import javax.swing.table.*;

import auftragsverwaltung.c.*;
import auftragsverwaltung.c.geschaeftspartner.Geschaeftspartner;
import auftragsverwaltung.c.geschaeftspartner.Telefon;

/**
 * Auftragsverwaltung:<BR> Klasse der DialogTabellen zur Ausgabe des Ergebnisses der Suche nach Telefonnummern<BR>
 * @author Jonas & Sven
 * @version  0.1
 */
public class TelefonDT1 extends JTable
{
	
	/** Spalte der Telefontabelle: telefonnummer */
	private TableColumn telefonNrDES = new TableColumn( );
  
	/** Verweis auf das Fenster zum Auswaehlen eines Geschaeftspartners, innerhalb dessen diese Tabelle angezeigt wurde */
	private TelefonDG telefonDG;
  
	/** Tabellenmodell */
	private DefaultTableModel telefonDT1Modell;
  
	/** Tabellenspaltenmodell */
	private DefaultTableColumnModel telefonDT1Spaltenmodell;

	/** Datenobjekt: Liste von Geschaeftspartnern */
	private ArrayList< Telefon > telefonL;

	
	/**
    erzeugt eine DialogTabelle der Anwendung:<BR> Telefon Daten Auswaehlen
	 */
	public TelefonDT1( TelefonDG telefonDG )
	{
	  	this.telefonDG = telefonDG;
	  	telefonDT1Spaltenmodell = new DefaultTableColumnModel( );
	  	telefonDT1Modell = new DefaultTableModel( );
	
	    zusammenbauen( );
	}
  
	/**
		Tabelle dient nur zur Ausgabe
		@return false
	 */
	public boolean isCellEditable( int zeile, int spalte)
	{
		return false;
	}
  
	public Class getColumnClass( int spalte )
	{
		switch ( spalte )
		{
			case 0: 	return Number.class;
			default: 	return Number.class;
		}
	}
  
	/**
    	baut die Tabelle zur Ausgabe und zur einfachen Auswahl der Treffermenge einer Auswahl von Telefon Nummern zusammen
	 */
	public void zusammenbauen( )
	{
	    // Spalte der Telefontabelle: Telefonnummer
		telefonNrDES.setHeaderValue( "Geschaeftspartnernr." );
		telefonDT1Spaltenmodell.addColumn( telefonNrDES );
		telefonDT1Modell.addColumn( telefonNrDES.getIdentifier( ) );
	        
	    setColumnModel( telefonDT1Spaltenmodell );
	}
  
   /**
	  Methode um Standardwerte zu setzen
	*/
	public void radieren( )
	{
		telefonL = new ArrayList< Telefon >( );
		telefonDT1Modell.setRowCount( 0 );
		setModel( telefonDT1Modell );
	}
  
}


