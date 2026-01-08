package menu.domain;

import java.util.List;
import java.util.Optional;

public interface MenuRepository {

    Optional<Menu> findByName(String name);

    List<Menu> findAll();
}
