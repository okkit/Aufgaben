/**
 * @author ValentinaTikko
 */
package data.dataHandling;

import java.util.List;

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

	/**
	 * Lädt alle Themen aus der Datenbank.
	 * 
	 * @param mitAufgaben ob auch alle Aufgaben mitgeladen werden sollen
	 * @return Liste aller Themen. Die Liste ist leer, <br>
	 *         wenn kein Thema ind er DB gefunden wurde.<br>
	 *         null, wenn während des Ladens ein Fehler aufgetreten ist.
	 */
	public List<Thema> leseAlleThemen(boolean mitAufgaben);

	/**
	 * Lädt alle Aufgaben zum Thema aus der Datenbank und fügt<br>
	 * sie zu der Liste der Aufgaben des Thema-Objektes.
	 * 
	 * @param Thema-Objekt
	 */
	public String leseAlleAufgabenZumThema(Thema thema);

	/**
	 * 
	 * @param aufgabe
	 * @return message of the SQLException
	 */
	public String delete(Aufgabe aufgabe);

}
