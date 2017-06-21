package main;

import java.io.IOException;

import model.dao.BddRequete;
import view.Menu;

/**
 * <h1>The Class Main.</h1>
 *
 * @author Damien Watteau
 * @version 1.0
 */
public abstract class Main {

    /**
     * The main method.
     *
     * @param args
     *            the arguments
     */
	/** Spawn vehicle position X. */
    private static final int startX = 5;

    /** Spawn vehicle position Y. */
    private static final int startY = 0;
    
    public static void main(final String[] args) throws IOException, InterruptedException  {
    	 
    	Menu menu = new Menu();
  	   	BddRequete requete = new BddRequete();
  	   	requete.user(menu.MenuPseudo());
  	   	menu.MenuLevel();
  	   
//  		JFrame fen = new JFrame();
//  	   
//  		BddRequete requete2 = new BddRequete();
//  		requete2.selectTable();	
//  		
  	  final IInsaneVehiclesModel model = new InsaneVehiclesModel("road.txt", startX, startY);
      final InsaneVehiclesView view = new InsaneVehiclesView(model.getRoad(), model.getMyVehicle());
      final IIinsaneVehiclesController controller = new InsaneVehiclesController(view, model);
      view.setOrderPerformer(controller.getOrderPeformer());

      controller.play();
  	   	
  	   	
  	   	
    }
}
