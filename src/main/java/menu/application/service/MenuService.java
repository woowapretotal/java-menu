package menu.application.service;

import menu.application.domain.CoachRepository;
import menu.domain.Coach;
import menu.domain.CoachFactory;

import java.util.List;

public class MenuService {
    private final CoachRepository coachRepository;
    private final CoachFactory coachFactory;

    public MenuService(final CoachRepository coachRepository, final CoachFactory coachFactory) {
        this.coachRepository = coachRepository;
        this.coachFactory = coachFactory;
    }

    public void registerCoachName(final List<String> coachNames) {
        List<Coach> coaches = coachFactory.createCoaches(coachNames);
        coachRepository.saveAll(coaches);
    }
}
