package kg.tech.retailment.entities;

import kg.tech.retailment.enums.Color;
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
    Color dialColor; // цвет циферблата

    String glass; // стекло

    String waterResistance; // водостойкость

    String straps; // ремень

    int standardBatteryLife;

    @Column(length = 500)
    String description;

    @Column(columnDefinition = "boolean default true")
    boolean isActive = true;

    @OneToMany(
            cascade = CascadeType.MERGE,
            orphanRemoval = true
    )
    List<Image> images;


}
