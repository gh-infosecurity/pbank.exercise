package ua.com.pb.biplane.testexercise.input;

import org.simpleframework.xml.core.Persister;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.com.pb.biplane.testexercise.bl.exceptions.IncorrectConfigData;
import ua.com.pb.biplane.testexercise.dto.ConfigDto;
import ua.com.pb.biplane.testexercise.dto.InputDto;
import ua.com.pb.biplane.testexercise.dto.enumerations.TypeOfOperations;
import ua.com.pb.biplane.testexercise.input.fs.FsStorage;
import ua.com.pb.biplane.testexercise.input.fs.ReadTermFile;
import ua.com.pb.biplane.testexercise.input.fs.ReadUiFile;
import ua.com.pb.biplane.testexercise.input.fs.exceptions.ErrorXML;
import ua.com.pb.biplane.testexercise.input.prop.ReadConfig;
import java.io.File;
import java.io.IOException;
import java.util.Properties;


/**
 * Created by Baelousov Artur Igorevich. E-mail: g.infosecurity@gmail.com on 12.04.15.
 */
public class DataController {
    protected Logger logger = LoggerFactory.getLogger(DataController.class);
    final String CONFIG_FILE = "src/main/resources/config.properties";
    String path = null;

    public DataController(String path) {
        this.path = path;
    }

    /**
     * Method Read config.properties file from resources directory
     * @return
     * @throws IllegalAccessException
     * @throws IOException
     */
    public ConfigDto getProperties() throws IllegalAccessException, IOException {
        ReadConfig readConfig;
        ConfigDto configDto;
        readConfig = new ReadConfig();
        TypeOfOperations type;
        int n;

        try {
            Properties prop = readConfig.getConfig(CONFIG_FILE);
            type = TypeOfOperations.valueOf(prop.getProperty("operations.type"));
            n = new Integer(prop.getProperty("elements.number"));
        } catch (IllegalArgumentException e) {
            logger.error(e.getMessage());
            throw new IllegalAccessException(e.getMessage());
        }

        configDto = new ConfigDto();
        configDto.setTypeOfOperations(type);
        configDto.setNumberOfInputElements(n);
        return configDto;
    }

    public InputDto getInputData(ConfigDto confDto) throws IncorrectConfigData, IOException, ErrorXML {
        FsStorage fsStorage;

        if(path!=null){
            fsStorage = new ReadTermFile(confDto, path);
        }else {
            fsStorage = new ReadUiFile(confDto);
        }

        return fsStorage.readInputData();
    }

    public void generateExampleDto(){
        Persister persister = new Persister();

        InputDto dto = new InputDto();
        String[] values = {"123", "1q", "2", "3g", "5"};
        dto.setValues(values);
        try {
            persister.write(dto, new File(path));
            logger.info("Example file was generated at "+path);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }
}
