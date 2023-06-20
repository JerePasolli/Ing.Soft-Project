import graphics.Loader;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LoaderTest {

    @Test
    public void loadResourcesTest(){
        assertNotNull(Loader.FontLoader("src/main/resources/fonts/Pacmania.ttf",30));
        assertNotNull(Loader.ImageLoader("src/main/resources/images/left.gif"));
        assertNotNull(Loader.SoundLoader("src/main/resources/sounds/pacman-song.wav"));
    }
}
