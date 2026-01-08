package menu.domain;

import java.util.List;
import java.util.Optional;

public interface CoachRepository {

    void saveAll(List<Coach> coaches);

    List<Coach> findAll();

    Optional<Coach> findByName(String name);
}
