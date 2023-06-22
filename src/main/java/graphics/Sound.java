package graphics;

import javax.sound.sampled.Clip;

public class Sound {
    private Clip clip;

    /**
     *  Constructor de la clase, se encarga de inicializar un sonido con un archivo de audio como parametro.
     *  @param clip clip para crear sonido
     */
    public Sound(Clip clip){
        this.clip = clip;
    }

    /**
     *  Reproduce un audio desde el comienzo
     */
    public void play(){
        clip.setFramePosition(0);
        clip.start();
    }

    /**
     *  Detiene un sonido
     */
    public void stop(){
        clip.stop();
    }

    /**
     *  Reproduce un sonido en bucle.
     */
    public void loopClip(){
        clip.setFramePosition(0);
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
}
