package menu.application.controller;

import menu.application.controller.adapter.ConsoleInputAdapter;
import menu.application.service.MenuService;
import menu.application.view.ConsoleOutputView;

import java.util.List;

public class MenuController extends RetryController {
    private final MenuService menuService;
    private final ConsoleInputAdapter inputAdapter;

    public MenuController(final MenuService menuService, final ConsoleInputAdapter inputAdapter, final ConsoleOutputView outputView) {
        super(outputView);
        this.menuService = menuService;
        this.inputAdapter = inputAdapter;
    }

    public void printInitializeMessage() {
        outputView.printInitializingMessage();
    }

    public void registerCoachNamesWithRetrying() {
        retryingWithoutNoResponse(() -> {
            List<String> coachNames = inputAdapter.readCoachNames();
            menuService.registerCoachName();
        });
    }

    public void runWithRetrying() {
        /*XServiceXXXResponse response = retrying(() -> {
            int xx = inputReader.readXX();
            return xService.logic(new XServiceXXXRequest(xx));
        });

        outputView.printXX(response);*/
    }
}
