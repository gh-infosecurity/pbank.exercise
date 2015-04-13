package ua.com.pb.biplane.testexercise.bl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.com.pb.biplane.testexercise.dto.ConfigDto;
import ua.com.pb.biplane.testexercise.dto.InputDto;
import ua.com.pb.biplane.testexercise.dto.StateDto;
import ua.com.pb.biplane.testexercise.dto.enumerations.Status;
import ua.com.pb.biplane.testexercise.dto.enumerations.TypeOfOperations;
import ua.com.pb.biplane.testexercise.util.Utils;

/**
 * Created by artur on 09.04.15.
 */
class Operations extends BaseOperation{
    public Operations(ConfigDto configDto) {
        super();
        confDto = configDto;
    }

    public InputDto sumStrings(InputDto dto) {
        beforeOperation(dto);

        String [] dataArray = dto.getValues();
        String tmp = "[";
        String delimeter = "\t";
        for (String s: dataArray){
                tmp = tmp.concat(delimeter).concat(s);
        }
        stDto.setResult(tmp+"]");
        stDto.setStatus(Status.OK);

        afterOperation(stDto);
        return dto;
    }

    public InputDto sumNumbers(InputDto dto){
        beforeOperation(dto);

        SumOperations sumOperations;

        if (confDto.getTypeOfOperations()== TypeOfOperations.SUM_INT_WITH_CHECK) {
            sumOperations = new SumWithCheck(confDto);
        }else if (confDto.getTypeOfOperations()== TypeOfOperations.SUM_INT_WITHOUT_CHECK){
            sumOperations = new SumWithoutCheck(confDto);
        }else {
            logger.error("Incorrect input Config data - "+confDto.getTypeOfOperations());
            throw new IllegalArgumentException("Incorrect input Config data - "+confDto.getTypeOfOperations());
        }
        return sumOperations.sumNumbers(dto);
    }
}
