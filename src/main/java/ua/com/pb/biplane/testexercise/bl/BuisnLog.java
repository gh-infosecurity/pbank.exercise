package ua.com.pb.biplane.testexercise.bl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.com.pb.biplane.testexercise.bl.exceptions.IllegalOperationTypeConfigData;
import ua.com.pb.biplane.testexercise.bl.exceptions.IncorrectConfigData;
import ua.com.pb.biplane.testexercise.dto.ConfigDto;
import ua.com.pb.biplane.testexercise.dto.InputDto;
import ua.com.pb.biplane.testexercise.input.DataController;
import ua.com.pb.biplane.testexercise.input.fs.exceptions.ErrorXML;

import java.io.IOException;

/**
 * Created by artur on 09.04.15.
 */

/**
 * BuisnLog Business Logic Layers
 */
public class BuisnLog {
    Logger logger = LoggerFactory.getLogger(BuisnLog.class);

    Operations operations;
    ConfigDto configDto ;
    DataController dataController;
    InputDto inDto;

    public BuisnLog(DataController dataController) throws IncorrectConfigData {
        this.dataController = dataController;
        logger.info("DataController Constr - "+dataController.getInputData(configDto)); //todo

        try {
            this.configDto = dataController.getProperties();
        } catch (IllegalAccessException e) {
            throw new IllegalOperationTypeConfigData(e.getMessage());
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
    }

    public InputDto doOperation() throws IncorrectConfigData, IOException, ErrorXML {
        operations = new Operations(configDto);
        InputDto dto;

        switch (configDto.getTypeOfOperations()){
            case SUM_INT_WITHOUT_CHECK:
            case SUM_INT_WITH_CHECK:{
                inDto = dataController.getInputData(configDto);
                dto = runSumNumber();
                break;
            }

            case SUM_STR:{
                inDto = dataController.getInputData(configDto);
                dto = runSumString();
                break;
            }
            case REVERSE:{
                inDto = dataController.getInputData(configDto);
                dto = runReverse();
                break;
            }
            case FILTER:{
                inDto = dataController.getInputData(configDto);
                dto = runFilter();
                break;
            }
            default:{
                logger.error("Unsupported Operation");
                throw new IllegalArgumentException("Unsupported Operation");
            }
        }
        return dto;
    }

    private InputDto runFilter() {
        operations.runLoopFilter(inDto);
        return inDto;
    }

    private InputDto runReverse() {
        operations.runReverse(inDto);
        return inDto;
    }

    protected InputDto runSumNumber(){
        operations.sumNumbers(inDto);
        return inDto;
    }
    protected InputDto runSumString(){
        operations.sumStrings(inDto);
        return inDto;
    }

}
