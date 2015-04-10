package ua.com.pb.biplane.testexercise.ui;

import com.beust.jcommander.Parameter;

/**
 * Created by artur on 10.04.15.
 */
public class Settings {

    @Parameter(names = "-gen", description = "generate Example xml file", required = false)
    public static String generate;

    @Parameter(names = "-file", description = "path to xml file", required = false)
    public static String path;
}