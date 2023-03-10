package kg.tech.order.domain.models;

import kg.tech.order.domain.enums.PaymentMethod;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SimpleOrderView {
    BigDecimal totalAmount;
    PaymentMethod paymentMethod;
    LocalDateTime createdAt;
    LocalDate deliverDate;
    ImageModel defaultImage;
}
