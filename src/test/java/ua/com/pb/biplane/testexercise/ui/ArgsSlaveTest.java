package ua.com.pb.biplane.testexercise.ui;

import com.beust.jcommander.JCommander;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by artur on 10.04.15.
 */
public class ArgsSlaveTest {

    @Test
    public void JCommander() throws Exception {

        Settings settings = new Settings();

        String[] args = { "-gen", "path"};
        new JCommander(settings, args);

        Assert.assertEquals(Settings.generate, "path");

    }

}