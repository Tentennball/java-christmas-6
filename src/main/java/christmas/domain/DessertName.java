package christmas.domain;

import java.util.ArrayList;
import java.util.List;

public class DessertName {
    private List<String> dessertNames;

    public DessertName() {
        this.dessertNames = inputAppetizerName();
    }

    public List<String> inputAppetizerName() {
        dessertNames = new ArrayList<>();
        for (Dessert appetizer : Dessert.values()) {
            dessertNames.add(appetizer.getName());
        }
        return dessertNames;
    }

    public List<String> getDessertNames(){
        return dessertNames;
    }
}
