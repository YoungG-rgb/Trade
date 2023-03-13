package kg.tech.gateway.controllers.extApi;

import kg.tech.commons.models.ResponseModel;
import kg.tech.commons.rest.BaseController;
import kg.tech.gateway.models.UserModel;
import kg.tech.gateway.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ext-api/users")
@RequiredArgsConstructor
public class UserExtRestController extends BaseController {

    private final UserService userService;

    @PostMapping
    public ResponseModel<UserModel> register(@RequestBody UserModel userModel) {
        return successResponse(userService.save(userModel));
    }
}
