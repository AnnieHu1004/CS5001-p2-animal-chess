package animalchess;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import animalchess.*;

public class PieceTest {
    
    private Piece wazir;
    private Piece silver;

    private Square square1;
    private Square square2;
    private Square square3;
    private Player michael;
    private Player oz;

    @Before
    public void setup() {
        square1 = new Square(null, 1, 2);
        square2 = new Square(null, 1, 0);
        square3 = new Square(null, 2, 1);
        michael = new Player("Michael", 0);
        oz = new Player("Ozgur", 1);
        wazir = new Giraffe(michael, square1);
        silver = new Cat(oz, square3);
    }

    @Test
    public void testGetSquare() {
        assertEquals(square1, wazir.getSquare());
    }

    @Test
    public void testGetOwner() {
        assertEquals(michael, wazir.getOwner());
    }

    @Test
    public void testBeCaptured() {
        wazir.beCaptured(oz);
        assertEquals(oz, wazir.getOwner());
        assertNotEquals(michael, wazir.getOwner());
    }

    @Test
    public void testMove() {
        wazir.move(square2);
        assertEquals(square2, wazir.getSquare());
        assertNotEquals(square1, wazir.getSquare());
    }

    @Test
    public void testMoveAndCapture() {
        assertEquals(square3, silver.getSquare());
        assertEquals(oz, silver.getOwner());
        wazir.move(square3);  // wazir takes silver by moving to its square
        assertEquals(square3, wazir.getSquare());
        assertNull(silver.getSquare());
        assertEquals(michael, silver.getOwner());
        assertNotEquals(oz, silver.getOwner());
    }

}
