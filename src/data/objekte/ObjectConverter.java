package data.objekte;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * Klasse für Experimente mit Map und Reflection
 */
public class ObjectConverter {

	public static void main(String[] args) {

		Aufgabe a = new Aufgabe();
		a.setNummer(66);
		a.setThema("HashMap");
		a.setText("HashMap ist ein Kontaier für Daten");

		Map<String, Object> map = aufgabe2Map(a);

//		IO.println(map);
	}

	public static Map<String, Object> aufgabe2Map(Aufgabe a) {

		Map<String, Object> map = new HashMap<String, Object>();
		
		Field[] felder = a.getClass().getDeclaredFields();
		
		for (Field field : felder) {
			
			try {				
				field.setAccessible(true);
				map.put(field.getName(), field.get(a));
				
			} catch (IllegalArgumentException | IllegalAccessException e) {
				e.printStackTrace();
			}
			
		}
		IO.println(map);
				
		String nummer = "Nummer";

//		// Key Value
//		map.put(nummer, a.getNummer());
//		map.put("Thema", a.getThema());
//		map.put("Text", a.getText());
//
////		Aufgabe 11
////		Schreiben Sie den SQL-Befehl (als String) zum Speichern 
////		eines Datensatzes in die DB-Tabelle (hier) Tabelle Aufgabe.
////		Verwenden Sie die Values aus der map!
////		INSERT INTO `bbq`.`fach` (`id`, `bezeichnung`) VALUES ('10', 'FISI');
//
//		String sql = "insert into Aufgabe (Nummer, Thema, Text)";
//		sql += " Values (" + map.get("Nummer") + ",";
//		sql += map.get("Thema") + ",";
//		sql += map.get("Text") + ");";
//		
//		IO.println(sql);
//		
//		String sqlStatement = "insert into Aufgabe (Nummer, Thema, Text) Values (%s, \"%s\", \"%s\");";
//		sqlStatement = sqlStatement.formatted(map.get(nummer), map.get("Thema"), map.get("Text"));
//		
//		IO.println(sqlStatement);

		return map;
	}

}
