package kg.tech.retailment.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
