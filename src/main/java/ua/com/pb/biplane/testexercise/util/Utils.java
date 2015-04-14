package ua.com.pb.biplane.testexercise.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.com.pb.biplane.testexercise.dto.InputDto;
import ua.com.pb.biplane.testexercise.input.fs.exceptions.ErrorXML;
import ua.com.pb.biplane.testexercise.servlet.InpunServletFilter;
import ua.com.pb.biplane.testexercise.util.exceptions.IncorrectInputXML;

import javax.servlet.http.HttpServletRequest;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.util.*;
import java.util.logging.Level;

/**
 * Created by artur on 09.04.15.
 */
public class Utils {
    static Logger logger = LoggerFactory.getLogger(Utils.class);

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
        Set<String> set = new HashSet<>(Arrays.asList(dto.getValues()));
        dto.setValues(set.toArray(new String[set.size()]));
        return dto;
    }

    public static InputDto doRevers(InputDto dto){
        ArrayList<String> list = new ArrayList<>(Arrays.asList(dto.getValues()));
        Collections.reverse(list);
        dto.setValues(list.toArray(new String[list.size()]));
        return dto;
    }

    public static String getInputXML(InputStream in, String chEncoding, int dataLength) {

        String xml = null;
        try {
            byte[] xmlData = new byte[dataLength];

            InputStream sis = in;
            BufferedInputStream bis = new BufferedInputStream(sis);

            bis.read(xmlData, 0, xmlData.length);


            if (chEncoding != null) {
                xml = new String(xmlData, chEncoding);
            } else {
                xml = new String(xmlData);
            }
        } catch (IOException e) {
            logger.error(e.getMessage());
        }

        return xml;
    }

    public static Boolean isValidXML(File file){
        XMLValidator validator = new XMLValidator();

        try {
            validator.validate(file);
            return true;
        } catch (IncorrectInputXML|IOException e) {
            logger.error(e.getMessage());
            return false;
        }
    }
}
