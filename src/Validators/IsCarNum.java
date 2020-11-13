package Validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import Main.TextFormatter;

public class IsCarNum extends Validatator {
    private final TextFormatter tf = new TextFormatter();
    private final Pattern carP = Pattern.compile("^[A-Za-z]{3}\\d{3}");
    private Matcher m;

    public boolean isValid(String input){
        String carNumString = String.join("", tf.removeDashAndSpace(input));
        m = carP.matcher(carNumString);
        return m.matches();
    }

    String getDescription() {
        return "Checks if input is a valid swedish car number.";
    }
}
