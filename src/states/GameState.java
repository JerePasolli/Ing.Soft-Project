package states;

import gameObjects.Pacman;
import graphics.Assets;
import math.Vector2D;

import java.awt.*;

public class GameState {

    private Pacman pacman;

    public GameState(){
        pacman = new Pacman(new Vector2D(80, 80), new Vector2D(3, 3), Assets.up);
    }

    public void update(){
        pacman.update();
    }

    public void draw(Graphics g){
        pacman.draw(g);

    }
}
