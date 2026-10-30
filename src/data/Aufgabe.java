/**
 * @author ValentinaTikko
 */
package data;

/**
 * Beschreibt eine Aufgabe
 */
public class Aufgabe extends AObject {
	
	private int nummer;
	private String thema;
	private String text;

	@Override
	protected String getObjectData() {
		// TODO Auto-generated method stub
		return null;
	}

	public int getNummer() {
		return nummer;
	}

	public void setNummer(int nummer) {
		this.nummer = nummer;
	}

	public String getThema() {
		return thema;
	}

	public void setThema(String thema) {
		this.thema = thema;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	

}
