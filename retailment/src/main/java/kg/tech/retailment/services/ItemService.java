package kg.tech.retailment.services;

import kg.tech.retailment.models.ItemFilterPattern;
import kg.tech.retailment.models.ItemModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ItemService {
    List<ItemModel> getAll();

    ItemModel findById(Long id) throws Exception;

    ItemModel save(ItemModel itemModel);

    ItemModel update(ItemModel itemModel) throws Exception;

    void delete(Long id) throws Exception;

    Page<ItemModel> filter(ItemFilterPattern searchPattern, Pageable pageable);
}
