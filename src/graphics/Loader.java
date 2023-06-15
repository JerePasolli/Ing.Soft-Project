package graphics;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Objects;

public class Loader {

    public static Image ImageLoader(String path){
        return new ImageIcon(path).getImage();
    }
    /*public static Font FontLoader(String path, int size){
        try{
            return Font.createFont(Font.TRUETYPE_FONT, Loader.class.getResourceAsStream(path)).deriveFont(Font.PLAIN, size);
        }
        catch(FontFormatException | IOException e){
            e.printStackTrace();
            return null;
        }
    }
    public static Clip SoundLoader(String path){
        try{
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(Loader.class.getResource(path)));
            return clip;
        }
        catch(LineUnavailableException | IOException | UnsupportedAudioFileException e){
            e.printStackTrace();
        }
        return null;
    }*/
}
