package ui;

import graphics.Assets;
import graphics.Text;
import input.Mouse;
import math.Vector2D;

import javax.swing.*;
import java.awt.*;

public class Button {
    private final Image mouseOutImage;
    private final Image mouseInImage;
    private boolean mouseIn;
    private final Rectangle box;
    private final String text;
    private final Action action;

    /**
     *  Constructor de la clase. Crea un boton con la apariencia y el texto que recibe como parámetros. Además
     *  se le define una acción al presionarlo mediante la interfaz Action.
     *  @param mouseOutImage imagen del boton cuando el mouse no esta encima de este
     *  @param mouseInImage imagen del boton cuando el mouse esta encima de este
     *  @param x coordenada "x" del boton
     *  @param y coordenada "y" del boton
     *  @param text texto que se muestra sobre el boton
     *  @param action accion que realiza el boton
     */
    public Button(Image mouseOutImage, Image mouseInImage, int x, int y, String text, Action action) {
        this.mouseOutImage = mouseOutImage;
        this.mouseInImage = mouseInImage;
        this.text = text;
        box = new Rectangle(x, y, new ImageIcon(mouseInImage).getIconWidth(), new ImageIcon(mouseInImage).getIconHeight());
        this.action = action;
    }

    /**
     *  Actualiza el estado del boton segun la ubicacion del mouse y si se encuentra presionado o no.
     */
    public void update(){
        mouseIn = box.contains(Mouse.x, Mouse.y);

        if(mouseIn && Mouse.mouseLeftButton){
            action.doAction();
        }
    }

    /**
     *  Cambia la apariencia del boton dependiendo de si el mouse esta encima de el o no, y dibuja el texto.
     */
    public void draw(Graphics g){
        if(mouseIn){
            g.drawImage(mouseInImage, box.x, box.y, null);
        }
        else{
            g.drawImage(mouseOutImage, box.x, box.y, null);
        }

        Text.drawText(g, text, new Vector2D((int) (box.getX() + box.getWidth() / 2), (int) (box.getY() + box.getHeight())), true, Color.BLACK, Assets.fontMed);
    }
}
