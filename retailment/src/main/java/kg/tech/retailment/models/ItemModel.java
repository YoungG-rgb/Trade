package kg.tech.retailment.models;

import kg.tech.retailment.enums.Color;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ItemModel {

    Long id;

    String name;

    BigDecimal price;
    Integer count;
    Double rating;

    Color dialColor;

    String glass;

    String waterResistance;

    String straps;

    int standardBatteryLife;

    String description;

    boolean isActive;

    List<Long> imagesId;
}
