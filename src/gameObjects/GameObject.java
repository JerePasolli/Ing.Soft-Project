package gameObjects;
import java.awt.*;

import states.GameState;

public abstract class GameObject {

    protected Image texture;
    protected int x,y;

    public GameObject(int x,int y, Image texture){
        this.x=x;
        this.y=y;
        this.texture = texture;
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
