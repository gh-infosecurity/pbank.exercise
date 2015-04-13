package ua.com.pb.biplane.testexercise.input.exceptions;

/**
 * Created by Baelousov Artur Igorevich. E-mail: g.infosecurity@gmail.com on 13.04.15.
 */
public class IncorrectConfigData extends RuntimeException{
    public IncorrectConfigData() { super(); }
    public IncorrectConfigData(String s) { super(s); }
    public IncorrectConfigData(String s, Throwable throwable) { super(s, throwable); }
    public IncorrectConfigData(Throwable throwable) { super(throwable); }
}
