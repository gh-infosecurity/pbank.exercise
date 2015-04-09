package ua.com.pb.biplane.testexercise.main;

import ua.com.pb.biplane.testexercise.bl.Blogic;
import ua.com.pb.biplane.testexercise.dto.InputDto;
import ua.com.pb.biplane.testexercise.ui.Storage;

import java.sql.Blob;


/**
 * Created by artur on 08.04.15.
 */
public class Main {
    public static void main(String[] args) throws Exception {

        InputDto dto;
        Blogic bl = new Blogic(args);

        dto = bl.readData();

        bl.printReadetData(dto);

//        bl.createExampleXml();


        System.out.println("Finish ! ! !");
    }
}
