package me.jfenn.hmosutils;

import junit.framework.TestCase;
import me.jfenn.hmosutils.anim.AnimatedFloat;
import org.junit.Test;

import static org.junit.Assert.assertNotEquals;

public class AnimatedFloatTest extends TestCase {
    private AnimatedFloat animatedFloat;

    public void setUp() throws Exception {
        super.setUp();
    }

    public void tearDown() throws Exception {
        //this method is empty
    }

    @Test
    public void testNextVal() {
        animatedFloat = new AnimatedFloat(5);
        float val1=animatedFloat.nextVal(2,4);
        assertEquals(String.valueOf(5.0),String.valueOf(val1));
    }

    @Test
    public void testNextVal1() {
        animatedFloat = new AnimatedFloat(20);
        float val1=animatedFloat.nextVal(2,4);
        assertNotEquals(String.valueOf(5.0),String.valueOf(val1));
    }
}