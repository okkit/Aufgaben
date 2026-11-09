/**
 * @author ValentinaTikko
 */
package data.objekte;

import java.util.ArrayList;
import java.util.List;

/**
 * Beschreibt das Objekt Thema
 */
public class Thema extends AObject {

	// Konstante für Nutzung an der Schnittstelle zu der
	// MySQL-Datenbank (s. MySqlDataManager)
	public static final String TITEL = "titel";

	private String titel;
	private List<Aufgabe> aufgaben;

	/**
	 * Damit keine andere Klasse den Standartkonstruktor<br>
	 * verwendet, um anschließend zu versuchen die Setters<br>
	 * zu benutzen, die hier als private deklariert sind, <br>
	 * wirft der Konstruktor eine entsprechende Exception.
	 * 
	 * @param titel
	 * @throws PleaseNotUseException
	 */
	public Thema(String titel) throws PleaseNotUseException {
	}

	/**
	 * Ausschlißlich mit dem Konstruktor wird eine Instanz<br>
	 * der Klasse erzeugt.
	 * 
	 * @param id    deklariert in der Mutterklasse, hat man keine,<br>
	 *              setzt man als id -1
	 * @param titel
	 */
	public Thema(int id, String titel) {
		super(id);
		this.titel = titel;
	}

	/**
	 * Fügr das Objekt Aufgabe (Instanz der Klasse Aufgabe) zu der<br>
	 * Liste der Aufgaben hinzu.<br>
	 * Ist das Objekt bereits in der Liste, wird es zuerst aus der<br>
	 * Liste entfern und anschließen neu hinzugefügt.<br>
	 * Die Instanzvariable thema des Objektes bekommt als<br>
	 * Wert die aktuelle Instanz der Klasse Thema, also this.
	 * 
	 * @param aufgabe
	 */
	public void addAufgabe(Aufgabe aufgabe) {

		if (aufgaben == null)
			aufgaben = new ArrayList<Aufgabe>();

		if (aufgaben.contains(aufgabe)) {
			aufgaben.remove(aufgabe);
			aufgaben.add(aufgabe);
			aufgabe.setThema(this);
		}
	}

	public List<Aufgabe> getAufgaben() {
		return aufgaben;
	}

	@SuppressWarnings("unused")
	private void setAufgaben(List<Aufgabe> aufgaben) {
		this.aufgaben = aufgaben;
	}

	public String getTitel() {
		return titel;
	}

	@SuppressWarnings("unused")
	private void setTitel(String titel) {
		this.titel = titel;
	}

	@Override
	public String[] getObjectData() {
		return null;
	}

}
