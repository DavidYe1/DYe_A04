import org.junit.Assert;
import org.junit.Test;
import unittests.MyClock;

/**
 * Created by @Autor DavidYe on @Version 01.12.2016.
 */
public class TestMyClock {
    MyClock c = new MyClock();
    @Test
    public void testKonstruktor(){
        new MyClock();
        String t = c.showTime();

        Assert.assertEquals("0:0:0",t);
    }
    @Test

    public void testSetTime(){
        c.setTime(1,2,3);
        String t = c.showTime();

        Assert.assertEquals("1:2:3",t);
    }
    @Test
    /**
     * tick setzt nicht auf 0:0:0 wenn 23:59:59 erhöht wird
     * d.h. mit einer tick in einer schleife kann man unendlich
     * hoch gehen
     */
    public void testTick(){
        c.setTime(23,59,59);
        c.tick();
        String t = c.showTime();

        Assert.assertEquals("0:0:0",t);
    }
    @Test
    public void testshowTime(){
        String t = new MyClock().showTime();

        Assert.assertEquals("0:0:0",t);
    }
    @Test
    public void testGetTime(){
        c.setTime(1,2,3);
        int[] a = {1,2,3};

        Assert.assertArrayEquals(a,c.getTime());
    }
    @Test(expected = IllegalArgumentException.class)
    public void testNegativWert(){
        c.setTime(-1,0,0);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testOvertimeStunde(){
        c.setTime(25,0,0);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testOvertimeMinute(){
        c.setTime(0,90,0);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testOvertimeSecond(){
        c.setTime(0,0,90);
    }
    @Test
    public void testTickMinute(){
        c.setTime(0,0,59);
        c.tick();
        String t = c.showTime();

        Assert.assertEquals("0:1:0",t);
    }
    @Test
    public void testTickStunde(){
        c.setTime(0,59,59);
        c.tick();
        String t = c.showTime();

        Assert.assertEquals("1:0:0",t);
    }
}
