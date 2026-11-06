package data.dataHandling;

import java.util.ArrayList;

import data.objekte.Aufgabe;
import data.objekte.Thema;

/**
 * Definiert die Schnittstelle zu der permanenten Datenspeicherung
 * 
 */
public interface DataManager {

	/**
	 * Insert/Update Object into persistent data store
	 * 
	 * @param aufgabe Object to be saved
	 * @return Message of the SQLException
	 */
	public String save(Aufgabe aufgabe);
	
	public ArrayList<Thema> leseAlleThemen(boolean mitAufgaben);

	/**
	 * Fetsch Aufgabe-Date from the persistent data store
	 * 
	 * @return The List of loaded objects, the List can be empty but not null!<br>
	 *         null - SQLException occured
	 */
	public ArrayList<Aufgabe> leseAlleAufgaben();

	/**
	 * 
	 * @param aufgabe
	 * @return message of the SQLException 
	 */
	public String delete(Aufgabe aufgabe);

}
