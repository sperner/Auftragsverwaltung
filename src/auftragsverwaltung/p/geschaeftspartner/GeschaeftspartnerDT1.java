package auftragsverwaltung.p.geschaeftspartner;

import java.util.*;
import javax.swing.*;
import javax.swing.table.*;

import auftragsverwaltung.c.*;
import auftragsverwaltung.c.geschaeftspartner.Geschaeftspartner;

/**
 * Auftragsverwaltung:<BR> Klasse der DialogTabellen zur Ausgabe des Ergebnisses der Suche nach Geschaeftspartnern<BR>
 * @author Jonas & Sven
 * @version  0.1
 */
public class GeschaeftspartnerDT1 extends JTable
{
	
	/** Spalte der Treffertabelle: Name */
	private TableColumn nameDES = new TableColumn( );
  
	/** Spalte der Treffertabelle: Strasse, Hausnummer */
	private TableColumn strasseHausnrDES = new TableColumn( );
  
	/** Spalte der Treffertabelle: PLZ */
	private TableColumn plzDES = new TableColumn( );
  
	/** Spalte der Treffertabelle: Ort */
	private TableColumn ortDES = new TableColumn( );
  
	/** Spalte der Treffertabelle: Ist Kunde */
	private TableColumn istKundeDES = new TableColumn( );
  
	/** Spalte der Treffertabelle: ist Lieferant */
	private TableColumn istLieferantDES = new TableColumn( );
  
	/** Verweis auf das Fenster zum Auswählen eines Geschaeftspartners, innerhalb dessen diese Tabelle angezeigt wurde */
	private GeschaeftspartnerAuswDAF geschaeftspartnerAuswDAF;
  
	/** Tabellenmodell */
	private DefaultTableModel geschaeftspartnerDT1Modell;
	
	/** Tabellenspaltenmodell */
	private DefaultTableColumnModel geschaeftspartnerDT1Spaltenmodell;

	/** Datenobjekt: Liste von Geschaeftspartnern */
	private ArrayList< Geschaeftspartner > geschaeftspartnerL;

  
	/**
       erzeugt eine DialogTabelle der Anwendung:<BR> Geschaeftspartner Auswaehlen
	 */
	public GeschaeftspartnerDT1( GeschaeftspartnerAuswDAF geschaeftspartnerAuswDAF )
	{
	  	this.geschaeftspartnerAuswDAF = geschaeftspartnerAuswDAF;
	  	geschaeftspartnerDT1Spaltenmodell = new DefaultTableColumnModel( );
	  	geschaeftspartnerDT1Modell = new DefaultTableModel( );
	
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
	  		case 0: 	return String.class;
	  		case 1: 	return String.class;
	  		case 2: 	return Number.class;
	  		case 3: 	return String.class;
	  		case 4: 	return String.class;
	  		case 5: 	return String.class;
	  		default: 	return String.class;
	  	}
	}
  
	/**
    	baut die Tabelle zur Ausgabe und zur einfachen Auswahl der Treffermenge einer Auswahl von Geschaeftspartnerdaten zusammen
	 */
	public void zusammenbauen( )
	{
	    // Spalte der Treffertabelle: nameDES
		nameDES.setHeaderValue( "Name" );
		geschaeftspartnerDT1Spaltenmodell.addColumn( nameDES );
		geschaeftspartnerDT1Modell.addColumn( nameDES.getIdentifier( ) );
	
	    // Spalte der Treffertabelle: strasseHausnrDES
	    strasseHausnrDES.setHeaderValue( "Strasse, Hausnummer" );
	    geschaeftspartnerDT1Spaltenmodell.addColumn( strasseHausnrDES );
	    geschaeftspartnerDT1Modell.addColumn( strasseHausnrDES.getIdentifier( ) );
	
	    // Spalte der Treffertabelle: plzDES
	    plzDES.setHeaderValue( "PLZ" );
	    geschaeftspartnerDT1Spaltenmodell.addColumn( plzDES );
	    geschaeftspartnerDT1Modell.addColumn( plzDES.getIdentifier( ) );
	
	    // Spalte der Treffertabelle: ortDES
	    ortDES.setHeaderValue( "Ort" );
	    geschaeftspartnerDT1Spaltenmodell.addColumn( ortDES );
	    geschaeftspartnerDT1Modell.addColumn( ortDES.getIdentifier( ) );
	    
	    // Spalte der Treffertabelle: istKundeDES
	    istKundeDES.setHeaderValue( "istKunde" );
	    geschaeftspartnerDT1Spaltenmodell.addColumn( istKundeDES );
	    geschaeftspartnerDT1Modell.addColumn( istKundeDES.getIdentifier( ) );
	    
	    // Spalte der Treffertabelle: istLieferantDES
	    istLieferantDES.setHeaderValue( "istLieferant" );
	    geschaeftspartnerDT1Spaltenmodell.addColumn( istLieferantDES );
	    geschaeftspartnerDT1Modell.addColumn( istLieferantDES.getIdentifier( ) );
	    
	    setColumnModel( geschaeftspartnerDT1Spaltenmodell );
	}
  
   /**
	  Methode um Standardwerte zu setzen
	*/
	public void radieren( )
	{
	  	geschaeftspartnerL = new ArrayList< Geschaeftspartner >( );
	  	
	  	geschaeftspartnerDT1Modell.setRowCount( 0 );
	  	setModel( geschaeftspartnerDT1Modell );
	}
	
}


