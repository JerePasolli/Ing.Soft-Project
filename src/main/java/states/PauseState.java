package states;

import graphics.Text;
import input.KeyBoard;
import constants.Constants;
import graphics.Assets;
import math.Vector2D;
import ui.Action;
import ui.Button;

import javax.swing.ImageIcon;
import java.awt.*;
import java.util.ArrayList;


/**
 * La clase que muestra el menu de pausa
 */
public class PauseState extends State {


    /**
     * Contiene los botones
     */
    private final ArrayList<Button> buttons;
    private GameState gameState;

    /**
     * El constructor de la clase, genera las vistas.
     * @param gameState el estado del juego
     */
    public PauseState(GameState gameState){
        this.gameState = gameState;
        buttons = new ArrayList<Button>();
        buttons.add(new Button(Assets.greyButton, Assets.yellowButton,
                Constants.CANVAS_WIDTH / 2 - new ImageIcon(Assets.greyButton).getIconWidth() / 2,
                Constants.CANVAS_HEIGHT / 2 - new ImageIcon(Assets.greyButton).getIconHeight(),
                Constants.RESUME,
                () -> State.changeState(gameState)
        ));

        buttons.add(new Button(Assets.greyButton, Assets.yellowButton,
                Constants.CANVAS_WIDTH / 2 - new ImageIcon(Assets.greyButton).getIconWidth() / 2,
                Constants.CANVAS_HEIGHT / 2 - new ImageIcon(Assets.greyButton).getIconHeight() * 3,
                Constants.MAIN_MENU,
                () -> State.changeState(new MenuState())
        ));
    }
    @Override
    public void update() {
        if(KeyBoard.SPACE) changeState(this.gameState);
        for(Button b: buttons){
            b.update();
        }
    }

    /**
     * Dibuja las vistas en pantalla
     * @param g la ruta de la screen donde se visualizaran las vistas
     */
    @Override
    public void draw(Graphics g) {
        for(Button b: buttons){
            b.draw(g);
        }
        Vector2D pausePos = new Vector2D(
                Constants.SCREEN_SIZE / 6,
                40
        );
        Text.drawText(g, Constants.PAUSE, pausePos, true, Color.YELLOW, Assets.fontMed);

    }
}
