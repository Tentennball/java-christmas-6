package christmas.domain;

import java.util.ArrayList;
import java.util.List;

public class MainMenuName {
    private List<String> mainMenuNames;

    public MainMenuName() {
        this.mainMenuNames = inputAppetizerName();
    }

    public List<String> inputAppetizerName() {
        mainMenuNames = new ArrayList<>();
        for (MainMenu appetizer : MainMenu.values()) {
            mainMenuNames.add(appetizer.getName());
        }
        return mainMenuNames;
    }

    public List<String> getMainMenuNames(){
        return mainMenuNames;
    }
}
