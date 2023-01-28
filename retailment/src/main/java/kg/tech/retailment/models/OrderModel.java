package kg.tech.retailment.models;


import kg.tech.retailment.enums.OrderStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderModel {
    Long id;
    OrderStatus status;
    BigDecimal total;
    LocalDateTime createdAt;
    LocalDateTime deliverDate;
    List<ItemModel> items;
}
