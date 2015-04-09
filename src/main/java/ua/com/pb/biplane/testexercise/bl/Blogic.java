package ua.com.pb.biplane.testexercise.bl;

import ua.com.pb.biplane.testexercise.dto.InputDto;
import ua.com.pb.biplane.testexercise.ui.Storage;
import ua.com.pb.biplane.testexercise.ui.TermFile;
import ua.com.pb.biplane.testexercise.ui.UiFile;

/**
 * Created by artur on 09.04.15.
 */
public class Blogic {
    String filePath;
    Storage storage;

    public Blogic(String[] args) {

        if (args.length != 0 && !args[0].isEmpty()){
            filePath=args[0];
            storage = new TermFile(filePath);
        }else {
            storage = new UiFile();
        }
    }


    public InputDto readData() throws Exception {
        return storage.readData();
    }

    public void printReadetData(InputDto dto) {
        System.out.println(dto.getOperation());
        for (String s:dto.getValues()){
            System.out.println(s);
        }
    }

    public void writeXml(InputDto dto) throws Exception {
        storage.create(dto);
    }
}
