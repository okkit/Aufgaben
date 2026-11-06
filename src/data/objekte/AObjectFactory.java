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

}
