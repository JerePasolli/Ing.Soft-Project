package states;

import constants.Constants;
import graphics.Assets;
import graphics.Text;
import math.Vector2D;
import ui.Action;
import ui.Button;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ScoreState extends State{

    private final Button returnButton;

    public ScoreState(){
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

    @Override
    public void draw(Graphics g) {
        returnButton.draw(g);

        Vector2D scorePos = new Vector2D(
                Constants.CANVAS_WIDTH / 2 - 100,
                100
        );
        Vector2D datePos = new Vector2D(
                Constants.CANVAS_WIDTH / 2 + 100,
                100
        );

        Text.drawText(g, Constants.SCORE, scorePos, true, Color.YELLOW, Assets.fontMed);
        Text.drawText(g, Constants.DATE, datePos, true, Color.YELLOW, Assets.fontMed);
    }
}
