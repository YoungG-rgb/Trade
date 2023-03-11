package kg.tech.retailment.services.impl;

import kg.tech.commons.exceptions.RetailmentException;
import kg.tech.retailment.entities.Image;
import kg.tech.retailment.entities.Item;
import kg.tech.retailment.mappers.ImageMapper;
import kg.tech.retailment.models.ImageModel;
import kg.tech.retailment.repositories.ImageRepository;
import kg.tech.retailment.services.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService {

    private final ImageRepository imageRepository;
    private final ImageMapper imageMapper;

    @Override
    public ImageModel save(ImageModel imageModel) {
        imageRepository.save(imageMapper.toEntity(imageModel));
        return imageModel;
    }

    @Override
    public ImageModel update(ImageModel imageModel) {
        return this.save(imageModel);
    }

    @Override
    public void delete(Long id) throws Exception {
        Optional<Image> imageOptional = imageRepository.findById(id);
        if (imageOptional.isEmpty()) throw new RetailmentException("ITEM IS ALREADY DELETED");
        imageRepository.delete(imageOptional.get());
    }

    @Override
    public List<ImageModel> findAll() {
        return imageRepository.findAll().stream().map(imageMapper::toModel).toList();
    }
}
