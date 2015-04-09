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

    public Blogic(String[] args) {

        if (args.length != 0 && !args[0].isEmpty()){
            filePath=args[0];
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

    public void runSumString(InputDto dto){
        operations = getRightOperation(dto);
        operations.sumStrings(dto);
    }

    public void printReadetData(InputDto dto) {
        System.out.println(dto.getOperation());
        for (String s:dto.getValues()){
            System.out.println(s);
        }
    }

    public void writeXml(InputDto dto) throws Exception {
        storage.create(dto);
    }

    public InputDto generateExampleDto(){
        InputDto dto = new InputDto();
        dto.setOperation("+");
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
