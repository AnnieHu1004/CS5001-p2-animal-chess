package animalchess;

/**
 * class for Location.
 */
public class Location {
    private int row;
    private int col;

    /**
     * Constructor method.
     * @param row set the row of certain location
     * @param col set the col of certain location
     */
    public Location(int row, int col) {
        this.row = row;
        this.col = col;
    }

    /**
     * method for getting the row of certain location.
     * @return row of certain location
     */
    public int getRow() {
        return row;
    }

    /**
     * method for getting the col of certain location.
     * @return col of certain location
     */
    public int getCol() {
        return col;
    }
}
