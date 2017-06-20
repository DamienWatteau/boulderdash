package main;

import java.awt.Menu;

/**
 * <h1>The Class Main.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public abstract class Main {

    /**
     * The main method.
     *
     * @param args
     *            the arguments
     */
    public static void main(final String[] args) {
    	 Menu menu = new Menu();
  	   BddRequete requete = new BddRequete();
  	   requete.user(menu.MenuPseudo());
  	   menu.MenuLevel();
  	   
  		JFrame fen = new JFrame();
  	   
  		BddRequete requete2 = new BddRequete();
  		requete2.selectTable();	
  		

    }
}
