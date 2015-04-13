package ua.com.pb.biplane.testexercise.ui;

import com.beust.jcommander.JCommander;
import org.junit.Assert;
import org.junit.Test;
import ua.com.pb.biplane.testexercise.util.CLineArgs;

/**
 * Created by artur on 10.04.15.
 */
public class ArgsSlaveTest {

    @Test
    public void JCommander() throws Exception {

        CLineArgs cla = new CLineArgs();

        String[] args = { "-gen", "path"};
        new JCommander(cla, args);

        Assert.assertEquals(cla.getGenerate(), "path");

    }

}