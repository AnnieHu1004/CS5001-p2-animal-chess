package animalchess;

/**
 * class for Square.
 * offer method for instance of square
 */
public class Square {
    private Game game;
    private int row;
    private int col;
    private Player promotesPlayer;
    private Piece piece;

    /**
     * Constructor method for square that can not promote piece.
     * @param game the game that squares belong to
     * @param row  the row of this square in the chessboard
     * @param col  the col of this square in the chessboard
     */
    public Square(Game game, int row, int col) {
        this.game = game;
        this.row = row;
        this.col = col;
    }

    /**
     * Constructor method for square that can promote piece.
     * @param game the game that squares belong to
     * @param row  the row of this square in the chessboard
     * @param col  the col of this square in the chessboard
     * @param promotesPlayer player that have squares where pieces can be promoted
     */
    public Square(Game game, int row, int col, Player promotesPlayer) {
        this.game = game;
        this.row = row;
        this.col = col;
        this.promotesPlayer = promotesPlayer;
    }

    /**
     * method for placing piece on this square.
     * @param piece the piece that is going to sit on this square
     * @throws IllegalArgumentException if player wants to place a piece on a square that is already occupied
     */
    public void placePiece(Piece piece) throws IllegalArgumentException {
        if (this.piece == null || !this.piece.getOwner().equals(piece.getOwner())) {
            // if the square has no piece sits on
            // or the square has a piece that belongs to the other player
            this.piece = piece;
        } else if (!this.piece.equals(piece)) {
            // except for situations mentioned above and situation when initialize the piece
            // exception should be thrown
            throw new IllegalArgumentException("You place a piece on a square that is already occupied");
        }
    }

    /**
     * method for removing piece on this square.
     */
    public void removePiece() {
        this.piece = null;
    }

    /**
     * method for judging whether the square is corresponding player's promotion zone.
     * @param player player who move the promotable piece
     * @return boolean indicates whether the square is corresponding player's promotion zone.
     */
    public boolean isPromotionZone(Player player) {
        boolean isPromZone = false;
        if (getPromotesPlayer() != null && getPromotesPlayer().equals(player)) {
            isPromZone = true;
        }
        return isPromZone;
    }

    /**
     * method for getting game that squares belong to.
     * @return game that squares belong to..
     */
    public Game getGame() {
        return game;
    }

    /**
     * method for getting the number of row of the square.
     * @return the number of row of the square.
     */
    public int getRow() {
        return row;
    }

    /**
     * method for getting the number of col of the square.
     * @return the number of col of the square.
     */
    public int getCol() {
        return col;
    }

    /**
     * method for getting the piece that sits on the square.
     * @return piece that sits on the square
     */
    public Piece getPiece() {
        return piece;
    }

    /**
     * method for getting the player that has certain promotion squares.
     * @return the player that has certain promotion squares.
     */
    public Player getPromotesPlayer() {
        return promotesPlayer;
    }
}
