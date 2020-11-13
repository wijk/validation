package Validators;

import Main.TextFormatter;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IsPersNum extends ValidationChecker {
    private final TextFormatter tf = new TextFormatter();
    private final Pattern persNumP = Pattern.compile("\\d{8,10}");
    private Matcher m;

    public boolean isValid(String input){
        List<String> persNumList = tf.formatPersNumInput(input);
        m = persNumP.matcher(String.join("", persNumList));
        if(m.matches()) {
            List<Integer> persNumIntList = tf.toIntList(persNumList);
            int lastNum = persNumIntList.get(persNumList.size() - 1);
            persNumIntList.remove(persNumList.size() - 1);
            return persNumMod(persNumReduceToSingles(persNumMult(persNumIntList)), lastNum);
        }
        return false;
    }
    //Itterates through the list and multiplies each even index with 2
    private List<Integer> persNumMult(List<Integer> input){
        for(int i = 0; i < input.size(); i++){
            if(i % 2 == 0){
                input.set(i, (int) input.get(i) * 2);
            }
        }
        return input;
    }
    //Itterates through the list, each value of 10 or bigger gets added together, ie 11 => 1+1 = 2
    private List<Integer> persNumReduceToSingles(List<Integer> input){
        for(int i = 0; i < input.size(); i++){
            if((int) input.get(i) >= 10){
                input.set(i, String.valueOf(input.get(i))
                        .chars()
                        .map(Character::getNumericValue)
                        .sum());
            }
        }
        return input;
    }
    //Adds the list together and does mod(totalValue) => 10-value => mod value
    private boolean persNumMod(List<Integer> input, int lastNum){
        int validator =  input.stream().mapToInt(n -> (int) n).sum();
        validator = (10 - (validator % 10)) % 10;
        return validator == lastNum;
    }

    String getDescription() {
        return "Checks if input is a valid swedish personal number";
    }
}
