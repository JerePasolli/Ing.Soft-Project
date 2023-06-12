package graphics;

import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;

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

    public static void init(){
        down = Loader.ImageLoader("././res/images/down.gif");
        up = Loader.ImageLoader("././res/images/up.gif");
        left = Loader.ImageLoader("././res/images/left.gif");
        right = Loader.ImageLoader("././res/images/right.gif");
        ghost = Loader.ImageLoader("././res/images/ghost.gif");
        heart = Loader.ImageLoader("././res/images/heart.png");
        fontBig = Loader.FontLoader("././res/fonts/kenvector_future.ttf",42);
        fontMed = Loader.FontLoader("././res/fonts/kenvector_future.ttf",20);
        fontSmall = Loader.FontLoader("././res/fonts/kenvector_future.ttf",10);
        greyButton = Loader.ImageLoader("././res/ui/grey_button00.png");
        yellowButton = Loader.ImageLoader("././res/ui/yellow_button00.png");
        //backgroundMusic = Loader.SoundLoader("././res/sounds/pacman-song.mp3");
    }
}
