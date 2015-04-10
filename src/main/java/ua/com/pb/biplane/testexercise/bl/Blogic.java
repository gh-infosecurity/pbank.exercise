package ua.com.pb.biplane.testexercise.bl;

import com.sun.corba.se.spi.orb.Operation;
import ua.com.pb.biplane.testexercise.dto.InputDto;
import ua.com.pb.biplane.testexercise.dto.Status;
import ua.com.pb.biplane.testexercise.ui.Storage;
import ua.com.pb.biplane.testexercise.ui.TermFile;
import ua.com.pb.biplane.testexercise.ui.UiFile;

/**
 * Created by artur on 09.04.15.
 */
public class Blogic {
    String filePath;
    Storage storage;
    Operations operations;

    public Blogic(String filePath) {
        this.filePath = filePath;
        if (filePath!="" & filePath!=null){
            storage = new TermFile(filePath);
        }else {
            storage = new UiFile();
        }
    }


    public InputDto readData() throws Exception {
        return storage.readData();
    }

    public void runSumNumber(InputDto dto){
        operations = getRightOperation(dto);
        operations.sumNumbers(dto);
    }

    public void runSubtractionNumber(InputDto dto){
        operations = getRightOperation(dto);
        operations.subtractionNumber(dto);
    }

    public void runDivisionNumber(InputDto dto){
        operations = getRightOperation(dto);
        operations.divisionNumber(dto);
    }

    public void runMultiplicationNumber(InputDto dto){
        operations = getRightOperation(dto);
        operations.multiplicationNumber(dto);
    }


    public void runSumString(InputDto dto){
        operations = getRightOperation(dto);
        operations.sumStrings(dto);
    }

    public void writeXml(InputDto dto) throws Exception {
        storage.create(dto);
    }

    public InputDto generateExampleDto(){
        InputDto dto = new InputDto();
        dto.setOperation('+');
        dto.setChecker(false);
        dto.setStatus(Status.UNKNOW);
        String[] values = {"123", "1q", "2", "3g", "5"};
        dto.setValues(values);
        dto.setResult(Status.NO_RESULT.toString());
        return dto;
    }

    private Operations getRightOperation (InputDto dto) {
        if (dto.getChecker()){
            operations = new  OperationsWithCheck();
        }else if (!dto.getChecker()){
            operations = new OperationsWithoutCheck();
        }else throw new IllegalArgumentException();

        return operations;
    }
}
