package graphics;

import javax.sound.sampled.Clip;

public class Sound {
    private Clip clip;

    public Sound(Clip clip){
        this.clip = clip;
    }
    public void play(){
        clip.setFramePosition(0);
        clip.start();
    }
    public void stop(){
        clip.stop();
    }
    public int getFramePosition(){
        return clip.getFramePosition();
    }
    public void loopClip(){
        clip.setFramePosition(0);
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
}
