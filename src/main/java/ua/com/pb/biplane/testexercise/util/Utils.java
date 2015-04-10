package ua.com.pb.biplane.testexercise.util;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;

/**
 * Created by artur on 09.04.15.
 */
public class Utils {

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


    public boolean containsOnlyDigit(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i)))
                return false;
        }
        return true;
    }
}
