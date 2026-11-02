package sandbox;

import java.io.FileWriter;
import java.io.IOException;

public class FileIO {
	
	/**
	 * Schreibt auf die einfachste Weise in einen File.
	 * 
	 * @param fileName Pfad der Datei
	 * @param data     Daten, die gespeichert werden
	 * @return
	 */
	public static String writeIntoFile(String fileName, String data) {

		try (FileWriter fileWriter = new FileWriter(fileName, true)) {

			fileWriter.write("\n" + data);

		} catch (IOException e) {
			return e.getLocalizedMessage();
		}
		return null;
	}

}
