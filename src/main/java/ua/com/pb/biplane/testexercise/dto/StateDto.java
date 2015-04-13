package ua.com.pb.biplane.testexercise.dto;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;
import ua.com.pb.biplane.testexercise.dto.enumerations.Status;

/**
 * Created by Baelousov Artur Igorevich. E-mail: g.infosecurity@gmail.com on 12.04.15.
 */
@Root(name = "StateDto")
public class StateDto {

    @Element(name = "result")
    private String result;

    @Element(name = "status")
    private Status status;

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
