package controller;

/**
 * <h1>The Class ControllerFacade provides a facade of the Controller component.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
import java.io.IOException;

/**
 * <h1>The Class InsaneVehiclesController.</h1>
 *
 * @author Jade
 * @version 0.1
 * @see IOrderPerformer
 */
public class BoulderdashController implements IBoulderdashController, IOrderPerformer {

    /** The Constant speed. */
    private static final int     speed = 300;

    /** The view. */
    private IBoulderdashView  view;

    /** The model. */
    private IBoulderdashModel model;

    /** The stack order. */
    private UserOrder            stackOrder;

    /**
     * Instantiates a new insane vehicles controller.
     *
     * @param view
     *            the view
     * @param model
     *            the model
     */
    public BoulderdashController(final IBoulderdashView view, final IBoulderdashModel model) {
        this.setView(view);
        this.setModel(model);
        this.clearStackOrder();
    }

    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.controller.IIinsaneVehiclesController#play()
     */
    @Override
    public final void play() throws InterruptedException {
        while (this.getModel().getMyVehicle().isAlive()) {
            Thread.sleep(speed);
            switch (this.getStackOrder()) {
                case RIGHT:
                    this.getModel().getMyVehicle().moveRight();
                    break;
                case LEFT:
                    this.getModel().getMyVehicle().moveLeft();
                    break;
                case UP:
                	this.getModel().getMyVehicle().moveUp();
                	break;
                case DOWN:
                    this.getModel().getMyVehicle().moveDown();
                    break;
                case NOP:
                default:
                    this.getModel().getMyVehicle().doNothing();
                    break;
            }
            this.clearStackOrder();
//            if (this.getModel().getMyVehicle().isAlive()) {
////                this.getModel().getMyVehicle().moveDown();
//            }
            this.getView().followMyVehicle();
        }
        this.getView().displayMessage("CRASH !!!!!!!!!.");
    }

    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.controller.IOrderPerformed#orderPerform(fr.exia.insanevehicles.
     * controller.UserOrder)
     */
    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.controller.IIinsaneVehiclesController#orderPerform(fr.exia.
     * insanevehicles.controller.UserOrder)
     */
    @Override
    public final void orderPerform(final UserOrder userOrder) throws IOException {
        this.setStackOrder(userOrder);
    }

    /**
     * Gets the view.
     *
     * @return the view
     */
    private IBoulderdashView getView() {
        return this.view;
    }

    /**
     * Sets the view.
     *
     * @param view
     *            the view to set
     */
    private void setView(final IBoulderdashView view) {
        this.view = view;
    }

    /**
     * Gets the model.
     *
     * @return the model
     */
    private IBoulderdashModel getModel() {
        return this.model;
    }

    /**
     * Sets the model.
     *
     * @param model
     *            the model to set
     */
    private void setModel(final IBoulderdashModel model) {
        this.model = model;
    }

    /**
     * Gets the stack order.
     *
     * @return the stack order
     */
    private UserOrder getStackOrder() {
        return this.stackOrder;
    }

    /**
     * Sets the stack order.
     *
     * @param stackOrder
     *            the new stack order
     */
    private void setStackOrder(final UserOrder stackOrder) {
        this.stackOrder = stackOrder;
    }

    /**
     * Clear stack order.
     */
    private void clearStackOrder() {
        this.stackOrder = UserOrder.NOP;
    }

    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.controller.IIinsaneVehiclesController#getOrderPeformer()
     */
    @Override
    public IOrderPerformer getOrderPeformer() {
        return this;
    }

}

