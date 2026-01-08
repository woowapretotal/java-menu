package menu.application.view;


import menu.application.service.response.CoachDrawResponse;

import java.util.List;
import java.util.stream.Collectors;

public final class OutputFormatter {

    private OutputFormatter() {
    }

    public static String formatErrorMessage(String message) {
        return GlobalMessage.ERROR_PREFIX.get() + message;
    }

    public static String formatCategory(final List<String> categoryNames) {
        String barSeparatedCategories = categoryNames.stream()
                .collect(Collectors.joining(GlobalMessage.BAR_SPACE.get()));
        return "[ 카테고리 | %s ]".formatted(barSeparatedCategories);
    }

    public static String formatCoachDrawResults(final List<CoachDrawResponse> coachDrawResponses) {
        return coachDrawResponses.stream()
                .map(OutputFormatter::formatCoachDrawResult)
                .collect(Collectors.joining(GlobalMessage.LINE_SEPARATOR.get()));
    }

    private static String formatCoachDrawResult(final CoachDrawResponse coachDrawResponse) {
        List<String> menuNames = coachDrawResponse.menuNames();
        String barSeparatedMenus = menuNames.stream()
                .collect(Collectors.joining(GlobalMessage.BAR_SPACE.get()));
        return "[ %s | %s ]".formatted(coachDrawResponse.coachName(), barSeparatedMenus);
    }
}
