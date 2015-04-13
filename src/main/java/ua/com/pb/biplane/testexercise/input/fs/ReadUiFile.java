package ua.com.pb.biplane.testexercise.input.fs;

import ua.com.pb.biplane.testexercise.dto.InputDto;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;


/**
 * Created by artur on 09.04.15.
 */
public class ReadUiFile extends FsStorage {


    @Override
    public InputDto readInputData() throws Exception {
        file = getFile();
        InputDto dto = persister.read(InputDto.class, file);
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
}
