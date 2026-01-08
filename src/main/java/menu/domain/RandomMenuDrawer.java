package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomMenuDrawer {
    private static final int MIN_ID_VALUE = 1;
    private static final int MAX_ID_VALUE = 5;
    private static final int MAX_DRAW_COUNT = 5;
    private static final int MAX_INCLUDED_COUNT = 2;

    public List<CoachMenusDrawnResult> drawCoachesMenus(List<Coach> coaches, List<Category> categories, List<Menu> menus) {
        return coaches.stream()
                .map(coach -> this.drawCoachMenus(coach, categories, menus))
                .toList();
    }

    private CoachMenusDrawnResult drawCoachMenus(Coach coach, List<Category> categories, List<Menu> menus) {
        List<String> drawnMenuNames = categories.stream()
                .map(category -> this.drawMenuFromAllMenu(coach, menus, category))
                .toList();

        return new CoachMenusDrawnResult(coach, drawnMenuNames);
    }

    private String drawMenuFromAllMenu(final Coach coach, final List<Menu> menus, final Category category) {
        List<String> menuNames = menus.stream()
                .filter(menu -> menu.isSameCategory(category))
                .map(Menu::getName)
                .toList();

        return drawMenuFromFilteredMenu(coach, menuNames, category);
    }

    private String drawMenuFromFilteredMenu(final Coach coach, final List<String> filteredMenuNames, final Category category) {
        while (true) {
            String drawnMenuName = Randoms.shuffle(filteredMenuNames).getFirst();
            if (!coach.containsHateMenu(new Menu(drawnMenuName, category))) {
                return drawnMenuName;
            }
        }
    }

    public List<Category> drawCategories() {
        List<Category> drawnCategories = new ArrayList<>();

        while (drawnCategories.size() != MAX_DRAW_COUNT) {
            int id = Randoms.pickNumberInRange(MIN_ID_VALUE, MAX_ID_VALUE);
            Category lastDrawnCategory = Category.findById(id);
            if (isDrawnCategoryBelowThanMax(lastDrawnCategory, drawnCategories)) {
                drawnCategories.add(lastDrawnCategory);
            }
        }

        return drawnCategories;
    }

    private boolean isDrawnCategoryBelowThanMax(final Category lastDrawnCategory, final List<Category> drawnCategories) {
        return drawnCategories.stream()
                .filter(drawnCategory -> drawnCategory.equals(lastDrawnCategory))
                .count() < MAX_INCLUDED_COUNT;
    }
}
