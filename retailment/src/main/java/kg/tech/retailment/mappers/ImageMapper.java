package kg.tech.retailment.mappers;

import kg.tech.retailment.entities.Image;
import kg.tech.retailment.models.ImageModel;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ImageMapper {

    Image toEntity(ImageModel imageModel);

    ImageModel toModel(Image image);
}
