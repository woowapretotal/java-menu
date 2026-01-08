package menu.application.view;

import menu.application.service.response.DomainListResponse;

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

    public void printDomains(final DomainListResponse listResponse) {
        System.out.println(OutputFormatter.formatDomains(listResponse) +
                GlobalMessage.BLANK_AND_NEW_LINE.get());
    }

}
