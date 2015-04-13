package ua.com.pb.biplane.testexercise.bl;

import ua.com.pb.biplane.testexercise.dto.ConfigDto;
import ua.com.pb.biplane.testexercise.dto.InputDto;
import ua.com.pb.biplane.testexercise.dto.StateDto;
import ua.com.pb.biplane.testexercise.dto.enumerations.Status;

/**
 * Created by artur on 09.04.15.
 */
public class SumWithCheck extends SumOperations {
    StateDto stDto = new StateDto();

    public SumWithCheck(ConfigDto configDto) {
        super(configDto);
    }

    @Override
    public InputDto sumNumbers(InputDto dto) {

        beforeOperation(dto);

        String [] dataArray = dto.getValues();
        int tmp = 0;
        for (String s: dataArray){
            if (utils.containsOnlyNumbers(s)) {
                tmp += new Integer(s);
            }else {
                stDto.setStatus(Status.FAIL);
                stDto.setResult(Integer.toString(0));
                logger.error("Input data set consist Numbers"); //todo
                break;
            }
            stDto.setResult(Integer.toString(tmp));
        }
        afterOperation(stDto);
        return dto;
    }

}
