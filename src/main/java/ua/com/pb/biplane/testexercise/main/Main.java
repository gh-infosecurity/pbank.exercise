package ua.com.pb.biplane.testexercise.main;

import com.beust.jcommander.JCommander;
import ua.com.pb.biplane.testexercise.bl.Blogic;
import ua.com.pb.biplane.testexercise.dto.InputDto;
import ua.com.pb.biplane.testexercise.ui.Settings;


/**
 * Created by artur on 08.04.15.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        InputDto dto;
        Settings settings = new Settings();
        new JCommander(settings, args);
        Blogic bl;

        if (Settings.generate!=null & Settings.path==null){
            bl = new Blogic(Settings.generate);
            bl.writeXml(bl.generateExampleDto());
            System.out.println("Example file was generated at "+Settings.generate);
        }else{
            bl = new Blogic(Settings.path);
        }

        dto = bl.readData();

        switch ((int)dto.getOperation()){
            case  (int)'+': {
                System.out.println("----------------------------------------------");
                bl.runSumNumber(dto);
                System.out.println("----------------------------------------------");
                bl.runSumString(dto);
                System.out.println("----------------------------------------------");
                break;
            }
            case (int)'-':{
                System.out.println("----------------------------------------------");
                bl.runSubtractionNumber(dto);
                System.out.println("----------------------------------------------");
                break;
            }
            case (int)'/':{
                System.out.println("----------------------------------------------");
                bl.runDivisionNumber(dto);
                System.out.println("----------------------------------------------");
                break;
            }
            case (int)'*':{
                System.out.println("----------------------------------------------");
                bl.runMultiplicationNumber(dto);
                System.out.println("----------------------------------------------");
                break;
            }

            default:{
                System.out.println("operation "+dto.getOperation()+" is not permited");
                System.exit(0);
            }

        }

        System.out.println("Finish ! ! !");
    }
}
