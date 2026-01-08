package menu.common.utils;

import menu.common.error.MenuSelectFailedException;

import java.util.function.Consumer;
import java.util.function.Supplier;

public final class RetryHandler {

    private RetryHandler() {
    }

    public static <T> T execute(Supplier<T> supplier, Consumer<String> onError) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                onError.accept(e.getMessage());
            }
        }
    }

    public static void execute(Runnable runnable, Consumer<String> onError) {
        while (true) {
            try {
                runnable.run();
                return;
            } catch (IllegalArgumentException e) {
                onError.accept(e.getMessage());
            }
        }
    }

    public static <T> T executeMenu(Supplier<T> supplier, Consumer<String> onError) {
        while (true) {
            try {
                return supplier.get();
            } catch (MenuSelectFailedException e) {
                onError.accept(e.getMessage());
            }
        }
    }
}
