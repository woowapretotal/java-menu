package menu.domain;

import java.util.Optional;

public interface MenuRepository {

    Optional<Menu> findByName(String name);
}
