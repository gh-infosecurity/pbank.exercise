package ua.com.pb.biplane.testexercise.input.fs.exceptions;

/**
 * Created by Baelousov Artur Igorevich. E-mail: g.infosecurity@gmail.com on 13.04.15.
 */
public class ErrorXML extends Exception{
    public ErrorXML() { super(); }
    public ErrorXML(String s) { super(s); }
    public ErrorXML(String s, Throwable throwable) { super(s, throwable); }
    public ErrorXML(Throwable throwable) { super(throwable); }
}
