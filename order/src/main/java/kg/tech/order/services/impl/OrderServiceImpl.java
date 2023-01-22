package kg.tech.order.services.impl;

import kg.tech.commons.exceptions.OrderException;
import kg.tech.order.entities.Order;
import kg.tech.order.enums.OrderStatus;
import kg.tech.order.mappers.OrderMapper;
import kg.tech.order.models.OrderModel;
import kg.tech.order.repositories.OrderRepository;
import kg.tech.order.services.EmailSenderService;
import kg.tech.order.services.OrderService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class OrderServiceImpl implements OrderService {

    OrderRepository orderRepository;
    OrderMapper orderMapper;
    EmailSenderService emailSenderService;

    @Override
    public OrderModel save(OrderModel orderModel) {
        emailSenderService.sendToEmail(orderModel.getUserId(), "ORDER", orderModel.toEmailString());
        orderRepository.save(orderMapper.toEntity(orderModel));
        return orderModel;
    }

    @Override
    public OrderModel update(OrderModel orderModel) {
        orderRepository.save(orderMapper.toEntity(orderModel));
        return orderModel;
    }

    @Override
    public void delete(Long orderId) throws OrderException {
        orderRepository.delete(
                orderRepository
                .findById(orderId)
                .orElseThrow(() -> new OrderException("ORDER_NOT_FOUND"))
        );
    }

    @Override
    public void changeStatusToSent(Long orderId) throws OrderException {
        Order order = this.findById(orderId);
        order.setStatus(OrderStatus.SENT);
        orderRepository.save(order);
    }

    @Override
    public void changeStatusToDelivered(Long orderId) throws OrderException {
        Order order = this.findById(orderId);
        order.setStatus(OrderStatus.DELIVERED);
        orderRepository.save(order);
    }

    @Override
    public void changeStatusToCompleted(Long orderId) throws OrderException {
        Order order = this.findById(orderId);
        order.setStatus(OrderStatus.COMPLETE);
        orderRepository.save(order);
    }

    @Override
    public List<OrderModel> findAllByUserId(Long userId) {
        return orderRepository
                .findByUserId(userId)
                .stream()
                .map(orderMapper::toModel)
                .collect(Collectors.toList());
    }

    private Order findById(Long id) throws OrderException {
        return orderRepository
                .findById(id)
                .orElseThrow(() -> new OrderException("ORDER_NOT_FOUND"));
    }
}
