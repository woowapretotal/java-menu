package menu.application.domain;

import menu.domain.Coach;

import java.util.List;

public interface CoachRepository {

    void saveAll(List<Coach> coaches);
}
