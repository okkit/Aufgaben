package data.dataHandling;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import data.objekte.Aufgabe;

public class TestDataManager {

	public static void main(String[] args) {

		testSelectAllAufgaben();

	}

	private static void testSelectAllAufgaben() {
		DataManager mng = new MySqlDataManager();

		ArrayList<Aufgabe> aufgaben = mng.leseAlleAufgaben();

		for (Aufgabe a : aufgaben) {
			IO.println(a);
		}
		
	}

	private static void testSQLManager() {

		DataManager mng = new MySqlDataManager();

		ArrayList<Aufgabe> aufgaben = mng.leseAlleAufgaben();

		for (Aufgabe a : aufgaben) {
			mng.delete(a);
		}

		

		for (int i = 10; i < 17; i++) {
			mng.save(new Aufgabe(i, "Text text " + i));
		}
		IO.println(" ---------------- aufgaben wurden generiert-----------------");
		aufgaben = mng.leseAlleAufgaben();
		for (Aufgabe a : aufgaben)
			IO.println(a);

		for (Aufgabe a : aufgaben) {
			a.setText(a.getText() + " - geändert ");
			mng.save(a);
		}

		aufgaben = mng.leseAlleAufgaben();
		IO.println(" ---------------- aufgaben wurden geändert-----------------");
		for (Aufgabe a : aufgaben)
			IO.println(a);

	}

	private static void testCSVManager() {

		DataManager mng = CSVDataManager.getInstance(); // nur eine Instanz möglich

		List<?> data = mng.leseAlleAufgaben();

		ListIterator<?> iterator = data.listIterator();

		while (iterator.hasNext()) {

			Object obj = iterator.next();
//			

			Aufgabe element = null;
			if (obj instanceof Aufgabe)
				element = (Aufgabe) obj; // Class cast

//			IO.println(element.getClass().getSimpleName());

			if (element != null)
				IO.println(element.getText());
		}

	}

}
