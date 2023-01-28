package kg.tech.retailment.controllers.extApi;

import kg.tech.commons.models.ResponseModel;
import kg.tech.commons.rest.BaseController;
import kg.tech.retailment.models.ItemModel;
import kg.tech.retailment.services.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/ext-api/home")
public class ExtHomePageController extends BaseController {

    private final ItemService itemService;

    @GetMapping
    public ResponseModel<List<ItemModel>> getAll(){
       return successResponse(itemService.getAll());
    }

}
