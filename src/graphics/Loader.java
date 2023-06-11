package graphics;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Objects;

public class Loader {

    public static Image ImageLoader(String path){
        return new ImageIcon(path).getImage();
    }
    public static Font FontLoader(String path, int size){
        try{
            return Font.createFont(Font.TRUETYPE_FONT, Loader.class.getResourceAsStream(path)).deriveFont(Font.PLAIN, size);
        }
        catch(FontFormatException | IOException e){
            e.printStackTrace();
            return null;
        }
    }
}
