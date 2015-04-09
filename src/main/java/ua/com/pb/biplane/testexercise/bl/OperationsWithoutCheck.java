package ua.com.pb.biplane.testexercise.bl;

import ua.com.pb.biplane.testexercise.dto.InputDto;
import ua.com.pb.biplane.testexercise.dto.Status;
import ua.com.pb.biplane.testexercise.tools.Tools;

import java.util.ArrayList;

/**
 * Created by artur on 09.04.15.
 */
public class OperationsWithoutCheck extends Operations{
    Tools tools = new Tools();

    @Override
    public InputDto sumNumbers(InputDto dto) {
        String methodName = Thread.currentThread().getStackTrace()[2].getMethodName();
        logger.info("Run Operation {} for {} {} in Check {} mode.", dto.getOperation(), methodName, dto.getValues(), dto.getChecker());
        long start = System.currentTimeMillis();

        String [] dataArray = dto.getValues();
        int tmp = 0;
        for (String s: dataArray){
            if (tools.containsOnlyNumbers(s))
                tmp += new Integer(s);
        }
        dto.setResult(Integer.toString(tmp));
        dto.setStatus(Status.OK);
        long finish = System.currentTimeMillis();
        logger.info("Status {}, Result {}. Operation {} was {}! in Check {} mode. in {} Millis.", dto.getStatus(), dto.getResult(), dto.getOperation(), dto.getStatus(), dto.getChecker(), (finish - start));
        return dto;
    }

    @Override
    public InputDto sumStrings(InputDto dto) {
        String methodName = Thread.currentThread().getStackTrace()[2].getMethodName();
        logger.info("Run Operation {} for {} {} in Check {} mode.", dto.getOperation(), methodName, dto.getValues(), dto.getChecker());
        long start = System.currentTimeMillis();

        String [] dataArray = dto.getValues();
        String tmp = "";
        for (String s: dataArray){
            if (!tools.containsOnlyNumbers(s))
                tmp = tmp.concat(s);
        }
        dto.setResult(tmp);
        dto.setStatus(Status.OK);

        long finish = System.currentTimeMillis();
        logger.info("Status {}, Result {}. Operation {} was {}! in Check {} mode. in {} Millis.", dto.getStatus(), dto.getResult(), dto.getOperation(), dto.getStatus(), dto.getChecker(), (finish - start));
        return dto;
    }


}
