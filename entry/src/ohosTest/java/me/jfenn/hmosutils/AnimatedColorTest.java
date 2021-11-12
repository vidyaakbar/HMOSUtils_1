package me.jfenn.hmosutils;

import junit.framework.TestCase;
import me.jfenn.hmosutils.anim.AnimatedColor;
import org.junit.Test;

import static org.junit.Assert.assertNotEquals;

public class AnimatedColorTest extends TestCase {
    private AnimatedColor animatedColor ;

    public void setUp() throws Exception {
        super.setUp();
    }

    public void tearDown()  {
        //this method is empty
    }

    @Test
    public void testNextVal() {
        animatedColor = new AnimatedColor(5);
        assertEquals(5,animatedColor.nextVal(2));
    }

    @Test
    public void testnextVal1() {
        animatedColor = new AnimatedColor(8);
        assertNotEquals(String.valueOf(5), animatedColor.nextVal(5));
    }

    @Test
    public void testNextVal2() {
        animatedColor = new AnimatedColor(5);
        assertEquals(5,animatedColor.nextVal(2, 4));
    }

    @Test
    public void testNextVal3() {
        animatedColor = new AnimatedColor(6);
        assertNotEquals(String.valueOf(4),animatedColor.nextVal(2, 4));
    }
}