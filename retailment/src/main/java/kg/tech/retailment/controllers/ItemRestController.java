package kg.tech.retailment.controllers;

import kg.tech.commons.models.ResponseModel;
import kg.tech.commons.rest.BaseController;
import kg.tech.retailment.models.ItemModel;
import kg.tech.retailment.models.ItemFilterPattern;
import kg.tech.retailment.services.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/items")
@RequiredArgsConstructor
public class ItemRestController extends BaseController {

    private final ItemService itemService;

    @PostMapping("/filter")
    public ResponseModel<Page<ItemModel>> getItems(@RequestBody ItemFilterPattern searchPattern, Pageable pageable) {
        return successResponse(itemService.filter(searchPattern, pageable));
    }

    @GetMapping("/{id}")
    public ResponseModel<ItemModel> getById(@PathVariable("id") Long id) throws Exception {
        return successResponse(itemService.findById(id));
    }

}
