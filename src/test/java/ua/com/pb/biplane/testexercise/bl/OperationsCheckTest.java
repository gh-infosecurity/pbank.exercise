package ua.com.pb.biplane.testexercise.bl;

import org.junit.Before;
import org.junit.Test;
import ua.com.pb.biplane.testexercise.dto.InputDto;
import ua.com.pb.biplane.testexercise.tools.Tools;

import static org.junit.Assert.*;

/**
 * Created by artur on 09.04.15.
 */
public class OperationsCheckTest {
    Tools tools;
    InputDto dto;
    Operations operations;
    Blogic blogic;

    public OperationsCheckTest() {
        tools = new Tools();
        String [] path = {"/home/artur/test.xml"};
        blogic = new Blogic(path);
    }

    @Before
    public void setUp() throws Exception {
        dto = blogic.readData();
    }

    @Test
    public void testSumNumbers() throws Exception {

        operations = new  OperationsCheck();
        dto = operations.sumNumbers(dto);
        assertEquals(dto.getResult(), Integer.toString(130));
    }

    @Test
    public void testSumStrings() throws Exception {
        operations = new  OperationsCheck();
        dto = operations.sumStrings(dto);
        assertEquals(dto.getResult(), "1q3g");
    }
}