package ua.com.pb.biplane.testexercise.bl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.com.pb.biplane.testexercise.dto.ConfigDto;
import ua.com.pb.biplane.testexercise.dto.InputDto;
import ua.com.pb.biplane.testexercise.input.DataController;

import java.io.IOException;

/**
 * Created by artur on 09.04.15.
 */

/**
 * BuisnLog Business Logic Layers
 */
public class BuisnLog {
    protected Logger logger = LoggerFactory.getLogger(BuisnLog.class);

    Operations operations;
    ConfigDto configDto ;
    DataController dataController;
    InputDto inDto;

    public BuisnLog(DataController dataController) {
        this.dataController = dataController;
        try {
            this.configDto = dataController.getProperties();
        } catch (IllegalAccessException e) {
            logger.error(e.getMessage());
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
    }

    public void doOperation() throws Exception {
        operations = new Operations(configDto);

        switch (configDto.getTypeOfOperations()){
            case SUM_INT_WITHOUT_CHECK:
            case SUM_INT_WITH_CHECK:{
                inDto = dataController.getInputData(configDto);
                runSumNumber(inDto);
                break;
            }

            case SUM_STR:{
                inDto = dataController.getInputData(configDto);
                runSumString(inDto);
                break;
            }
            default:{
                logger.error("Unsupported Operation");
                throw new IllegalArgumentException("Unsupported Operation");
            }
        }
    }




    public void runSumNumber(InputDto dto){
        operations.sumNumbers(dto);
    }
    public void runSumString(InputDto dto){
        operations.sumStrings(dto);
    }

}
