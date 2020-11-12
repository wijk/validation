import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationChecker{
    private final TextFormatter tf = new TextFormatter();
    private final Pattern carP = Pattern.compile("^[A-Za-z]{3}\\d{3}");
    private final Pattern persNumP = Pattern.compile("\\d{8,10}");
    private Logger logger = new Logger();
    private Matcher m;

    public boolean validationChecker(String input){
        if(notNull(input) && notEmpty(input)){
            if(validCarNumber(input) || validPersNum(input)){
                return true;
            } else {
                logger.loggData(input);
                return false;
            }
        }
        logger.loggData(input);
        return false;
    }

    private boolean notNull(String input){
        return input != null;
    }

    private boolean notEmpty(String input){
        return !input.equals("");
    }

    public boolean validCarNumber(String input){
            String carNumString = String.join("", tf.removeDashAndSpace(input));
            m = carP.matcher(carNumString);
            System.out.println(carNumString);
            return m.matches();
    }

    public boolean validPersNum(String input){
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

}
