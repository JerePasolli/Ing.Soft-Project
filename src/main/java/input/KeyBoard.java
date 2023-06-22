package input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyBoard implements KeyListener {

    private final boolean[] keys = new boolean[256];
    public static boolean UP, DOWN, LEFT, RIGHT, ESCAPE, SPACE;

    /**
     *  Constructor de la clase, setea las teclas de control en "false".
     */
    public KeyBoard(){
        UP = false;
        DOWN = false;
        RIGHT = false;
        LEFT = false;
        ESCAPE = false;
        SPACE = false;

    }

    /**
     *  Actualiza el estado de la entrada por teclado por parte del usuario.
     */
    public void update(){
        UP = keys[KeyEvent.VK_UP];
        DOWN = keys[KeyEvent.VK_DOWN];
        LEFT = keys[KeyEvent.VK_LEFT];
        RIGHT = keys[KeyEvent.VK_RIGHT];
        ESCAPE = keys[KeyEvent.VK_ESCAPE];
        SPACE = keys[KeyEvent.VK_SPACE];
    }

    /**
     *  Identifica que tecla se presiona del teclado.
     *  @param e tecla presionada del teclado
     */
    @Override
    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()] = true;
    }

    /**
     *  Identifica que tecla se deja de presionar del teclado.
     *  @param e tecla soltada del teclado
     */
    @Override
    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()] = false;
    }

    @Override
    public void keyTyped(KeyEvent e) {}
}
