package Utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {

    static final String CAR_PLATE_REGEX = "^[a-zA-Z0-9_]*$";

    public String checkSring(String verb) {
        if (!carPlateReg(verb)) {
            return "String contains illegar characters : " + verb;
        } else {
            verb = verb.toUpperCase();
        }
        return verb;
    }

    private boolean carPlateReg(String verb) {
        Pattern pattern = Pattern.compile(CAR_PLATE_REGEX);
        Matcher matcher = pattern.matcher(verb);
        boolean matches = matcher.matches();
        return matches;
    }
}
