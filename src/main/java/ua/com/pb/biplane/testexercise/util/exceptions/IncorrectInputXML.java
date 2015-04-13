package ua.com.pb.biplane.testexercise.util.exceptions;

/**
 * Created by Baelousov Artur Igorevich. E-mail: g.infosecurity@gmail.com on 13.04.15.
 */
public class IncorrectInputXML extends Exception{
    public IncorrectInputXML() { super(); }
    public IncorrectInputXML(String s) { super(s); }
    public IncorrectInputXML(String s, Throwable throwable) { super(s, throwable); }
    public IncorrectInputXML(Throwable throwable) { super(throwable); }
}
