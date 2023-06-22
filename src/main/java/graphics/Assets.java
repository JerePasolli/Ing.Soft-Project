package graphics;

import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.nio.file.Paths;

public class Assets {

    public static Image heart;
    public static Image ghost;
    public static Image up;
    public static Image down;
    public static Image left;
    public static Image right;
    public static Font fontBig;
    public static Font fontMed;
    public static Font fontSmall;
    public static Image greyButton;
    public static Image yellowButton;
    public static Clip backgroundMusic;
    public static Clip eatMusic1,eatMusic2,ghostm,death;
    public static Image blueGhost;

    /**
     *  Carga todos los recursos del juego.
     */
    public static void init(){
        down = Loader.ImageLoader("./src/main/resources/images/down.gif");
        up = Loader.ImageLoader("./src/main/resources/images/up.gif");
        left = Loader.ImageLoader("./src/main/resources/images/left.gif");
        right = Loader.ImageLoader("./src/main/resources/images/right.gif");
        ghost = Loader.ImageLoader("./src/main/resources/images/ghost.gif");
        heart = Loader.ImageLoader("./src/main/resources/images/heart.png");
        fontBig = Loader.FontLoader("./src/main/resources/fonts/Pacmania.ttf",42);
        fontMed = Loader.FontLoader("./src/main/resources/fonts/8-BIT WONDER.TTF",15);
        fontSmall = Loader.FontLoader("./src/main/resources/fonts/Pacmania.ttf",10);
        greyButton = Loader.ImageLoader("./src/main/resources/ui/grey_button00.png");
        yellowButton = Loader.ImageLoader("./src/main/resources/ui/yellow_button00.png");
        backgroundMusic = Loader.SoundLoader("./src/main/resources/sounds/pacman-song.wav");
        eatMusic1 = Loader.SoundLoader("./src/main/resources/sounds/pacman-waka1.wav");
        eatMusic2 = Loader.SoundLoader("./src/main/resources/sounds/pacman-waka2.wav");
        ghostm = Loader.SoundLoader("./src/main/resources/sounds/pacman-ghost.wav");
        death = Loader.SoundLoader("./src/main/resources/sounds/pacman-death.wav");
        blueGhost = Loader.ImageLoader("./src/main/resources/images/blue-ghost.gif");
    }
}
