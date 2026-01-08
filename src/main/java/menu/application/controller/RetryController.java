package menu.application.controller;

import menu.application.view.ConsoleOutputView;
import menu.common.utils.RetryHandler;

import java.util.function.Supplier;

public abstract class RetryController {
    protected final ConsoleOutputView outputView;

    protected RetryController(ConsoleOutputView outputView) {
        this.outputView = outputView;
    }

    protected final <T> T retrying(Supplier<T> supplier) {
        return RetryHandler.execute(supplier, outputView::printErrorMessage);
    }

    protected final void retryingWithoutNoResponse(Runnable runnable) {
        RetryHandler.execute(runnable, outputView::printErrorMessage);
    }
}
