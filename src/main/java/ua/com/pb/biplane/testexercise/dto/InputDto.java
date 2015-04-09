package ua.com.pb.biplane.testexercise.dto;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import java.util.List;

/**
 * Created by artur on 08.04.15.
 */
@Root(name = "InputData")
public class InputDto {

    @Element(name = "checker")
    private boolean checker;

    @Element(name = "result")
    private String result;

    @Element(name = "status")
    private Status status;

    @Element(name = "operation")
    private String operation;

    @Element(name = "values")
    private String values[];

    public String getOperation() {
        return operation;
    }

    public String[] getValues() {
        return values;
    }

    public void setChecker(boolean checker) {
        this.checker = checker;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public void setValues(String[] values) {
        this.values = values;
    }

    public boolean getChecker() {
        return checker;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
