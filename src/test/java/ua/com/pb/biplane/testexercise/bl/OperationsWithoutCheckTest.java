package ua.com.pb.biplane.testexercise.bl;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import ua.com.pb.biplane.testexercise.dto.InputDto;
import ua.com.pb.biplane.testexercise.dto.Status;
import ua.com.pb.biplane.testexercise.tools.Tools;

import static org.junit.Assert.*;

/**
 * Created by artur on 09.04.15.
 */
public class OperationsWithoutCheckTest {
    Tools tools;
    InputDto dto;
    Operations operations;
    Blogic blogic;

    public OperationsWithoutCheckTest() {
        tools = new Tools();
        String [] path = {"/tmp/test.xml"};
        blogic = new Blogic(path);
    }

    @BeforeClass
    public static void onceExecutedBeforeAll() throws Exception {
        InputDto dto = new InputDto();
        dto.setOperation("+");
        dto.setChecker(false);
        dto.setStatus(Status.UNKNOW);
        String[] values = {"123", "1q", "2", "3g", "5"};
        dto.setValues(values);
        dto.setResult(Status.NO_RESULT.toString());


        String [] path = {"/tmp/test.xml"};
        Blogic blogic = new Blogic(path);
        blogic.writeXml(dto);
    }

    @Before
    public void setUp() throws Exception {
        dto = blogic.readData();
    }

    @Test
    public void testSumNumbers() throws Exception {

        operations = new OperationsWithoutCheck();
        dto = operations.sumNumbers(dto);
        assertEquals(dto.getResult(), Integer.toString(130));
    }

    @Test
    public void testSumStrings() throws Exception {
        operations = new OperationsWithoutCheck();
        dto = operations.sumStrings(dto);
        assertEquals(dto.getResult(), "1q3g");
    }
}