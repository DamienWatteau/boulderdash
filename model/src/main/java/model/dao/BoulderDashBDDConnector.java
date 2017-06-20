package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BoulderDashBDDConnector {

	  //Objet Connection
	  private static Connection connect;
	   
	  //Constructeur privé
	  private BoulderDashBDDConnector(){
	    
	  }
	   
	  //Méthode qui va nous retourner notre instance et la créer si elle n'existe pas
	  public static Connection getInstance(){
		  if(connect == null){
			  try {
				  String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
					
				//Register JDBC driver
	            try {
					Class.forName(JDBC_DRIVER);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
	            
				//URL de connexion
				  String url = "jdbc:mysql://localhost/boulderdash?autoReconnect=true&useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
				  //Nom du user
				  String user = "root";
				  //Mot de passe de l'utilisateur
				  String passwd = "";
			      connect = DriverManager.getConnection(url, user, passwd);
			    } catch (SQLException e) {
			      e.printStackTrace();
			    }
			  //new BddConnector();
		    System.out.println("INSTANCIATION DE LA CONNEXION SQL ! ");
		  }
		  else{
		    System.out.println("CONNEXION SQL EXISTANTE ! ");
		  }
		  return connect;   
		}
}