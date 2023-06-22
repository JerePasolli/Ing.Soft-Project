package input;

import javax.swing.event.MouseInputListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Mouse extends MouseAdapter {

    public static int x, y;
    public static boolean mouseLeftButton;

    /**
     *  Identifica que boton del mouse se presiona.
     *  @param e boton presionado del mouse
     */
    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getButton() == MouseEvent.BUTTON1){
            mouseLeftButton = true;
        }
    }

    /**
     *  Identifica que boton del mouse se suelta.
     *  @param e boton soltado del mouse
     */
    @Override
    public void mouseReleased(MouseEvent e) {
        if(e.getButton() == MouseEvent.BUTTON1){
            mouseLeftButton = false;
        }
    }

    /**
     *  Identifica que boton del mouse se mantiene presionado al mover el mouse.
     *  @param e boton presionado mientras se arrastra el mouse
     */
    @Override
    public void mouseDragged(MouseEvent e) {
        x = e.getX();
        y = e.getY();
    }

    /**
     *  Identifica movimientos del mouse.
     *  @param e coordenadas de movimiento del mouse
     */
    @Override
    public void mouseMoved(MouseEvent e) {
        x = e.getX();
        y = e.getY();
    }
}
