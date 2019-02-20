package esi.atl.G39864.Blokus.Model.test;

import esi.atl.gg39864.blokus.model.Position;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * this class test the method of the class position 
 * @author chris home
 */
public class PositionTest {

    /**
     * this test verify if the position (0,0) is in the board
     */
    @Test
    public void testIsInside1() {
        Position position = new Position(0, 0);
        boolean inside = position.isInside(position);
        assertTrue(inside);
    }

    /**
     * this test verify if the position (19,19) is in the board
     */
    @Test
    public void testIsInside2() {
        Position position = new Position(19, 19);
        boolean inside = position.isInside(position);
        assertTrue(inside);
    }

    /**
     * this test verify if the position (-1,0) is in the board
     */
    @Test
    public void testIsInside3() {
        Position position = new Position(-1, 0);
        boolean inside = position.isInside(position);
        assertFalse(inside);
    }

    /**
     * this test verify if the position (0,-1) is in the board
     */
    @Test
    public void testIsInside4() {
        Position position = new Position(0, -1);
        boolean inside = position.isInside(position);
        assertFalse(inside);
    }

    /**
     * this test verify if the position (20,0) is in the board
     */
    @Test
    public void testIsInside5() {
        Position position = new Position(20, 0);
        boolean inside = position.isInside(position);
        assertFalse(inside);
    }

    /**
     * this test verify if the position (0,20) is in the board
     */
    @Test
    public void testIsInside6() {
        Position position = new Position(0, 20);
        boolean inside = position.isInside(position);
        assertFalse(inside);
    }

    /**
     * this test verify if the position (20,20) is in the board
     */
    @Test
    public void testIsInside7() {
        Position position = new Position(20, 20);
        boolean inside = position.isInside(position);
        assertFalse(inside);
    }

    /**
     * this test verify if the position (-1,-1) is in the board
     */
    @Test
    public void testIsInside8() {
        Position position = new Position(-1, -1);
        boolean inside = position.isInside(position);
        assertFalse(inside);
    }

}
