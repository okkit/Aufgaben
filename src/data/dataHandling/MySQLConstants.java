package data.dataHandling;

final class MySQLConstants {

	/**
	 * SQL-Statements
	 */
	static final String SELECT_THEMEN = "SELECT * FROM klassenbuch.thema";
	static final String INSERT_AUFGABE = "INSERT INTO klassenbuch.aufgabe (nummer, thema_id, text) VALUES (?, ?, ?);";
	static final String UPDATET_AUFGABE = "UPDATE klassenbuch.aufgabe SET nummer = ?, thema_id = ?, text = ? WHERE (id = ?);";
	static final String SELECT_BY_THEMA = "SELECT * FROM klassenbuch.aufgabe where thema_id = ";
	static final String DELETE_AUFGABE_BY_THEMA = "DELETE FROM klassenbuch.aufgabe WHERE (id = %d);";

	/**
	 * Messages
	 */
	static final String SAVING_NULL_OBJECT = "Kann kein null-Objekt speichern";
	static final String LOAD_NOT_POSSIBLE = "Lesen der Aufgaben zum Thema %s war nicht möglich";
}

