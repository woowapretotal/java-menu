package menu.domain;

import menu.common.error.DomainException;
import menu.common.error.ErrorMessage;

import java.util.List;

public class HateMenus {
    private static final int HATE_MENU_MAX = 2;
    
    private final List<Menu> hateMenus;

    public HateMenus(final List<Menu> hateMenus) {
        validateHateMenuCount(hateMenus);
        this.hateMenus = hateMenus;
    }

    private void validateHateMenuCount(final List<Menu> hateMenus) {
        if (hateMenus.size() > HATE_MENU_MAX) {
            throw new DomainException(ErrorMessage.EXCEEDS_MAX_HATE_MENU, HATE_MENU_MAX);
        }
    }
}
