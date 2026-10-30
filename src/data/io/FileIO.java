package data.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * Die Klasse stellt einfache Mitteln (Methoden)<br>
 * zu Verfügung, um Daten in einen File zu schreiben/lesen
 */
public class FileIO {

	private static final String NL = "\n";
	private static final String SEPARATOR = ";";
	private static final String FOLDER = "./data/";
	private static final String NOFOLDER = "Das Verzeichnis zu erstellen war nicht möglich";

	/**
	 * Schreibt auf die einfachste Weise in einen File.
	 * 
	 * @param fileName Pfad der Datei
	 * @param strings  Daten, die gespeichert werden
	 * @return Fehlermeldung, wenn das Speichern nicht gelingt, <br>
	 *         sonst null
	 */
	public static String writeIntoFile(String fileName, String[] data) {
		
		if (!checkFolder())
			return NOFOLDER;

		try (FileWriter fileWriter = new FileWriter(toPath(fileName), true)) {

			String str = "";
			int i = 0;
			for (i = 0; i < data.length - 1; i++) {
				str += (data[i] + SEPARATOR);
			}
			str += data[i];
			fileWriter.write(NL + str);

		} catch (IOException e) {
			return e.getLocalizedMessage();
		}
		return null;
	}

	private static boolean checkFolder() {
		File f = new File(FOLDER);
		if (!f.exists()) {
			Path path = Paths.get(FOLDER);
			try {
				Files.createDirectory(path);
			} catch (IOException e) {
				return false;
			}
		}
		return true;
	}

	private static String toPath(String fileName) {
		return fileName = FOLDER + fileName;
	}

	/**
	 * Zählt die Anzahl der Zeilen in einem File
	 * 
	 * @param fileName
	 * @return Anzahl der Zeilen, 0 auch, wenn Fehler beim lesen aus dem File
	 */
	public static int getLineCount(String fileName) {

		int count = 0;
		try (Scanner scanner = new Scanner(new File(toPath(fileName)))) {
			while (scanner.hasNextLine()) {
				scanner.next();
				count++;
			}
		} catch (FileNotFoundException e) {
		}
		return count;
	}
}
