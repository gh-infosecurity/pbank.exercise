package ua.com.pb.biplane.testexercise.bl;

import ua.com.pb.biplane.testexercise.dto.ConfigDto;
import ua.com.pb.biplane.testexercise.dto.InputDto;
import ua.com.pb.biplane.testexercise.dto.StateDto;
import ua.com.pb.biplane.testexercise.dto.UnitedDto;
import ua.com.pb.biplane.testexercise.dto.enumerations.Status;
import ua.com.pb.biplane.testexercise.dto.enumerations.TypeOfOperations;

import java.util.*;


/**
 * Created by artur on 09.04.15.
 */
class Operations extends BaseOperation {
    UnitedDto unDto;

    public Operations(ConfigDto configDto) {
        super();
        confDto = configDto;
        unDto = new UnitedDto();
    }

    public UnitedDto sumStrings(InputDto dto) {
        beforeOperation(dto);

        StateDto stDto = new StateDto();
        String result = valuesAsString(dto.getValues());
        stDto.setResult(result);
        stDto.setStatus(Status.OK);

        afterOperation(stDto);

        unDto.setConfDto(confDto);
        unDto.setStDato(stDto);
        unDto.setInputDto(dto);

        return unDto;
    }

    public UnitedDto sumNumbers(InputDto dto) {

        beforeOperation(dto);
        SumOperations sumOperations;

        if (confDto.getTypeOfOperations() == TypeOfOperations.SUM_INT_WITH_CHECK) {
            sumOperations = new SumWithCheck(confDto);
        } else{
            sumOperations = new SumWithoutCheck(confDto);
        }

        unDto = sumOperations.sumNumbers(dto);

        return unDto;
    }


    public UnitedDto runLoopFilter(InputDto dto) {
        beforeOperation(dto);

        StateDto stDto = new StateDto();
        Set<String> set = new HashSet<>(Arrays.asList(dto.getValues()));
        dto.setValues(set.toArray(new String[set.size()]));

        stDto.setStatus(Status.OK);
        stDto.setResult(valuesAsString(dto.getValues()));
        afterOperation(stDto);

        unDto.setConfDto(confDto);
        unDto.setStDato(stDto);
        unDto.setInputDto(dto);

        return unDto;
    }


    public UnitedDto runReverse(InputDto dto) {
        beforeOperation(dto);

        StateDto stDto = new StateDto();
        ArrayList<String> list = new ArrayList<>(Arrays.asList(dto.getValues()));
        Collections.reverse(list);
        dto.setValues(list.toArray(new String[list.size()]));

        stDto.setStatus(Status.OK);
        stDto.setResult(valuesAsString(dto.getValues()));
        afterOperation(stDto);

        unDto.setConfDto(confDto);
        unDto.setStDato(stDto);
        unDto.setInputDto(dto);

        return unDto;
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
