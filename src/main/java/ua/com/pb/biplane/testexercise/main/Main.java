package ua.com.pb.biplane.testexercise.main;

import com.beust.jcommander.JCommander;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.com.pb.biplane.testexercise.bl.BuisnLog;
import ua.com.pb.biplane.testexercise.input.DataController;
import ua.com.pb.biplane.testexercise.util.CLineArgs;


/**
 * Created by artur on 08.04.15.
 */
public class Main {
    static private Logger logger = LoggerFactory.getLogger(Main.class);
    static DataController inputData;

    public static void main(String[] args){
        CLineArgs cla = new CLineArgs();
        new JCommander(cla, args);

        if (cla.getGenerate()!=null & cla.getPath()==null){
            inputData = new DataController(cla.getGenerate());
            inputData.generateExampleDto();
            System.out.println("Example file was generated at "+ cla.getGenerate());
        }else {
            inputData = new DataController(cla.getPath());
        }

        BuisnLog buisnLog = new BuisnLog(inputData);
        try {
            buisnLog.doOperation();
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }
}
