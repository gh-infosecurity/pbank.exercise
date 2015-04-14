package ua.com.pb.biplane.testexercise.input;

import org.simpleframework.xml.core.Persister;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.com.pb.biplane.testexercise.dao.Database;
import ua.com.pb.biplane.testexercise.dto.ConfigDto;
import ua.com.pb.biplane.testexercise.dto.InputDto;
import ua.com.pb.biplane.testexercise.dto.enumerations.TypeOfOperations;
import ua.com.pb.biplane.testexercise.input.fs.ReadTermFile;
import ua.com.pb.biplane.testexercise.input.fs.ReadUiFile;
import ua.com.pb.biplane.testexercise.input.prop.ReadConfig;
import ua.com.pb.biplane.testexercise.input.web.WebStorage;
import ua.com.pb.biplane.testexercise.util.Utils;

import java.io.File;
import java.io.IOException;
import java.util.Properties;


/**
 * Created by Baelousov Artur Igorevich. E-mail: g.infosecurity@gmail.com on 12.04.15.
 */
public class DataController {
    protected Logger logger = LoggerFactory.getLogger(DataController.class);
    final String CONFIG_FILE = "src/main/resources/config.properties";
    String inputXml;
    String path;


    public DataController(String path) {
        if (!(new File(path).exists())) {
            this.path = path;
        } else if (Utils.isValidXML(new File(path))) {
            inputXml = path;
        }
    }

    /**
     * Method Read config.properties file from resources directory
     *
     * @return
     * @throws IllegalAccessException
     * @throws IOException
     */
    public ConfigDto getProperties() throws IllegalAccessException, IOException {
        ReadConfig readConfig = new ReadConfig();
        ConfigDto configDto;
        Properties prop;
        TypeOfOperations type;
        int numbers;


        try {
            prop = Database.readConfig();
            if (prop == null) {
                prop = readConfig.getConfig(CONFIG_FILE);
            }
            type = TypeOfOperations.valueOf(prop.getProperty("operations.type"));
            numbers = new Integer(prop.getProperty("elements.number"));
        } catch (IllegalArgumentException e) {

            throw new IllegalAccessException(e.getMessage());
        }

        configDto = new ConfigDto();
        configDto.setTypeOfOperations(type);
        configDto.setNumberOfInputElements(numbers);
        return configDto;
    }

    public InputDto getInputData(ConfigDto confDto) {
        IStorage storage;

        if (path != null) {
            storage = new ReadTermFile(confDto, path);
        } else if (inputXml != null) {
            storage = new WebStorage(inputXml);
        } else {
            storage = new ReadUiFile(confDto);
        }

        try {
            return storage.readInputData();
        } catch (Exception e) {
            logger.error(e.getMessage());
            return null;
        }
    }

    public void generateExampleDto() {
        Persister persister = new Persister();

        InputDto dto = new InputDto();
        String[] values = {"123", "1q", "2", "3g", "5"};
        dto.setValues(values);
        try {
            persister.write(dto, new File(path));
            logger.info("Example file was generated at " + path);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }
}
