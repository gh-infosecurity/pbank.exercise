package ua.com.pb.biplane.testexercise.ui;

import ua.com.pb.biplane.testexercise.dto.InputDto;


/**
 * Created by artur on 09.04.15.
 */
public class TermFile extends Storage {

    public TermFile(String path) {
        super(path);
    }


    public InputDto readData() throws Exception {
        InputDto dto = persister.read(InputDto.class, file);
        return dto;
    }
}
