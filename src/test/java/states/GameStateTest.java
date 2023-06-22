package states;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import graphics.Assets;

import org.junit.jupiter.api.BeforeAll;

public class GameStateTest {
    private static GameState gameState;
    
    @BeforeAll
    public static void beforeAll(){
        gameState=new GameState();
        Assets.init();
    }

    @Test
    public void test(){
        gameState.addScore(3);
        Assertions.assertEquals(gameState.getScoreData().getScore(), 3);
    }
}
