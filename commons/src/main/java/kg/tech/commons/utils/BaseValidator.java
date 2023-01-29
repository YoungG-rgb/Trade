package kg.tech.commons.utils;

import kg.tech.commons.exceptions.ValidationException;

import java.util.Arrays;

public class BaseValidator {

    public static final String NUMBER_CHECK_REGEXP = "^996(70|50)+[\\d]{7}";

    public static boolean isValidNumber(String number) throws ValidationException {
        if (number.matches(NUMBER_CHECK_REGEXP)) return true;
        throw new ValidationException("Неверный номер телефона");
    }

    public static boolean isNotEmpty(final CharSequence... charSequences) {
        return Arrays.stream(charSequences).noneMatch(CharSequence::isEmpty);
    }

}
