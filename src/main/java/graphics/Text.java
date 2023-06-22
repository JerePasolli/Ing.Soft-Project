package graphics;

import math.Vector2D;

import java.awt.*;

public class Text {

    /**
     *  Dibuja un textom en la posicion indicada, utilizando la fuente indicada, y puede estar centrado o no.
     *  @param g graficos para dibujar en el canvas
     *  @param text texto a graficar
     *  @param pos coordenadas con la posicion donde colocar el texto
     *  @param center indica si el texto debe ir centrado o no
     *  @param color indica el color del texto
     *  @param font indica la fuente a utilizar para dibujar el texto
     */
    public static void drawText(Graphics g, String text, Vector2D pos, boolean center, Color color, Font font){
        g.setColor(color);
        g.setFont(font);
        Vector2D position = new Vector2D(pos.getX(), pos.getY());
        if(center){
            FontMetrics fm = g.getFontMetrics();
            position.setX(position.getX() - fm.stringWidth(text) / 2);
            position.setY(position.getY() - fm.getHeight());
        }
        g.drawString(text, position.getX(), position.getY());
    }
}
