package br.com.each.ConnectionFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	private static String DRIVER = "com.mysql.jdbc.Driver";
	private static String URL = "jdbc:mysql://ec2-50-19-213-178.compute-1.amazonaws.com/banco_ufc";
	private static String USER = "makeyourbet";
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