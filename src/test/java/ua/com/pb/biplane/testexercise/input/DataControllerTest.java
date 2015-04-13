package ua.com.pb.biplane.testexercise.input;

import org.junit.Test;
import ua.com.pb.biplane.testexercise.dto.ConfigDto;
import ua.com.pb.biplane.testexercise.dto.InputDto;
import ua.com.pb.biplane.testexercise.dto.enumerations.TypeOfOperations;
import ua.com.pb.biplane.testexercise.util.CLineArgs;


import static org.junit.Assert.*;


/**
 * Created by Baelousov Artur Igorevich. E-mail: g.infosecurity@gmail.com on 13.04.15.
 */
public class DataControllerTest {

    String INPUT_FILE = "src/test/resources/xml/in.xml";
    DataController dataController;
    ConfigDto confDto;

    public DataControllerTest() throws Exception{
        dataController = new DataController(INPUT_FILE);
        confDto = dataController.getProperties();
    }

    @Test
    public void testGetProperties_ok() throws Exception {
        ConfigDto expected = dataController.getProperties();
        confDto = dataController.getProperties();
        confDto.setNumberOfInputElements(5);
        confDto.setTypeOfOperations(TypeOfOperations.SUM_INT_WITH_CHECK);


    }

    @Test
    public void testGetProperties_IllExc() throws Exception {
        dataController.getProperties();

    }

    @Test
    public void testGetProperties_IOExc() throws Exception {
        dataController.getProperties();

    }

    @Test(expected = Exception.class)
    public void testGetInputData_XML_Exc() throws Exception {
        dataController.getInputData(confDto);
    }

    @Test
    public void testGetInputData_Exception() throws Exception {
        InputDto expected = dataController.getInputData(confDto);

        InputDto current = new InputDto();
        String [] values = {"123", "1q", "2", "3g", "5"};
        current.setValues(values);

        assertArrayEquals(expected.getValues(), current.getValues());
    }

    @Test(expected = Exception.class)
    public void testGetInputData_Ok() throws Exception {
        InputDto expected = dataController.getInputData(confDto);

        InputDto current = new InputDto();
        String [] values = {"123", "1q", "2", "3g", "5"};
        current.setValues(values);

        assertArrayEquals(expected.getValues(), current.getValues());
    }

    @Test
    public void testGenerateExampleDto_Ok() throws Exception {

        CLineArgs cla = new CLineArgs();
        InputDto expected = dataController.getInputData(confDto);
        dataController.generateExampleDto();

        InputDto current = new InputDto();
        String [] values = {"123", "1q", "2", "3g", "5"};
        current.setValues(values);

        assertArrayEquals(expected.getValues(), current.getValues());
    }


    @Test
    public void testGenerateExampleDto_False() throws Exception {

        CLineArgs cla = new CLineArgs();
        InputDto expected = dataController.getInputData(confDto);
        dataController.generateExampleDto();

        InputDto current = new InputDto();
        String [] values = {"123", "1q", "2", "3g"};
        current.setValues(values);

        assertFalse(expected.getValues().length == current.getValues().length);
    }
}