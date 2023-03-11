package kg.tech.gateway.services.impl;

import kg.tech.gateway.mappers.RoleMapper;
import kg.tech.gateway.models.RoleModel;
import kg.tech.gateway.repositories.RoleRepository;
import kg.tech.gateway.services.RoleService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class RoleServiceImpl implements RoleService {
    RoleRepository roleRepository;
    RoleMapper roleMapper;

    @Override
    public RoleModel save(RoleModel roleModel) {
        roleRepository.save(roleMapper.toEntity(roleModel));
        return roleModel;
    }

    @Override
    public List<RoleModel> getRoles() {
        return roleRepository.findAll().stream().map(roleMapper::toModel).collect(Collectors.toList());
    }

}
