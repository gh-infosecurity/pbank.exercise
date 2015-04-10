package ua.com.pb.biplane.testexercise.ui;

import ua.com.pb.biplane.testexercise.dto.InputDto;
import ua.com.pb.biplane.testexercise.util.Utils;


/**
 * Created by artur on 09.04.15.
 */
public class UiFile extends Storage {

    public UiFile(String path) {
        super(path);
    }

    public UiFile() {
        super();
    }

    @Override
    public InputDto readData() throws Exception {
        Utils tools = new Utils();
        file = tools.getFile();
        InputDto dto = persister.read(InputDto.class, file);
        return dto;
    }


}
