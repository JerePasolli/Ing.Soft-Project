package gameObjects;

import states.GameState;
import java.awt.*;

public abstract class MovingObject extends GameObject{
    protected int dx,dy;
    protected GameState gameState;
    public MovingObject(int x,int y, Image texture,GameState gameState){
        super(x,y,texture);
        this.gameState=gameState;
    }
    @Override
    public void update() throws AWTException {

    }

    @Override
    public void draw(Graphics g) {

    }
}
