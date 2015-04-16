package ua.com.pb.biplane.testexercise.bl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.com.pb.biplane.testexercise.bl.exceptions.IllegalOperationTypeConfigData;
import ua.com.pb.biplane.testexercise.bl.exceptions.IncorrectConfigData;
import ua.com.pb.biplane.testexercise.dao.LogDAO;
import ua.com.pb.biplane.testexercise.dto.ConfigDto;
import ua.com.pb.biplane.testexercise.dto.InputDto;
import ua.com.pb.biplane.testexercise.dto.LogDto;
import ua.com.pb.biplane.testexercise.dto.UnitedDto;
import ua.com.pb.biplane.testexercise.input.DataController;
import ua.com.pb.biplane.testexercise.input.exceptions.ErrorXML;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by artur on 09.04.15.
 */

/**
 * BuisnLog Business Logic Layers
 */
public class BuisnLog {
    Logger logger = LoggerFactory.getLogger(BuisnLog.class);

    DataController dataController;
    Operations operations;
    ConfigDto configDto ;
    UnitedDto unDto;
    InputDto inDto;


    public BuisnLog() {}

    public BuisnLog(DataController dataController) throws IncorrectConfigData {
        this.dataController = dataController;

        try {
            this.configDto = dataController.getProperties();
        } catch (IllegalAccessException e) {
            throw new IllegalOperationTypeConfigData(e.getMessage());
        } catch (IOException e) {
            logger.error(e.getMessage());
        }

    }

    public UnitedDto doOperation() throws IncorrectConfigData, IOException, ErrorXML {
        operations = new Operations(configDto);

        switch (configDto.getTypeOfOperations()){
            case SUM_INT_WITHOUT_CHECK:
            case SUM_INT_WITH_CHECK:{
                inDto = dataController.getInputData(configDto);
                unDto = runSumNumber();
                break;
            }

            case SUM_STR:{
                inDto = dataController.getInputData(configDto);
                unDto = runSumString();
                break;
            }
            case REVERSE:{
                inDto = dataController.getInputData(configDto);
                unDto = runReverse();
                break;
            }
            case FILTER:{
                inDto = dataController.getInputData(configDto);
                unDto = runFilter();
                break;
            }
            default:{
                logger.error("Unsupported Operation");
                throw new IllegalArgumentException("Unsupported Operation");
            }
        }
        return unDto;
    }



    private UnitedDto runFilter() {
        return operations.runLoopFilter(inDto);
    }

    private UnitedDto runReverse() {
        return operations.runReverse(inDto);
    }

    protected UnitedDto runSumNumber(){
        return operations.sumNumbers(inDto);
    }

    protected UnitedDto runSumString(){
        return operations.sumStrings(inDto);
    }

    public void logOperation(UnitedDto unDto) {
        LogDAO logDAO = new LogDAO();
        logDAO.createLog(unDto);
    }

    public ArrayList<LogDto> getLogOperation() {
        LogDAO logDAO = new LogDAO();
        return logDAO.readLogs();
    }

}
