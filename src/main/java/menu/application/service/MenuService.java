package menu.application.service;

import menu.application.service.response.DrawResponse;
import menu.common.error.ApplicationException;
import menu.common.error.ErrorMessage;
import menu.domain.*;

import java.util.List;

public class MenuService {
    private final CoachRepository coachRepository;
    private final MenuRepository menuRepository;
    private final CoachFactory coachFactory;
    private final RandomMenuDrawer randomMenuDrawer;

    public MenuService(final CoachRepository coachRepository, final MenuRepository menuRepository, final CoachFactory coachFactory, final RandomMenuDrawer randomMenuDrawer) {
        this.coachRepository = coachRepository;
        this.menuRepository = menuRepository;
        this.coachFactory = coachFactory;
        this.randomMenuDrawer = randomMenuDrawer;
    }

    public void registerCoachName(final List<String> coachNames) {
        List<Coach> coaches = coachFactory.createCoaches(coachNames);
        coachRepository.saveAll(coaches);
    }

    public List<String> findAllCoachNames() {
        List<Coach> coaches = coachRepository.findAll();
        return coaches.stream()
                .map(Coach::getName)
                .toList();
    }

    public void registerHateMenus(final String coachName, final List<String> hateMenuNames) {
        Coach coach = coachRepository.findByName(coachName)
                .orElseThrow(() -> new IllegalStateException(ErrorMessage.CANNOT_FIND_COACH.message()));

        if (hateMenuNames.size() == 1 && hateMenuNames.getFirst().isEmpty()) {
            coach.registerHateMenus(List.of());
            return;
        }

        List<Menu> hateMenus = hateMenuNames.stream()
                .map(this::findMenuBy)
                .toList();

        coach.registerHateMenus(hateMenus);
    }

    public DrawResponse drawMenus() {
        List<Coach> coaches = coachRepository.findAll();
        List<Menu> menus = menuRepository.findAll();

        List<Category> categories = randomMenuDrawer.drawCategories();
        List<CoachMenusDrawnResult> coachMenusDrawnResults = randomMenuDrawer.drawCoachesMenus(coaches, categories, menus);

        return DrawResponse.from(categories, coachMenusDrawnResults);
    }

    private Menu findMenuBy(String name) {
        return menuRepository.findByName(name)
                .orElseThrow(() -> new ApplicationException(ErrorMessage.CANNOT_FIND_MENU));
    }
}
