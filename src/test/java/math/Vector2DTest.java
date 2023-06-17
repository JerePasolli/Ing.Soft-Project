package math;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Vector2DTest {

    private static Vector2D vector1;
    private static Vector2D vector2;

    @BeforeAll
    public static void beforeAll(){
        vector1 = new Vector2D();
        vector2 = new Vector2D(4,7);
    }

    @Test
    public void testCoordenates(){
        assertEquals(0,vector1.getX());
        assertEquals(0,vector1.getY());
        assertEquals(4,vector2.getX());
        assertEquals(7,vector2.getY());
        vector1.setX(9);
        vector1.setY(4);
        assertEquals(9,vector2.getX());
        assertEquals(4,vector2.getY());
    }
}
