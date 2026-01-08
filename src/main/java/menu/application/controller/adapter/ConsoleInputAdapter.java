package menu.application.controller.adapter;

import menu.application.view.ConsoleInputView;
import menu.application.view.ConsoleOutputView;
import menu.common.utils.CSVParser;

import java.util.List;

public class ConsoleInputAdapter {
    private final ConsoleOutputView outputView;
    private final ConsoleInputView inputView;

    public ConsoleInputAdapter(final ConsoleInputView inputView, final ConsoleOutputView outputView) {
        this.outputView = outputView;
        this.inputView = inputView;
    }

    public int readXX() {
        /*outputView.printOnboardingMessage("xx를 입력해주세요");
        int xx = inputView.readNumber();
        // 추가적인 파싱 로직 필요시 수행
        return xx;*/
        return 0;
    }

    public List<String> readCoachNames() {
        outputView.printOnboardingMessage("코치의 이름을 입력해 주세요. (, 로 구분)");
        return CSVParser.split(inputView.readLine());
    }

    public List<String> readHateMenus(String coachName) {
        outputView.printOnboardingMessage("%s(이)가 못 먹는 메뉴를 입력해 주세요.".formatted(coachName));
        return CSVParser.split(inputView.readLine());
    }
}
