package menu.infra;

import menu.domain.Coach;
import menu.domain.CoachRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InMemoryCoachRepository implements CoachRepository {
    private final List<Coach> coaches = new ArrayList<>();

    @Override
    public void saveAll(final List<Coach> coaches) {
        this.coaches.addAll(coaches);
    }

    @Override
    public List<Coach> findAll() {
        return coaches;
    }

    @Override
    public Optional<Coach> findByName(final String name) {
        return coaches.stream()
                .filter(coach -> coach.isSameName(name))
                .findFirst();
    }
}
