package model;

import java.io.IOException;

/**
 * <h1>The Class InsaneVehiclesModel.</h1>
 */
public class BoulderdashModel implements IBoulderdashModel {

    /** The road. */
    private IRoad   road;

    /** The my vehicle. */
    private IMobile myVehicle;

    /**
     * Instantiates a new insane vehicles model.
     *
     * @param fileName
     *            the file name
     * @param myVehicleStartX
     *            the my vehicle start X
     * @param myVehicleStartY
     *            the my vehicle start Y
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    public BoulderdashModel(final String fileName, final int myVehicleStartX, final int myVehicleStartY)
            throws IOException {
        this.setRoad(new Road(fileName));
        this.setMyVehicle(new Rockford(myVehicleStartX, myVehicleStartY, this.getRoad()));
    }

    /* (non-Javadoc)
     * @see fr.exia.insanevehicles.model.IInsaneVehiclesModel#getRoad()
     */
    @Override
    public final IRoad getRoad() {
        return this.road;
    }

    /**
     * Sets the road.
     *
     * @param road
     *            the road to set
     */
    private void setRoad(final IRoad road) {
        this.road = road;
    }

    /* (non-Javadoc)
     * @see fr.exia.insanevehicles.model.IInsaneVehiclesModel#getMyVehicle()
     */
    @Override
    public final IMobile getMyVehicle() {
        return this.myVehicle;
    }

    /**
     * Sets the my vehicle.
     *
     * @param myVehicle
     *            the myVehicle to set
     */
    private void setMyVehicle(final IMobile myVehicle) {
        this.myVehicle = myVehicle;
    }

}
