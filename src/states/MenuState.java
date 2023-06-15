package states;

import constants.Constants;
import graphics.Assets;
import ui.Action;
import ui.Button;

import javax.swing.ImageIcon;
import java.awt.*;
import java.util.ArrayList;

public class MenuState extends State {

    private final ArrayList<Button> buttons;

    public MenuState(){
        buttons = new ArrayList<Button>();

        buttons.add(new Button(Assets.greyButton, Assets.yellowButton,
                Constants.CANVAS_WIDTH / 2 - new ImageIcon(Assets.greyButton).getIconWidth() / 2,
                Constants.CANVAS_HEIGHT / 2 - new ImageIcon(Assets.greyButton).getIconHeight(),
                Constants.PLAY,
                new Action(){
                    @Override
                    public void doAction(){
                        State.changeState(new GameState());
                    }
                }
                ));

        buttons.add(new Button(Assets.greyButton, Assets.yellowButton,
                Constants.CANVAS_WIDTH / 2 - new ImageIcon(Assets.greyButton).getIconWidth() / 2,
                Constants.CANVAS_HEIGHT / 2 + new ImageIcon(Assets.greyButton).getIconHeight() / 2,
                Constants.EXIT,
                new Action(){
                    @Override
                    public void doAction(){
                        System.exit(0);
                    }
                }
        ));
    }

    @Override
    public void update() {
        for(Button b: buttons){
            b.update();
        }
    }

    @Override
    public void draw(Graphics g) {
        for(Button b: buttons){
            b.draw(g);
        }
    }
}
