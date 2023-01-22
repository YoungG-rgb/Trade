package kg.tech.order.mappers;

import kg.tech.order.entities.Order;
import kg.tech.order.models.OrderModel;
import org.mapstruct.Mapper;

@Mapper
public interface OrderMapper {

    OrderModel toModel(Order order);

    Order toEntity(OrderModel orderModel);
}
