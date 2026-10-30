/**
 * @author ValentinaTikko
 */
package data.objekte;

import java.util.List;

import data.io.FileIO;

/**
 * Mutterklasse aller Objekte in diesem Proekt
 */
public abstract class AObject {

	private static final String KLASSENBUCH = "Klassenbuch.csv";
	private static final String SAVED_MSG = "Der Eintrag wurde gespeichert";;
	private int id;

	/**
	 * Jede Tochterklasse muss die Daten, die<br>
	 * gespeichert werden, selbst als String "verpacken"
	 * 
	 * @return daten
	 */
	protected abstract String[] getObjectData();

	/**
	 * Speichert ein Objekt
	 * 
	 * @return Fehlermeldung, wenn das Speichern <br>
	 *         nicht gelingt, sonst null
	 */
	public String save() {

		if (id < 1)
			id = FileIO.getLineCount(KLASSENBUCH) + 1;
		String err = FileIO.writeIntoFile(KLASSENBUCH, getObjectData());
		if (err == null)
			return SAVED_MSG;
		return err;
	}

	/**
	 * Lädt alle gespeicherten Objekte
	 * 
	 * @return Liste der Objekte
	 */
	protected List<AObject> loadAll() {
		// TODO
		return null;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
