package data.dataHandling;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import data.objekte.Aufgabe;
import data.objekte.Thema;

/**
 * @see data.dataHandling.DataManager
 */
public class MySqlDataManager implements DataManager {

	private static final String URL = "jdbc:mysql://localhost:3307/Klassenbuch";
	private static final String USER = "root";
	private static final String PASSWORD = "root";
	private static String SELECT_THEMEN = "SELECT * FROM klassenbuch.thema";
	private static String SELECT_AUFGABEN_ZUM_THEMA = "SELECT * FROM klassenbuch.aufgabe where thema_id = ";
	private static String INSERT_AUFGABE = "INSERT INTO klassenbuch.aufgabe (nummer, thema_id, text) VALUES (?, ?, ?);";
	private static String UPDATET_AUFGABE = "UPDATE klassenbuch.aufgabe SET nummer = ?, thema_id = ?, text = ? WHERE (id = ?);";

//	Irgendwo ist gemacht worden: Thema th = new Thema(...);
//	Das heißt, der Parameter th ist eine Instanz der Klasse Thema.
//	Diese Instanz kann ihre id geben: th.getId().
//	Diese id können wir im SELECT-Befehl verwenden:
//	"SELECT * from AUFGABE WHERE thema_id = " + th.getId();
	public ArrayList<Aufgabe> leseAlleAufgabenZumThema(Thema thema) {

		try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);){
			Statement stmt = connection.createStatement();		
			ResultSet result = stmt.executeQuery("SELECT * FROM klassenbuch.aufgabe where thema_id = " + thema.getId());

			ArrayList<Aufgabe> liste = new ArrayList<Aufgabe>();
			
			while(result.next()) {
				Aufgabe aufgabe = new Aufgabe(result.getInt(Aufgabe.ID), result.getString(Aufgabe.TEXT));
				thema.addAufgabe(aufgabe);
//				 Das kann ich mir sparen, weil bei th.add findet aufgabe.setThema(th) so wie so statt 
//				aufgabe.setThema(th);			
				liste.add(aufgabe);
			}
			
			return liste;

		} catch (SQLException e) {
			return null;
		}

	}

	@Override
	public ArrayList<Thema> leseAlleThemen(boolean mitAufgaben) {

		ArrayList<Thema> themen = new ArrayList<Thema>();

		try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);) {

			Statement stmt = conn.createStatement();
			ResultSet result = stmt.executeQuery(SELECT_THEMEN);

			if (result == null)
				return null;

			while (result.next()) {
				themen.add(new Thema(result.getInt(Thema.ID), result.getString(Thema.TITEL)));

			}

		} catch (SQLException e) {
			return null;
		}

		return themen;
	}

	@Override
	public ArrayList<Aufgabe> leseAlleAufgaben() {

		ArrayList<Aufgabe> aufgaben = new ArrayList<Aufgabe>();
		ArrayList<Thema> themen = leseAlleThemen(false);

		// Connection zu der Datenbank
		try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);) {

			Statement stmt;
			for (Thema thema : themen) {

				stmt = conn.createStatement();
//				"SELECT * FROM klassenbuch.aufgabe where thema_id = ";
				ResultSet result = stmt.executeQuery(SELECT_AUFGABEN_ZUM_THEMA + thema.getId());

				if (result == null)
					return null;

				while (result.next()) {
					Aufgabe a = new Aufgabe(result.getInt("id"), result.getString("text"));
					aufgaben.add(a);
					a.setThema(thema);
				}
			}

		} catch (SQLException e) {
			return null;
		}

		return aufgaben;
	}

//	@Override
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
