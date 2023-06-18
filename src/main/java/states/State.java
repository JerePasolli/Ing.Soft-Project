package states;

import java.awt.*;

public abstract class State {
    private static State currentState = null;
    public abstract void update();
    public abstract void draw(Graphics g);
    public static State getCurrentState() {
        return currentState;
    }
    public static void changeState(State newState){
        try{
            Thread.sleep(100);
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }
        currentState = newState;
    }
}
