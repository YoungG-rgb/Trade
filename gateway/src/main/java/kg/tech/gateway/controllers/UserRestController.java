package kg.tech.gateway.controllers;

import kg.tech.commons.exceptions.AuthorizationException;
import kg.tech.commons.models.ResponseModel;
import kg.tech.commons.rest.BaseController;
import kg.tech.gateway.models.UserModel;
import kg.tech.gateway.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserRestController extends BaseController {
    private final UserService userService;

    @GetMapping
    public ResponseModel<List<UserModel>> getAll(){
        return successResponse(userService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseModel<UserModel> findById(@PathVariable Long id) throws AuthorizationException {
        return successResponse(userService.findById(id));
    }


}
