package ua.com.pb.biplane.testexercise.ui;

import org.simpleframework.xml.core.Persister;
import ua.com.pb.biplane.testexercise.dto.InputDto;
import ua.com.pb.biplane.testexercise.tools.Tools;

import java.io.File;

/**
 * Created by artur on 08.04.15.
 */
abstract public class Storage {
    protected File file;
    protected Persister persister;

    public Storage(String path) {
        file = new File(path);
        persister = new Persister();
    }

    public Storage() {
        persister = new Persister();
    }


    public void create(InputDto dto) throws Exception {
        if (file ==null){
            Tools tools = new Tools();
            file = tools.getFile();
        }
        persister.write(dto, file);
    }

    abstract public InputDto readData() throws Exception;

}
