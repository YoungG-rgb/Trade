package kg.tech.order.models;

import kg.tech.order.enums.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.StringJoiner;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderModel {
    Long id;

    OrderStatus status = OrderStatus.START;

    BigDecimal total;

    LocalDateTime createdAt;
    LocalDateTime deliverDate;

    List<ItemModel> items;

    Long userId;

    public String toEmailString() {
        StringJoiner emailText = new StringJoiner("\n");

        return emailText
                .add("Информация о заказе:")
                .add("[")
                .add("Статус: " + status.statusDescription())
                .add("Создано: " + createdAt)
                .add("Дата доставки: " + deliverDate)
                .add("Товары: " + items.toString())
                .add("Общая сумма: " + total)
                .add("]")
                .toString();
    }
}
