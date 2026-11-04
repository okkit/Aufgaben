package data.dataHandling;

import java.util.ArrayList;

import data.objekte.Aufgabe;

/**
 * Definiert die Schnittstelle zu der permanenten Datenspeicherung
 * 
 */
public interface DataManager {

	public void save(Aufgabe aufgabe);
	
	public ArrayList<Aufgabe> leseAlleAufgaben();


}
