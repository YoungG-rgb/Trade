package kg.tech.retailment.services;

import kg.tech.retailment.models.ItemModel;

import java.util.List;

public interface ItemService {
    List<ItemModel> findAll();
}
