package kg.tech.order.entities;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "phones")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PHONES_SEQ")
    @SequenceGenerator(name = "PHONES_SEQ", sequenceName = "PHONES_SEQ", allocationSize = 1)
    Long id;


    String number;

}
