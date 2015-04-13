package ua.com.pb.biplane.testexercise.bl.exceptions;

/**
 * Created by Baelousov Artur Igorevich. E-mail: g.infosecurity@gmail.com on 13.04.15.
 */
public class NumberConfigDataTooMatch extends IncorrectConfigData{
    public NumberConfigDataTooMatch() { super(); }
    public NumberConfigDataTooMatch(String s) { super(s); }
    public NumberConfigDataTooMatch(String s, Throwable throwable) { super(s, throwable); }
    public NumberConfigDataTooMatch(Throwable throwable) { super(throwable); }
}
