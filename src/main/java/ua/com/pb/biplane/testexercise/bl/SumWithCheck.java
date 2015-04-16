package ua.com.pb.biplane.testexercise.bl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
public class SumWithCheck extends SumOperations {
    Logger logger = LoggerFactory.getLogger(SumWithCheck.class);


    public SumWithCheck(ConfigDto configDto) {
        super(configDto);
        unDto = new UnitedDto();
    }

    @Override
    public UnitedDto sumNumbers(InputDto dto) {

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
                logger.error("Input data set consist Numbers");
                break;
            }
        }

        afterOperation(stDto);

        unDto.setConfDto(confDto);
        unDto.setStDato(stDto);
        unDto.setInputDto(dto);

        return unDto;
    }
}
