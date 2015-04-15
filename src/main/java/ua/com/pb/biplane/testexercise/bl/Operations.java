package ua.com.pb.biplane.testexercise.bl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.com.pb.biplane.testexercise.dto.ConfigDto;
import ua.com.pb.biplane.testexercise.dto.InputDto;
import ua.com.pb.biplane.testexercise.dto.StateDto;
import ua.com.pb.biplane.testexercise.dto.enumerations.Status;
import ua.com.pb.biplane.testexercise.dto.enumerations.TypeOfOperations;

import java.util.*;


/**
 * Created by artur on 09.04.15.
 */
class Operations extends BaseOperation {


    public Operations(ConfigDto configDto) {
        super();
        confDto = configDto;
    }

    public InputDto sumStrings(InputDto dto) {
        beforeOperation(dto);

        StateDto stDto = new StateDto();
        String result = valuesAsString(dto.getValues());
        stDto.setResult(result);
        stDto.setStatus(Status.OK);

        afterOperation(stDto);
        return dto;
    }

    public InputDto sumNumbers(InputDto dto) {

        beforeOperation(dto);
        SumOperations sumOperations;

        if (confDto.getTypeOfOperations() == TypeOfOperations.SUM_INT_WITH_CHECK) {
            sumOperations = new SumWithCheck(confDto);
        } else if (confDto.getTypeOfOperations() == TypeOfOperations.SUM_INT_WITHOUT_CHECK) {
            sumOperations = new SumWithoutCheck(confDto);
        } else {
            logger.error("Incorrect input Config Type data - " + confDto.getTypeOfOperations());
            throw new IllegalArgumentException("Incorrect input Config data - " + confDto.getTypeOfOperations());
        }

        dto = sumOperations.sumNumbers(dto);
        return dto;
    }


    public InputDto runLoopFilter(InputDto dto) {
        beforeOperation(dto);

        StateDto stDto = new StateDto();
        Set<String> set = new HashSet<>(Arrays.asList(dto.getValues()));
        dto.setValues(set.toArray(new String[set.size()]));

        stDto.setStatus(Status.OK);
        stDto.setResult(valuesAsString(dto.getValues()));
        afterOperation(stDto);

        return dto;
    }


    public InputDto runReverse(InputDto dto) {
        beforeOperation(dto);

        StateDto stDto = new StateDto();
        ArrayList<String> list = new ArrayList<>(Arrays.asList(dto.getValues()));
        Collections.reverse(list);
        dto.setValues(list.toArray(new String[list.size()]));

        stDto.setStatus(Status.OK);
        stDto.setResult(valuesAsString(dto.getValues()));
        afterOperation(stDto);
        return dto;
    }

    private String valuesAsString(String[] arr){
        String result = "[";
        String delimeter = " ";
        for (String s : arr) {
            result = result.concat(delimeter).concat(s);
        }
        result=result.concat("]");
        return result;
    }
}
