package menu.application.view;

import camp.nextstep.edu.missionutils.Console;
import menu.common.utils.TypeConverter;

public class ConsoleInputView {

    public int readNumber() {
        return TypeConverter.toInteger(readLine());
    }

    public double readDecimal() {
        return TypeConverter.toDecimal(readLine());
    }

    public boolean readTFKorean() {
        return TypeConverter.toBooleanFromKorean(Console.readLine());
    }

    public boolean readTFEnglish() {
        return TypeConverter.toBooleanFromKorean(Console.readLine());
    }

    public String readLine() {
        return Console.readLine();
    }
}
