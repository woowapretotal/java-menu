package menu.domain;

import menu.common.error.ErrorMessage;

import java.util.Arrays;

public enum Category {
    JAPANESE(1, "일식"),
    KOREAN(2, "한식"),
    CHINESE(3, "중식"),
    ASIAN(4, "아시안"),
    WESTERN(5, "양식");

    private final int id;
    private final String name;

    Category(final int id, final String name) {
        this.id = id;
        this.name = name;
    }

    public static Category findById(int id) {
        return Arrays.stream(Category.values())
                .filter(category -> category.isSameId(id))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException(ErrorMessage.CANNOT_FIND_CATEGORY.message()));
    }

    public boolean isSameId(int otherId) {
        return this.id == otherId;
    }

    public String getName() {
        return name;
    }
}
