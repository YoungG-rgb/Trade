package kg.tech.order.services;

import kg.tech.commons.exceptions.OrderException;
import kg.tech.order.models.CouponModel;

import java.util.List;

public interface CouponService {
    CouponModel save(CouponModel couponModel);
    CouponModel update(CouponModel couponModel) throws OrderException;

    void delete(Long couponId) throws OrderException;

    List<CouponModel> getAll();

    List<CouponModel> findByUserId(Long userId);

}
