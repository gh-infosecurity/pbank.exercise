package ua.com.pb.biplane.testexercise.bl;

import ua.com.pb.biplane.testexercise.dto.InputDto;
import ua.com.pb.biplane.testexercise.tools.Tools;

import java.util.ArrayList;

/**
 * Created by artur on 09.04.15.
 */
public class OperationsWithoutCheck extends Operations{
    Tools tools = new Tools();

    @Override
    public InputDto sumNumbers(InputDto dto) {
        String [] dataArray = dto.getValues();
        int tmp = 0;
        for (String s: dataArray){
            if (tools.containsOnlyNumbers(s))
                tmp += new Integer(s);
        }
        dto.setResult(Integer.toString(tmp));
        return dto;
    }

    @Override
    public InputDto sumStrings(InputDto dto) {
        String [] dataArray = dto.getValues();
        String tmp = "";
        for (String s: dataArray){
            if (!tools.containsOnlyNumbers(s))
                tmp = tmp.concat(s);
        }
        dto.setResult(tmp);
        return dto;
    }


}
