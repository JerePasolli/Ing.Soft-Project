package graphics;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

public class AssetsTest {

    @Test
    public void resourcesTest(){
        Assets.init();
        assertNotNull(Assets.fontMed);
        assertNotNull(Assets.fontBig);
        assertNotNull(Assets.fontSmall);
        assertNotNull(Assets.down);
        assertNotNull(Assets.up);
        assertNotNull(Assets.left);
        assertNotNull(Assets.right);
        assertNotNull(Assets.ghost);
        assertNotNull(Assets.heart);
        assertNotNull(Assets.greyButton);
        assertNotNull(Assets.yellowButton);
        assertNotNull(Assets.backgroundMusic);
        assertNotNull(Assets.death);
        assertNotNull(Assets.ghostm);
        assertNotNull(Assets.eatMusic1);
        assertNotNull(Assets.eatMusic2);
    }

}
