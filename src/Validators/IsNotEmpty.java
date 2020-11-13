package Validators;

public class IsNotEmpty extends Validatator {

    public boolean isValid(String input){
        return !input.equals("");
    }

    String getDescription() {
        return "Checks if input is not empty.";
    }
}
