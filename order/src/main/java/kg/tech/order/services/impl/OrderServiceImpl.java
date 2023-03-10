package kg.tech.order.services.impl;

import kg.tech.commons.exceptions.OrderException;
import kg.tech.commons.utils.BaseValidator;
import kg.tech.order.domain.entities.Card;
import kg.tech.order.domain.entities.Coupon;
import kg.tech.order.domain.entities.Order;
import kg.tech.order.domain.entities.User;
import kg.tech.order.domain.enums.OrderStatus;
import kg.tech.order.mappers.OrderMapper;
import kg.tech.order.domain.models.OrderModel;
import kg.tech.order.repositories.CouponRepository;
import kg.tech.order.repositories.OrderRepository;
import kg.tech.order.repositories.UserRepository;
import kg.tech.order.services.EmailSenderService;
import kg.tech.order.services.OrderService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
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
    public OrderModel save(OrderModel orderModel, List<Long> coupons) throws Exception {
        validateOrder(orderModel);
        if (coupons != null) subtractAndToInvalidity(orderModel, coupons);

        emailSenderService.send(orderModel.getUserId(), "ORDER", orderModel.toEmailString());
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

    private void validateOrder(OrderModel orderModel) throws OrderException {
        User user = userRepository.findById(orderModel.getUserId()).get();
        Card creditCard = user.getCreditCard();

        if (userRepository
                .findById(orderModel.getUserId())
                .orElseThrow(() -> new OrderException("???????????????????????? ???? ????????????????????"))
                .getAddress() == null
        ) throw new OrderException("????????????????????, ?????????????? ??????????");

        if (switch(orderModel.getPaymentMethod()) {
            case BALANCE -> user.getBalance().compareTo(orderModel.getTotal()) < 0;
            case PAYPAL, COD -> false;
            case CREDIT_CARD ->
                    BaseValidator.isEmpty( creditCard.getCardNumber(), creditCard.getCVCandCVV() ) && creditCard.getExpiryDate() == null;
        }) throw new OrderException("???? ?????????????? ??????????????");
    }
}
