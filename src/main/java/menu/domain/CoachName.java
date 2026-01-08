package menu.domain;

import menu.common.error.DomainException;
import menu.common.error.ErrorMessage;

import java.util.Objects;

public class CoachName {
    private static final int MAX_LENGTH = 4;
    private static final int MIN_LENGTH = 2;

    private final String value;

    public CoachName(final String value) {
        validateNotEmpty(value);
        validateMaxLength(value);
        validateMinLength(value);
        this.value = value;
    }

    private void validateNotEmpty(final String value) {
        if (value == null || value.isBlank()) {
            throw new DomainException(ErrorMessage.BLANK_STRING);
        }
    }

    private void validateMaxLength(final String value) {
        if (value.length() > MAX_LENGTH) {
            throw new DomainException(ErrorMessage.EXCEEDS_MAX_LENGTH, MAX_LENGTH);
        }
    }

    private void validateMinLength(final String value) {
        if (value.length() < MIN_LENGTH) {
            throw new DomainException(ErrorMessage.BELOW_MIN_LENGTH, MIN_LENGTH);
        }
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(final Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        CoachName stringMaxLengthVO = (CoachName) object;
        return Objects.equals(value, stringMaxLengthVO.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}
