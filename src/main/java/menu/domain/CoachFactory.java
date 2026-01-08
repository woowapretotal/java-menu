package menu.domain;

import menu.common.error.DomainException;
import menu.common.error.ErrorMessage;

import java.util.List;

public class CoachFactory {
    private static final int MAX_COACH_COUNT = 5;
    private static final int MIN_COACH_COUNT = 2;

    public List<Coach> createCoaches(List<String> coachNames) {
        validateCoachesCount(coachNames);
        return coachNames.stream()
                .map(Coach::new)
                .toList();
    }

    private void validateCoachesCount(final List<String> coachNames) {
        if (coachNames.size() < MIN_COACH_COUNT || coachNames.size() > MAX_COACH_COUNT) {
            throw new DomainException(ErrorMessage.OUT_OF_COACH_COUNT, MIN_COACH_COUNT, MAX_COACH_COUNT);
        }
    }
}
