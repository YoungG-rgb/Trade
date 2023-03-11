package kg.tech.retailment.models;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ImageModel {
    Long id;
    byte[] picture;
    boolean isMain;
}
