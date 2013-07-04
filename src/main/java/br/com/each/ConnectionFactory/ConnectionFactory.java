package br.com.each.ConnectionFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	private static String DRIVER = "org.postgresql.Driver";
	private static String URL = "jdbc:postgresql://localhost:5432/banco_ufc";
	private static String USER = "postgres";
	private static String PASSWD = "xxx";

	public static Connection getConnection() throws SQLException {
		try {
			Class.forName(DRIVER);
			return DriverManager.getConnection(URL, USER, PASSWD);
		} catch (ClassNotFoundException e) {
			throw new SQLException(e.getMessage());
		}
	}
}