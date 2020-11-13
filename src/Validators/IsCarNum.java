package Validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import Main.TextFormatter;

public class IsCarNum extends Valid {
    private final TextFormatter tf = new TextFormatter();
    private final Pattern carP = Pattern.compile("^[A-Za-z]{3}\\d{3}");
    private Matcher m;

    @Override
    public boolean isValid(String input){
        String carNumString = String.join("", tf.removeDashAndSpace(input));
        m = carP.matcher(carNumString);
        return m.matches();
    }

    public String getDescription() {
        return "IsCarNum: Checks if input is a valid swedish car number.";
    }
}
