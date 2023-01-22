package kg.tech.gateway.services;


import kg.tech.commons.exceptions.AuthorizationException;
import kg.tech.commons.services.BaseService;
import kg.tech.gateway.models.UserModel;
import org.springframework.security.core.userdetails.UserDetailsService;


public interface UserService extends UserDetailsService, BaseService<UserModel> {

    UserModel findById(Long id) throws AuthorizationException;

}
