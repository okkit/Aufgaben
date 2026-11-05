package data.dataHandling;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import data.objekte.Aufgabe;

/**
 * @see data.dataHandling.DataManager
 */
public class MySqlDataManager implements DataManager {

	private static final String URL = "jdbc:mysql://localhost:3307/Klassenbuch";
	private static final String USER = "root";
	private static final String PASSWORD = "root";
	private static String INSERT_AUFGABE = "INSERT INTO klassenbuch.aufgabe (nummer, thema, text) "
			+ "VALUES (?, ?, ?);";
//	UPDATE `klassenbuch`.`aufgabe` SET nummer = ? `thema` = ?, `text` = ? WHERE (`id` = ?);
	private static String UPDATET_AUFGABE = "";

	@Override
	public void save(Aufgabe aufgabe) {

		if (aufgabe == null) {
			IO.println("Kann kein null-Objekt speichern");
			return;
		}
		
		if (aufgabe.getId() > 0)
			update(aufgabe); // TODO
		else
			insert(aufgabe);			
	}
	
	/**
	 * Führt den QSL-Insert-Befehl aus
	 * @param a
	 */
	private void insert(Aufgabe aufgabe) {
		
		// Connection zu der Datenbank
		try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);) {

			// Statement, mit dem wir den SQL-Befel absetzen		
			PreparedStatement stmt = conn.prepareStatement(INSERT_AUFGABE, Statement.RETURN_GENERATED_KEYS);

			stmt.setString(2, aufgabe.getThema());
			stmt.setInt(1, aufgabe.getNummer());
			stmt.setString(3, aufgabe.getText());
			
			stmt.execute();
			
			// Wir brauchen den Primyry Key, dass auto generated wurde
			ResultSet generated = stmt.getGeneratedKeys();
			

			
			int id = -1;
			if (generated.next()) {

				id = generated.getInt(1);
				aufgabe.setId(id);
			}
			IO.println("**** " + id);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public ArrayList<Aufgabe> leseAlleAufgaben() {
		// TODO Auto-generated method stub
		return null;
	}

}
