import org.junit.Assert;
import org.junit.Test;
import unittests.MyClock;

/**
 * Created by @Autor DavidYe on @Version 01.12.2016.
 */
public class TestMyClock {
    @Test
    public void testKonstruktor(){
        MyClock c1 = new MyClock();
        String t = c1.showTime();

        Assert.assertEquals("0:0:0",t);
    }
    public void testK
}
