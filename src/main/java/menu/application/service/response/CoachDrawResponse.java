package menu.application.service.response;

import menu.domain.CoachMenusDrawnResult;

import java.util.List;

public record CoachDrawResponse(
        String coachName,
        List<String> menuNames
) {

    public static CoachDrawResponse from(CoachMenusDrawnResult result) {
        return new CoachDrawResponse(result.getCoach().getName(), result.getMenuNames());
    }
}
