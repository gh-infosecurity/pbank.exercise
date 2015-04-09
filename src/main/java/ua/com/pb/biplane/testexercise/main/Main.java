package ua.com.pb.biplane.testexercise.main;

import ua.com.pb.biplane.testexercise.bl.Blogic;
import ua.com.pb.biplane.testexercise.dto.InputDto;


/**
 * Created by artur on 08.04.15.
 */
public class Main {
    public static void main(String[] args) throws Exception {

        InputDto dto;
        Blogic bl = new Blogic(args);

//        bl.writeXml(bl.generateExampleDto());

        dto = bl.readData();

        System.out.println("----------------------------------------------");
        bl.runSumNumber(dto);
        System.out.println("----------------------------------------------");
        bl.runSumString(dto);
        System.out.println("----------------------------------------------");

        System.out.println("Finish ! ! !");
    }
}
