package menu.domain;

import java.util.Objects;

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

    public boolean isSameCategory(Category category) {
        return this.category.equals(category);
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(final Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        Menu menu = (Menu) object;
        return Objects.equals(getName(), menu.getName()) && category == menu.category;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), category);
    }
}
