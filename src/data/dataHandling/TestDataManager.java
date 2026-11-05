package data.dataHandling;

import java.util.List;
import java.util.ListIterator;

import data.objekte.Aufgabe;

public class TestDataManager {

	public static void main(String[] args) {

		if (true)
			testSQLManager();
		else
			testCSVManager();

	}

	private static void testSQLManager() {

		DataManager mng = new MySqlDataManager();// SCVDataManager.getInstance(); // nur eine Instanz möglich

		Aufgabe a = new Aufgabe();
		a.setNummer(777);
		a.setThema("Thema 777");
		a.setText("Text 777");
		IO.println("Before Save " + a.getId());

		mng.save(a);

		IO.println(a);

		a.setText("geänderter Text");
		mng.save(a);
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
