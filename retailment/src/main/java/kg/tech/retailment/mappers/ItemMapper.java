package kg.tech.retailment.mappers;

import kg.tech.retailment.entities.Item;
import kg.tech.retailment.models.ItemModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(uses = ImageMapper.class, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ItemMapper {

    @Mapping(target = "images", source = "imageModels")
    Item toEntity(ItemModel itemModel);

    @Mapping(target = "imageModels", source = "images")
    ItemModel toModel(Item item);

}
