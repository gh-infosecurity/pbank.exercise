package ua.com.pb.biplane.testexercise.dto;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;
import ua.com.pb.biplane.testexercise.dto.enumerations.Status;
import ua.com.pb.biplane.testexercise.dto.enumerations.TypeOfOperations;

/**
 * Created by artur on 08.04.15.
 */
@Root(name = "InputData")
public class InputDto {

    @Element(name = "values")
    private String values[];

    public String[] getValues() {
        return values;
    }

    public void setValues(String[] values) {
        this.values = values;
    }

}
