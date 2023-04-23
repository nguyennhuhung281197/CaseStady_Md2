package model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailExample {
    private static Pattern pattern;
    private Matcher matcher;

    private static final String EMAIL_REGEX =   "^[A-Za-z0-9]+@gmail+(\\.[A-Za-z0-9]+)$";

    public EmailExample() {

    }

    public boolean validate(String regex) {
        pattern = Pattern.compile(EMAIL_REGEX);
        matcher = pattern.matcher(regex);
        return matcher.matches();
    }


}