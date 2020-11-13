package Validators;

public class IsNotNull extends ValidationChecker{

    public boolean isValid(String input){
        return input != null;
    }

    String getDescription() {
        return "Checks if input is not null.";
    }
}
