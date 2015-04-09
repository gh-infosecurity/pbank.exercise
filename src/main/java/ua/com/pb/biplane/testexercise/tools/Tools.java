package ua.com.pb.biplane.testexercise.tools;

import ua.com.pb.biplane.testexercise.dto.InputDto;
import ua.com.pb.biplane.testexercise.dto.Status;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;

/**
 * Created by artur on 09.04.15.
 */
public class Tools {

    public InputDto fillDto() {
        InputDto dto = new InputDto();
        dto.setOperation("sum");
        dto.setChecker(true);
        dto.setStatus(Status.OK);
        String [] values = {"123","1q","2"};
        dto.setValues(values);
        return dto;
    }

    public File getFile() {
        File file = null;
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("xml files (*.xml)", "xml");
        chooser.setFileFilter(filter);
        int result = chooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION)
            file = chooser.getSelectedFile();
        else
        {
            JOptionPane.showMessageDialog(null, "No file selected");
            System.exit(1);
        }
        return file;
    }

    public boolean containsOnlyNumbers(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i)))
                return false;
        }
        return true;
    }
}
