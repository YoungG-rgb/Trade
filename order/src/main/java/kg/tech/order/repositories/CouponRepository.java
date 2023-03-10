package kg.tech.order.repositories;

import kg.tech.order.domain.entities.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CouponRepository extends JpaRepository<Coupon, Long> {

    List<Coupon> findByUserId(Long userId);

    @Query("select c from Coupon c where c.id = :id and c.isValid = true")
    Coupon findByIdAndValidIsTrue(Long id);


}
