package menu.config;

import menu.application.controller.MenuController;
import menu.application.controller.adapter.ConsoleInputAdapter;
import menu.application.service.MenuService;
import menu.application.view.ConsoleInputView;
import menu.application.view.ConsoleOutputView;
import menu.domain.CoachFactory;
import menu.domain.CoachRepository;
import menu.domain.MenuRepository;
import menu.infra.InMemoryCoachRepository;
import menu.infra.InMemoryMenuRepository;

public class AppConfig {
    // == repository ==
    private final CoachRepository coachRepository = new InMemoryCoachRepository();
    private final MenuRepository menuRepository = new InMemoryMenuRepository();

    // == view ==
    private final ConsoleInputView inputView = new ConsoleInputView();
    private final ConsoleOutputView outputView = new ConsoleOutputView();
    private final ConsoleInputAdapter inputAdapter = new ConsoleInputAdapter(inputView, outputView);

    // == domain service ==
    private final CoachFactory coachFactory = new CoachFactory();

    // == application service ==
    private final MenuService menuService = new MenuService(coachRepository, menuRepository, coachFactory);

    private final MenuController menuController = new MenuController(menuService, inputAdapter, outputView);

    public ConsoleInputAdapter inputAdapter() {
        return inputAdapter;
    }

    public ConsoleOutputView outputView() {
        return outputView;
    }

    public MenuService xService() {
        return menuService;
    }

    public MenuController menuController() {
        return menuController;
    }

}
