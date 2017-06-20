package main;
import java.sql.SQLException;

import javax.swing.text.View;

import controller.ControllerFacade;
import model.ModelFacade;
import model.dao.AbstractDAO;
import view.ViewFacade;

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
<<<<<<< HEAD
    	ViewFacade view = new ViewFacade();
    	view.Pseudo();
    	
    	
    	//view.Pseudo();
    	/*final ControllerFacade controller = new ControllerFacade(new ViewFacade(), new ModelFacade());

=======
    	AbstractDAO dao = new AbstractDAO();
    	dao.open();
    	/*        final ControllerFacade controller = new ControllerFacade(new ViewFacade(), new ModelFacade());
>>>>>>> 119c1e2e1a7a27bff74acf435a5568fd0a0c32eb
        try {
            controller.start();
        } catch (final SQLException exception) {
            exception.printStackTrace();
<<<<<<< HEAD
        }*/
    }
=======
        }
    }*/
>>>>>>> 119c1e2e1a7a27bff74acf435a5568fd0a0c32eb

    }
}
