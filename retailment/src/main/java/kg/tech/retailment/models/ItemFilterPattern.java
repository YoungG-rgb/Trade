package kg.tech.retailment.models;

import lombok.*;
import kg.tech.retailment.enums.Color;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ItemFilterPattern {

    String name;
    BigDecimal priceTo;
    BigDecimal priceFrom;
    Double rating;
    Color dialColor;
    String straps;
    String glass;

}
