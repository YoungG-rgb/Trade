package kg.tech.retailment.services.impl;

import kg.tech.retailment.mappers.ItemMapper;
import kg.tech.retailment.models.ItemModel;
import kg.tech.retailment.repositories.ItemRepository;
import kg.tech.retailment.services.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {
    private final ItemRepository itemRepository;
    private final ItemMapper itemMapper;
    @Override
    public List<ItemModel> findAll() {
        return itemRepository.findAll().stream().map(itemMapper::toModel).toList();
    }
}
