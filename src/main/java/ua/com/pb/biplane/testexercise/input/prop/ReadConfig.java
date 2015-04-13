package ua.com.pb.biplane.testexercise.input.prop;


import java.io.*;
import java.util.Properties;

/**
 * Created by artur on 11.04.15.
 */

public class ReadConfig {
    Properties prop = new Properties();
    InputStream input = null;
    String CONFIG_FILE = "src/main/resources/config.properties";

    /**
     * Method for read properties object from config.properties file
     *
     * @param confPath  Path to config.properties file
     * @return          Properties object from config.properties file
     * @throws IOException
     */
    public Properties getConfig(String confPath) throws IOException {
        if (confPath!=null)
            CONFIG_FILE = confPath;

        try {
            input = new FileInputStream(CONFIG_FILE);
            prop.load(input);
        } catch (IOException ex) {
            throw new FileNotFoundException(ex.getMessage());
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    throw new IOException(e.getMessage());
                }
            }
        }
        return prop;
    }
}
