package model.element.motionless;


/**
 * <h1>The Class Ditch.</h1>
 *
 * @author Jade
 * @version 0.2
 */
class DitchRightTurnRight extends MotionlessElement {

    /** The Constant SPRITE. */
    private static final Sprite SPRITE = new Sprite(')', "DitchRightTurnRight.jpg");

    /**
     * Instantiates a new ditch.
     */
    DitchRightTurnRight() {
        super(SPRITE, Permeability.BLOCKING);
    }
}
