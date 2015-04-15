package ua.com.pb.biplane.testexercise.bl;

import ua.com.pb.biplane.testexercise.dto.ConfigDto;
import ua.com.pb.biplane.testexercise.dto.InputDto;
import ua.com.pb.biplane.testexercise.dto.StateDto;
import ua.com.pb.biplane.testexercise.dto.enumerations.Status;
import ua.com.pb.biplane.testexercise.dto.enumerations.TypeOfOperations;
import ua.com.pb.biplane.testexercise.util.Utils;

import java.util.ArrayList;

/**
 * Created by artur on 09.04.15.
 */
public class SumWithCheck extends SumOperations {


    public SumWithCheck(ConfigDto configDto) {
        super(configDto);
    }

    @Override
    public InputDto sumNumbers(InputDto dto) {

        ArrayList<String> tmpList = new ArrayList<>();
        String[] dataArray = dto.getValues();
        StateDto stDto = new StateDto();
        int tmp = 0;

        for (String s : dataArray) {
            if (Utils.containsOnlyNumbers(s)) {
                tmpList.add(s);
                tmp += new Integer(s);

                stDto.setStatus(Status.OK);
                stDto.setResult(Integer.toString(tmp));
                dto.setValues(tmpList.toArray(new String[tmpList.size()]));
            } else {
                stDto.setStatus(Status.FAIL);
                stDto.setResult(Integer.toString(0));
                dto.setValues(new String[0]);
                logger.error("Input data set consist Numbers"); //todo
                break;
            }
        }

        afterOperation(stDto);
        return dto;
    }
}
