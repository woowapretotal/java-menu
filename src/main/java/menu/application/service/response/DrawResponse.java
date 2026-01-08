package menu.application.service.response;

import menu.domain.Category;
import menu.domain.CoachMenusDrawnResult;

import java.util.List;

public record DrawResponse(
        List<String> categoryNames,
        List<CoachDrawResponse> coachDrawResponses
) {

    public static DrawResponse from(List<Category> categories, List<CoachMenusDrawnResult> coachMenusDrawnResults) {
        List<String> categoryNames = categories.stream()
                .map(Category::getName)
                .toList();

        List<CoachDrawResponse> coachDrawResponses = coachMenusDrawnResults.stream()
                .map(CoachDrawResponse::from)
                .toList();

        return new DrawResponse(categoryNames, coachDrawResponses);
    }
}
