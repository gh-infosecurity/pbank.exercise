package ua.com.pb.biplane.testexercise.input.web;

import org.simpleframework.xml.core.Persister;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.com.pb.biplane.testexercise.dto.InputDto;
import ua.com.pb.biplane.testexercise.input.IStorage;

/**
 * Created by artur on 08.04.15.
 */
 public class WebStorage implements IStorage{

    protected Persister persister = new Persister();
    private InputDto dto = null;
    private String xml;

    public WebStorage(String xml) {
        this.xml = xml;
    }

    @Override
    public InputDto readInputData() throws Exception {
        dto = persister.read(InputDto.class, xml);
        return dto;
    }
}
