package kg.tech.order.models;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CouponModel {
    Long id;

    String uuid;

    boolean isValid = true;

    Long userId;
}
