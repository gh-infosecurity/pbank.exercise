package ua.com.pb.biplane.testexercise.input.fs;

import ua.com.pb.biplane.testexercise.bl.exceptions.IncorrectConfigData;
import ua.com.pb.biplane.testexercise.bl.exceptions.NumberConfigDataTooMatch;
import ua.com.pb.biplane.testexercise.dto.ConfigDto;
import ua.com.pb.biplane.testexercise.dto.InputDto;
import ua.com.pb.biplane.testexercise.input.fs.exceptions.ErrorXML;

import javax.xml.stream.XMLStreamException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;


/**
 * Created by artur on 09.04.15.
 */
public class ReadTermFile extends FsStorage {

    public ReadTermFile(ConfigDto conf, String path) {
        super();
        file = new File(path);
        confDto = conf;
    }

    public InputDto readInputData() throws IncorrectConfigData, IOException, ErrorXML {
        InputDto dto = null;

        try {
            dto = persister.read(InputDto.class, file);
            dto.setValues(getInputValue(dto.getValues()));
        } catch (NumberConfigDataTooMatch e) {
            throw new IncorrectConfigData(e.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        if(isValidXML())
            return dto;
        return dto;
    }

}
