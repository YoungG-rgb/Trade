package kg.tech.order.services.impl;

import kg.tech.commons.exceptions.OrderException;
import kg.tech.order.entities.Address;
import kg.tech.order.entities.Coupon;
import kg.tech.order.entities.Order;
import kg.tech.order.entities.User;
import kg.tech.order.enums.OrderStatus;
import kg.tech.order.mappers.CouponMapper;
import kg.tech.order.mappers.OrderMapper;
import kg.tech.order.models.AddressModel;
import kg.tech.order.models.OrderModel;
import kg.tech.order.repositories.CouponRepository;
import kg.tech.order.repositories.OrderRepository;
import kg.tech.order.repositories.UserRepository;
import kg.tech.order.services.CouponService;
import kg.tech.order.services.EmailSenderService;
import kg.tech.order.services.OrderService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class OrderServiceImpl implements OrderService {

    OrderRepository orderRepository;
    OrderMapper orderMapper;
    EmailSenderService emailSenderService;
    CouponRepository couponRepository;
    private final UserRepository userRepository;

    @Override
    public OrderModel save(OrderModel orderModel, List<Long> coupons) throws OrderException {
        if (addressIsExists(orderModel.getUserId())) throw new OrderException("Пожалуйста, укажите адрес");
        if (coupons != null) subtractAndToInvalidity(orderModel, coupons);

        emailSenderService.sendToEmail(orderModel.getUserId(), "ORDER", orderModel.toEmailString());
        orderRepository.save(orderMapper.toEntity(orderModel));
        return orderModel;
    }

    private void subtractAndToInvalidity(OrderModel orderModel, List<Long> coupons) {
        BigDecimal subtractedTotal = orderModel.getTotal().subtract(applyCoupons(coupons));
        orderModel.setTotal(subtractedTotal);

        for(Long id: coupons) {
            Coupon coupon = couponRepository.findById(id).get();
            coupon.setValid(false);
            couponRepository.save(coupon);
        }
    }

    @Override
    public OrderModel update(OrderModel orderModel) throws OrderException {
        if (orderModel.getId() == null) throw new OrderException("ORDER_NOT_FOUND");
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

    private BigDecimal applyCoupons(List<Long> coupons) {
        return coupons
                .stream()
                .map(couponRepository::findByIdAndValidIsTrue)
                .map(Coupon::getBonus)
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);
    }

    private boolean addressIsExists(Long userId) throws OrderException {
        return userRepository
                .findById(userId)
                .orElseThrow(() -> new OrderException("Пользователя не существует"))
                .getAddress() != null;
    }
}
