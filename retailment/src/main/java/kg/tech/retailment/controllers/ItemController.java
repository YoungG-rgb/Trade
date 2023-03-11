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
@RequestMapping("/api/items")
@RequiredArgsConstructor
public class ItemController extends BaseController {

    private final ItemService itemService;

    @PostMapping("/filter")
    public ResponseModel<Page<ItemModel>> getItems(@RequestBody ItemFilterPattern searchPattern, Pageable pageable) {
        return successResponse(itemService.filter(searchPattern, pageable));
    }

    @GetMapping("/{id}")
    public ResponseModel<ItemModel> getById(@PathVariable("id") Long id) throws Exception {
        return successResponse(itemService.findById(id));
    }

    @PostMapping
    public ResponseModel<ItemModel> save(@RequestBody ItemModel itemModel) {
        return successResponse(itemService.save(itemModel));
    }

    @DeleteMapping("/{id}")
    public ResponseModel<String> delete(@PathVariable Long id) throws Exception {
        itemService.delete(id);
        return successResponse("DELETED");
    }
}
