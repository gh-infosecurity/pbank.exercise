package ua.com.pb.biplane.testexercise.input.fs;

import org.simpleframework.xml.core.Persister;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.com.pb.biplane.testexercise.dto.ConfigDto;
import ua.com.pb.biplane.testexercise.dto.InputDto;
import java.io.File;

/**
 * Created by artur on 08.04.15.
 */
abstract public class FsStorage {
    protected Logger logger = LoggerFactory.getLogger(FsStorage.class);
    File file = null;
    ConfigDto confDto = null;
    protected Persister persister = new Persister();

    abstract public InputDto readInputData() throws Exception;
}
