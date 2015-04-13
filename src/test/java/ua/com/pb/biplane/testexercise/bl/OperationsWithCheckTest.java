package ua.com.pb.biplane.testexercise.bl;

import org.junit.Before;
import org.junit.Test;
import ua.com.pb.biplane.testexercise.dto.ConfigDto;
import ua.com.pb.biplane.testexercise.dto.InputDto;
import ua.com.pb.biplane.testexercise.dto.StateDto;
import ua.com.pb.biplane.testexercise.dto.enumerations.Status;
import ua.com.pb.biplane.testexercise.input.DataController;
import ua.com.pb.biplane.testexercise.util.CLineArgs;
import ua.com.pb.biplane.testexercise.util.Utils;

import static org.junit.Assert.assertEquals;

/**
 * Created by artur on 09.04.15.
 */
public class OperationsWithCheckTest {

    String CONFIG_FILE = "src/test/resources/config.properties";
    String INPUT_FILE = "src/test/resources/xml/in.xml";

    Utils utils;
    InputDto dto;
    StateDto stDto;
    Operations operations;
    BuisnLog bll;
    DataController dataController;
    ConfigDto confDto;

    public OperationsWithCheckTest() {
        utils = new Utils();
        stDto = new StateDto();
        bll = new BuisnLog(new DataController(INPUT_FILE));
        dataController = new DataController(INPUT_FILE);
    }


    @Before
    public void setUp() throws Exception {
        CLineArgs cla = new CLineArgs();
        confDto = dataController.getProperties();
        dataController.generateExampleDto();

    }

    @Test
    public void testSumNumbers_Check() throws Exception {
        operations = new SumWithCheck(confDto);
        dto = operations.sumNumbers(dto);
        assertEquals(stDto.getResult(), Integer.toString(0));
        assertEquals(stDto.getStatus(), Status.FAIL);
    }

    @Test
    public void testSumStrings_Check() throws Exception {
        operations = new SumWithCheck(confDto);
        dto = operations.sumStrings(dto);
        assertEquals(stDto.getResult(), Status.NO_RESULT.toString());
        assertEquals(stDto.getStatus(), Status.FAIL);
    }
}