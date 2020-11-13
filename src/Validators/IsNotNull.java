package Validators;

public class IsNotNull extends Valid {

    @Override
    public boolean isValid(String input){
        return input != null;
    }

    public String getDescription() {
        return "IsNotNull: Checks if input is not null.";
    }
}
