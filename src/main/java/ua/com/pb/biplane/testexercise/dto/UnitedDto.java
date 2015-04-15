package ua.com.pb.biplane.testexercise.dto;

/**
 * Created by artur on 15.04.15.
 */
public class UnitedDto {
    ConfigDto confDto;
    StateDto stDato;
    InputDto inputDto;


    public StateDto getStDato() {
        return stDato;
    }

    public void setStDato(StateDto stDato) {
        this.stDato = stDato;
    }

    public InputDto getInputDto() {
        return inputDto;
    }

    public void setInputDto(InputDto inputDto) {
        this.inputDto = inputDto;
    }

    public ConfigDto getConfDto() {

        return confDto;
    }

    public void setConfDto(ConfigDto confDto) {
        this.confDto = confDto;
    }
}
