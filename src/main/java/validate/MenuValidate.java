package validate;

import christmas.constant.ErrorConstant;
import christmas.constant.ValidateConstant;

import java.util.HashSet;
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
}
