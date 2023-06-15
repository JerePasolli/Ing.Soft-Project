package gameObjects;

import constants.Constants;
import math.Vector2D;
import states.GameState;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Ghost extends MovingObject{

    private Random random;

    public Ghost(Vector2D position, Vector2D velocity, Image texture, GameState gameState, short[] screenData) {
        super(position, velocity, texture, gameState, screenData);
        random = new Random();
    }

   @Override
   public void update() throws AWTException {

        int randomDirection = random.nextInt(4);

       switch (randomDirection) {
           case 0 ->
               // Mover hacia derecha
                   position = position.addX(velocity);
           case 1 ->
               // Mover hacia izquierda
                   position = position.substractX(velocity);
           case 2 ->
               // Mover hacia arriba
                   position = position.substractY(velocity);
           case 3 ->
               // Mover hacia abajo
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

   }

   @Override
   public void draw(Graphics g) {
       g.drawImage(texture, (int)position.getX(), (int)position.getY(), null);
   }

}
