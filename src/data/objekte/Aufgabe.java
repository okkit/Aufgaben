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
	public static final String TITLE = "title";

	private String titel;
	private String text;
	private Thema thema;

	public Aufgabe(String titel, String text) {
		this(-1, titel, text);
	}

	public Aufgabe(int id, String titel, String text) {
		super(id);
		this.titel = titel;
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

	public String getTitel() {
		return titel;
	}

	public void setTitel(String titel) {
		this.titel = titel;
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
		return titel;
	}

}
