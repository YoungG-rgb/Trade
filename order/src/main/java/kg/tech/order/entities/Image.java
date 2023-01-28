package kg.tech.order.entities;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "images")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "IMAGES_SEQ")
    @SequenceGenerator(name = "IMAGES_SEQ", sequenceName = "IMAGES_SEQ", allocationSize = 1)
    Long id;

    @Lob
    @Type(type = "org.hibernate.type.ImageType")
    byte[] picture;

    boolean isMain;
}
