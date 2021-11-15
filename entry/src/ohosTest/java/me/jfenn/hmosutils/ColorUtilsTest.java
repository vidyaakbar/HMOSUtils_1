package me.jfenn.hmosutils;

import junit.framework.TestCase;
import ohos.agp.utils.Color;
import org.junit.Test;

public class ColorUtilsTest extends TestCase {
    public void setUp() throws Exception {
        super.setUp();
    }

    public void tearDown() throws Exception {
        //this method is empty
    }

    @Test
    public void testIsColorDark() {
        assertEquals(false,ColorUtils.isColorDark(0xFF46EA55));
    }

    @Test
    public void testWithBackground() {
        assertEquals(0xFF46EA55,ColorUtils.withBackground(0xFF46EA55,0xFF52255A));
    }

    @Test
    public void testChangeParamColor() {
        assertEquals(Color.BLUE,AlphaColorDrawable.changeParamToColor(Color.BLUE.getValue()));
    }
}