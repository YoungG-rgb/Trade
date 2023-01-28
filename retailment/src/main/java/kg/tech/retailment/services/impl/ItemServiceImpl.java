package kg.tech.retailment.services.impl;

import kg.tech.commons.exceptions.RetailmentException;
import kg.tech.retailment.entities.Item;
import kg.tech.retailment.mappers.ItemMapper;
import kg.tech.retailment.models.ItemFilterPattern;
import kg.tech.retailment.models.ItemModel;
import kg.tech.retailment.repositories.ItemRepository;
import kg.tech.retailment.services.ItemService;
import kg.tech.retailment.specifications.ItemSpecification;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {
    private final ItemRepository itemRepository;
    private final ItemMapper itemMapper;
    @Override
    public List<ItemModel> getAll() {
        return itemRepository.findAll().stream().map(itemMapper::toModel).toList();
    }

    @Override
    public ItemModel findById(Long id) throws Exception {
        Optional<Item> item = itemRepository.findById(id);
        return item
                .map(itemMapper::toModel)
                .orElseThrow(() -> new RetailmentException("ITEM_NOT_FOUND"));
    }

    @Override
    public ItemModel save(ItemModel itemModel) {
        Item item = itemRepository.save(itemMapper.toEntity(itemModel));
        log.info("itemServiceImpl.save::" + item.getId());
        return itemModel;
    }

    @Override
    public ItemModel update(ItemModel itemModel) throws Exception {
        if (itemModel.getId() == null) throw new RetailmentException("ID IS NULL");
        return this.save(itemModel);
    }

    @Override
    public void delete(Long id) throws Exception {
        Optional<Item> itemOptional = itemRepository.findById(id);
        if (itemOptional.isEmpty()) throw new RetailmentException("ITEM IS ALREADY DELETED");
        itemRepository.delete(itemOptional.get());
    }

    @Override
    public Page<ItemModel> filter(ItemFilterPattern searchPattern, Pageable pageable) {
        ItemSpecification itemSpecification = new ItemSpecification(searchPattern);
        Page<Item> items = itemRepository.findAll(itemSpecification, pageable);
        return items.map(itemMapper::toModel);
    }


}
