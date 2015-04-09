package ua.com.pb.biplane.testexercise.ui;

import org.simpleframework.xml.core.Persister;
import ua.com.pb.biplane.testexercise.dto.InputDto;

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


    public void create() throws Exception {
        InputDto dto = new InputDto();
        dto.operation="sum";
        String [] values = {"artur","vasia","petia"};
        dto.values=values;

        persister.write(dto, file);
    }

    abstract public InputDto readData() throws Exception;

}
