package sandbox;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Okkit {

	public static void main(String[] args) throws SQLException {
		
		Connection verbindungZuDerMariaDB = DriverManager.getConnection("jdbc:mysql://localhost:3307/", "root", "root");
		
		Statement butler = verbindungZuDerMariaDB.createStatement();
		
		
		butler.execute("create database okkitDataBase;");
		
		
		String[] namen = {"aaa", "bbb", "ccc"};
		
		PreparedStatement ps = verbindungZuDerMariaDB.prepareStatement("insert into table Gast (name) values ('?');");
		
		for (int i = 0; i < namen.length; i++) {
			
			butler.execute("insert into table Gast (name) values (" + namen[i] + ");");
		}
		
		butler.execute("insert into table Gast (name) values (Bob);");
		butler.execute("insert into table Gast (name) values (Tom);");
		butler.execute("insert into table Gast (name) values (Ana);");
		
	

	}

}
