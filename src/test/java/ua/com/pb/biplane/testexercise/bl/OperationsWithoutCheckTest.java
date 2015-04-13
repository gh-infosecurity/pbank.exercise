package ua.com.pb.biplane.testexercise.bl;

import org.junit.Before;
import org.junit.Test;
import ua.com.pb.biplane.testexercise.bl.exceptions.IncorrectConfigData;
import ua.com.pb.biplane.testexercise.dto.ConfigDto;
import ua.com.pb.biplane.testexercise.dto.InputDto;
import ua.com.pb.biplane.testexercise.dto.StateDto;
import ua.com.pb.biplane.testexercise.input.DataController;
import ua.com.pb.biplane.testexercise.util.Utils;
import static org.junit.Assert.assertEquals;


/**
 * Created by artur on 09.04.15.
 */
public class OperationsWithoutCheckTest {
    String CONFIG_FILE = "src/test/resources/config.properties";
    String INPUT_FILE = "src/test/resources/xml/in.xml";
    Utils tools;
    DataController dataController;
    Operations operations;
    BuisnLog bll;
    InputDto dto;
    StateDto stDto;
    ConfigDto confDto;

    public OperationsWithoutCheckTest() throws IncorrectConfigData {
        tools = new Utils();
        stDto = new StateDto();
        confDto = new ConfigDto();
        bll = new BuisnLog(new DataController(INPUT_FILE));
        dataController = new DataController(INPUT_FILE);
    }


    @Before
    public void setUp() throws Exception {
        confDto = dataController.getProperties();
    }

    @Test
    public void testSumNumbers() throws Exception {

        operations = new SumWithoutCheck(confDto);
        dto = operations.sumNumbers(dto);
        assertEquals(stDto.getResult(), Integer.toString(130));
    }

    @Test
    public void testSumStrings() throws Exception {
        operations = new SumWithoutCheck(confDto);
        dto = operations.sumStrings(dto);
        assertEquals(stDto.getResult(), "1q3g");
    }
}