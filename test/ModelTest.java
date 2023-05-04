import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ModelTest {

    private static Model model;
    private static Model.TAdapter keyListener;

    @BeforeAll
    public static void beforeAll(){
        model = new Model();
    }

    @Test
    public void testImageLoad(){
        assertNotNull(model.getHeart());
        assertNotNull(model.getGhost());
        assertNotNull(model.getUp());
        assertNotNull(model.getDown());
        assertNotNull(model.getRight());
        assertNotNull(model.getLeft());
    }

    @Test
    public void testInitVariables(){
        assertEquals(model.getScreenData().length, model.getN_BLOCKS() * model.getN_BLOCKS());
        assertEquals(model.getGhost_x().length, model.getMAX_GHOSTS());
        assertEquals(model.getGhost_dx().length, model.getMAX_GHOSTS());
        assertEquals(model.getGhost_y().length, model.getMAX_GHOSTS());
        assertEquals(model.getGhost_dy().length, model.getMAX_GHOSTS());

    }

   /* @Test
    public void testKeyPressed() throws AWTException {
        int keyUp = 38;
        int keyDown = 40;
        int keyLeft = 37;
        int keyRight = 39;

        Robot robot = new Robot();
        model.addKeyListener(keyListener);
        model.requestFocus();
        robot.keyPress(KeyEvent.VK_UP);
        try{Thread.sleep(50);}catch(InterruptedException e){}
        robot.keyRelease(KeyEvent.VK_UP);
    }*/

    @Test
    public void testDeath(){
        model.setLives(1);
        model.death();
        assertFalse(model.isInGame());
    }

    @Test
    public void testInitGame(){
        model.initGame();
        assertEquals(model.getLives(), 3);
        assertEquals(model.getScore(), 0);
        assertEquals(model.getN_GHOSTS(), 6);
        assertEquals(model.getCurrentSpeed(), 3);
    }

}