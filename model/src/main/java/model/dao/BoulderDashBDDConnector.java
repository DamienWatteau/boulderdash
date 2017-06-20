package model.dao;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class BoulderDashBDDConnector {

<<<<<<< HEAD
	/** The login. */
	private static String user = "root";

	/** The password. */
	private static String password = "";

	/** The url. */
=======
>>>>>>> 119c1e2e1a7a27bff74acf435a5568fd0a0c32eb
	private static String url = "jdbc:mysql://localhost/boulderdash";
	private static String user = "root";
	private static String pass = "";
	private static Connection connect;

	public static Connection getInstance() {
		if (connect == null) {
			try {
				connect = (Connection) DriverManager.getConnection(url, user, pass);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return connect;
	}
}

// L'instanciation ne se fait qu'une seule fois, notre connexion à la BDD est
// unique
