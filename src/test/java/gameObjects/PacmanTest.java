package gameObjects;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import graphics.Assets;

import java.awt.Image;

import states.GameState;

public class PacmanTest {

    @Test
    public void pacmanTest(){
        Pacman esperado=new Pacman(1,1,Assets.left,null);
        Pacman pacman=new Pacman(1,1,Assets.left,null);
        Assertions.assertEquals(esperado, pacman);
    }
    
}
