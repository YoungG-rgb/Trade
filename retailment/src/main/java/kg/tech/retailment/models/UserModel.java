package kg.tech.retailment.models;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserModel {
    Long id;
    String username;
    String password;
    String email;
    BigDecimal balance;
    LocalDate updatedAt;
    List<OrderModel> orders;
}
