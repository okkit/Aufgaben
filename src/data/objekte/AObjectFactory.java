/**
 * @author ValentinaTikko
 */
package data.objekte;

/**
 * Konstruiert Instanzen der Objekt-Klassen
 */
public abstract class AObjectFactory {
	
	/**
	 * Konstruiert eine Instanz der Klasse Aufgabe<br>
	 * mit den Daten aus einem String-Array.<br>
	 * De facto das umgeherte Prozedere zum Verpacken<br>
	 * der Daten in der Klasse Aufgabe:
	 * 	protected String[] getObjectData() {
		String[] data = new String[4];
		data[0] = "" + getId();
		data[1] = nummer.toString();
		data[2] = thema;
		data[3] = text;
		return data;
	}
	 * @param werte 
	 * @return eine Instanz der Klasse Aufgabe
	 */
	public static Aufgabe aufgabeFromData(String[] werte) {

		Aufgabe a = new Aufgabe();
		a.setId(Integer.valueOf(werte[0]));
		a.setNummer(Integer.valueOf(werte[1]));
		a.setThema(werte[2]);
		a.setText(werte[3]);
		
		return a;
	}

}
