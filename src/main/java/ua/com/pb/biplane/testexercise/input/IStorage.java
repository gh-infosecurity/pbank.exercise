package ua.com.pb.biplane.testexercise.input;

import ua.com.pb.biplane.testexercise.dto.InputDto;


/**
 * Created by artur on 14.04.15.
 */
public interface IStorage {
    public InputDto readInputData() throws Exception;
}
