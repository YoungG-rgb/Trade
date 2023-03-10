package kg.tech.order.domain.models;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CartModel {
    Long id;

    Long userId;

    BigDecimal totalAmount;

    BigDecimal totalBonuses;

    List<SimpleOrderView> simpleOrderViews;

}
