package kg.tech.gateway.mappers;

import kg.tech.gateway.entities.User;
import kg.tech.gateway.models.UserModel;
import org.mapstruct.Mapper;

@Mapper(uses = {RoleMapper.class})
public interface UserMapper {

    User toEntity(UserModel userModel);

    UserModel toModel(User user);
}
