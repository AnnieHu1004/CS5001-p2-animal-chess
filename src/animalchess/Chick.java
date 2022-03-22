package animalchess;

import java.util.ArrayList;

/**
 * class for chick.
 */
public class Chick extends PromotablePiece {
    /**
     * Constructor method for class Chick.
     * @param owner  the owner of the chick piece.
     * @param square the square where the chick piece sits on
     */
    public Chick(Player owner, Square square) {
        super(owner, square);
    }

    /**
     * method for collecting chick's legal moves.
     * @return an arrayList that contains all legal squares a chick can move
     */
    @Override
    public ArrayList<Square> getLegalMoves() {
        ArrayList<Square> legalMoves = new ArrayList<>();
        Location[] adjacent = getAdjacent(); // use this array to help judge legal moves

        // the moving directions of chick piece of the two players are opposite
        if (getOwner().getPlayerNumber() == 1) {
            // move directions for player p1
            if (getIsPromoted()) {
                // move directions when chick is promoted
                for (int i = 0; i < adjacent.length; i++) {
                    if (i != 6 && i != 8) {
                        if (isMoveLegal(i) != null) {
                            legalMoves.add(isMoveLegal(i));
                        }
                    }
                }
            } else {
                // move directions when chick is un-promoted
                if (isMoveLegal(1) != null) {
                    legalMoves.add(isMoveLegal(1));
                }
            }
        } else if (getOwner().getPlayerNumber() == 0) {
            // move directions for player p0
            if (getIsPromoted()) {
                // move directions when chick is promoted
                for (int i = 0; i < adjacent.length; i++) {
                    if (i != 0 && i != 2) {
                        if (isMoveLegal(i) != null) {
                            legalMoves.add(isMoveLegal(i));
                        }
                    }
                }
            } else {
                // move directions when chick is un-promoted
                if (isMoveLegal(7) != null) {
                    legalMoves.add(isMoveLegal(7));
                }
            }
        }
        return legalMoves;
    }
}
