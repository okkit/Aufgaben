/**
 * @author ValentinaTikko
 */
package data.objekte;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * Konstruiert Instanzen der Objekt-Klassen
 */
public abstract class AObjectFactory {
	
	public static HashMap<String, Object> toHashMap(AObject a) {

		Field[] fields = a.getClass().getDeclaredFields();
		HashMap<String, Object> map = new HashMap<String, Object>();
		for (Field field : fields) {
			field.setAccessible(true);
			try {

				map.put(field.getName(), field.get(a));
			} catch (IllegalArgumentException | IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		return map;
	}

	public static Aufgabe createFromMap(Map<String, Object> map) {

		Aufgabe a = new Aufgabe();
		Field[] fields = a.getClass().getDeclaredFields();

		for (Field field : fields) {
			field.setAccessible(true);
			try {
				field.set(a, map.get(field.getName()));

			} catch (IllegalArgumentException | IllegalAccessException e) {

				e.printStackTrace();
			}
		}
		return a;
	}

	/**
	 * Konstruiert eine Instanz der Klasse Aufgabe<br>
	 * mit den Daten aus einem String-Array.<br>
	 * De facto das umgeherte Prozedere zum Verpacken<br>
	 * der Daten in der Klasse Aufgabe: protected String[] getObjectData() {
	 * String[] data = new String[4]; data[0] = "" + getId(); data[1] =
	 * nummer.toString(); data[2] = thema; data[3] = text; return data; }
	 * 
	 * @param werte
	 * @return eine Instanz der Klasse Aufgabe
	 */
	public static Aufgabe aufgabeFromData(String[] werte) {

		Aufgabe a = new Aufgabe();
		if (werte[0] != null)
			a.setId(Integer.valueOf(werte[0]));
		a.setNummer(Integer.valueOf(werte[1]));
		a.setThema(werte[2]);
		a.setText(werte[3]);

		return a;
	}

}
