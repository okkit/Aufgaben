package data.dataHandling;

import java.util.ArrayList;

import data.objekte.Aufgabe;

/**
 * Definiert die Schnittstelle zu der permanenten Datenspeicherung
 * 
 */
public interface DataManager {

	/**
	 * Insert/Update Object into persistent data store
	 * 
	 * @param aufgabe Object to be saved
	 * @return Message in case of error, null - no error occured
	 */
	public String save(Aufgabe aufgabe);

	/**
	 * Fetsch Aufgabe-Date from the persistent data store
	 * @return The List of loaded objects
	 */
	public ArrayList<Aufgabe> leseAlleAufgaben();

}
