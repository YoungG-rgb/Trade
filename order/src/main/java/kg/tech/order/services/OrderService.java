package kg.tech.order.services;

import kg.tech.commons.exceptions.OrderException;
import kg.tech.order.models.OrderModel;

import java.util.List;

public interface OrderService {
    OrderModel save(OrderModel orderModel);
    OrderModel update(OrderModel orderModel);
    void delete(Long orderId) throws OrderException;
    void changeStatusToSent(Long orderId) throws OrderException;
    void changeStatusToDelivered(Long orderId) throws OrderException;
    void changeStatusToCompleted(Long orderId) throws OrderException;

    List<OrderModel> findAllByUserId(Long userId);


}
