package gameObjects;
import java.awt.*;

import states.GameState;

public abstract class GameObject {

    protected Image texture;
    protected int x,y;
    protected int dx,dy;
    protected GameState gameState;

    public GameObject(int x,int y, Image texture, GameState gameState){
        this.x=x;
        this.y=y;
        this.texture = texture;
        this.gameState=gameState;
    }

    public abstract void update() throws AWTException;
    public abstract void draw(Graphics g);

    public int getX() {
        return x;
    }
     public int getY() {
        return y;
    }

    public void setPosition(int x,int y) {
        this.x=x;
        this.y=y;
    }
}
