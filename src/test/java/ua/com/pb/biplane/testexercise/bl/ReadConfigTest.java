package ua.com.pb.biplane.testexercise.bl;

import org.junit.Before;
import org.junit.Test;
import ua.com.pb.biplane.testexercise.input.ReadConfig;

import java.io.*;
import java.util.Properties;

import static org.junit.Assert.*;

/**
 * Created by artur on 11.04.15.
 */
public class ReadConfigTest{

    ReadConfig readConfig = new ReadConfig();
    OutputStream output = null;
    String CONFIG_FILE = "src/test/resources/config.properties";
    String MISSING_FILE = "/missing/path/foo.properties";
    Properties expectedProp;


    @Before
    public void SetUp() throws IOException {
        expectedProp = new Properties();
        expectedProp.setProperty("database", "localhost");
        expectedProp.setProperty("dbuser", "mkyong");
        expectedProp.setProperty("dbpassword", "password");
        setConfig(expectedProp, CONFIG_FILE);
    }

    @Test
    public void testSetConfig() throws Exception {
        setConfig(expectedProp, CONFIG_FILE);
        assertTrue(new File(CONFIG_FILE).exists());
    }

    @Test(expected = FileNotFoundException.class)
    public void testSetConfig_FNF() throws Exception {
        setConfig(expectedProp, MISSING_FILE);
    }

    @Test
    public void testGetConfig_true() throws Exception {
        Properties prop = readConfig.getConfig(CONFIG_FILE);
        assertEquals(prop, expectedProp);
    }

    @Test
    public void testGetConfig_false() throws Exception {

        Properties prop = readConfig.getConfig(CONFIG_FILE);
        expectedProp.setProperty("database", "PostgreSQL");
        assertFalse(prop.equals(expectedProp));
    }

    @Test(expected = FileNotFoundException.class)
    public void testGetConfig_IOEx() throws Exception {
        readConfig.getConfig(MISSING_FILE);
    }

    /**
     * Method writes this property list (key and element pairs) in choosen
     * output stream.
     *
     * @param prop      Properties obj fo write
     * @param confPath  File system Path to write Properties file
     * @throws IOException  IOException if writing this property list to the specified
     *                      output stream throws an IOException.
     */
    private void setConfig(Properties prop, String confPath) throws IOException {
        if (confPath!=null)
            CONFIG_FILE = confPath;
        try {

            output = new FileOutputStream(CONFIG_FILE);
            prop.store(output, null);

        } catch (IOException ex) {
            throw new FileNotFoundException(ex.getMessage());
        } finally {
            if (output != null) {
                try {
                    output.close();
                } catch (IOException e) {
                    throw new IOException(e.getMessage());
                }
            }
        }
    }
}