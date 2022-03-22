package animalchess;

import java.util.ArrayList;

/**
 * class for giraffe.
 */
public class Giraffe extends Piece {
    /**
     * Constructor method for class Giraffe.
     * @param owner  the owner of the giraffe piece.
     * @param square the square where the giraffe piece sits on
     */
    public Giraffe(Player owner, Square square) {
        super(owner, square);
    }

    /**
     * method for collecting giraffe's legal moves.
     * @return an arrayList that contains all legal squares a giraffe can move
     */
    @Override
    public ArrayList<Square> getLegalMoves() {
        ArrayList<Square> legalMoves = new ArrayList<>();
        Location[] adjacent = getAdjacent(); // use this array to help judge legal moves

        // judge giraffe's adjacent squares in order
        // forward, left, right or backward
        for (int i = 1; i < adjacent.length; i += 2) {
            if (isMoveLegal(i) != null) {
                legalMoves.add(isMoveLegal(i));
            }
        }
        return legalMoves;
    }
}
