package animalchess;

import java.util.ArrayList;

/**
 * class for cat.
 */
public class Cat extends PromotablePiece {
    /**
     * Constructor method for class Cat.
     * @param owner  the owner of the cat piece.
     * @param square the square where the cat piece sits on
     */
    public Cat(Player owner, Square square) {
        super(owner, square);
    }

    /**
     * method for collecting cat's legal moves.
     * @return an arrayList that contains all legal squares a cat can move
     */
    @Override
    public ArrayList<Square> getLegalMoves() {
        ArrayList<Square> legalMoves = new ArrayList<>();
        Location[] adjacent = getAdjacent(); // use this array to help judge legal moves

        // the moving directions of cat piece of the two players are opposite
        if (getOwner().getPlayerNumber() == 1) {
            // move directions for player p1
            if (getIsPromoted()) {
                // move directions when cat is promoted
                for (int i = 0; i < adjacent.length; i++) {
                    if (i != 6 && i != 8) {
                        if (isMoveLegal(i) != null) {
                            legalMoves.add(isMoveLegal(i));
                        }
                    }
                }
            } else {
                // move directions when cat is un-promoted
                for (int i = 0; i < adjacent.length; i++) {
                    if (i != 3 && i != 5 && i != 7) {
                        if (isMoveLegal(i) != null) {
                            legalMoves.add(isMoveLegal(i));
                        }
                    }
                }
            }
        } else if (getOwner().getPlayerNumber() == 0) {
            // move directions for player p0
            if (getIsPromoted()) {
                // move directions when cat is promoted
                for (int i = 0; i < adjacent.length; i++) {
                    if (i != 0 && i != 2) {
                        if (isMoveLegal(i) != null) {
                            legalMoves.add(isMoveLegal(i));
                        }
                    }
                }
            } else {
                // move directions when cat is promoted
                for (int i = 0; i < adjacent.length; i++) {
                    if (i != 1 && i != 3 && i != 5) {
                        if (isMoveLegal(i) != null) {
                            legalMoves.add(isMoveLegal(i));
                        }
                    }
                }
            }
        }
        return legalMoves;
    }
}
