package ua.com.pb.biplane.testexercise.dto;

import ua.com.pb.biplane.testexercise.dto.enumerations.TypeOfOperations;

/**
 * Created by Baelousov Artur Igorevich. E-mail: g.infosecurity@gmail.com on 12.04.15.
 */
public class ConfigDto {
    private int numberOfInputElements;
    private TypeOfOperations typeOfOperations;

    public int getNumberOfInputElements() {
        return numberOfInputElements;
    }

    public void setNumberOfInputElements(int numberOfInputElements) {
        this.numberOfInputElements = numberOfInputElements;
    }

    public TypeOfOperations getTypeOfOperations() {
        return typeOfOperations;
    }

    public void setTypeOfOperations(TypeOfOperations typeOfOperations) {
        this.typeOfOperations = typeOfOperations;
    }
}
