package christmas.util;

import christmas.constant.ValidateConstant;
import christmas.validate.MenuValidate;

import java.util.HashMap;
import java.util.Map;

public class FormatUtil {
    public static int stringToInteger(String input) {
        return Integer.parseInt(input);
    }

    public static Map<String, Integer> splitMenuNameAndCount(String menuInfo) {
        String[] splittedCommas = splitCommas(menuInfo);
        return splithyphen(splittedCommas);
    }

    public static String[] splitCommas(String input) {
        return input.split(ValidateConstant.COMMA);
    }

    public static Map<String, Integer> splithyphen(String[] splittedCommaInputs) {
        Map<String, Integer> menuInfo = new HashMap<>();
        for (String splittedCommaInput : splittedCommaInputs) {
            String[] splittedHyphen = splittedCommaInput.split(ValidateConstant.HYPHEN);
            MenuValidate.validateInputDuplicate(splittedHyphen);
            menuInfo.put(splittedHyphen[0], stringToInteger(splittedHyphen[1]));
        }
        return menuInfo;
    }
}
