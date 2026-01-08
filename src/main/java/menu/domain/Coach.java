package menu.domain;

import java.util.List;

public class Coach {
    private final CoachName name;
    private HateMenus hateMenus;

    public Coach(final String name) {
        this.name = new CoachName(name);
    }

    public void registerHateMenus(List<Menu> menus) {
        this.hateMenus = new HateMenus(menus);
    }

    public String getName() {
        return name.value();
    }

    public boolean isSameName(String otherName) {
        return name.value().equals(otherName);
    }
}
