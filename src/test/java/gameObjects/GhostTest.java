package gameObjects;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import graphics.Assets;
import states.GameState;

import org.junit.jupiter.api.BeforeAll;
public class GhostTest {
    private static Ghost ghost;
    
    @BeforeAll
    public void beforeAll(){
        Assets.init();
        GameState gameState=new GameState();
        ghost=new Ghost(Assets.ghost, gameState);
    }
    @Test
    public void ghostTest(){
        Assertions.assertFalse(ghost.getFinished());
    }
}
