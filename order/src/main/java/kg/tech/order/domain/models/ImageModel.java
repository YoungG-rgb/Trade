package kg.tech.order.domain.models;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ImageModel {
    Long id;
    byte[] picture;
    boolean isMain;
}
