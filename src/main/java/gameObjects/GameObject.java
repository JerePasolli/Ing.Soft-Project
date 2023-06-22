package gameObjects;
import java.awt.*;

import states.GameState;

public abstract class GameObject {

    protected Image texture;
    protected int x,y;
    protected int dx,dy;
    protected GameState gameState;

    /**
     *  Constructor de la clase. Inicializa un objeto del juego (Fantasma o Pacman).
     *  @param x coordenada "x" inicial del objeto
     *  @param y coordenada "y" incial del objeto
     *  @param texture imagen para visualizar el objeto
     *  @param gameState estado del juego en curso
     */
    public GameObject(int x,int y, Image texture, GameState gameState){
        this.x=x;
        this.y=y;
        this.texture = texture;
        this.gameState=gameState;
    }

    public abstract void update() throws AWTException;
    public abstract void draw(Graphics g);

    /**
     *  Retorna la coordenada "x" del objeto.
     *  @return coordenada "x" del objeto
     */
    public int getX() {
        return x;
    }

    /**
     *  Retorna la coordenada "y" del objeto.
     *  @return coordenada "y" del objeto
     */
     public int getY() {
        return y;
    }
}
