package me.jfenn.hmosutils;

import junit.framework.TestCase;
import me.jfenn.hmosutils.anim.AnimatedInteger;
import org.junit.Test;

public class AnimatedIntegerTest extends TestCase {

    public void setUp() throws Exception {
        super.setUp();
    }

    public void tearDown() throws Exception {
        //this method is empty
    }

    @Test
    public void testNextVal() {
        AnimatedInteger animatedInteger;
        animatedInteger = new AnimatedInteger(9);
        float val = animatedInteger.nextVal(2, 4);
        assertEquals(String.valueOf(9.0),String.valueOf(val));
    }
}