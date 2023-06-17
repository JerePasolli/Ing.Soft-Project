package states;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MenuStateTest {

    private static MenuState menuState;

    @BeforeAll
    public static void beforeAll(){
        menuState = new MenuState();
    }

    @Test
    public void testButtons(){
        assertEquals(4, menuState.getButtons().size());
    }

    @Test
    public void testSound(){
        assertNotNull(menuState.getMusic());
    }
}
