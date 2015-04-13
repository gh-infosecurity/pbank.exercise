package ua.com.pb.biplane.testexercise.input.fs;

import org.simpleframework.xml.core.Persister;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.com.pb.biplane.testexercise.bl.exceptions.IncorrectConfigData;
import ua.com.pb.biplane.testexercise.bl.exceptions.NumberConfigDataTooMatch;
import ua.com.pb.biplane.testexercise.dto.ConfigDto;
import ua.com.pb.biplane.testexercise.dto.InputDto;
import ua.com.pb.biplane.testexercise.input.fs.exceptions.ErrorXML;
import ua.com.pb.biplane.testexercise.util.XMLValidator;
import ua.com.pb.biplane.testexercise.util.exceptions.IncorrectInputXML;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

/**
 * Created by artur on 08.04.15.
 */
abstract public class FsStorage {
    protected Logger logger = LoggerFactory.getLogger(FsStorage.class);
    protected File file = null;
    protected ConfigDto confDto = null;
    protected Persister persister = new Persister();

    public String [] getInputValue (String [] inValue) throws NumberConfigDataTooMatch {
        if(inValue.length==confDto.getNumberOfInputElements()){
            return inValue;
        }else if(inValue.length>confDto.getNumberOfInputElements()){
            return Arrays.copyOf(inValue, confDto.getNumberOfInputElements());
        } else {
            throw new NumberConfigDataTooMatch("Number Of Input Elements of Config data too Match - "+confDto.getNumberOfInputElements());
        }
    }

    protected Boolean isValidXML() throws IOException, ErrorXML {
        XMLValidator validator = new XMLValidator();


        try {
            validator.validate(file);
            return true;
        } catch (IncorrectInputXML e) {
            throw new ErrorXML(e.getMessage());
        }
    }

    abstract public InputDto readInputData() throws IncorrectConfigData, IOException, ErrorXML;
}
