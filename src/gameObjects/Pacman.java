package gameObjects;

import graphics.Assets;
import input.KeyBoard;
import math.Vector2D;
import constants.Constants;

import java.awt.*;

public class Pacman extends MovingObject{
    public Pacman(Vector2D position, Vector2D velocity, Image texture) {
        super(position, velocity, texture);
    }

    @Override
    public void update() {
        if(KeyBoard.RIGHT){
            texture = Assets.right;
            position.setX(position.getX()+1.5);
        }
        else if(KeyBoard.LEFT){
            texture = Assets.left;
            position.setX(position.getX()-1.5);
        }
        else if(KeyBoard.UP){
            texture = Assets.up;
            position.setY(position.getY()-1.5);
        }
        else if(KeyBoard.DOWN){
            texture = Assets.down;
            position.setY(position.getY()+1.5);
        }

        if(position.getX() > Constants.CANVAS_WIDTH){
            position.setX(0);
        }
        if(position.getY() > Constants.CANVAS_HEIGHT){
            position.setY(0);
        }
        if(position.getX() < 0){
            position.setX(Constants.CANVAS_WIDTH);
        }
        if(position.getY() < 0){
            position.setY(Constants.CANVAS_HEIGHT);
        }


    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(texture, (int)position.getX(), (int)position.getY(), null);
    }
}
