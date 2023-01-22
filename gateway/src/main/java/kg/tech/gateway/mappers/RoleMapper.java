package kg.tech.gateway.mappers;


import kg.tech.gateway.entities.Role;
import kg.tech.gateway.models.RoleModel;
import org.mapstruct.Mapper;

@Mapper
public interface RoleMapper {

    Role toEntity(RoleModel roleModel);

    RoleModel toModel(Role role);
}
