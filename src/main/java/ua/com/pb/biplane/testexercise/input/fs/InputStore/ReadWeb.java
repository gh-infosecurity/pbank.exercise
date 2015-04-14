package ua.com.pb.biplane.testexercise.input.fs.InputStore;

import org.simpleframework.xml.core.Persister;
import ua.com.pb.biplane.testexercise.bl.exceptions.IncorrectConfigData;
import ua.com.pb.biplane.testexercise.bl.exceptions.NumberConfigDataTooMatch;
import ua.com.pb.biplane.testexercise.dto.ConfigDto;
import ua.com.pb.biplane.testexercise.dto.InputDto;
import ua.com.pb.biplane.testexercise.input.fs.exceptions.ErrorXML;

import java.io.File;
import java.io.IOException;


/**
 * Created by artur on 09.04.15.
 */
public class ReadWeb{
    protected Persister persister = new Persister();
    InputDto dto = null;

    public InputDto readInputData(String xml) throws Exception {
        dto = persister.read(InputDto.class, xml);
        return dto;
    }

}
