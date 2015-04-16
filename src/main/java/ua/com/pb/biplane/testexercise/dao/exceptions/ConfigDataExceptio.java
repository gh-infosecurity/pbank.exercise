package ua.com.pb.biplane.testexercise.dao.exceptions;

/**
 * Created by Baelousov Artur Igorevich. E-mail: g.infosecurity@gmail.com on 13.04.15.
 */
public class ConfigDataExceptio extends Exception{
    public ConfigDataExceptio() { super(); }
    public ConfigDataExceptio(String s) { super(s); }
    public ConfigDataExceptio(String s, Throwable throwable) { super(s, throwable); }
    public ConfigDataExceptio(Throwable throwable) { super(throwable); }
}
