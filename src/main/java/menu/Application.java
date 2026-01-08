package menu;

import camp.nextstep.edu.missionutils.Console;
import menu.application.controller.MenuController;
import menu.config.AppConfig;

public class Application {
    public static void main(String[] args) {
        try {
            AppConfig appConfig = new AppConfig();
            MenuController menuController = appConfig.menuController();
            menuController.printInitializeMessage();
            menuController.registerCoachNamesWithErrorRetrying();
            menuController.registerHateMenuWithErrorRetrying();
            menuController.drawMenus();
        } finally {
            Console.close();
        }
    }
}
