/**
 * @author ValentinaTikko
 */
package data.dataHandling;

import java.util.ArrayList;

import data.io.FileIO;
import data.objekte.AObject;
import data.objekte.AObjectFactory;
import data.objekte.Aufgabe;
import data.objekte.Thema;

/**
 * Managet Persistenz via text-File
 */
public class CSVDataManager implements DataManager {

	private static final CSVDataManager instance = new CSVDataManager();

	public static CSVDataManager getInstance() {
		return instance;
	}

	private CSVDataManager() {

	}

	/**
	 * Lädt alle gespeicherten Aufgaben.<br>
	 * Jede gelesene Zeile ist ein String - ein Eintrag, d.h. eine Aufgabe.<br>
	 * Die String-Zeilen werden gesplitet zu String[], aus dem<br>
	 * anschließend eine Instanz der Klasse Aufgabe erzeugt un zur<br>
	 * Liste hinzugefügt wird.
	 * 
	 * @return Liste der Aufgabe-Instanzen
	 */
	@Override
	public ArrayList<Aufgabe> leseAlleAufgaben() {
		ArrayList<String> data = FileIO.readFromFile(AObject.KLASSENBUCH);

		if (data == null)
			return null;
		ArrayList<Aufgabe> aufgaben = new ArrayList<Aufgabe>();
		String[] werte;

		for (String str : data) {
			if (str.isEmpty())
				continue;
			werte = str.split(FileIO.DELIMETER);
			// TODO Aufgabe gehört zu einem Thema
//			aufgaben.add(AObjectFactory.aufgabeFromData(werte));
		}

		return aufgaben;
	}

	@Override
	public String save(Aufgabe aufgabe) {
//		if (aufgabe.getId() < 1)
		aufgabe.setId(FileIO.getLineCount(AObject.KLASSENBUCH) + 1);
		String err = FileIO.writeIntoFile(AObject.KLASSENBUCH, aufgabe.getObjectData());
		return err;
	}

	@Override
	public String delete(Aufgabe aufgabe) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Thema> leseAlleThemen(boolean mitAufgaben) {
		// TODO Auto-generated method stub
		return null;
	}

}
