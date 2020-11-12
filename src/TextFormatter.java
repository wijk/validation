import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TextFormatter {
    private List<String> stringList;

    public List<String> removeDashAndSpace(String input){
        stringList = new ArrayList<String>(Arrays.asList(input.split("")));
        stringList.remove("-");
        stringList.remove(" ");
        return stringList;
    }

    public List<String> formatPersNumInput(String input){
        stringList = removeDashAndSpace(input);
        if(stringList.size() == 12) {
            stringList = stringList.subList(2, stringList.size());
        }
        return stringList;
    }

    public List<Integer> toIntList(List<String> input){
        return input.stream().map(Integer::parseInt).collect(Collectors.toList());
    }
}
