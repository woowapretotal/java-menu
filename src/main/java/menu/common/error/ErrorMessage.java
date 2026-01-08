package menu.common.error;

public enum ErrorMessage {
    INVALID_INTEGER_FORMAT("정수 형식의 문자가 아닙니다."),
    INVALID_DECIMAL_FORMAT("소수 형식의 문자가 아닙니다."),
    INVALID_DATETIME_FORMAT("올바른 시간 형식의 문자 입력이 아닙니다."),
    INVALID_Y_N_FORMAT("Y 또는 N을 입력해주세요."),

    EMPTY_INPUT("입력이 비어있을 수 없습니다."),
    BLANK_STRING("문자열이 비어있거나 공백일 수 없습니다."),

    EXCEEDS_MAX_VALUE("최댓값 %s를 초과했습니다."),
    BELOW_MIN_VALUE("최솟값 %s 미만입니다."),
    EXCEEDS_MAX_LENGTH("최대 길이 %d를 초과하였습니다."),
    BELOW_MIN_LENGTH("최소 길이 %d 미만입니다."),
    EXCEEDS_MAX_HATE_MENU("못 먹는 음식은 최대 %d개 입니다."),
    OUT_OF_COACH_COUNT("코치는 최소 %d명, 최대 %d명 입니다"),
    CANNOT_FIND_COACH("코치를 찾을 수 없습니다."),
    CANNOT_FIND_MENU("메뉴를 찾을 수 없습니다."),
    CANNOT_FIND_CATEGORY("해당 ID에 속한 카테고리가 존재하지 않습니다."),

    INVALID_MENU_NUMBER("존재하지 않는 메뉴를 선택하셨습니다."),
    EMPTY_PARSED_VALUE("비어있는 항목이 존재합니다."),
    INVALID_REQUEST_FIELD_COUNT("요청에 필요한 항목이 부족합니다.");

    private final String message;

    ErrorMessage(final String message) {
        this.message = message;
    }

    public String message() {
        return message;
    }

    public String formatted(final Object... args) {
        return message.formatted(args);
    }
}
