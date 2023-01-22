package kg.tech.gateway.services;

import kg.tech.gateway.models.RoleModel;

import java.util.List;

public interface RoleService {
    RoleModel save(RoleModel roleModel);

    List<RoleModel> getRoles();
}
