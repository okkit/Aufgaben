/**
 * @author ValentinaTikko
 */
package gui.console;

import data.objekte.AObjectFactory;
import data.objekte.Aufgabe;

/**
 * Startet das Programm
 */
public class Main {

	public static final String HALLO = "Beginn eines neuen Eintrags";
	private static final Integer NUMMER = 1;
	private static final Integer THEMA = 2;
	private static final Integer TEXT = 3;
	
	private static final String NUMMER_LABEL = "Nummer der Aufgabe: \n";
	private static final String THEMA_LABEL = "Thema: \n";
	private static final String TEXT_LABEL = "Text: \n";

	public Main() {
		start();
	}

	private void start() {
		IO.println(HALLO);
	
		String[] eingabe = new String[4];
		
		eingabe[NUMMER] = IO.readln(NUMMER_LABEL);
		eingabe[THEMA] = IO.readln(THEMA_LABEL);
		eingabe[TEXT] = IO.readln(TEXT_LABEL);
		
		Aufgabe a = AObjectFactory.aufgabeFromData(eingabe);
		IO.print(a.save());

	}

	public static void main(String[] args) {

		new Main();
	}

}
