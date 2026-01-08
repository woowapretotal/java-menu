package menu.domain;

public class Menu {
    private final String name;
    private final Category category;

    public Menu(final String name, final Category category) {
        this.name = name;
        this.category = category;
    }

    public boolean isSameName(String otherName) {
        return name.equals(otherName);
    }
}
