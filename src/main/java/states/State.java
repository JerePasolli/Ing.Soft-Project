package states;

import java.awt.*;

public abstract class State {
    private static State currentState = null;
    public abstract void update();
    public abstract void draw(Graphics g);

    /**
     *  Retorna el estado (pantalla) en el que se encuentra el juego.
     *  @return estado actual del juego
     */
    public static State getCurrentState() {
        return currentState;
    }

    /**
     *  Permite cambiar el estado del juego en tiempo de ejecucion.
     *  @param newState estado del juego al que se quiere cambiar
     */
    public static void changeState(State newState){
        try{
            Thread.sleep(200);
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }
        currentState = newState;
    }
}
