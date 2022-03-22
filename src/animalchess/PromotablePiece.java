package animalchess;

/**
 * Abstract class for promotable piece.
 * Provide common methods for subclass's instance to use.
 */
public abstract class PromotablePiece extends Piece {
    private boolean state; // true for promoted while false for un-promoted
    /**
     * Constructor method for abstract promotable class .
     * @param owner  the owner of the cat piece.
     * @param square the square where the cat piece sits on
     */
    public PromotablePiece(Player owner, Square square) {
        super(owner, square);
    }

    /**
     * method for getting the state of promotion for certain promotable piece.
     * @return a boolean that indicates its state of promotion
     */
    public boolean getIsPromoted() {
        return state;
    }

    /**
     * method for promoting certain pieces by changing its state of promotion.
     */
    public void promote() {
        state = true;
    }

    /**
     * method for moving on piece to an appointed square.
     * @param toSquare the square player want to move his/her chess to.
     */
    @Override
    public void move(Square toSquare) {
        super.move(toSquare);
        // if the square player want to move if in promotion zone
        if (toSquare.isPromotionZone(getOwner())) {
            promote();
        }
    }

    /**
     * method for changing the owner of piece and un-promote the piece if needed.
     * @param capturer the player on the other side
     */
    @Override
    public void beCaptured(Player capturer) {
        super.beCaptured(capturer);
        if (state) {
            state = false;
        }
    }
}
