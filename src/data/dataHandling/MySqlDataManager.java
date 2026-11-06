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
	private static String SELECT_AUFGABEN = "SELECT * FROM klassenbuch.aufgabe";
	private static String INSERT_AUFGABE = "INSERT INTO klassenbuch.aufgabe (nummer, thema, text) VALUES (?, ?, ?);";
	private static String UPDATET_AUFGABE = "UPDATE klassenbuch.aufgabe SET nummer = ?, thema = ?, text = ? WHERE (id = ?);";

	@Override
	public ArrayList<Aufgabe> leseAlleAufgaben() {
		
		ArrayList<Aufgabe> aufgaben = new ArrayList<Aufgabe>();
		
		// Connection zu der Datenbank
				try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);) {
					
					Statement stmt = conn.createStatement();
					ResultSet result = stmt.executeQuery(SELECT_AUFGABEN);
					
					if (result == null)
						return null;
					
					while (result.next()) {
						aufgaben.add(new Aufgabe(result.getInt(1), 
								result.getInt(2), 
								result.getString(3),
								result.getString(4)));
					}
					
				}catch (SQLException e) {
					return null;
				}
		
		return aufgaben;
	}

	
	@Override
	public String delete(Aufgabe aufgabe){

		try (Connection verbindungZuDerMariaDB = DriverManager.getConnection("jdbc:mysql://localhost:3307/", "root", "root")){

		Statement butler = verbindungZuDerMariaDB.createStatement();

		butler.execute("DELETE FROM klassenbuch.aufgabe WHERE (id = " + aufgabe.getId() + ");");
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String save(Aufgabe aufgabe) {

		if (aufgabe == null) {
			return "Kann kein null-Objekt speichern";
		}

		// Hat das Objekt noch keine PK? Wenn nein, insert.
		boolean insert = aufgabe.getId() < 0;

		// Connection zu der Datenbank
		try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);) {

			String sql = insert ? INSERT_AUFGABE : UPDATET_AUFGABE;

			// Statement, mit dem wir den SQL-Befel absetzen
			PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			stmt.setString(2, aufgabe.getThema());
			stmt.setInt(1, aufgabe.getNummer());
			stmt.setString(3, aufgabe.getText());
			if (!insert)
				stmt.setInt(4, aufgabe.getId());

			stmt.execute();

			// Wir brauchen den Primyry Key, dass auto generated wurde
			ResultSet generated = stmt.getGeneratedKeys();

			if (generated != null) {
				int id = -1;
				if (generated.next()) {

					id = generated.getInt(1);
					aufgabe.setId(id);
				}
			}

		} catch (SQLException e) {
			return e.getMessage();
		}
		return null;
	}
}
