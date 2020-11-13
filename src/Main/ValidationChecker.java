package Main;

import Validators.IsCarNum;
import Validators.IsNotEmpty;
import Validators.IsNotNull;
import Validators.IsPersNum;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class ValidationChecker {
    private IsCarNum isCarNum = new IsCarNum();
    private IsPersNum isPersNum = new IsPersNum();
    private IsNotEmpty isNotEmpty = new IsNotEmpty();
    private IsNotNull isNotNull = new IsNotNull();
    private ErrorLogger errorLogger = new ErrorLogger();

    public ValidationChecker() throws IOException {
    }

    public void validateInput(String input){
        if(isNotNull.isValid(input) && isNotEmpty.isValid(input)){
            if(isPersNum.isValid(input)){
                System.out.println(input + " is a valid personal number.");
            } else if(isCarNum.isValid(input)){
                System.out.println(input + " is a valid car number.");
            } else {
                System.out.println(input + " is neiter a personal number or car number.");
                errorLogger.loggError(input);
            }
        }
    }


    public static void main(String[] args) throws IOException {
        ArrayList argsList = new ArrayList(Arrays.asList(args));
        ValidationChecker validationChecker = new ValidationChecker();
        Arrays.stream(args).forEach(n -> {
            validationChecker.validateInput(n);
        });
    }
}
