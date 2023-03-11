package kg.tech.admin.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum Color {
    BLACK("Черный"),
    WHITE("Белый"),
    GRAY("Серый"),
    BLUE("Синий");

    @Getter
    private final String description;
}
