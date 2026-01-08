package menu.domain;

import java.util.List;

public class CoachMenusDrawnResult {
    private final Coach coach;
    private final List<String> menuNames;

    public CoachMenusDrawnResult(final Coach coach, final List<String> menuNames) {
        this.coach = coach;
        this.menuNames = menuNames;
    }
}
