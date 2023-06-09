package states;

import constants.Constants;
import graphics.Assets;
import graphics.Text;
import math.Vector2D;
import ui.Button;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


/**
 * Clase que se encarga de mostrar el menu de ayuda al jugador
 */
public class HelpState extends State{

    private final Button returnButton;


    /**
     * El constructor
     */
    public HelpState(){
        returnButton = new Button(
                Assets.greyButton,
                Assets.yellowButton,
                0,
                Constants.CANVAS_HEIGHT - 50,
                Constants.RETURN,
                () -> State.changeState(new MenuState())
        );
    }

    @Override
    public void update() {
        returnButton.update();
    }


    /**
     * Dibuja en pantalla las vistas
     * @param g la referencia a la screen donde se dibujan las vistas
     */
    @Override
    public void draw(Graphics g) {
        returnButton.draw(g);

        Vector2D helpTitlePos = new Vector2D(
                Constants.CANVAS_WIDTH / 2,
                50
        );
        Vector2D help1Pos = new Vector2D(
                Constants.CANVAS_WIDTH / 2,
                100
        );
        Vector2D help2Pos = new Vector2D(
                Constants.CANVAS_WIDTH / 2,
                150
        );
        Vector2D help3Pos = new Vector2D(
                Constants.CANVAS_WIDTH / 2,
                200
        );
        Vector2D help4Pos = new Vector2D(
                Constants.CANVAS_WIDTH / 2,
                250
        );

        Text.drawText(g, Constants.HELP, helpTitlePos, true, Color.YELLOW, Assets.fontMed);
        Text.drawText(g, Constants.HELPLINE1, help1Pos, true, Color.YELLOW, Assets.fontSmall);
        Text.drawText(g, Constants.HELPLINE2, help2Pos, true, Color.YELLOW, Assets.fontSmall);
        Text.drawText(g, Constants.HELPLINE3, help3Pos, true, Color.YELLOW, Assets.fontSmall);
        Text.drawText(g, Constants.HELPLINE4, help4Pos, true, Color.YELLOW, Assets.fontSmall);
    }
}
