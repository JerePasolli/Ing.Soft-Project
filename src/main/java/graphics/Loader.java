package graphics;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Loader {

    /**
     *  Busca y retorna una imagen que se encuentre en el path indicado
     *  @param path path hacia la imagen a cargar
     *  @return imagen encontrada en el path
     */
    public static Image ImageLoader(String path){
        return new ImageIcon(path).getImage();
    }

    /**
     *  Busca y retorna una fuente que se encuentre en el path indicado
     *  @param path path hacia la fuente a cargar
     *  @return fuente encontrada en el path
     */
    public static Font FontLoader(String path, int size){
        try{
            return Font.createFont(Font.TRUETYPE_FONT, new File(path)).deriveFont(Font.PLAIN, size);
        }
        catch(FontFormatException | IOException e){
            e.printStackTrace();
            return null;
        }
    }

    /**
     *  Busca y retorna un clip (audio) que se encuentre en el path indicado
     *  @param path path hacia el archivo de audio a cargar
     *  @return audio encontrado en el path
     */
    public static Clip SoundLoader(String path){
        try{
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(new File(path)));
            return clip;
        }
        catch(LineUnavailableException | IOException | UnsupportedAudioFileException e){
            e.printStackTrace();
        }
        return null;
    }
}
