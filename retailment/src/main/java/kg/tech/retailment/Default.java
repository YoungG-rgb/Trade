package kg.tech.retailment;

import kg.tech.retailment.entities.Image;
import kg.tech.retailment.entities.Item;
import kg.tech.retailment.enums.Color;
import kg.tech.retailment.repositories.ImageRepository;
import kg.tech.retailment.repositories.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.file.Files;
import java.util.List;

@Component
@RequiredArgsConstructor
public class Default {
    private final ImageRepository imageRepository;
    private final ItemRepository itemRepository;

//    @PostConstruct
//    public void init() throws IOException {
//        File item1Image1 = ResourceUtils.getFile("classpath:static/image1.png");
//        byte [] arrayItem1Image1 = Files.readAllBytes(item1Image1.toPath());
//        File item1Image2 = ResourceUtils.getFile("classpath:static/image1-1.png");
//        byte [] arrayItem1Image2 = Files.readAllBytes(item1Image2.toPath());
//        File item1Image3 = ResourceUtils.getFile("classpath:static/image1-2.png");
//        byte [] arrayItem1Image3 = Files.readAllBytes(item1Image3.toPath());
//
//        Image image1 = new Image();
//        image1.setPicture(arrayItem1Image1);
//        Image savedImage1 = imageRepository.save(image1);
//
//        Image image2 = new Image();
//        image2.setPicture(arrayItem1Image2);
//        Image savedImage2 = imageRepository.save(image2);
//
//        Image image3 = new Image();
//        image3.setPicture(arrayItem1Image3);
//        Image savedImage3 = imageRepository.save(image3);
//        //--------------------------------------------------------------------------------------------------------------
//
//        Item item1 = new Item();
//        item1.setGlass("Синее стекло");
//        item1.setCount(100);
//        item1.setName("Volumenzeit S2");
//        item1.setImages(List.of(savedImage1, savedImage2, savedImage3));
//        item1.setDescription("Lorem ipsum");
//        item1.setPrice(new BigDecimal(BigInteger.valueOf(17),588));
//        item1.setWaterResistance("Отличная водостойкость");
//        item1.setRating(4.8d);
//        item1.setStraps("Синий");
//        item1.setDialColor(Color.BLUE);
//        item1.setStandardBatteryLife(100);
//
//        itemRepository.save(item1);
//    }
}
