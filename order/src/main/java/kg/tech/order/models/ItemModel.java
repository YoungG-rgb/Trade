package kg.tech.order.models;

import kg.tech.order.entities.Image;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class ItemModel {
    Long id;
    String name;
    BigDecimal price;
    Integer count;
    Double rating;
    String description;
    boolean active;
    List<Image> images;
}
