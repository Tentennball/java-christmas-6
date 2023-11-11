package validate;

import christmas.constant.ErrorConstant;
import christmas.constant.ExceptionConstant;
import christmas.constant.ValidateConstant;
import christmas.util.FormatUtil;

import java.util.regex.Pattern;

public class DateValidate {
    private static final Pattern DATE_REGEX = Pattern.compile(ValidateConstant.DATE_REGEX);

    public static void validateNumeric(String input) {
        if (!DATE_REGEX.matcher(input).matches())
            throw new IllegalArgumentException(ExceptionConstant.ERROR_MESSAGE_PREFIX + ErrorConstant.NOT_NUMERIC);
    }

    public static void validateDateSize(String date) {
        int numericDate = FormatUtil.stringToInteger(date);
        if (numericDate > 31 || numericDate < 1)
            throw new IllegalArgumentException(ExceptionConstant.ERROR_MESSAGE_PREFIX + ErrorConstant.OUT_OF_RANGE);
    }
}
