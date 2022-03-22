package animalchess;

import java.util.ArrayList;

/**
 * class for lion.
 */
public class Lion extends Piece {
    /**
     * Constructor method for class Lion.
     * @param owner  the owner of the lion piece.
     * @param square the square where the lion piece sits on
     */
    public Lion(Player owner, Square square) {
        super(owner, square);
    }

    /**
     * method for collecting lion's legal moves.
     * @return an arrayList that contains all legal squares a lion can move
     */
    @Override
    public ArrayList<Square> getLegalMoves() {
        ArrayList<Square> legalMoves = new ArrayList<>();
        Location[] adjacent = getAdjacent(); // use this array to help judge legal moves

        // judge lion's adjacent squares in order
        for (int i = 0; i < adjacent.length; i++) {
            if (isMoveLegal(i) != null) {
                legalMoves.add(isMoveLegal(i));
            }
        }
        return legalMoves;
    }

    /**
     * method for making rule for wining the game- capture the lion of the other player.
     */
    @Override
    public void beCaptured(Player capturer) {
        capturer.winGame();
        capturer.hasWon();
    }
}
