/**
 * @author ValentinaTikko
 */
package data.objekte;

/**
 * Beschreibt eine Aufgabe
 */
public class Aufgabe extends AObject {

	// Konstante für Nutzung an der Schnittstelle zu der
	// MySQL-Datenbank (s. MySqlDataManager)
	public static final String TEXT = "text";

	private String text;
	private Thema thema;

	public Aufgabe(String text) {
		this(-1, text);
	}

	public Aufgabe(int id, String text) {
		super(id);
		this.text = text;
	}

	public Aufgabe() {
		super();
	}

	@Override
	public String[] getObjectData() {
		String[] data = new String[4];
		data[0] = "" + getId();
		data[1] = "" + (thema != null ? thema.getId() : -1);
		data[2] = text;
		return data;
	}

	public Thema getThema() {
		return thema;
	}

	public void setThema(Thema thema) {
		this.thema = thema;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		String str = "	" + getId() + ". " + text.substring(0, text.length() > 30 ? 30 : text.length()); 
		return str;
	}

}
