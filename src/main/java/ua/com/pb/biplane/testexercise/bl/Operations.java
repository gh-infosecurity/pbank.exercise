package ua.com.pb.biplane.testexercise.bl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.com.pb.biplane.testexercise.dto.InputDto;

/**
 * Created by artur on 09.04.15.
 */
abstract class Operations {
    protected Logger logger = LoggerFactory.getLogger(Operations.class);

    abstract public InputDto sumNumbers (InputDto dto);
    abstract public InputDto sumStrings (InputDto dto);
    abstract public InputDto subtractionNumber(InputDto dto);
    abstract public InputDto divisionNumber(InputDto dto);
    abstract public InputDto multiplicationNumber(InputDto dto);
}
