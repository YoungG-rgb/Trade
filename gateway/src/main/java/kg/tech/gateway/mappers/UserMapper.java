package kg.tech.gateway.mappers;

import kg.tech.gateway.entities.User;
import kg.tech.gateway.models.UserModel;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(uses = {RoleMapper.class}, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface UserMapper {

    User toEntity(UserModel userModel);

    UserModel toModel(User user);
}
