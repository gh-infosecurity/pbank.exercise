package ua.com.pb.biplane.testexercise.bl;

import ua.com.pb.biplane.testexercise.dto.ConfigDto;
import ua.com.pb.biplane.testexercise.dto.InputDto;
import ua.com.pb.biplane.testexercise.dto.StateDto;
import ua.com.pb.biplane.testexercise.dto.UnitedDto;
import ua.com.pb.biplane.testexercise.dto.enumerations.Status;
import ua.com.pb.biplane.testexercise.util.Utils;

import java.util.ArrayList;

/**
 * Created by artur on 09.04.15.
 */
public class SumWithoutCheck extends SumOperations{

    public SumWithoutCheck(ConfigDto configDto) {
        super(configDto);
    }

    @Override
    public UnitedDto sumNumbers(InputDto dto) {

        ArrayList<String> tmpList = new ArrayList<>();
        String [] dataArray = dto.getValues();
        StateDto stDto = new StateDto();

        int tmp = 0;
        for (String s: dataArray){
            if (Utils.containsOnlyNumbers(s)) {
                tmpList.add(s);
                tmp += new Integer(s);
            }
        }
        stDto.setResult(Integer.toString(tmp));
        stDto.setStatus(Status.OK);
        dto.setValues(tmpList.toArray(new String[tmpList.size()]));

        afterOperation(stDto);

        unDto = new UnitedDto();
        unDto.setConfDto(confDto);
        unDto.setStDato(stDto);
        unDto.setInputDto(dto);

        return unDto;
    }

}
