package states;

import constants.Constants;
import graphics.Assets;
import graphics.Text;
import io.JSONMaker;
import io.ScoreData;
import math.Vector2D;
import ui.Action;
import ui.Button;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Arrays;

/**
 * La clase que muestra los diez puntajes más altos
 */
public class ScoreState extends State{
    private Comparator<ScoreData> scoreComparator;
    private ScoreData[] scoreDataArr;
    private final Button returnButton;
    private JSONMaker json;

    /**
     * El constructor de la clase. Genera las vistas
     */
    public ScoreState(){
        returnButton = new Button(
                Assets.greyButton,
                Assets.yellowButton,
                0,
                Constants.CANVAS_HEIGHT - 50,
                Constants.RETURN,
                () -> State.changeState(new MenuState())
        );

        scoreComparator = new Comparator<ScoreData>() {

            @Override
            public int compare(ScoreData o1, ScoreData o2) {
                return o1.getScore() < o2.getScore() ? -1: o1.getScore() > o2.getScore() ? 1 : 0;
            }
            
        };
        this.json = JSONMaker.getInstance();
        this.scoreDataArr = json.getScoreData().toArray(new ScoreData[json.getScoreData().size()]);  
        Arrays.sort(scoreDataArr, scoreComparator); 
        if(scoreDataArr.length > 5) scoreDataArr = Arrays.copyOfRange(scoreDataArr, scoreDataArr.length - 5, scoreDataArr.length); 
     }


    /**
     * La funcion que actualiza el boton
     */
    @Override
    public void update() {
        returnButton.update();
    }


    /**
     * Dibuja las vistas en pantalla
     * @param g la referencia de la screen donde se mostrarán las vistas
     */
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

        scorePos.setY(scorePos.getY() + 40);
        datePos.setY(datePos.getY() + 40);

        for(int i = scoreDataArr.length - 1; i > -1; i--){
            ScoreData d = scoreDataArr[i];

                    Text.drawText(g, Integer.toString(d.getScore()), scorePos, true, Color.YELLOW, Assets.fontMed);
                    Text.drawText(g, d.getDate(), datePos, true, Color.YELLOW, Assets.fontMed);

        scorePos.setY(scorePos.getY() + 40);
        datePos.setY(datePos.getY() + 40);
        }

    }
}