package menu.infra;

import menu.common.utils.CSVParser;
import menu.domain.Category;
import menu.domain.Menu;
import menu.domain.MenuRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InMemoryMenuRepository implements MenuRepository {
    private final List<Menu> menus = new ArrayList<>();

    public InMemoryMenuRepository() {
        addJapanese();
        addKorean();
        addChinese();
        addAsian();
        addWestern();
    }

    @Override
    public Optional<Menu> findByName(final String name) {
        return menus.stream()
                .filter(menu -> menu.isSameName(name))
                .findFirst();
    }

    private void addJapanese() {
        String menuLine = "규동, 우동, 미소시루, 스시, 가츠동, 오니기리, 하이라이스, 라멘, 오코노미야끼";
        convertAndMenus(menuLine, Category.JAPANESE);
    }

    private void addKorean() {
        String menuLine = "김밥, 김치찌개, 쌈밥, 된장찌개, 비빔밥, 칼국수, 불고기, 떡볶이, 제육볶음";
        convertAndMenus(menuLine, Category.KOREAN);
    }

    private void addChinese() {
        String menuLine = "깐풍기, 볶음면, 동파육, 짜장면, 짬뽕, 마파두부, 탕수육, 토마토 달걀볶음, 고추잡채";
        convertAndMenus(menuLine, Category.CHINESE);
    }

    private void addAsian() {
        String menuLine = "팟타이, 카오 팟, 나시고렝, 파인애플 볶음밥, 쌀국수, 똠얌꿍, 반미, 월남쌈, 분짜";
        convertAndMenus(menuLine, Category.ASIAN);
    }

    private void addWestern() {
        String menuLine = "라자냐, 그라탱, 뇨끼, 끼슈, 프렌치 토스트, 바게트, 스파게티, 피자, 파니니";
        convertAndMenus(menuLine, Category.WESTERN);
    }

    private void convertAndMenus(final String menuLine, final Category category) {
        List<String> menuNames = CSVParser.split(menuLine);
        List<Menu> menus = menuNames.stream()
                .map(menuName -> new Menu(menuName, category))
                .toList();
        this.menus.addAll(menus);
    }
}
