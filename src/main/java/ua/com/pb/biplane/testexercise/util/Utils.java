package ua.com.pb.biplane.testexercise.util;

import ua.com.pb.biplane.testexercise.dto.InputDto;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;

/**
 * Created by artur on 09.04.15.
 */
public class Utils {

    public static boolean containsOnlyNumbers(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i)))
                return false;
        }
        return true;
    }


    public static boolean containsOnlyChars(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i)))
                return false;
        }
        return true;
    }
}
