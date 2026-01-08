package menu.common.utils;

import menu.common.error.ApplicationException;
import menu.common.error.ErrorMessage;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TypeConverter {
    private static final String TRUE_BOOLEAN_KO = "네";
    private static final String TRUE_BOOLEAN_EN = "Y";
    private static final String FALSE_BOOLEAN_KO = "아니오";
    private static final String FALSE_BOOLEAN_EN = "N";

    public static int toInteger(String line) {
        try {
            return Integer.parseInt(line);
        } catch (NumberFormatException e) {
            throw new ApplicationException(ErrorMessage.INVALID_INTEGER_FORMAT);
        }
    }

    public static double toDecimal(String line) {
        try {
            return Double.parseDouble(line);
        } catch (NumberFormatException e) {
            throw new ApplicationException(ErrorMessage.INVALID_DECIMAL_FORMAT);
        } catch (NullPointerException e) {
            throw new ApplicationException(ErrorMessage.EMPTY_INPUT);
        }
    }

    public static boolean toBooleanFromKorean(String line) {
        if (line.equals(TRUE_BOOLEAN_KO)) {
            return true;
        }
        if (line.equals(FALSE_BOOLEAN_KO)) {
            return false;
        }

        throw new ApplicationException(ErrorMessage.INVALID_Y_N_FORMAT);
    }

    public static boolean toBooleanFromEnglish(String line) {
        if (line.equals(TRUE_BOOLEAN_EN)) {
            return true;
        }
        if (line.equals(FALSE_BOOLEAN_EN)) {
            return false;
        }

        throw new ApplicationException(ErrorMessage.INVALID_Y_N_FORMAT);
    }

    public static LocalDateTime toLocalDateTime(String line) {
        try {
            return LocalDateTime.parse(line, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        } catch (DateTimeException e) {
            throw new ApplicationException(ErrorMessage.INVALID_DATETIME_FORMAT);
        } catch (NullPointerException e) {
            throw new ApplicationException(ErrorMessage.EMPTY_INPUT);
        }
    }
}
