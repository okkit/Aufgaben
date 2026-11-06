/**
 * @author ValentinaTikko
 */
package data.objekte;

/**
 * Beschreibt eine Aufgabe
 */
public class Aufgabe extends AObject {

	private Integer nummer = -1;
	private String text;
	private Thema thema;
	
	public Aufgabe(Integer nummer, String text) {
		this(-1, nummer, text);
	}

	public Aufgabe(int id, Integer nummer, String text) {
		super(id);
		this.nummer = nummer;
		this.text = text;
	}

	public Aufgabe() {
		super();
	}

	@Override
	public  String[] getObjectData() {
		String[] data = new String[4];
		data[0] = "" + getId();
		data[1] = nummer.toString();
		data[2] = "" + (thema != null ? thema.getId() : -1);
		data[3] = text;
		return data;
	}

	public int getNummer() {
		return nummer;
	}

	public void setNummer(int nummer) {
		this.nummer = nummer;
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
		String str = getId() + ". Thema: \"" + thema + "\". A." + nummer + " ";
		str += text.substring(0, text.length() > 30 ? 30 : text.length()); // Nur den Beginn des Textes
		return str;
	}

}
