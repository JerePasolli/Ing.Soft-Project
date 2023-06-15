package states;

import input.KeyBoard;
import constants.Constants;
import graphics.Assets;
import ui.Action;
import ui.Button;

import javax.swing.ImageIcon;
import java.awt.*;
import java.util.ArrayList;

public class PauseState extends State {

    private final ArrayList<Button> buttons;
    private GameState gameState;

    public PauseState(GameState gameState){
        this.gameState = gameState;
        buttons = new ArrayList<Button>();
        buttons.add(new Button(Assets.greyButton, Assets.yellowButton,
                Constants.CANVAS_WIDTH / 2 - new ImageIcon(Assets.greyButton).getIconWidth() / 2,
                Constants.CANVAS_HEIGHT / 2 - new ImageIcon(Assets.greyButton).getIconHeight(),
                Constants.RESUME,
                new Action(){
                    @Override
                    public void doAction(){
                        State.changeState(gameState);
                    }
                }
        ));
    }
    @Override
    public void update() {
        if(KeyBoard.SPACE) changeState(this.gameState);
        for(Button b: buttons){
            b.update();
        }
    }

    @Override
    public void draw(Graphics g) {
        for(Button b: buttons){
            b.draw(g);
        }
    g.setColor(Color.yellow);
    g.drawString(Constants.PAUSE, Constants.SCREEN_SIZE / 6, 40);

    }
}
