package christmas.validate;

import christmas.constant.ErrorConstant;
import christmas.constant.ValidateConstant;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MenuValidate {
    public static void validateInputFormat(String input) {
        if (!input.matches(ValidateConstant.MENU_REGEX)) {
            throw new IllegalArgumentException(ErrorConstant.INVALID_ORDER);
        }
    }

    public static void validateInputDuplicate(String[] input) {
        Set<String> menuName = new HashSet<>();
        try {
            menuName.add(input[0]);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(ErrorConstant.INVALID_ORDER);
        }
    }

    public static void validateMenuCount(Map<String, Integer> menuInfo) {
        int menuCount = 0;
        for (String menu : menuInfo.keySet()) {
            menuCount += map.get(menu);
        }
        if (menuCount < 0 || menuCount > 30) {
            throw new IllegalArgumentException(ErrorConstant.INVALID_ORDER);
        }
    }

    public static void validateOnlyBeverage(Map<String, Integer>menuInfo){
        int beverageCount = 0;

    }
}
