package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class BddRequete {
	
	public void user (String nom){

		try {

	    Statement state = BoulderDashBDDConnector.getInstance().createStatement();


	    ResultSet result = state.executeQuery("SELECT * FROM players");
	    
	    //On récupère les MetaData
	    ResultSetMetaData resultMeta = result.getMetaData();
	    
	    int ID = 0;
	    String nomBDD = " ";
	    int nbrcolumn = 0;
	    
	    
	    result.last();
	    nbrcolumn = result.getRow();
	
	    // next() récupere la ligne
	    result.beforeFirst();
		    do{
		    	result.next();
		    	ID = result.getInt(1);
		    	nomBDD =result.getString(2);
		    }while(!(nom.equals(nomBDD)) && (ID != nbrcolumn));

		   //String sql = "{call insert_player("+nom+")}";
		    
			if(!nom.equals(nomBDD)){
				System.out.println("ERROR");
				Statement state2 = BoulderDashBDDConnector.getInstance().createStatement();

			    state2.executeUpdate("INSERT INTO players (player_name) VALUES ('"+nom+"') ");
				
			}
			else{
				System.out.println("Trouvé");
			}
	       
		  } catch (SQLException e) {
		    e.printStackTrace();
		  }
	}
	
	public char[][] selectTable(){
		char[][]chars = new char[20][35];
		try{
				
				Statement st; // L'objet Statement permet d'exécuter des instructions SQL (Il interroge la base de donnée et retourne les résultats)
				ResultSet rst; // L'objet ResultSet stocke les résultats de Statement (soit les données de la BDD)
				
				st = BoulderDashBDDConnector.getInstance().createStatement();
				rst = st.executeQuery("SELECT (map_code) From maps"); // Execution 
				String test;
				char finale = ' ';
				//char[][]chars = new char[3][4];
				//char[][]chars = new char[20][35];
				int i = 0;
				int j = 0;
				int s = 0;
				//test = "TEST;TEST;TEST|";
					rst.next();
					test=(rst.getString("map_code"));
				
					while(finale != '|'){
						
						while(finale != ';' && finale != '|'){
							finale = test.charAt(s);
							s++;
							if(finale != ';' && finale != '|'){
								//chars[j]=finale;
								chars[i][j]=finale;
								//System.out.print(chars[j]);
								System.out.print(chars[i][j]);
								j++;
							}
						}
						
						System.out.println(" ");
						
						if(finale == ';'){
							j=0;
							i++;
							finale = test.charAt(s);
							s++;
							chars[i][j]=finale;
							System.out.print(chars[i][j]);
							
						}
					}
				
			}catch (Exception ex){
				ex.printStackTrace();
			}
		return chars;
		
	}
}