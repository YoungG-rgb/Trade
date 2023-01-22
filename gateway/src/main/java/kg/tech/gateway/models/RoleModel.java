package kg.tech.gateway.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RoleModel {
    Long id;

    String name;
}
