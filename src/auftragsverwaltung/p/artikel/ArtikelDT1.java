package auftragsverwaltung.p.artikel;

import java.util.*;
import javax.swing.*;
import javax.swing.table.*;

import auftragsverwaltung.c.*;
import auftragsverwaltung.c.artikel.Artikel;

/**
 * Auftragsverwaltung:<BR> Klasse der Tabellen zur Ausgabe des Ergebnisses der Suche nach Artikeln<BR>
 * @author Jonas & Sven
 * @version  0.1
 */
public class ArtikelDT1 extends JTable
{
	
	/** Spalte der Treffertabelle: Artikelnr */
	private TableColumn artikelNrDES = new TableColumn( );
  
	/** Spalte der Treffertabelle: Bezeichnung */
	private TableColumn bezeichnungDES = new TableColumn( );
  
	/** Spalte der Treffertabelle: Einheit */
	private TableColumn einheitDES = new TableColumn( );
  
	/** Spalte der Treffertabelle: Preis pro Einheit */
	private TableColumn preisProEinheitDES = new TableColumn( );
  
	/** Spalte der Treffertabelle: Herstellungskosten pro Einheit */
	private TableColumn herstellungskostenProEinheitDES = new TableColumn( );
  
	/** Spalte der Treffertabelle: Einkaufspreis pro Einheit */
	private TableColumn einkaufspreisProEinheitDES = new TableColumn( );
  
	/** Verweis auf das Fenster zum Auswählen eines Artikels, innerhalb dessen diese Tabelle angezeigt wurde */
	private ArtikelAuswDAF artikelAuswDAF;
  
	/** Tabellenmodell */
	private DefaultTableModel artikelDT1Modell;
  
	/** Tabellenspaltenmodell */
	private DefaultTableColumnModel artikelDT1Spaltenmodell;

	/** Datenobjekt: Liste von Artikeln */
	private ArrayList< Artikel > artikelL;

  
	public ArtikelDT1( ArtikelAuswDAF artikelAuswDAF )
	{
	  	this.artikelAuswDAF = artikelAuswDAF;
	  	artikelDT1Spaltenmodell = new DefaultTableColumnModel( );
	  	artikelDT1Modell = new DefaultTableModel( );
	
	    zusammenbauen( );
	}
  
	/**
		Tabelle dient nur zur Ausgabe
	 */
	public boolean isCellEditable( int zeile, int spalte)
	{
		return false;
	}
  
	/**
  		in Spalte 0, 1 und 2: Ausgabe linksbündig;
  		in Spalte 3, 4 und 5: Ausgabe rechtsbündig
	 */
	public Class getColumnClass( int spalte )
	{
	  	switch ( spalte )
	  	{
	  		case 0: 	return String.class;
	  		case 1: 	return String.class;
	  		case 2: 	return String.class;
	  		case 3: 	return Number.class;
	  		case 4: 	return Number.class;
	  		case 5: 	return Number.class;
	  		default: 	return String.class;
	  	}
	}
  
	/**
    	baut die Tabelle zur Ausgabe und zur einfachen Auswahl der Treffermenge einer Auswahl von Artikeldaten zusammen
	 */
	public void zusammenbauen( )
	{
	    // Spalte der Treffertabelle: artikelNrDES
	    artikelNrDES.setHeaderValue( "Artikelnr." );
	    artikelDT1Spaltenmodell.addColumn( artikelNrDES );
	    artikelDT1Modell.addColumn( artikelNrDES.getIdentifier( ) );
	
	    // Spalte der Treffertabelle: bezeichnungDES
	    bezeichnungDES.setHeaderValue( "Bezeichnung" );
	    artikelDT1Spaltenmodell.addColumn( bezeichnungDES );
	    artikelDT1Modell.addColumn( bezeichnungDES.getIdentifier( ) );
	
	    // Spalte der Treffertabelle: einheitDES
	    einheitDES.setHeaderValue( "Einheit" );
	    artikelDT1Spaltenmodell.addColumn( einheitDES );
	    artikelDT1Modell.addColumn( einheitDES.getIdentifier( ) );
	
	    // Spalte der Treffertabelle: preisProEinheitDES
	    preisProEinheitDES.setHeaderValue( "Preis pro Einheit" );
	    artikelDT1Spaltenmodell.addColumn( preisProEinheitDES );
	    artikelDT1Modell.addColumn( preisProEinheitDES.getIdentifier( ) );
	    
	    // Spalte der Treffertabelle: herstellungskostenProEinheitDES
	    herstellungskostenProEinheitDES.setHeaderValue( "Herstellungskosten p.E." );
	    artikelDT1Spaltenmodell.addColumn( herstellungskostenProEinheitDES );
	    artikelDT1Modell.addColumn( herstellungskostenProEinheitDES.getIdentifier( ) );
	    
	    // Spalte der Treffertabelle: einkaufspreispreisProEinheitDES
	    einkaufspreisProEinheitDES.setHeaderValue( "Einkaufspreis p.E." );
	    artikelDT1Spaltenmodell.addColumn( einkaufspreisProEinheitDES );
	    artikelDT1Modell.addColumn( einkaufspreisProEinheitDES.getIdentifier( ) );
	    
	    setColumnModel( artikelDT1Spaltenmodell );
	}
  
	public void radieren( )
	{
	  	artikelL = new ArrayList< Artikel >( );
	  	
	  	artikelDT1Modell.setRowCount( 0 );
	  	setModel( artikelDT1Modell );
	}
  
/*
    public void ausgeben( ArrayList< Artikel > artikelL )
  	{

  	// noch auszufüllen
  
  	}


  	public Artikel entgegennehmen( )
	{
	  	int zeile = getSelectedRow( );
	  	
	  	if ( zeile >= 0 )
	  	  return artikelL.get( zeile );
	  	else
	  		return null;
	}
*/
}


