package kg.tech.order.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum Color {
    BLACK("Черный"),
    WHITE("Белый"),
    GRAY("Серый");

    @Getter private final String description;
}
