package kg.tech.gateway.services.impl;

import kg.tech.commons.exceptions.AuthorizationException;
import kg.tech.gateway.entities.User;
import kg.tech.gateway.mappers.UserMapper;
import kg.tech.gateway.models.UserModel;
import kg.tech.gateway.repositories.UserRepository;
import kg.tech.gateway.services.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserServiceImpl implements UserService {

    UserRepository userRepository;
    UserMapper userMapper;
    PasswordEncoder passwordEncoder;

    @Override
    public List<UserModel> getAll() {
        return userRepository.findAll().stream().map(userMapper::toModel).collect(Collectors.toList());
    }

    @Override
    public UserModel findById(Long id) throws AuthorizationException {
        Optional<User> user = userRepository.findById(id);
        return user
                .map(userMapper::toModel)
                .orElseThrow(() -> new AuthorizationException("USER_NOT_FOUND"));
    }

    @Override
    public UserModel save(UserModel user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(userMapper.toEntity(user));
        log.info("UserServiceImpl.save::user saved");
        return user;
    }

    @Override
    public UserModel update(UserModel userModel) {
        return this.save(userModel);
    }

    @Override
    public void delete(Long id) throws AuthorizationException {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) throw new AuthorizationException("USER IS ALREADY DELETED");
        userRepository.delete(user.get());
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository
                .findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("USERNAME IS NULL"));
    }
}
