package gameObjects;

import graphics.Assets;
import input.KeyBoard;
import math.Vector2D;
import constants.Constants;
import states.GameState;

import javax.swing.*;
import java.awt.*;

public class Pacman extends MovingObject{
    public Pacman(Vector2D position, Vector2D velocity, Image texture, GameState gameState, short[] screenData) {
        super(position, velocity, texture, gameState, screenData);
    }

    @Override
    public void update() throws AWTException {

        if(KeyBoard.RIGHT){
            texture = Assets.right;
            position = position.addX(velocity);
        }
        else if(KeyBoard.LEFT){
            texture = Assets.left;
            position = position.substractX(velocity);
        }
        else if(KeyBoard.UP){
            texture = Assets.up;
            position = position.substractY(velocity);
        }
        else if(KeyBoard.DOWN){
            texture = Assets.down;
            position = position.addY(velocity);
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

        if(isValidMove(position.getX(), position.getY())){
        }

        if(isWhiteDot(position.getX(), position.getY())){
            gameState.addScore(10);
        }

        collidesWith();

    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(texture, (int)position.getX(), (int)position.getY(), null);
    }
}
