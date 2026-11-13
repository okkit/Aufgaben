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

import config.KBProperties;
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

	private static final String URL = KBProperties.getURL();
	private static final String USER = KBProperties.getUser();
	private static final String PASSWORD = KBProperties.getPass();
	
	public Thema[] leseAlleThemen() {
		
		List<Thema> all = leseAlleThemen(true);
		Thema[] arr = new Thema[all.size()];
		int i = 0;
		for (Thema thema : all) {
			arr[i++] = thema;
		}
		return arr;
	}

	@Override
	public String leseAlleAufgabenZumThema(Thema thema) {

		try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);) {
			Statement stmt = connection.createStatement();
			ResultSet result = stmt.executeQuery(MySQLConstants.SELECT_BY_THEMA + thema.getId());

			while (result.next()) {
				Aufgabe aufgabe = new Aufgabe(result.getInt(Aufgabe.ID), result.getString(Aufgabe.TEXT));
				thema.addAufgabe(aufgabe);
			}

			return null;

		} catch (SQLException e) {
			return MySQLConstants.LOAD_NOT_POSSIBLE.formatted(thema);
		}

	}

	@Override
	public List<Thema> leseAlleThemen(boolean mitAufgaben) {

		ArrayList<Thema> themen = new ArrayList<Thema>();

		try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);) {

			Statement stmt = conn.createStatement();
			ResultSet result = stmt.executeQuery(MySQLConstants.SELECT_THEMEN);

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

		try (Connection verbindungZuDerMariaDB = DriverManager.getConnection(URL, USER, PASSWORD)) {

			Statement stmt = verbindungZuDerMariaDB.createStatement();
			stmt.execute(MySQLConstants.DELETE_AUFGABE_BY_THEMA.formatted(aufgabe.getId()));

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String save(Aufgabe aufgabe) {

		if (aufgabe == null) {
			return MySQLConstants.SAVING_NULL_OBJECT;
		}

		// Hat das Objekt noch keine PK? Wenn nein, insert.
		boolean insert = aufgabe.getId() < 0;

		// Connection zu der Datenbank
		try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);) {

			String sql = insert ? MySQLConstants.INSERT_AUFGABE : MySQLConstants.UPDATET_AUFGABE;
			
//			if (insert)
//				sql = MySQLConstants.INSERT_AUFGABE;
//			else
//				sql = MySQLConstants.UPDATET_AUFGABE;

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
