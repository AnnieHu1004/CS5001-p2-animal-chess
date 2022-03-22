package animalchess;

import java.util.ArrayList;

/**
 * class for Player.
 */
public class Player {
    private String name;
    private int playerNumber;
    private Player winner;
    private ArrayList<Piece> handPieces = new ArrayList<>();

    /**
     * Constructor method for player.
     * @param name         the name of the player
     * @param playerNumber the number of player that indicates their position
     */
    public Player(String name, int playerNumber) {
        this.name = name;
        this.playerNumber = playerNumber;
    }

    /**
     * method for getting player's name.
     * @return name of player
     */
    public String getName() {
        return name;
    }

    /**
     * method for getting player's number.
     * @return the number of player
     */
    public int getPlayerNumber() {
        return playerNumber;
    }

    /**
     * method for getting pieces at hand.
     * @return an arraylist contains pieces the player has at hand.
     */
    public ArrayList<Piece> getHand() {
        return handPieces;
    }

    /**
     * method for adding piece to hand.
     * @param piece piece that is captured by the player.
     */
    public void addPieceToHand(Piece piece) {
        handPieces.add(piece);
    }

    /**
     * method for dropping a piece of pieces at hand to a certain square.
     * @param piece  piece the player wants to drop on the chessboard
     * @param square the square the player wants to drop the piece on
     * @throws IllegalArgumentException if player wants to drop a piece that does not belong to them.
     */
    public void dropPiece(Piece piece, Square square) throws IllegalArgumentException {
        if (handPieces.contains(piece)) {
            square.placePiece(piece);
            piece.setSquare(square);
            handPieces.remove(piece);
        } else {
            throw new IllegalArgumentException("You can not drop a piece that does not belong to you.");
        }
    }

    /**
     * method for setting winner of the game.
     */
    public void winGame() {
        winner = this;
    }

    /**
     * method for judging whether the player is the winner of the game.
     * @return a boolean that indicates whether the player is the winner or not
     */
    public boolean hasWon() {
        boolean hasWon = false;
        if (winner == this) {
            hasWon = true;
        }
        return hasWon;
    }
}
