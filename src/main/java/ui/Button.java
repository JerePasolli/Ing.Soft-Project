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

    public Button(Image mouseOutImage, Image mouseInImage, int x, int y, String text, Action action) {
        this.mouseOutImage = mouseOutImage;
        this.mouseInImage = mouseInImage;
        this.text = text;
        box = new Rectangle(x, y, new ImageIcon(mouseInImage).getIconWidth(), new ImageIcon(mouseInImage).getIconHeight());
        this.action = action;
    }

    public void update(){
        mouseIn = box.contains(Mouse.x, Mouse.y);

        if(mouseIn && Mouse.mouseLeftButton){
            action.doAction();
        }
    }

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
