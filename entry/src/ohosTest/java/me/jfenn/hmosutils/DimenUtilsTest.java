package me.jfenn.hmosutils;

import junit.framework.TestCase;
import ohos.aafwk.ability.delegation.AbilityDelegatorRegistry;
import ohos.app.Context;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotEquals;

public class DimenUtilsTest extends TestCase {

    private Context context;

    @Before
    public void setUp() {
        context = AbilityDelegatorRegistry.getAbilityDelegator().getAppContext();

    }

    @Test
    public void testDpToPx() {
        int px = DimenUtils.dpToPx(context,30);
        assertEquals(60,px);
    }

    @Test
    public void testDpToPx1() {
        int px = DimenUtils.dpToPx(context,30);
        assertNotEquals(30,px);
    }

    @Test
    public void testPxToDp() {
        int dp = (int) DimenUtils.pxToDp(context, 30);
        assertEquals(15,dp);
    }

    @Test
    public void testPxToDp1() {
        int dp = (int) DimenUtils.pxToDp(context, 30);
        assertNotEquals(30,dp);
    }


    @Test
    public void testSpToPx() {
        int px = DimenUtils.spToPx(context,30);
        assertEquals(60,px);
    }

    @Test
    public void testSpToPx1() {
        int px = DimenUtils.spToPx(context,30);
        assertNotEquals(30,px);
    }

    @Test
    public void testPxToSp() {
        int dp = (int) DimenUtils.pxToSp(context, 30);
        assertEquals(15,dp);
    }

    @Test
    public void testPxToSp1() {
        int dp = (int) DimenUtils.pxToSp(context, 30);
        assertNotEquals(30,dp);
    }


    public void tearDown() throws Exception {
        //this method is empty
    }
}