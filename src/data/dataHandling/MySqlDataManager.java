/**
 * @author ValentinaTikko
 */
package data.dataHandling;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import data.objekte.Aufgabe;
import data.objekte.Thema;

/**
 * @see data.dataHandling.DataManager
 */
public class MySqlDataManager implements DataManager {

	private static final MySqlDataManager instance = new MySqlDataManager();

	public static MySqlDataManager getInstance() {
		return instance;
	}

	private MySqlDataManager() {
	};

	private static final String URL = "jdbc:mysql://localhost:3307/Klassenbuch";
	private static final String USER = "root";
	private static final String PASSWORD = "root";
	private static String SELECT_THEMEN = "SELECT * FROM klassenbuch.thema";
	private static String INSERT_AUFGABE = "INSERT INTO klassenbuch.aufgabe (nummer, thema_id, text) VALUES (?, ?, ?);";
	private static String UPDATET_AUFGABE = "UPDATE klassenbuch.aufgabe SET nummer = ?, thema_id = ?, text = ? WHERE (id = ?);";

	@Override
	public String leseAlleAufgabenZumThema(Thema thema) {

		try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);) {
			Statement stmt = connection.createStatement();
			ResultSet result = stmt.executeQuery("SELECT * FROM klassenbuch.aufgabe where thema_id = " + thema.getId());

			while (result.next()) {
				Aufgabe aufgabe = new Aufgabe(result.getInt(Aufgabe.ID), result.getString(Aufgabe.TEXT));
				thema.addAufgabe(aufgabe);
			}

			return null;

		} catch (SQLException e) {
			return "Lesen der Aufgaben zum Thema " + thema + "war nicht möglich";
		}

	}

	@Override
	public List<Thema> leseAlleThemen(boolean mitAufgaben) {

		ArrayList<Thema> themen = new ArrayList<Thema>();

		try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);) {

			Statement stmt = conn.createStatement();
			ResultSet result = stmt.executeQuery(SELECT_THEMEN);

			if (result == null)
				return null;

			Thema thema;
			while (result.next()) {
				thema = new Thema(result.getInt(Thema.ID), result.getString(Thema.TITEL));
				themen.add(thema);
				if (mitAufgaben) {
					leseAlleAufgabenZumThema(thema);
				}
			}

		} catch (SQLException e) {
			return null;
		}

		return themen;
	}

	@Override
	public String delete(Aufgabe aufgabe) {

		try (Connection verbindungZuDerMariaDB = DriverManager.getConnection("jdbc:mysql://localhost:3307/", "root",
				"root")) {

			Statement butler = verbindungZuDerMariaDB.createStatement();

			butler.execute("DELETE FROM klassenbuch.aufgabe WHERE (id = " + aufgabe.getId() + ");");

		} catch (SQLException e) {
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

			stmt.setInt(1, aufgabe.getThema().getId());
			stmt.setString(1, aufgabe.getText());
			if (!insert)
				stmt.setInt(2, aufgabe.getId());

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
