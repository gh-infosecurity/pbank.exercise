package ua.com.pb.biplane.testexercise.util;

import com.beust.jcommander.Parameter;

/**
 * Created by artur on 10.04.15.
 */
public class CLineArgs {

    @Parameter(names = "-gen", description = "generate Example xml file", required = false)
    private String generate;

    @Parameter(names = "-file", description = "path to xml file", required = false)
    private String path;

    public  String getGenerate() {
        return generate;
    }

    public  void setGenerate(String generate) {
        generate = generate;
    }

    public  String getPath() {
        return path;
    }

    public  void setPath(String path) {
        path = path;
    }
}