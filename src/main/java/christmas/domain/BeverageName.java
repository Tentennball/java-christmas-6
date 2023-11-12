package christmas.domain;

import java.util.ArrayList;
import java.util.List;

public class BeverageName {
    private List<String> beverageNames;

    public BeverageName() {
        this.beverageNames = inputAppetizerName();
    }

    public List<String> inputAppetizerName() {
        beverageNames = new ArrayList<>();
        for (Beverage appetizer : Beverage.values()) {
            beverageNames.add(appetizer.getName());
        }
        return beverageNames;
    }

    public List<String> getBeverageNames(){
        return beverageNames;
    }
}
