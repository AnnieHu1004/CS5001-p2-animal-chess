package animalchess;

import java.util.ArrayList;

/**
 * abstract class for piece.
 * offer common methods for all types of piece
 */
public abstract class Piece {
    private Player owner;
    private Square square;

    // an array that is used to calculate the adjacent squares of certain piece
    private final Location[] adjacent = {
            new Location(-1, -1), new Location(-1, 0), new Location(-1, 1),
            new Location(0, -1), new Location(0, 0), new Location(0, 1),
            new Location(1, -1), new Location(1, 0), new Location(1, 1)
    };

    /**
     * Constructor.
     * @param owner player who owns the chess piece
     * @param square the square where the chess piece sits on
     * @throws IllegalArgumentException if add a new piece to a square that all ready sits a piece
     */
    public Piece(Player owner, Square square) throws IllegalArgumentException {
        this.owner = owner;
        if (square.getPiece() == null) {
            this.setSquare(square);
            square.placePiece(this);
        } else {
            throw new IllegalArgumentException("Can not add a new piece to a square that all ready sits a piece");
        }
    }

    /**
     * Abstract method for getting legal moves for certain chess piece.
     * @return an arraylist that shows legal square a certain chess can move to.
     */
    public abstract ArrayList<Square> getLegalMoves();

    /**
     * method for moving chess.
     * @param toSquare the square player want to move his/her chess to.
     * @throws IllegalArgumentException if player wants to move their piece to a square that already has their piece
     */
    public void move(Square toSquare) throws IllegalArgumentException {
        if (toSquare.getPiece() == null) {
            toSquare.placePiece(this); // bind information of piece to the square player wants to go
            this.square.removePiece(); // remove this piece sitting on this square
            setSquare(toSquare); // bind information of the square player wants to go to the piece
        } else if (owner != toSquare.getPiece().getOwner() && toSquare.getPiece() != null) {
            // if the square player wants to go sits a piece that belongs to the other player
            toSquare.getPiece().beCaptured(this.owner); // this piece capture the other player's piece

            toSquare.getPiece().setSquare(null); // remove information of the other player's piece from the chessboard
            toSquare.removePiece(); // remove information of this piece sitting on the square player wants to go

            toSquare.placePiece(this); // bind information of piece to the square player wants to go
            this.square.removePiece(); // remove this piece sitting on this square
            setSquare(toSquare); // bind information of the square player wants to go to the piece
        } else {
            throw new IllegalArgumentException("You can not move to the square that already has your piece");
        }
    }

    /**
     * method for change information about becaptured chess.
     * @param capturer the player on the other side
     */
    public void beCaptured(Player capturer) {
        this.owner = capturer;
        this.owner.addPieceToHand(this);
    }

    /**
     * method for getting the owner of the piece.
     * @return the owner of this piece
     */
    public Player getOwner() {
        return owner;
    }

    /**
     * method for setting the square where the piece will sit on.
     * @param square a new square needs to be set according to player's needs
     */
    public void setSquare(Square square) {
        this.square = square;
    }

    /**
     * method for getting the square where the piece sits on.
     * @return the square where this piece sits on
     */
    public Square getSquare() {
        return square;
    }

    /**
     * method for getting an array that is used to help to judge legal move.
     * @return an array that is used to help to judge legal move.
     */
    public Location[] getAdjacent() {
        return adjacent;
    }

    /**
     * method for judging whether the move is legal or not.
     * @param i the index for the array adjacent
     * @return a square of legal move or null if the move is illegal
     */
    public Square isMoveLegal(int i) {
        Location[] adjacent = getAdjacent(); // use this array to help judge legal moves

        // calculate the row and col of corresponding squares
        int r = getSquare().getRow() + adjacent[i].getRow();
        int c = getSquare().getCol() + adjacent[i].getCol();

        Square getMove = null;
        if (r >= 0 && r <= 5 && c >= 0 && c <= 4) {
            Square move = getSquare().getGame().getSquare(r, c);
            // legal moves are empty squares or squares that are occupied by the other player
            if (move.getPiece() == null || !getOwner().equals(move.getPiece().getOwner())) {
                getMove = move;
            }
        }
        return getMove;
    }
}
