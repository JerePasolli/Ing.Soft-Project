package graphics;

import java.awt.*;

public class Assets {

    public static Image heart;
    public static Image ghost;
    public static Image up;
    public static Image down;
    public static Image left;
    public static Image right;

    public static void init(){
        down = Loader.ImageLoader("../../res/images/down.gif");
        up = Loader.ImageLoader("../../res/images/up.gif");
        left = Loader.ImageLoader("../../res/images/left.gif");
        right = Loader.ImageLoader("../../res/images/right.gif");
        ghost = Loader.ImageLoader("../../res/images/ghost.gif");
        heart = Loader.ImageLoader("../../res/images/heart.gif");
    }
}
