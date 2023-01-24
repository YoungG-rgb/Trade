package kg.tech.retailment.mappers;

import kg.tech.retailment.entities.Item;
import kg.tech.retailment.models.ItemModel;
import org.mapstruct.Mapper;

@Mapper
public interface ItemMapper {

    Item toEntity(ItemModel itemModel);

    ItemModel toModel(Item item);
}
