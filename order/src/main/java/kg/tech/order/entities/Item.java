package kg.tech.order.entities;

import kg.tech.order.enums.Color;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "items")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ITEMS_SEQ")
    @SequenceGenerator(name = "ITEMS_SEQ", sequenceName = "ITEMS_SEQ", allocationSize = 1)
    Long id;

    @Column(unique = true)
    String name;

    BigDecimal price;

    Integer count;

    Double rating;

    @Enumerated(value = EnumType.STRING)
    Color dialColor;

    String glass;

    String waterResistance;

    String straps;

    int standardBatteryLife;

    @Column(length = 500)
    String description;

    @Column(columnDefinition = "boolean default true")
    boolean isActive;

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    List<Image> images;


}
