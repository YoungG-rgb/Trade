package kg.tech.gateway.controllers;

import kg.tech.commons.models.ResponseModel;
import kg.tech.commons.rest.BaseController;
import kg.tech.gateway.models.UserModel;
import kg.tech.gateway.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserRestController extends BaseController {
    private final UserService userService;

    @GetMapping
    public ResponseModel<List<UserModel>> getAll(){
        return successResponse(userService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseModel<?> findById(@PathVariable("id") Long id) throws Exception {
        return successResponse(userService.findById(id));
    }

    @PostMapping
    public ResponseModel<UserModel> register(@RequestBody UserModel userModel) {
        return successResponse(userService.save(userModel));
    }

    @DeleteMapping("/{id}")
    public ResponseModel<String> delete(@PathVariable Long id) throws Exception {
        userService.delete(id);
        return successResponse("OK");
    }

    @PutMapping
    public ResponseModel<?> update(@RequestBody UserModel userModel) throws Exception {
        return successResponse(userService.update(userModel));
    }
}
