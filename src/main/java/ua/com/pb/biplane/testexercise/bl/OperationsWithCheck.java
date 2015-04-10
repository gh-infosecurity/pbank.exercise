package ua.com.pb.biplane.testexercise.bl;

import ua.com.pb.biplane.testexercise.dto.InputDto;
import ua.com.pb.biplane.testexercise.dto.Status;
import ua.com.pb.biplane.testexercise.util.Utils;

/**
 * Created by artur on 09.04.15.
 */
public class OperationsWithCheck extends Operations {

    Utils tools = new Utils();

    @Override
    public InputDto sumNumbers(InputDto dto) {
        String methodName = Thread.currentThread().getStackTrace()[2].getMethodName();
        logger.info("Run Operation {} for {} {} in Check {} mode.", dto.getOperation(), methodName, dto.getValues(), dto.getChecker());
        long start = System.currentTimeMillis();

        String [] dataArray = dto.getValues();
        int tmp = 0;
        for (String s: dataArray){
            if (tools.containsOnlyNumbers(s)) {
                tmp += new Integer(s);
            }else {
                dto.setStatus(Status.FAIL);
                dto.setResult(Integer.toString(0));
                logger.error("Input data set consist Characters");
                logger.error("Status {}, Result {}. Operation {} not permited in Check {} mode.", dto.getStatus(), dto.getResult(), dto.getOperation(), dto.getChecker());
                break;
            }
            dto.setResult(Integer.toString(tmp));
        }

        long finish = System.currentTimeMillis();
        logger.info("Status {}, Result {}. Operation {} was {}! in Check {} mode. in {} Millis.", dto.getStatus(), dto.getResult(), dto.getOperation(), dto.getStatus(), dto.getChecker(), (finish - start));
        return dto;
    }

    @Override
    public InputDto sumStrings(InputDto dto) {
        String methodName = Thread.currentThread().getStackTrace()[2].getMethodName();
        logger.info("Run Operation {} for {} {} in Check {} mode.", dto.getOperation(), methodName, dto.getValues(), dto.getChecker());
        long start = System.currentTimeMillis();

        String[] dataArray = dto.getValues();
        String tmp = Status.NO_RESULT.toString();
        for (String s : dataArray) {
            if (tools.containsOnlyDigit(s)) {
                tmp = tmp.concat(s);
            }else {
                dto.setStatus(Status.FAIL);
                dto.setResult(Status.NO_RESULT.toString());
                logger.error("Input data set consist Numbers");
                logger.error("Status {}, Result {}. Operation {} not permited in Check {} mode.", dto.getStatus(), dto.getResult(), dto.getOperation(), dto.getChecker());
            }
        }
        dto.setResult(tmp);

        long finish = System.currentTimeMillis();
        logger.info("Status {}, Result {}. Operation {} was {}! in Check {} mode. in {} Millis.", dto.getStatus(), dto.getResult(), dto.getOperation(), dto.getStatus(), dto.getChecker(), (finish - start));
        return dto;
    }

    @Override
    public InputDto subtractionNumber(InputDto dto) {
        return null;
    }

    @Override
    public InputDto divisionNumber(InputDto dto) {
        return null;
    }

    @Override
    public InputDto multiplicationNumber(InputDto dto) {
        return null;
    }
}
