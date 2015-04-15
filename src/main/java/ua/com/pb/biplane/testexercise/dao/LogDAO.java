package ua.com.pb.biplane.testexercise.dao;

import ua.com.pb.biplane.testexercise.dto.ConfigDto;
import ua.com.pb.biplane.testexercise.dto.StateDto;

/**
 * Created by artur on 15.04.15.
 */
public class LogDAO {
    ConfigDto confDto;
    StateDto stDto;

    public LogDAO(ConfigDto confDto, StateDto stDto) {
        this.confDto = confDto;
        this.stDto = stDto;
    }

    public Boolean persistLog(){
        return null;
    }
}
