package christmas.domain;

import christmas.validate.MenuValidate;

import java.util.Map;

public class Menu {
    private final Map<String, Integer> menuInfo;

    public Menu(Map<String, Integer> menuInfo) {
        validate(menuInfo);
        this.menuInfo = menuInfo;
    }

    public Map<String, Integer> getMenuInfo() {
        return menuInfo;
    }

    private void validate(Map<String, Integer> menuInfo) {
        MenuValidate.validateMenuCount(menuInfo);
    }
}
