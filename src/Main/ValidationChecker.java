package Main;

import Validators.*;

import java.util.*;

public class ValidationChecker {
    private IsCarNum isCarNum = new IsCarNum();
    private IsPersNum isPersNum = new IsPersNum();
    private IsNotEmpty isNotEmpty = new IsNotEmpty();
    private IsNotNull isNotNull = new IsNotNull();
    private ErrorLogger errorLogger = new ErrorLogger();
    private List<Valid> validatorList;

    public ValidationChecker() {
    }

    public void validateInput(String input){
        for(Valid validator : validatorList){
            if(!validator.isValid(input)){
                errorLogger.loggError(input + " Failed at " + validator.getDescription());
            } else {

            }
        }
    }

    private void makeValidatorList(String type){
        validatorList = new ArrayList<Valid>();
        validatorList.add(isNotNull);
        validatorList.add(isNotEmpty);
        if(type.equals("carnum")){
            validatorList.add(isCarNum);
        } else {
            validatorList.add(isPersNum);
        }

    }


    public static void main(String[] args) {
        ArrayList<String> argsList = new ArrayList(Arrays.asList(args));
        ValidationChecker validationChecker = new ValidationChecker();
        validationChecker.makeValidatorList(argsList.get(0).toString());
        argsList.remove(0);
        argsList.stream().forEach(n ->{
            validationChecker.validateInput(n);
        });
    }
}
