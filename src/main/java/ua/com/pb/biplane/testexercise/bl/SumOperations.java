package ua.com.pb.biplane.testexercise.bl;

import ua.com.pb.biplane.testexercise.dto.ConfigDto;
import ua.com.pb.biplane.testexercise.dto.InputDto;

/**
 * Created by Baelousov Artur Igorevich. E-mail: g.infosecurity@gmail.com on 13.04.15.
 */
public abstract class SumOperations extends Operations{

    public SumOperations(ConfigDto configDto) {
        super(configDto);
    }

    public abstract InputDto sumNumbers(InputDto dto);
}
