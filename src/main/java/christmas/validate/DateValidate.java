package christmas.validate;

import christmas.constant.ErrorConstant;
import christmas.constant.ExceptionConstant;
import christmas.constant.ValidateConstant;
import christmas.util.FormatUtil;

import java.util.regex.Pattern;

public class DateValidate {
    private static final Pattern DATE_REGEX = Pattern.compile(ValidateConstant.DATE_REGEX);

    public static void validateNumeric(String input) {
        if (!DATE_REGEX.matcher(input).matches())
            throw new IllegalArgumentException(ExceptionConstant.ERROR_MESSAGE_PREFIX + ErrorConstant.INVALID_DATE);
    }

    public static void validateDateSize(String date) {
        int numericDate = FormatUtil.stringToInteger(date);
        if (numericDate > ValidateConstant.LAST_DAY_OF_MONTH || numericDate < ValidateConstant.FIRST_DAY_OF_MONTH)
            throw new IllegalArgumentException(ExceptionConstant.ERROR_MESSAGE_PREFIX + ErrorConstant.INVALID_DATE);
    }
}
