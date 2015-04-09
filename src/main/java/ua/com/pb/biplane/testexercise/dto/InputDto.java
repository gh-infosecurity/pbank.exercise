package ua.com.pb.biplane.testexercise.dto;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import java.util.List;

/**
 * Created by artur on 08.04.15.
 */
@Root(name="InputData")
public class InputDto
{
    @Element(name="operation")
    public String operation;

    @Element(name="values")
    public String values[];
    
}
