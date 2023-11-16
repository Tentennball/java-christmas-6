package christmas.validate;

import christmas.constant.ErrorConstant;
import christmas.constant.ExceptionConstant;
import christmas.constant.ValidateConstant;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MenuValidate {
    public static void validateInputFormat(String input) {
        if (!input.matches(ValidateConstant.MENU_REGEX)) {
            throw new IllegalArgumentException(ExceptionConstant.ERROR_MESSAGE_PREFIX + ErrorConstant.INVALID_ORDER);
        }
    }

    public static void validateInputDuplicate(String[] input) {
        Set<String> menuName = new HashSet<>();
        try {
            menuName.add(input[0]);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(ExceptionConstant.ERROR_MESSAGE_PREFIX + ErrorConstant.INVALID_ORDER);
        }
    }

    public static void validateMenuCount(Map<String, Integer> menuInfo) {
        int menuCount = 0;
        for (String menu : menuInfo.keySet()) {
            menuCount += menuInfo.get(menu);
        }
        if (menuCount < ValidateConstant.MIN_ORDER_COUNT || menuCount > ValidateConstant.MAX_ORDER_COUNT) {
            throw new IllegalArgumentException(ExceptionConstant.ERROR_MESSAGE_PREFIX + ErrorConstant.INVALID_ORDER);
        }
    }

    public static void validateOnlyBeverage(int beverageMenuCount, int totalMenuCount) {
        if(beverageMenuCount==totalMenuCount){
            throw new IllegalArgumentException(ExceptionConstant.ERROR_MESSAGE_PREFIX + ErrorConstant.INVALID_ORDER);
        }
    }

    public static void validateValidMenu(Object valid){
        if(valid==null){
            throw new IllegalArgumentException(ExceptionConstant.ERROR_MESSAGE_PREFIX + ErrorConstant.INVALID_ORDER);
        }
    }
}
