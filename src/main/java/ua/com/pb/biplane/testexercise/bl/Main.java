package ua.com.pb.biplane.testexercise.bl;

import org.simpleframework.xml.core.Persister;
import ua.com.pb.biplane.testexercise.dto.InputDto;

import java.io.File;


/**
 * Created by artur on 08.04.15.
 */
public class Main {
    public static void main(String[] args) throws Exception {

        InputDto dto = new InputDto();
        Storage storage = new Storage();

//        storage.create(dto);

        dto = storage.readData();

        System.out.println("Finish ! ! !");

        for (String s:dto.values){
            System.out.println(s);
        }
    }
}
