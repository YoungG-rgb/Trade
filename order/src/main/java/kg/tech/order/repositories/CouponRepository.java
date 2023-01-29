package kg.tech.order.repositories;

import kg.tech.order.entities.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CouponRepository extends JpaRepository<Coupon, Long> {

    List<Coupon> findByUserId(Long userId);

    Coupon findByIdAndValidTrue(Long id);


}
