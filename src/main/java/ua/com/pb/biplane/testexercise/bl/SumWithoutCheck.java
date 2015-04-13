package ua.com.pb.biplane.testexercise.bl;

import ua.com.pb.biplane.testexercise.dto.ConfigDto;
import ua.com.pb.biplane.testexercise.dto.InputDto;
import ua.com.pb.biplane.testexercise.dto.StateDto;
import ua.com.pb.biplane.testexercise.dto.enumerations.Status;
import ua.com.pb.biplane.testexercise.util.Utils;

/**
 * Created by artur on 09.04.15.
 */
public class SumWithoutCheck extends SumOperations{
    Utils tools = new Utils();
    StateDto stDto = new StateDto();

    public SumWithoutCheck(ConfigDto configDto) {
        super(configDto);
    }

    @Override
    public InputDto sumNumbers(InputDto dto) {

        beforeOperation(dto);

        String [] dataArray = dto.getValues();
        int tmp = 0;
        for (String s: dataArray){
            if (tools.containsOnlyNumbers(s))
                tmp += new Integer(s);
        }
        stDto.setResult(Integer.toString(tmp));
        stDto.setStatus(Status.OK);

        afterOperation(stDto);
        return dto;
    }

}
