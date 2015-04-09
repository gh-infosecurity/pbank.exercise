package ua.com.pb.biplane.testexercise.ui;

import ua.com.pb.biplane.testexercise.dto.InputDto;

import javax.swing.*;
import java.io.File;

/**
 * Created by artur on 09.04.15.
 */
public class UiFile extends Storage {
    private JFrame frame;

    public UiFile(String path) {
        super(path);
        frame = new JFrame();
        frame.setVisible(true);
        BringToFront();
    }

    public UiFile() {
        super();
    }

    @Override
    public InputDto readData() throws Exception {
        file = getFile();
        InputDto dto = persister.read(InputDto.class, file);
        return dto;
    }

    public File getFile() {
        JFileChooser chooser = new JFileChooser();
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

    private void BringToFront() {
        frame.setExtendedState(JFrame.ICONIFIED);
        frame.setExtendedState(JFrame.NORMAL);

    }
}
