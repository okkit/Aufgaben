/**
 * @author ValentinaTikko
 */
package data;

import java.util.List;

/**
 * Mutterklasse aller Objekte in diesem Proekt
 */
public abstract class AObject {

	private int id;

	/**
	 * Jede Tochterklasse muss die Daten, die<br>
	 * gespeichert werden, selbst als String "verpacken"
	 * 
	 * @return daten
	 */
	protected abstract String getObjectData();

	/**
	 * Speichert ein Objekt
	 * 
	 * @return Fehlermeldung, wenn das Speichern <br>
	 *         nicht gelingt, sonst null
	 */
	protected String save() {

		return null;
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
