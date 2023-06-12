package input;
import java.util.Arrays;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyBoard implements KeyListener {

    private final boolean[] keys = new boolean[256];
    public static boolean UP, DOWN, LEFT, RIGHT;
    public KeyBoard(){
        UP = false;
        DOWN = false;
        RIGHT = false;
        LEFT = false;
    }

    public void update(){
        UP = keys[KeyEvent.VK_UP];
        DOWN = keys[KeyEvent.VK_DOWN];
        LEFT = keys[KeyEvent.VK_LEFT];
        RIGHT = keys[KeyEvent.VK_RIGHT];
    }

    @Override
    public void keyPressed(KeyEvent e) {
        //keys[e.getKeyCode()] = true;
        Arrays.fill(keys,false);
        keys[e.getKeyCode()]=true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //keys[e.getKeyCode()] = false;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }
}
