package gameObjects;

import input.KeyBoard;
import math.Vector2D;

import java.awt.*;

public class Pacman extends MovingObject{
    public Pacman(Vector2D position, Vector2D velocity, Image texture) {
        super(position, velocity, texture);
    }

    @Override
    public void update() {
        if(KeyBoard.RIGHT){
            position.setX(position.getX()+1);
        }
        if(KeyBoard.LEFT){
            position.setX(position.getX()-1);
        }
        if(KeyBoard.UP){
            position.setX(position.getY()-1);
        }
        if(KeyBoard.DOWN){
            position.setX(position.getX()+1);
        }

    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(texture, (int)position.getX(), (int)position.getY(), null);
    }
}
