package ua.com.pb.biplane.testexercise.main;

import com.beust.jcommander.JCommander;
import ua.com.pb.biplane.testexercise.bl.BuisnLog;
import ua.com.pb.biplane.testexercise.bl.exceptions.IncorrectConfigData;
import ua.com.pb.biplane.testexercise.bl.exceptions.NumberConfigDataTooMatch;
import ua.com.pb.biplane.testexercise.input.DataController;
import ua.com.pb.biplane.testexercise.input.fs.exceptions.ErrorXML;
import ua.com.pb.biplane.testexercise.util.CLineArgs;

import java.io.IOException;


/**
 * Created by artur on 08.04.15.
 */
public class Main {
    static DataController inputData;

    public static void main(String[] args) {
        CLineArgs cla = new CLineArgs();
        new JCommander(cla, args);

        if (cla.getGenerate() != null & cla.getPath() == null) {
            inputData = new DataController(cla.getGenerate());
            inputData.generateExampleDto();
            System.out.println("Example file was generated at " + cla.getGenerate());
        } else {
            inputData = new DataController(cla.getPath());
        }


        try {
            BuisnLog buisnLog = new BuisnLog(inputData);
            buisnLog.doOperation();
        } catch (IncorrectConfigData e) {
            System.out.println(e.getMessage());
        } catch (ErrorXML errorXML) {
            System.out.println(errorXML.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
