package ua.com.pb.biplane.testexercise.bl;

import ua.com.pb.biplane.testexercise.dto.InputDto;
import ua.com.pb.biplane.testexercise.dto.Status;
import ua.com.pb.biplane.testexercise.tools.Tools;

/**
 * Created by artur on 09.04.15.
 */
public class OperationsWithCheck extends Operations {
    Tools tools = new Tools();

    @Override
    public InputDto sumNumbers(InputDto dto) {
        String [] dataArray = dto.getValues();
        int tmp = 0;
        for (String s: dataArray){
            if (tools.containsOnlyNumbers(s)) {
                tmp += new Integer(s);
            }else {
                dto.setStatus(Status.FAIL);
                dto.setResult(Integer.toString(0));
                break;
            }
            dto.setResult(Integer.toString(tmp));
        }
        return dto;
    }

    @Override
    public InputDto sumStrings(InputDto dto) {
        String[] dataArray = dto.getValues();
        String tmp = Status.NO_RESULT.toString();
        for (String s : dataArray) {
            if (tools.containsOnlyDigit(s)) {
                tmp = tmp.concat(s);
            }else {
                dto.setStatus(Status.FAIL);
                dto.setResult(Status.NO_RESULT.toString());
            }
        }
        dto.setResult(tmp);
        return dto;
    }
}
