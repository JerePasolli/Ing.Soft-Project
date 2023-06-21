package main;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class WindowTest {

    private static Window window;

    @BeforeAll
    public static void beforeAll(){
        window = new Window();
    }

    @Test
    public void setTitleTest(){
        window.setTitle("TitleTest");
        assertEquals("TitleTest", window.getTitle());
    }

    @Test
    public void canvasTest(){
        assertNotNull(window.getCanvas());
    }

    @Test
    public void keyboardTest(){
        assertNotNull(window.getKeyBoard());
    }

    @Test
    public void mouseTest(){
        assertNotNull(window.getMouseInput());
    }
}
