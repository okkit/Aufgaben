/**
 * @author ValentinaTikko
 */
package data.manager;

import java.util.ArrayList;
import java.util.List;

import data.io.FileIO;
import data.objekte.AObject;
import data.objekte.AObjectFactory;
import data.objekte.Aufgabe;

/**
 * Managet Persistenz via text-File
 */
public class FileDataManager {

	/**
	 * Lädt alle gespeicherten Aufgaben.<br>
	 * Jede gelesene Zeile ist ein String - ein Eintrag, d.h. eine Aufgabe.<br>
	 * Die String-Zeilen werden gesplitet zu String[], aus dem<br>
	 * anschließend  eine Instanz der Klasse Aufgabe erzeugt un zur<br>
	 * Liste hinzugefügt wird.
	 * 
	 * @return Liste der Aufgabe-Instanzen
	 */
	public List<Aufgabe> ladeAlleAufgaben() {
		List<String> data = FileIO.readFromFile(AObject.KLASSENBUCH);

		if (data == null)
			return null;
		List<Aufgabe> aufgaben = new ArrayList<Aufgabe>();
		String[] werte;
		
		for (String str : data) { // str: 1;5;Thema 0;0 TextTextTextTextTextTextTextText
			if (str.isEmpty())
				continue;
			werte = str.split(FileIO.DELIMETER);
//			werte[0] ist 1
//			werte[1] ist 5
//			werte[2] ist Thema0
//			werte[3] ist TextTextTextTextTextTextTextText
//			Aufgabe a = new Aufgabe();
//			a.setId(werte[0]);
			aufgaben.add(AObjectFactory.aufgabeFromData(werte));
		}

		return aufgaben;
	}

}
