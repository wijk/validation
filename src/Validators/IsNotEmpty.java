package Validators;

public class IsNotEmpty extends Valid {

@Override
    public boolean isValid(String input){
        return !input.equals("");
    }

    public String getDescription() {
        return "IsNotEmpty: Checks if input is not empty.";
    }
}
