package kg.tech.gateway.models;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import java.util.List;

@Data
@Builder
public class UserModel {

    Long id;

    @NonNull
    String username;
    @NonNull
    String password;

    @NonNull
    String email;

    List<RoleModel> roles;
}
