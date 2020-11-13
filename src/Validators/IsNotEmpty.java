package Validators;

public class IsNotEmpty extends ValidationChecker{

    public boolean isValid(String input){
        return !input.equals("");
    }

    String getDescription() {
        return "Checks if input is not empty.";
    }
}
