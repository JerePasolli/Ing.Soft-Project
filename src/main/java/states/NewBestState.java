package states;

import constants.Constants;
import graphics.Assets;
import graphics.Text;
import io.JSONMaker;
import io.ScoreData;
import math.Vector2D;
import ui.Button;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


/**
 * Clase que se encarga de mostrar el panel que indica el puntaje obtenido por el jugador
 */
public class NewBestState extends State{

private ScoreData newBest;
private JSONMaker jsonMaker;
private final Button returnButton;


    /**
     * El constructor de la clase, se genera el boton de return y el creador de JSON
     * @param scoreData el puntaje obtenido
     */
    public NewBestState(ScoreData scoreData){

      returnButton = new Button(
                Assets.greyButton,
                Assets.yellowButton,
                0,
                Constants.CANVAS_HEIGHT - 50,
                Constants.MAIN_MENU,
                () -> State.changeState(new MenuState())
        );

      this.newBest = scoreData;
      jsonMaker = JSONMaker.getInstance();
      jsonMaker.write(scoreData.getDate(), scoreData.getScore());
    }

    @Override
    public void update() {
        returnButton.update();
    }


    /**
     * Dibuja las vistas en la pantalla
     * @param g el acceso a la screen donde se colocan las vistas
     */
    @Override
    public void draw(Graphics g) {

                returnButton.draw(g);

         Vector2D newBestTitlePos = new Vector2D(
                Constants.CANVAS_WIDTH / 2,
                50
        );
        Vector2D newBestPos = new Vector2D(
                Constants.CANVAS_WIDTH / 2,
                100
        );
         Vector2D datePos = new Vector2D(
                Constants.CANVAS_WIDTH / 3,
                150
        );
         Vector2D dateMessagePos = new Vector2D(
                Constants.CANVAS_WIDTH / 3,
                150
        );
         Vector2D newBestMessagePos = new Vector2D(
                Constants.CANVAS_WIDTH / 3,
                150
        );

         if(jsonMaker.isBest()){
             Text.drawText(g, Constants.NEW_BEST_MESSAGE, newBestTitlePos, true, Color.YELLOW, Assets.fontMed);
             Text.drawText(g, String.valueOf(this.newBest.getScore()), newBestPos, true, Color.YELLOW, Assets.fontMed);
             Text.drawText(g, String.valueOf(this.newBest.getDate()), datePos, true, Color.YELLOW, Assets.fontSmall);
             Text.drawText(g, String.valueOf(this.newBest.getDate()), dateMessagePos, true, Color.YELLOW, Assets.fontSmall);
             Text.drawText(g, String.valueOf(this.newBest.getDate()), newBestMessagePos, true, Color.YELLOW, Assets.fontSmall);
         }else{
             Text.drawText(g, Constants.MESSAGE_DEFAULT, newBestTitlePos, true, Color.YELLOW, Assets.fontMed);
             Text.drawText(g, String.valueOf(this.newBest.getScore()), newBestPos, true, Color.YELLOW, Assets.fontMed);
             Text.drawText(g, String.valueOf(this.newBest.getDate()), datePos, true, Color.YELLOW, Assets.fontSmall);
             Text.drawText(g, String.valueOf(this.newBest.getDate()), dateMessagePos, true, Color.YELLOW, Assets.fontSmall);
             Text.drawText(g, String.valueOf(this.newBest.getDate()), newBestMessagePos, true, Color.YELLOW, Assets.fontSmall);
         }




    }
}
