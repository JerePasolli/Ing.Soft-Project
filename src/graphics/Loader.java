package graphics;

import javax.swing.*;
import java.awt.*;

public class Loader {

    public static Image ImageLoader(String path){
        return new ImageIcon(path).getImage();
    }
}
