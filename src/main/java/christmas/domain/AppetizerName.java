package christmas.domain;

import java.util.ArrayList;
import java.util.List;

public class AppetizerName {
    private List<String> appetizerNames;

    public AppetizerName() {
        this.appetizerNames = inputAppetizerName();
    }

    public List<String> inputAppetizerName() {
        appetizerNames = new ArrayList<>();
        for (Appetizer appetizer : Appetizer.values()) {
            appetizerNames.add(appetizer.getName());
        }
        return appetizerNames;
    }

    public List<String> getAppetizerNames(){
        return appetizerNames;
    }

}
