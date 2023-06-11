package gameObjects;

import constants.Constants;
import graphics.Assets;
import main.Window;
import math.Vector2D;
import states.GameState;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public abstract class MovingObject extends GameObject{

    protected Vector2D velocity;
    protected double angle;
    protected GameState gameState;
    protected short[] screenData;
    protected int width, height;
    public MovingObject(Vector2D position, Vector2D velocity, Image texture, GameState gameState, short[] screenData) {
        super(position, texture);
        this.velocity = velocity;
        this.angle = 0;
        this.gameState = gameState;
        this.screenData = screenData;
        width = new ImageIcon(texture).getIconWidth();
        height = new ImageIcon(texture).getIconHeight();

    }

    @Override
    public void update() throws AWTException {

    }

    @Override
    public void draw(Graphics g) {

    }

    public boolean isValidMove(int x, int y) throws AWTException {
        // Obtener el color del píxel en la posición especificada
        Color pixelColor = new Robot().getPixelColor(x , y);

        // Verificar si el color corresponde a azul, si eso pasa retornar false (movimiento invalido)
        return !pixelColor.equals(Color.BLUE);
    }

    public boolean isWhiteDot(int x, int y) throws AWTException {
        // Obtener el color del píxel en la posición especificada
        Color pixelColor = new Robot().getPixelColor(x , y);

        // Verificar si el color corresponde a blanco, si eso pasa retornar false (movimiento invalido)
        return pixelColor.equals(Color.WHITE);
    }

    protected Vector2D getCenter(){
        return new Vector2D(position.getX() + (width / 2), position.getY() + (height / 2));
    }

    protected void collidesWith(){
        ArrayList<MovingObject> movingObjects = gameState.getMovingObjects();
        for (MovingObject m : movingObjects){
            if(m.equals(this)){
                continue;
            }

            double distance = m.getCenter().substract(getCenter()).getMagnitude();
            if(distance < (double) m.width /2 + (double) width /2 && movingObjects.contains(this)){
                collision(m, this);
            }
        }
    }

    private void collision(MovingObject a, MovingObject b){
        if(a instanceof Ghost && b instanceof Pacman){ //colision con fantasmas
             //modificar, debe ir a la pantalla de pausa
            b.die();
        }
    }
    protected void die(){
        gameState.getPacman().setPosition(new Vector2D(10, 10));
        gameState.susbtractLife();
    }
}
