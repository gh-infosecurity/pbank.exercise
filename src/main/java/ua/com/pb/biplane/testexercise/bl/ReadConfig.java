package ua.com.pb.biplane.testexercise.bl;


import java.io.*;
import java.util.Properties;

/**
 * Created by artur on 11.04.15.
 */
public class ReadConfig {
    static Properties prop = new Properties();
    static OutputStream output = null;
    static InputStream input = null;
    static String CONFIG_FILE = "src/main/resources/config.properties";

    public static void setConfig(Properties prop, String confPath) throws IOException {
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

    public static Properties getConfig(String confPath) throws IOException {
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
