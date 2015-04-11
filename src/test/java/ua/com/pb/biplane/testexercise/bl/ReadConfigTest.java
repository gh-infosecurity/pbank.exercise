package ua.com.pb.biplane.testexercise.bl;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import static org.junit.Assert.*;

/**
 * Created by artur on 11.04.15.
 */
public class ReadConfigTest {

    String CONFIG_FILE = "src/test/resources/config.properties";
    String MISSING_FILE = "/missing/path/foo.properties";
    Properties expectedProp;

    @Before
    public void SetUp() throws IOException {
        expectedProp = new Properties();
        expectedProp.setProperty("database", "localhost");
        expectedProp.setProperty("dbuser", "mkyong");
        expectedProp.setProperty("dbpassword", "password");
        ReadConfig.setConfig(expectedProp, CONFIG_FILE);
    }

    @Test
    public void testSetConfig() throws Exception {
        ReadConfig.setConfig(expectedProp, CONFIG_FILE);
        assertTrue(new File(CONFIG_FILE).exists());
    }

    @Test(expected = FileNotFoundException.class)
    public void testSetConfig_FNF() throws Exception {
        ReadConfig.setConfig(expectedProp, MISSING_FILE);
    }

    @Test
    public void testGetConfig_true() throws Exception {
        Properties prop = ReadConfig.getConfig(CONFIG_FILE);
        assertEquals(prop, expectedProp);
    }

    @Test
    public void testGetConfig_false() throws Exception {

        Properties prop = ReadConfig.getConfig(CONFIG_FILE);
        expectedProp.setProperty("database", "PostgreSQL");
        assertFalse(prop.equals(expectedProp));
    }

    @Test(expected = FileNotFoundException.class)
    public void testGetConfig_IOEx() throws Exception {
        ReadConfig.getConfig(MISSING_FILE);
    }
}