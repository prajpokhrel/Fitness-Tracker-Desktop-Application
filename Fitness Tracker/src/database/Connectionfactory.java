package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connectionfactory {

	private static final String URI = "jdbc:mysql://127.0.0.1:3306/AdiDatabase";
	private static final String USER = "root";
	private static final String PWD = "";

	private static Connection conn;

	private Connectionfactory() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}
	}

	public static Connection getConnection() {
		if (conn == null) {
			try {
				conn = DriverManager.getConnection(URI, USER, PWD);
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}

		return conn;
	}

	public static void closeConnection() {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	}
}