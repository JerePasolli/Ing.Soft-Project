package states;

import constants.Constants;
import graphics.Assets;
import graphics.Sound;
import ui.Action;
import ui.Button;

import javax.swing.ImageIcon;
import java.awt.*;
import java.util.ArrayList;

public class MenuState extends State {

    private final ArrayList<Button> buttons;
    private Sound music;

    public MenuState(){
        buttons = new ArrayList<Button>();

        buttons.add(new Button(Assets.greyButton, Assets.yellowButton,
                Constants.CANVAS_WIDTH / 2 - new ImageIcon(Assets.greyButton).getIconWidth() / 2,
                Constants.CANVAS_HEIGHT / 2 - new ImageIcon(Assets.greyButton).getIconHeight() * 3,
                Constants.PLAY,
                () -> {
                    music.stop();
                    State.changeState(new GameState());
                }
        ));

        buttons.add(new Button(Assets.greyButton, Assets.yellowButton,
                Constants.CANVAS_WIDTH / 2 - new ImageIcon(Assets.greyButton).getIconWidth() / 2,
                Constants.CANVAS_HEIGHT / 2 + new ImageIcon(Assets.greyButton).getIconHeight() * 3,
                Constants.EXIT,
                () -> System.exit(0)
        ));

        buttons.add(new Button(
                Assets.greyButton,
                Assets.yellowButton,
                Constants.CANVAS_WIDTH / 2 - new ImageIcon(Assets.greyButton).getIconWidth() / 2,
                Constants.CANVAS_HEIGHT / 2 - 50,
                Constants.HIGH_SCORES,
                () -> {
                    music.stop();
                    State.changeState(new ScoreState());
                }
        ));

        buttons.add(new Button(
                Assets.greyButton,
                Assets.yellowButton,
                Constants.CANVAS_WIDTH / 2 - new ImageIcon(Assets.greyButton).getIconWidth() / 2,
                Constants.CANVAS_HEIGHT / 2 + 50,
                Constants.HELP,
                () -> {
                    music.stop();
                    State.changeState(new HelpState());
                }
        ));

        music = new Sound(Assets.backgroundMusic);
        music.play();
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
