package kg.tech.order.domain.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "carts")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CARTS_SEQ")
    @SequenceGenerator(name = "CARTS_SEQ", sequenceName = "CARTS_SEQ", allocationSize = 1)
    Long id;

    BigDecimal totalBonuses;

    BigDecimal totalAmount;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinTable(name = "carts_users",
            joinColumns = {@JoinColumn(name = "carts_id")},
            inverseJoinColumns = {@JoinColumn(name = "users_id")})
    User user;

}
