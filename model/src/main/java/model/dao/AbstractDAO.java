package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.jdbc.ResultSetMetaData;

public class AbstractDAO {

	private Connection connection;
	private Statement statement;

	// JDBC driver name and database URL
	private String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private String url = "jdbc:mysql://localhost/boulderdash";
	// Database credentials
	private String user = "root";
	private String passwd = "";

	public AbstractDAO() {
		this.connection = null;
		this.statement = null;
	}

	public void open() {

		try {
			// Register JDBC driver
			Class.forName(JDBC_DRIVER);
			// Open a connection
			System.out.println("Connecting to a selected database... ");
			// connection = DriverManager.getConnection(URL, USER, PASS);
			connection = BoulderDashBDDConnector.getInstance();
			System.out.println("Success!");

			// cr�ation d'un objet statement
			// Statement permet d'exécuter des instructions SQL
			// il interroge la bdd et retourne les resultats
			Statement state = connection.createStatement();
			ResultSet result = state.executeQuery("SELECT " + "player_score,player_time,player_name,map_name "
					+ " FROM play NATURAL JOIN players, maps");

			// ResultSetMetaData resultMeta = result.getMetaData();
			ResultSetMetaData resultMeta = (ResultSetMetaData) result.getMetaData();
			System.out.println("\n");

			// On affiche le nom des colonnes
			for (int i = 1; i <= resultMeta.getColumnCount(); i++) // resultMeta récupére les métadonnées de la  requéte
			{
				System.out.print("\t" + resultMeta.getColumnName(i).toUpperCase() + "\t");
			}

			System.out.println("\n");

			while (result.next()) {
				for (int i = 1; i <= resultMeta.getColumnCount(); i++) {
					System.out.print("\t" + result.getObject(i).toString() + "\t");
				}

				System.out.println("\n");

			}
			result.close();
			state.close();
			connection.close();
		} catch (Exception e) {
			// Handle errors for JDBC
			e.printStackTrace();
		}
	}
}