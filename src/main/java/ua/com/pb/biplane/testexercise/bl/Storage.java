package ua.com.pb.biplane.testexercise.bl;

import org.simpleframework.xml.core.Persister;
import ua.com.pb.biplane.testexercise.dto.InputDto;

import java.io.File;

/**
 * Created by artur on 08.04.15.
 */
public class Storage {
    File file;
    Persister persister;

    Storage(){
         file = new File("/home/artur/example1.xml");
         persister = new Persister();
    }
    public void create(InputDto dto) throws Exception {
        dto.operation="sum";
        String [] values = {"artur","vasia","petia"};
        dto.values=values;
        persister.write(dto, file);
    }

    public InputDto readData() throws Exception {
        InputDto dto = persister.read(InputDto.class, file);
        return dto;
    }
}
