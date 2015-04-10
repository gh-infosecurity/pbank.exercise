package ua.com.pb.biplane.testexercise.util;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by artur on 09.04.15.
 */
public class ToolsTest {

    Utils tools = new Utils();

    @Test
    public void testContaisOnlyDigit_true() throws Exception {
        assertTrue(tools.containsOnlyDigit("dfgdfgdf"));
    }

    @Test
    public void testContaisOnlyDigit_false() throws Exception {
        assertFalse(tools.containsOnlyDigit("dfgdfd345gdf"));
    }

    @Test
    public void testContaisOnlyNumbers_true() throws Exception {
        assertTrue(tools.containsOnlyNumbers("3454356"));
    }

    @Test
    public void testContaisOnlyNumbers_false() throws Exception {
        assertFalse(tools.containsOnlyDigit("345345jh"));
    }

}