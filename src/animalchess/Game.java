package animalchess;

/**
 * CS5001-p2-animal-chess.
 * @author 210005313
 * @version 1.0
 */
public class Game {
    /**
     * the height of the chessboard.
     */
    public static final int HEIGHT = 6;
    /**
     * the width of the chessboard.
     */
    public static final int WIDTH = 5;

    private Player p0;
    private Player p1;

    // all the squares make up the chessboard
    private static Square[][] squares = new Square[HEIGHT][WIDTH];

    /**
     * Constructor method for game.
     * @param p0 set the player of the game
     * @param p1 set the other player of the game
     */
    public Game(Player p0, Player p1) {
        this.p0 = p0;
        this.p1 = p1;

        initial();
    }

    /**
     * method for initialize the game.
     */
    public void initial() {
        try {
            for (int i = 0; i < HEIGHT; i++) {
                for (int j = 0; j < WIDTH; j++) {
                    if (i == 0 || i == 1) {
                        // initialize the promotion zone for player p1
                        squares[i][j] = new Square(this, i, j, p1);
                    } else if (i == 2 || i == 3) {
                        // initialize ordinary zone
                        squares[i][j] = new Square(this, i, j);
                    } else {
                        // initialize the promotion zone for player p0
                        squares[i][j] = new Square(this, i, j, p0);
                    }
                    squares[i][j].placePiece(null);
                }
            }

            //initialize animal chess pieces for player p0
            squares[0][0].placePiece(new Cat(p0, squares[0][0]));
            squares[0][4].placePiece(new Cat(p0, squares[0][4]));
            squares[0][1].placePiece(new Giraffe(p0, squares[0][1]));
            squares[0][3].placePiece(new Giraffe(p0, squares[0][3]));
            squares[0][2].placePiece(new Lion(p0, squares[0][2]));

            //initialize chick chess pieces for both player p0 and p1
            for (int i = 1; i <= 3; i++) {
                squares[2][i].placePiece(new Chick(p0, squares[2][i]));
                squares[3][i].placePiece(new Chick(p1, squares[3][i]));
            }

            //initialize animal chess pieces for player p0
            squares[5][0].placePiece(new Cat(p1, squares[5][0]));
            squares[5][4].placePiece(new Cat(p1, squares[5][4]));
            squares[5][1].placePiece(new Giraffe(p1, squares[5][1]));
            squares[5][3].placePiece(new Giraffe(p1, squares[5][3]));
            squares[5][2].placePiece(new Lion(p1, squares[5][2]));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * method for getting player corresponding to the player number.
     * @param playerNumber number of player
     * @return Player corresponding to the player number
     * @throws IllegalArgumentException if the number is an invalid player number
     */
    public Player getPlayer(int playerNumber) throws IllegalArgumentException {
        Player player;
        if (playerNumber == p0.getPlayerNumber()) {
            player = p0;
        } else if (playerNumber == p1.getPlayerNumber()) {
            player = p1;
        } else {
            throw new IllegalArgumentException("Invalid player number");
        }
        return player;
    }

    /**
     * method for getting winner.
     * @return the winner of the game
     */
    public Player getWinner() {
        Player winner = null;
        if (p0.hasWon()) {
            winner = p0;
        } else if (p1.hasWon()) {
            winner = p1;
        }
      return winner;
    }

    /**
     * method for getting certain square in the chessboard.
     * @param row the row the square the program needs to get
     * @param col the col the square the program needs to get
     * @return the square needs to get in this game
     */
    public Square getSquare(int row, int col) {
        return squares[row][col];
    }
}
