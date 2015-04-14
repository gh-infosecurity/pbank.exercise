package ua.com.pb.biplane.testexercise.input.fs;

import ua.com.pb.biplane.testexercise.bl.exceptions.IncorrectConfigData;
import ua.com.pb.biplane.testexercise.bl.exceptions.NumberConfigDataTooMatch;
import ua.com.pb.biplane.testexercise.dto.ConfigDto;
import ua.com.pb.biplane.testexercise.dto.InputDto;
import ua.com.pb.biplane.testexercise.input.IStorage;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;


/**
 * Created by artur on 09.04.15.
 */
public class ReadUiFile extends FsStorage implements IStorage {


    public ReadUiFile(ConfigDto conf) {
        confDto = conf;
    }

    @Override
    public InputDto readInputData() throws IncorrectConfigData {
        file = getFile();
        InputDto dto = null;

        try {
            dto = persister.read(InputDto.class, file);
            dto.setValues(getInputValue(dto.getValues()));
        } catch (NumberConfigDataTooMatch e) {
            throw new IncorrectConfigData(e.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage());
        }

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
        else {
            JOptionPane.showMessageDialog(null, "No file selected");
            System.exit(1);
        }
        return file;
    }
}
