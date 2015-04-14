package ua.com.pb.biplane.testexercise.util;

import ua.com.pb.biplane.testexercise.dto.InputDto;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.lang.reflect.Array;
import java.util.*;

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

    public static InputDto doLoopFilter(InputDto dto){
        Set<String> set = new HashSet<String>(Arrays.asList(dto.getValues()));
        dto.setValues(set.toArray(new String[set.size()]));
        return dto;
    }

    public static InputDto doRevers(InputDto dto){
        ArrayList<String> list = new ArrayList<String>(Arrays.asList(dto.getValues()));
        Collections.reverse(list);
        dto.setValues(list.toArray(new String[list.size()]));
        return dto;
    }
}
