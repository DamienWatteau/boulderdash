package model.element.motionless;

/**
 * <h1>A factory to create MotionlessElements objects.</h1>
 *
 * @author Jade
 * @version 0.3
 */
public abstract class MotionlessElementsFactory {

    /** The Constant ditchRight. */
    private static final DitchRight          ditchRight          = new DitchRight();

    /** The Constant ditchLeft. */
    private static final DitchLeft           ditchLeft           = new DitchLeft();

    /** The Constant ditchLeftTurnLeft. */
    private static final DitchLeftTurnLeft   ditchLeftTurnLeft   = new DitchLeftTurnLeft();

    /** The Constant ditchLeftTurnRight. */
    private static final DitchLeftTurnRight  ditchLeftTurnRight  = new DitchLeftTurnRight();

    /** The Constant ditchRightTurnLeft. */
    private static final DitchRightTurnLeft  ditchRightTurnLeft  = new DitchRightTurnLeft();

    /** The Constant ditchRightTurnRight. */
    private static final DitchRightTurnRight ditchRightTurnRight = new DitchRightTurnRight();

    /** The Constant TREE. */
    private static final Tree                TREE                = new Tree();

    /** The Constant MACADAM. */
    private static final Way             WAY             = new Way();

    /** The Constant OBSTACLE. */
    private static final Obstacle            OBSTACLE            = new Obstacle();

    /**
     * The motionless elements is an array of all possible MotionlessElement.
     */
    private static MotionlessElement[]       motionlessElements  = {
        ditchRight,
        ditchLeft,
        ditchLeftTurnLeft,
        ditchLeftTurnRight,
        ditchRightTurnLeft,
        ditchRightTurnRight,
        WAY,
        OBSTACLE,
        TREE, };

    /**
     * Creates a new MotionlessElements object.
     *
     * @return the motionless element
     */
    public static MotionlessElement createDitchRight() {
        return ditchRight;
    }

    /**
     * Creates a new MotionlessElements object.
     *
     * @return the motionless element
     */
    public static MotionlessElement createDitchLeft() {
        return ditchLeft;
    }

    /**
     * Creates a new MotionlessElements object.
     *
     * @return the motionless element
     */
    public static MotionlessElement createDitchLeftTurnLeft() {
        return ditchLeftTurnLeft;
    }

    /**
     * Creates a new MotionlessElements object.
     *
     * @return the motionless element
     */
    public static MotionlessElement createDitchLeftTurnRight() {
        return ditchLeftTurnRight;
    }

    /**
     * Creates a new MotionlessElements object.
     *
     * @return the motionless element
     */
    public static MotionlessElement createDitchRightTurnLeft() {
        return ditchRightTurnLeft;
    }

    /**
     * Creates a new MotionlessElements object.
     *
     * @return the motionless element
     */
    public static MotionlessElement createDitchRightTurnRight() {
        return ditchRightTurnRight;
    }

    /**
     * Creates a new macadam object.
     *
     * @return the motionless element
     */
    public static MotionlessElement createMacadam() {
        return WAY;
    }

    /**
     * Creates a new obstacle object.
     *
     * @return the motionless element
     */
    public static MotionlessElement createObstacle() {
        return OBSTACLE;
    }

    /**
     * Creates a new MotionlessElements object.
     *
     * @return the motionless element
     */
    public static MotionlessElement createTree() {
        return TREE;
    }

    /**
     * Gets the good MotionlessElement from file symbol.
     *
     * @param fileSymbol
     *            the file symbol
     * @return the from file symbol
     */
    public static MotionlessElement getFromFileSymbol(final char fileSymbol) {
        for (final MotionlessElement motionlessElement : motionlessElements) {
            if (motionlessElement.getSprite().getConsoleImage() == fileSymbol) {
                return motionlessElement;
            }
        }
        return WAY;
    }
}
