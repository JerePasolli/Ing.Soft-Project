package gameObjects;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ChronometerTest {
    
    @Test
    public void chronometerTest(){
        Chronometer cronometro=new Chronometer();

        Assertions.assertEquals(cronometro.getLastTime(), 0);
        Assertions.assertFalse(cronometro.isRunning());

        cronometro.run(50);
        Assertions.assertEquals(cronometro.getTime(), 50);
        Assertions.assertTrue(cronometro.isRunning());
        
    }
}
