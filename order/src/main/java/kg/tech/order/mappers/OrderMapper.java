package kg.tech.order.mappers;

import kg.tech.order.entities.Order;
import kg.tech.order.models.OrderModel;
import kg.tech.order.repositories.UserRepository;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(uses = ItemMapper.class)
public abstract class OrderMapper {
    @Autowired UserRepository userRepository;

    @Mapping(target = "userId", source = "user.id")
    public abstract OrderModel toModel(Order order);

    @Mapping(target = "user", expression = "java( userRepository.findById(orderModel.getUserId()).get() )")
    public abstract Order toEntity(OrderModel orderModel);
}
