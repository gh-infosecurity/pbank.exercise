package ua.com.pb.biplane.testexercise.bl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.com.pb.biplane.testexercise.dto.ConfigDto;
import ua.com.pb.biplane.testexercise.dto.InputDto;
import ua.com.pb.biplane.testexercise.dto.StateDto;
import ua.com.pb.biplane.testexercise.util.Utils;

/**
 * Created by Baelousov Artur Igorevich. E-mail: g.infosecurity@gmail.com on 13.04.15.
 */
public class BaseOperation {
    Logger logger = LoggerFactory.getLogger(BaseOperation.class);
    protected ConfigDto confDto;
    private long start;
    private long finish;

    protected void beforeOperation(InputDto inDto){
        logger.info("Run Operation {} for {} .", confDto.getTypeOfOperations(), inDto.getValues());
        start = System.currentTimeMillis();
    }

    protected void afterOperation(StateDto stDto){
        finish = System.currentTimeMillis();
        logger.info("Status Operation {} is {}, Result {} in {} Sec.", confDto.getTypeOfOperations(), stDto.getStatus(), stDto.getResult(),  (finish - start)/1000);
    }
}
