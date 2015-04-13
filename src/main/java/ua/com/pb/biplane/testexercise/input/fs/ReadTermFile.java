package ua.com.pb.biplane.testexercise.input.fs;

import ua.com.pb.biplane.testexercise.dto.ConfigDto;
import ua.com.pb.biplane.testexercise.dto.InputDto;
import java.io.File;
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

    public InputDto readInputData() throws Exception {
        InputDto dto = new InputDto();
        InputDto readData = persister.read(InputDto.class, file);

        if(readData.getValues().length > confDto.getNumberOfInputElements()){
            String [] values = Arrays.copyOf(readData.getValues(), confDto.getNumberOfInputElements());
            dto.setValues(values);
        }else if(readData.getValues().length < confDto.getNumberOfInputElements()){
            ArrayList<String>inpLIst = new ArrayList<String>();
            for(String str:readData.getValues()){
                inpLIst.add(str);
            }
            String [] readed = inpLIst.toArray(new String[inpLIst.size()]);
            dto.setValues(readed);
            logger.info("Input data {} el. is a less than set in Config {}."+readed.length, confDto.getNumberOfInputElements());
        }else {
            dto = readData;
        }
        return dto;
    }

}
