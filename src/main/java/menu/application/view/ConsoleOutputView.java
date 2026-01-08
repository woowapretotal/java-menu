package menu.application.view;

import menu.application.service.response.DrawResponse;

public class ConsoleOutputView {

    public void printOnboardingMessage(final String message) {
        System.out.println(message);
    }

    public void printInitializingMessage() {
        System.out.print("점심 메뉴 추천을 시작합니다." + GlobalMessage.BLANK_AND_NEW_LINE.get());
    }

    public void printErrorMessage(final String errorMessage) {
        System.out.println(OutputFormatter.formatErrorMessage(errorMessage));
    }

    public void printDrawResult(DrawResponse drawResponse) {
        System.out.println("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]");
        System.out.println(OutputFormatter.formatCategory(drawResponse.categoryNames()));
        System.out.print(OutputFormatter.formatCoachDrawResults(drawResponse.coachDrawResponses()) + GlobalMessage.BLANK_AND_NEW_LINE.get());
        System.out.println("추천을 완료했습니다.");
    }

}
