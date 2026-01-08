package menu.infra;

import menu.application.domain.CoachRepository;
import menu.domain.Coach;

import java.util.ArrayList;
import java.util.List;

public class InMemoryCoachRepository implements CoachRepository {
    private final List<Coach> coaches = new ArrayList<>();

    @Override
    public void saveAll(final List<Coach> coaches) {
        this.coaches.addAll(coaches);
    }
}
