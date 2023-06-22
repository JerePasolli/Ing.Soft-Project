package gameObjects;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

import graphics.Assets;
import input.KeyBoard;

import java.awt.Image;

import states.GameState;

public class PacmanTest {
    private static Pacman pacman;
    private GameState gameState;
    @BeforeAll
    public static void beforeAll(){
        Assets.init();
        GameState gameState=new GameState();
        pacman=new Pacman(1,1,Assets.left,gameState);

    }
    @Test
    public void pacmanTest(){
        Assertions.assertNotNull(pacman.getMusic1());
        Assertions.assertNotNull(pacman.getMusic2());
    }

    @Test
    public void movePacmanTest(){
        pacman.movePacman();
        Assertions.assertEquals(pacman.x, 1);
        Assertions.assertEquals(pacman.y, 1);
        pacman.dx=1;
        pacman.movePacman();
        Assertions.assertEquals(pacman.x, 3);
        Assertions.assertEquals(pacman.y, 1);
        pacman.dx=-1;
        pacman.movePacman();
        Assertions.assertEquals(pacman.x, 1);
        Assertions.assertEquals(pacman.y, 1);
        pacman.dy=1;
        pacman.movePacman();
        Assertions.assertEquals(pacman.x, -1);
        Assertions.assertEquals(pacman.y, 3);
        pacman.dy=-1;
        pacman.movePacman();
        Assertions.assertEquals(pacman.x, -3);
        Assertions.assertEquals(pacman.y, 1);
    }
    
}
